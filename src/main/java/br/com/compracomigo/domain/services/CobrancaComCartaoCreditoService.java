package br.com.compracomigo.domain.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;

import br.com.compracomigo.domain.model.CobrancaCartaoCreditoRequest;
import br.com.compracomigo.domain.model.CobrancaCartaoCreditoResponse;

@Service
public class CobrancaComCartaoCreditoService {

	@Value("${api.pagamento.url}")
	String url;

	@Value("${api.pagamento.apikey}")
	String apikey;
	
	public CobrancaCartaoCreditoResponse cobrar(CobrancaCartaoCreditoRequest creditoRequest) throws Exception {
		Gson g = new Gson();
		var json = g.toJson(creditoRequest);
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://sandbox.asaas.com/api/v3/payments/"))
			    .header("accept", "application/json")
			    .header("content-type", "application/json")
			    .header("access_token", apikey)
			    .method("POST", HttpRequest.BodyPublishers.ofString(json))
			    .build();
			HttpResponse<String> response = null;
			try {
				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
				System.out.println(response.statusCode());
				validateResponse(response);
				System.out.println(response.body());
				var resp = g.fromJson(response.body(), CobrancaCartaoCreditoResponse.class);
				return resp;
			} catch (IOException | InterruptedException e) {
				// manda erro para fila
				throw new Exception(e.getMessage());
			}
			
	}
	
	private void validateResponse(HttpResponse<String> response) {
		if (response.statusCode() == 400) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, response.body());
		}
	}
}

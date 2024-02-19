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

import br.com.compracomigo.domain.model.Cliente;

@Service
public class CustormerService {

	@Value("${api.pagamento.url}")
	String url;

	@Value("${api.pagamento.apikey}")
	String apikey;
	
	public Cliente newCustomer(Cliente customer) throws Exception {
		
		Gson g = new Gson();
		String json = g.toJson(customer);
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://sandbox.asaas.com/api/v3/customers"))
			    .header("accept", "application/json")
			    .header("content-type", "application/json")
			    .header("access_token", apikey)
			    .method("POST", HttpRequest.BodyPublishers.ofString(json))
			    .build();
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			validateResponse(response);
			System.out.println(response.body());
			var resp = response.body();
			var cus = g.fromJson(resp, Cliente.class);
			return cus;
		}catch (IOException | InterruptedException e) {
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

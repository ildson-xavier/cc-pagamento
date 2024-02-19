package br.com.compracomigo.domain.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.compracomigo.domain.model.ClientePesquisaModel;

@Service
public class PesquisaClienteService {

	@Value("${api.pagamento.apikey}")
	String apikey;
	
	public ClientePesquisaModel pesquisarClientePorDocumento(String id) throws Exception {
		Gson g = new Gson();
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://sandbox.asaas.com/api/v3/customers?externalReference="+id))
			    .header("accept", "application/json")
			    .header("access_token", apikey)
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			var customer = g.fromJson(response.body(), ClientePesquisaModel.class);
			return customer;
		} catch (IOException | InterruptedException e) {
			// manda erro para fila
			throw new Exception(e.getMessage());
		}

	}
}

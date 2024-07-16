package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertidorDivisas {

    private double cantidadConvertir;
    private String api_url;
    private String PaisOrigenDivisa;
    private String paisDestinoDivisa;


    public ConvertidorDivisas() {}

    public String Conversion() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getApi_url() + getPaisOrigenDivisa() +
                        "/"+ getPaisDestinoDivisa() + "/" + String.valueOf(getCantidadConvertir())))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        ConvertExchanges resultadoConversion = gson.fromJson(response.body(), ConvertExchanges.class);

        return "El valor de " + getCantidadConvertir() + " " + getPaisOrigenDivisa() + " a " +
                getPaisDestinoDivisa() + " es: " + resultadoConversion.getConversionResult() + " " +
                getPaisDestinoDivisa();
    }
    public double getCantidadConvertir() {
        return cantidadConvertir;
    }

    public void setCantidadConvertir(double cantidadConvertir) {
        this.cantidadConvertir = cantidadConvertir;
    }

    public String getApi_url() {
        return api_url;
    }

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }

    public String getPaisOrigenDivisa() {
        return PaisOrigenDivisa;
    }

    public void setPaisOrigenDivisa(String paisOrigenDivisa) {
        PaisOrigenDivisa = paisOrigenDivisa;
    }

    public String getPaisDestinoDivisa() {
        return paisDestinoDivisa;
    }

    public void setPaisDestinoDivisa(String paisDestinoDivisa) {
        this.paisDestinoDivisa = paisDestinoDivisa;
    }
}

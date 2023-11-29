package org.main.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class GoogleMapsApiClient {

    public static void main(String[] args) {
        try {
            String apiKey = "YOUR_GOOGLE_MAPS_API_KEY";
            String origin = "Paris,France";
            String destination = "Berlin,Germany";

            // Encode les paramètres pour l'URL
            origin = URLEncoder.encode(origin, "UTF-8");
            destination = URLEncoder.encode(destination, "UTF-8");

            // Construit l'URL de l'API Google Maps Distance Matrix
            String apiUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin +
                    "&destinations=" + destination + "&key=" + apiKey;

            // Crée un client HTTP
            HttpClient client = HttpClients.createDefault();

            // Crée une requête GET
            HttpGet request = new HttpGet(apiUrl);

            // Exécute la requête
            HttpResponse response = client.execute(request);

            // Lit la réponse
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            // Affiche la réponse
            System.out.println(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


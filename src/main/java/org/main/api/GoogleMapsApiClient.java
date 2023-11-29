package org.main.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GoogleMapsApiClient {

    public static void main(String[] args) {
        try {
            String endpoint = "https://maps.googleapis.com/maps/api/distancematrix/json";
            String origin = "Paris,France";
            String destination = "Berlin,Germany";
            String apiKey = "AIzaSyBSzkf6v8bVOvIkYJvy70lg4O3sE2YI1Sw"; // Replace with your actual API key

            // Encode the parameters for the URL
            origin = URLEncoder.encode(origin, StandardCharsets.UTF_8);
            destination = URLEncoder.encode(destination, StandardCharsets.UTF_8);

            // Construct the URL for the Google Maps Distance Matrix API
            String apiUrl = String.format("%s?origins=%s&destinations=%s&key=%s", endpoint, origin, destination, apiKey);
            System.out.println(apiUrl);

            // Create an HTTP client
            HttpClient client = HttpClients.createDefault();

            // Create a GET request
            HttpGet request = new HttpGet(apiUrl);

            // Execute the request
            HttpResponse response = client.execute(request);

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            // Parse the response to get the distance
            JSONObject json = new JSONObject(result.toString());
            String distance = null;
            if (json.has("rows") && !json.getJSONArray("rows").isEmpty()) {
                distance = json.getJSONArray("rows")
                        .getJSONObject(0)
                        .getJSONArray("elements")
                        .getJSONObject(0)
                        .getJSONObject("distance")
                        .getString("text");
                // Print the distance
                System.out.println("Distance between Paris and Berlin: " + distance);
            } else {
                System.out.println("No distance data available.");
            }
            // Print the distance
            System.out.println("Distance between Paris and Berlin: " + distance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
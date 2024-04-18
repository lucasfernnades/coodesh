package com.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */

public class TASK4 {

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(responseBody);

            int male = 0;
            int female = 0;
            for (JsonNode jsonNode : jsonArray) {
                String gender = jsonNode.get("gender").asText();
                if ("M".equalsIgnoreCase(gender)) {
                    male++;
                } else if ("F".equalsIgnoreCase(gender)) {
                    female++;
                }
            }

            String jsonContent = "{\"male\": " + male + ", \"female\": " + female + "}";
            saveToJsonFile(jsonContent);

            System.out.println("Male: " + male);
            System.out.println("Female: " + female);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToJsonFile(String jsonContent) {
        try {
            S3Client s3Client = S3Client.builder()
                    .credentialsProvider(StaticCredentialsProvider.create(
                            AwsBasicCredentials.create(AwsCredentials.ACCESS_KEY, AwsCredentials.SECRET_KEY)))
                    .region(Region.US_WEST_2)
                    .build();

            s3Client.putObject(PutObjectRequest.builder()
                    .bucket("interview-digiage")
                    .key("count-gender-lucasfernandes.json")
                    .contentType("application/json")
                    .build(), RequestBody.fromString(jsonContent));
            System.out.println("successfully.");
        } catch (S3Exception e) {
            e.printStackTrace();
        }
    }
}
package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ProjectApiClient {

    public static JSONArray getAllProjects() throws Exception {
        URL url = new URL("http://localhost:8080/api/projects");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : " + responseCode);
        }

        Scanner sc = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (sc.hasNext()) {
            inline.append(sc.nextLine());
        }
        sc.close();

        return new JSONArray(inline.toString());
    }

    public static JSONObject getProjectById(String projectId) throws Exception {
        URL url = new URL("http://localhost:8080/api/projects/" + projectId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : " + responseCode);
        }

        Scanner sc = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (sc.hasNext()) {
            inline.append(sc.nextLine());
        }
        sc.close();

        return new JSONObject(inline.toString());
    }

    public static JSONObject createProject(String projectTitle, String projectDescription, String[] plUser, String[] devUser, String[] testUser) throws Exception {
        URL url = new URL("http://localhost:8080/api/projects/create");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("projectTitle", projectTitle);
        jsonParam.put("projectDescription", projectDescription);
        jsonParam.put("plUser", new JSONArray(plUser));
        jsonParam.put("devUser", new JSONArray(devUser));
        jsonParam.put("testUser", new JSONArray(testUser));

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonParam.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP POST Request Failed with Error code : " + responseCode);
        }

        Scanner sc = new Scanner(conn.getInputStream());
        StringBuilder inline = new StringBuilder();
        while (sc.hasNext()) {
            inline.append(sc.nextLine());
        }
        sc.close();

        return new JSONObject(inline.toString());
    }
}

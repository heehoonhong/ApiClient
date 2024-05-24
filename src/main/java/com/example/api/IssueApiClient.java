package com.example.api;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class IssueApiClient {

    public static JSONObject createIssue(String projectId, String issueTitle, String issueDescription) throws Exception {
        URL url = new URL("http://localhost:8080/api/projects/" + projectId + "/issues/create");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("issueTitle", issueTitle);
        jsonParam.put("issueDescription", issueDescription);

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

    public static JSONObject assignDev(String projectId, String issueId, String assignee) throws Exception {
        URL url = new URL("http://localhost:8080/api/projects/" + projectId + "/issues/" + issueId + "/update-dev");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("assignee", assignee);

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

    public static JSONArray getComments(String projectId, String issueId) throws Exception {
        URL url = new URL("http://localhost:8080/api/projects/" + projectId + "/issues/" + issueId + "/comments");
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

    public static JSONObject getCommentById(String projectId, String issueId, String commentId) throws Exception {
        URL url = new URL("http://localhost:8080/api/projects/" + projectId + "/issues/" + issueId + "/comments/" + commentId);
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

    public static JSONObject createComment(String projectId, String issueId, String content) throws Exception {
        URL url = new URL("http://localhost:8080/api/projects/" + projectId + "/issues/" + issueId + "/comments/create");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("content", content);

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

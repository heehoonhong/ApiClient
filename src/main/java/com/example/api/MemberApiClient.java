package com.example.api;

import org.json.JSONObject;
//import org.json.simple.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MemberApiClient {

    public static JSONObject signup(String memberEmail, String memberPassword, String memberName) throws Exception {
        URL url = new URL("http://localhost:8080/api/member/save");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("memberEmail", memberEmail);
        jsonParam.put("memberPassword", memberPassword);
        jsonParam.put("memberName", memberName);

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

    public static JSONObject login(String memberEmail, String memberPassword) throws Exception {
        URL url = new URL("http://localhost:8080/api/member/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("memberEmail", memberEmail);
        jsonParam.put("memberPassword", memberPassword);

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

    public static void logout() throws Exception {
        URL url = new URL("http://localhost:8080/api/member/logout");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP POST Request Failed with Error code : " + responseCode);
        }

        System.out.println("Logout successful. Response code: " + responseCode);
    }
}

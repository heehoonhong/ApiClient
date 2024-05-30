package com.example.api;

import java.util.HashMap;
import java.util.Map;

public class ProjectApiClient {

    private static Map<Integer, String[]> projects = new HashMap<>();
    private static int projectCounter = 1;

    public static String createProject(String projectTitle, String projectDescription) {
        projects.put(projectCounter++, new String[]{projectTitle, projectDescription});
        return "프로젝트 생성 성공";
    }

    public static String getAllProjects() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String[]> entry : projects.entrySet()) {
            sb.append("ID: ").append(entry.getKey())
                    .append(", Title: ").append(entry.getValue()[0])
                    .append(", Description: ").append(entry.getValue()[1])
                    .append("\n");
        }
        return sb.toString();
    }

    public static String getProjectById(int projectId) {
        if (!projects.containsKey(projectId)) {
            return "존재하지 않는 프로젝트 ID입니다.";
        }
        String[] info = projects.get(projectId);
        return "ID: " + projectId + ", Title: " + info[0] + ", Description: " + info[1];
    }
}

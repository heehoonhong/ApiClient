package com.example.gui;

import com.example.api.ProjectApiClient;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectPanel extends JPanel {

    public ProjectPanel() {
        setLayout(null);

        JButton createProjectButton = new JButton("프로젝트 생성");
        createProjectButton.setBounds(50, 50, 400, 30);
        add(createProjectButton);

        JButton getProjectByIdButton = new JButton("특정 프로젝트 조회");
        getProjectByIdButton.setBounds(50, 100, 400, 30);
        add(getProjectByIdButton);

        JButton getAllProjectsButton = new JButton("모든 프로젝트 조회");
        getAllProjectsButton.setBounds(50, 150, 400, 30);
        add(getAllProjectsButton);

        createProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectTitle = JOptionPane.showInputDialog("Enter Project Title:");
                String projectDescription = JOptionPane.showInputDialog("Enter Project Description:");
                String plUser = JOptionPane.showInputDialog("Enter PL User (comma separated if multiple):");
                String devUser = JOptionPane.showInputDialog("Enter Dev User (comma separated if multiple):");
                String testUser = JOptionPane.showInputDialog("Enter Test User (comma separated if multiple):");

                try {
                    JSONObject response = ProjectApiClient.createProject(projectTitle, projectDescription, plUser.split(","), devUser.split(","), testUser.split(","));
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        getProjectByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectId = JOptionPane.showInputDialog("Enter Project ID:");
                try {
                    JSONObject response = ProjectApiClient.getProjectById(projectId);
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        getAllProjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JSONArray response = ProjectApiClient.getAllProjects();
                    for (int i = 0; i < response.length(); i++) {
                        System.out.println(response.getJSONObject(i).toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

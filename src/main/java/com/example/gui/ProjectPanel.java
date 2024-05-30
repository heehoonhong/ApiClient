package com.example.gui;

import com.example.api.ProjectApiClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectPanel extends JPanel {

    public ProjectPanel() {
        setLayout(null);

        JButton createProjectButton = new JButton("프로젝트 생성");
        createProjectButton.setBounds(50, 50, 400, 30);
        add(createProjectButton);

        JButton getAllProjectsButton = new JButton("모든 프로젝트 조회");
        getAllProjectsButton.setBounds(50, 100, 400, 30);
        add(getAllProjectsButton);

        JButton getProjectByIdButton = new JButton("특정 프로젝트 조회");
        getProjectByIdButton.setBounds(50, 150, 400, 30);
        add(getProjectByIdButton);

        createProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectTitle = JOptionPane.showInputDialog("Enter Project Title:");
                String projectDescription = JOptionPane.showInputDialog("Enter Project Description:");

                String response = ProjectApiClient.createProject(projectTitle, projectDescription);
                JOptionPane.showMessageDialog(null, response);
            }
        });

        getAllProjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = ProjectApiClient.getAllProjects();
                JOptionPane.showMessageDialog(null, response);
            }
        });

        getProjectByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectIdStr = JOptionPane.showInputDialog("Enter Project ID:");
                int projectId = Integer.parseInt(projectIdStr);

                String response = ProjectApiClient.getProjectById(projectId);
                JOptionPane.showMessageDialog(null, response);
            }
        });
    }
}

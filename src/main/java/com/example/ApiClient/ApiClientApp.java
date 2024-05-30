package com.example.ApiClient;

import com.example.gui.MemberPanel;
import com.example.gui.ProjectPanel;

import javax.swing.*;

public class ApiClientApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("API Client App");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JTabbedPane tabbedPane = new JTabbedPane();

        MemberPanel memberPanel = new MemberPanel();
        ProjectPanel projectPanel = new ProjectPanel();

        tabbedPane.addTab("Member", memberPanel);
        tabbedPane.addTab("Project", projectPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}

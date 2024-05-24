package com.example.gui;

//import com.example.api.IssueApiClient;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssuePanel extends JPanel {

    public IssuePanel() {
        setLayout(null);

        JButton createIssueButton = new JButton("이슈 생성");
        createIssueButton.setBounds(50, 50, 400, 30);
        add(createIssueButton);

        JButton assignDevButton = new JButton("이슈에 개발자 지정");
        assignDevButton.setBounds(50, 100, 400, 30);
        add(assignDevButton);

        JButton getCommentsButton = new JButton("이슈의 코멘트들 조회");
        getCommentsButton.setBounds(50, 150, 400, 30);
        add(getCommentsButton);

        JButton getCommentByIdButton = new JButton("특정 코멘트 조회");
        getCommentByIdButton.setBounds(50, 200, 400, 30);
        add(getCommentByIdButton);

        JButton createCommentButton = new JButton("코멘트 생성");
        createCommentButton.setBounds(50, 250, 400, 30);
        add(createCommentButton);

        createIssueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectId = JOptionPane.showInputDialog("Enter Project ID:");
                String issueTitle = JOptionPane.showInputDialog("Enter Issue Title:");
                String issueDescription = JOptionPane.showInputDialog("Enter Issue Description:");

                try {
                    JSONObject response = IssueApiClient.createIssue(projectId, issueTitle, issueDescription);
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        assignDevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectId = JOptionPane.showInputDialog("Enter Project ID:");
                String issueId = JOptionPane.showInputDialog("Enter Issue ID:");
                String assignee = JOptionPane.showInputDialog("Enter Assignee:");

                try {
                    JSONObject response = IssueApiClient.assignDev(projectId, issueId, assignee);
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        getCommentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectId = JOptionPane.showInputDialog("Enter Project ID:");
                String issueId = JOptionPane.showInputDialog("Enter Issue ID:");

                try {
                    JSONArray response = IssueApiClient.getComments(projectId, issueId);
                    for (int i = 0; i < response.length(); i++) {
                        System.out.println(response.getJSONObject(i).toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        getCommentByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectId = JOptionPane.showInputDialog("Enter Project ID:");
                String issueId = JOptionPane.showInputDialog("Enter Issue ID:");
                String commentId = JOptionPane.showInputDialog("Enter Comment ID:");

                try {
                    JSONObject response = IssueApiClient.getCommentById(projectId, issueId, commentId);
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        createCommentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectId = JOptionPane.showInputDialog("Enter Project ID:");
                String issueId = JOptionPane.showInputDialog("Enter Issue ID:");
                String content = JOptionPane.showInputDialog("Enter Comment Content:");

                try {
                    JSONObject response = IssueApiClient.createComment(projectId, issueId, content);
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

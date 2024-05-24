package com.example.gui;

import com.example.api.MemberApiClient;
import org.json.JSONObject;
//import org.json.simple.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberPanel extends JPanel {

    public MemberPanel() {
        setLayout(null);

        JButton signupButton = new JButton("회원가입");
        signupButton.setBounds(50, 50, 400, 30);
        add(signupButton);

        JButton loginButton = new JButton("로그인");
        loginButton.setBounds(50, 100, 400, 30);
        add(loginButton);

        JButton logoutButton = new JButton("로그아웃");
        logoutButton.setBounds(50, 150, 400, 30);
        add(logoutButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberEmail = JOptionPane.showInputDialog("Enter Member Email:");
                String memberPassword = JOptionPane.showInputDialog("Enter Member Password:");
                String memberName = JOptionPane.showInputDialog("Enter Member Name:");

                try {
                    JSONObject response = MemberApiClient.signup(memberEmail, memberPassword, memberName);
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberEmail = JOptionPane.showInputDialog("Enter Member Email:");
                String memberPassword = JOptionPane.showInputDialog("Enter Member Password:");

                try {
                    JSONObject response = MemberApiClient.login(memberEmail, memberPassword);
                    System.out.println(response.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MemberApiClient.logout();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

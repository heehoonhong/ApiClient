package com.example.gui;
//
import com.example.api.MemberApiClient;

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

        JButton getAllMembersButton = new JButton("모든 멤버 조회");
        getAllMembersButton.setBounds(50, 200, 400, 30);
        add(getAllMembersButton);

        JButton getMemberByEmailButton = new JButton("특정 멤버 조회");
        getMemberByEmailButton.setBounds(50, 250, 400, 30);
        add(getMemberByEmailButton);

        JButton updateMemberButton = new JButton("멤버 정보 수정");
        updateMemberButton.setBounds(50, 300, 400, 30);
        add(updateMemberButton);

        JButton deleteMemberButton = new JButton("멤버 삭제");
        deleteMemberButton.setBounds(50, 350, 400, 30);
        add(deleteMemberButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberEmail = JOptionPane.showInputDialog("Enter Member Email:");
                String memberPassword = JOptionPane.showInputDialog("Enter Member Password:");
                String memberName = JOptionPane.showInputDialog("Enter Member Name:");

                String response = MemberApiClient.signup(memberEmail, memberPassword, memberName);
                JOptionPane.showMessageDialog(null, response);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberEmail = JOptionPane.showInputDialog("Enter Member Email:");
                String memberPassword = JOptionPane.showInputDialog("Enter Member Password:");

                String response = MemberApiClient.login(memberEmail, memberPassword);
                JOptionPane.showMessageDialog(null, response);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = MemberApiClient.logout();
                JOptionPane.showMessageDialog(null, response);
            }
        });

        getAllMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = MemberApiClient.getAllMembers();
                JOptionPane.showMessageDialog(null, response);
            }
        });

        getMemberByEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberEmail = JOptionPane.showInputDialog("Enter Member Email:");

                String response = MemberApiClient.getMemberByEmail(memberEmail);
                JOptionPane.showMessageDialog(null, response);
            }
        });

        updateMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberEmail = JOptionPane.showInputDialog("Enter Member Email:");
                String newMemberPassword = JOptionPane.showInputDialog("Enter New Member Password:");
                String newMemberName = JOptionPane.showInputDialog("Enter New Member Name:");

                String response = MemberApiClient.updateMember(memberEmail, newMemberPassword, newMemberName);
                JOptionPane.showMessageDialog(null, response);
            }
        });

        deleteMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberEmail = JOptionPane.showInputDialog("Enter Member Email:");

                String response = MemberApiClient.deleteMember(memberEmail);
                JOptionPane.showMessageDialog(null, response);
            }
        });
    }
}

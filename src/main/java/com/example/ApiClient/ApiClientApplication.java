package com.example.ApiClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import com.example.gui.MemberPanel;
import com.example.gui.ProjectPanel;
import com.example.gui.IssuePanel;

import javax.swing.*;

@SpringBootApplication
public class ApiClientApplication  {
	public static void main(String[] args) {
		JFrame frame = new JFrame("API Client App");
		frame.setSize(600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane();

		MemberPanel memberPanel = new MemberPanel();
		ProjectPanel projectPanel = new ProjectPanel();
		IssuePanel issuePanel = new IssuePanel();

		tabbedPane.addTab("Member", memberPanel);
		tabbedPane.addTab("Project", projectPanel);
		tabbedPane.addTab("Issue", issuePanel);

		frame.add(tabbedPane);
		frame.setVisible(true);
	}


}

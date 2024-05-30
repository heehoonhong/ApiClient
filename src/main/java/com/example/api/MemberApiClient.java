package com.example.api;

import java.util.HashMap;
import java.util.Map;

public class MemberApiClient {

    private static Map<String, String[]> members = new HashMap<>();
    private static boolean isLoggedIn = false;

    public static String signup(String memberEmail, String memberPassword, String memberName) {
        if (members.containsKey(memberEmail)) {
            return "이미 존재하는 이메일입니다.";
        }
        members.put(memberEmail, new String[]{memberPassword, memberName});
        return "회원가입 성공";
    }

    public static String login(String memberEmail, String memberPassword) {
        if (!members.containsKey(memberEmail)) {
            return "존재하지 않는 이메일입니다.";
        }
        String[] info = members.get(memberEmail);
        if (!info[0].equals(memberPassword)) {
            return "비밀번호가 틀렸습니다.";
        }
        isLoggedIn = true;
        return "로그인 성공: " + info[1] + "님 환영합니다.";
    }

    public static String logout() {
        if (!isLoggedIn) {
            return "로그인 되어 있지 않습니다.";
        }
        isLoggedIn = false;
        return "로그아웃 성공";
    }

    public static String getAllMembers() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : members.entrySet()) {
            sb.append("Email: ").append(entry.getKey()).append(", Name: ").append(entry.getValue()[1]).append("\n");
        }
        return sb.toString();
    }

    public static String getMemberByEmail(String memberEmail) {
        if (!members.containsKey(memberEmail)) {
            return "존재하지 않는 이메일입니다.";
        }
        String[] info = members.get(memberEmail);
        return "Email: " + memberEmail + ", Name: " + info[1];
    }

    public static String updateMember(String memberEmail, String newMemberPassword, String newMemberName) {
        if (!members.containsKey(memberEmail)) {
            return "존재하지 않는 이메일입니다.";
        }
        members.put(memberEmail, new String[]{newMemberPassword, newMemberName});
        return "회원정보 수정 성공";
    }

    public static String deleteMember(String memberEmail) {
        if (!members.containsKey(memberEmail)) {
            return "존재하지 않는 이메일입니다.";
        }
        members.remove(memberEmail);
        return "회원 삭제 성공";
    }
}

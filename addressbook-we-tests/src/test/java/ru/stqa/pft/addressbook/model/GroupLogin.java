package ru.stqa.pft.addressbook.model;

public class GroupLogin {
    private final String admin;
    private final String secret;

    public GroupLogin(String admin, String secret) {
        this.admin = admin;
        this.secret = secret;
    }

    public String getAdmin() {
        return admin;
    }

    public String getSecret() {
        return secret;
    }
}

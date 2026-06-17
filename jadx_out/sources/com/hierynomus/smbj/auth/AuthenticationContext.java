package com.hierynomus.smbj.auth;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AuthenticationContext {
    private final String domain;
    private final char[] password;
    private final String username;

    public AuthenticationContext(String str, char[] cArr, String str2) {
        this.username = str;
        this.password = Arrays.copyOf(cArr, cArr.length);
        this.domain = str2;
    }

    public static AuthenticationContext anonymous() {
        return new AuthenticationContext("", new char[0], null);
    }

    public static AuthenticationContext guest() {
        return new AuthenticationContext("Guest", new char[0], null);
    }

    public String getDomain() {
        return this.domain;
    }

    public char[] getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAnonymous() {
        return this.username.isEmpty() && this.password.length == 0;
    }

    public boolean isGuest() {
        return this.username.equals("Guest") && this.password.length == 0;
    }

    public String toString() {
        return "AuthenticationContext[" + this.username + '@' + this.domain + ']';
    }
}

package com.thegrizzlylabs.sardineandroid.impl;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class BasicAuthenticator implements Authenticator {
    private String password;
    private String userName;

    public BasicAuthenticator(String str, String str2) {
        this.userName = str;
        this.password = str2;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        if (response.request().header("Authorization") != null) {
            return null;
        }
        System.out.println("Authenticating for response: " + response);
        System.out.println("Challenges: " + response.challenges());
        return response.request().newBuilder().header("Authorization", Credentials.basic(this.userName, this.password)).build();
    }
}

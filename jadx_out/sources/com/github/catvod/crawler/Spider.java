package com.github.catvod.crawler;

import android.content.Context;
import defpackage.q53;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Dns;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Spider {
    public String siteKey;

    public static OkHttpClient client() {
        return q53.j();
    }

    public static Dns safeDns() {
        return q53.m();
    }

    public String action(String str) {
        return null;
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        return "";
    }

    public void destroy() {
    }

    public String detailContent(List<String> list) {
        return "";
    }

    public String homeContent(boolean z) {
        return "";
    }

    public String homeVideoContent() {
        return "";
    }

    public void init(Context context, String str) {
        init(context);
    }

    public boolean isVideoFormat(String str) {
        return false;
    }

    public String liveContent(String str) {
        return "";
    }

    public boolean manualVideoCheck() {
        return false;
    }

    public String playerContent(String str, String str2, List<String> list) {
        return "";
    }

    public Object[] proxy(Map<String, String> map) {
        return null;
    }

    public String searchContent(String str, boolean z) {
        return "";
    }

    public String searchContent(String str, boolean z, String str2) {
        return "";
    }

    public void init(Context context) {
    }
}

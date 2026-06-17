package com.github.catvod.utils;

import defpackage.yj1;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Asset {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static InputStream open(String str) {
        try {
            return yj1.a().getAssets().open(str.replace("assets://", ""));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String read(String str) {
        try {
            return Path.read(open(str));
        } catch (Exception unused) {
            return "";
        }
    }
}

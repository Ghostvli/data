package com.github.catvod.utils;

import defpackage.g02;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Shell {
    private static final String TAG = "Shell";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String exec(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            Process processExec = Runtime.getRuntime().exec(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    g02.b(TAG).a("Shell command '%s' with exit code '%s'", str, Integer.valueOf(processExec.waitFor()));
                    return Util.substring(sb.toString());
                }
                sb.append(line);
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

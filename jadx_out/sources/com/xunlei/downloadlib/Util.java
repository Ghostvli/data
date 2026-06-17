package com.xunlei.downloadlib;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Util {
    private static final long MINIMAL = 31457280;
    private static final List<String> VIDEO = Arrays.asList("avi", "flv", "mkv", "mov", "mp4", "mpeg", "mpe", "mpg", "wmv");
    private static final List<String> AUDIO = Arrays.asList("aac", "ape", "flac", "mp3", "m4a", "ogg");
    private static final String[] UNITS = {"bytes", "KB", "MB", "GB", "TB"};

    public static boolean isMedia(String str, long j) {
        return (VIDEO.contains(str) || AUDIO.contains(str)) && j > MINIMAL;
    }

    public static String size(long j) {
        if (j <= 0) {
            return "";
        }
        double d = j;
        int iLog10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return "[" + new DecimalFormat("###0.#").format(d / Math.pow(1024.0d, iLog10)) + " " + UNITS[iLog10] + "] ";
    }
}

package com.hierynomus.protocol.commons;

import defpackage.d45;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IOUtils {
    private static final j02 logger = n02.k(IOUtils.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void closeQuietly(AutoCloseable... autoCloseableArr) {
        for (AutoCloseable autoCloseable : autoCloseableArr) {
            if (autoCloseable != null) {
                try {
                    d45.a(autoCloseable);
                } catch (Exception e) {
                    logger.m("Error closing {} - {}", autoCloseable, e);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void closeSilently(AutoCloseable... autoCloseableArr) {
        for (AutoCloseable autoCloseable : autoCloseableArr) {
            if (autoCloseable != null) {
                try {
                    d45.a(autoCloseable);
                } catch (Exception unused) {
                }
            }
        }
    }
}

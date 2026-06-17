package com.thegrizzlylabs.sardineandroid.impl;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SardineException extends IOException {
    private static final long serialVersionUID = -3900043433469104564L;
    private String responsePhrase;
    private final int statusCode;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SardineException(String str, int i, String str2) {
        super(str);
        this.statusCode = i;
        this.responsePhrase = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format(Locale.US, "%s (%d %s)", super.getMessage(), Integer.valueOf(getStatusCode()), getResponsePhrase());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getResponsePhrase() {
        return this.responsePhrase;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getStatusCode() {
        return this.statusCode;
    }
}

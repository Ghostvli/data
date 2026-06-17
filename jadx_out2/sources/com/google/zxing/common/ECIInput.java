package com.google.zxing.common;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface ECIInput {
    char charAt(int i);

    int getECIValue(int i);

    boolean haveNCharacters(int i, int i2);

    boolean isECI(int i);

    int length();

    CharSequence subSequence(int i, int i2);
}

package androidx.media;

import defpackage.lz4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(lz4 lz4Var) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = lz4Var.p(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.b = lz4Var.p(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = lz4Var.p(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = lz4Var.p(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, lz4 lz4Var) {
        lz4Var.x(false, false);
        lz4Var.F(audioAttributesImplBase.a, 1);
        lz4Var.F(audioAttributesImplBase.b, 2);
        lz4Var.F(audioAttributesImplBase.c, 3);
        lz4Var.F(audioAttributesImplBase.d, 4);
    }
}

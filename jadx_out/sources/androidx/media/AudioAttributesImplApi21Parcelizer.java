package androidx.media;

import android.media.AudioAttributes;
import defpackage.lz4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(lz4 lz4Var) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.a = (AudioAttributes) lz4Var.r(audioAttributesImplApi21.a, 1);
        audioAttributesImplApi21.b = lz4Var.p(audioAttributesImplApi21.b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, lz4 lz4Var) {
        lz4Var.x(false, false);
        lz4Var.H(audioAttributesImplApi21.a, 1);
        lz4Var.F(audioAttributesImplApi21.b, 2);
    }
}

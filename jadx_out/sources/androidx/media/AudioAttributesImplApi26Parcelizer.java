package androidx.media;

import android.media.AudioAttributes;
import defpackage.lz4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(lz4 lz4Var) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.a = (AudioAttributes) lz4Var.r(audioAttributesImplApi26.a, 1);
        audioAttributesImplApi26.b = lz4Var.p(audioAttributesImplApi26.b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, lz4 lz4Var) {
        lz4Var.x(false, false);
        lz4Var.H(audioAttributesImplApi26.a, 1);
        lz4Var.F(audioAttributesImplApi26.b, 2);
    }
}

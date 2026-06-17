package defpackage;

import android.media.AudioDescriptor;
import android.media.AudioDeviceInfo;
import android.media.AudioProfile;
import android.os.Build;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qb4 {
    public static final xi1 a = xi1.w(12);

    public static xi1 a() {
        return a;
    }

    public static xi1 b(AudioDeviceInfo audioDeviceInfo) {
        int speakerLayoutChannelMask;
        if (Build.VERSION.SDK_INT >= 36 && (speakerLayoutChannelMask = audioDeviceInfo.getSpeakerLayoutChannelMask()) != 0 && speakerLayoutChannelMask != 1) {
            return xi1.w(Integer.valueOf(speakerLayoutChannelMask));
        }
        xz1.i("SpeakerLayoutUtil", "Built-in speaker's getSpeakerLayoutChannelMask not usable, defaulting to stereo.");
        return a;
    }

    public static xi1 c(AudioDeviceInfo audioDeviceInfo) {
        xi1 xi1VarF = f(audioDeviceInfo);
        if (!xi1VarF.isEmpty()) {
            return xi1VarF;
        }
        xi1 xi1VarC = kc.c(audioDeviceInfo.getAudioDescriptors());
        return !xi1VarC.isEmpty() ? xi1VarC : a;
    }

    public static xi1 d(AudioDeviceInfo audioDeviceInfo) {
        xi1 xi1VarF = f(audioDeviceInfo);
        if (!xi1VarF.isEmpty()) {
            return xi1VarF;
        }
        List<AudioDescriptor> audioDescriptors = audioDeviceInfo.getAudioDescriptors();
        if (Build.VERSION.SDK_INT >= 34) {
            xi1 xi1VarB = kc.b(audioDescriptors);
            if (!xi1VarB.isEmpty()) {
                return xi1VarB;
            }
        }
        xi1 xi1VarC = kc.c(audioDescriptors);
        return !xi1VarC.isEmpty() ? xi1VarC : a;
    }

    public static xi1 e(AudioDeviceInfo audioDeviceInfo) {
        xi1 xi1VarF = f(audioDeviceInfo);
        return !xi1VarF.isEmpty() ? xi1VarF : a;
    }

    public static xi1 f(AudioDeviceInfo audioDeviceInfo) {
        List<AudioProfile> audioProfiles = audioDeviceInfo.getAudioProfiles();
        TreeSet treeSet = new TreeSet(Comparator.comparing(new jc()).reversed());
        Iterator<AudioProfile> it = audioProfiles.iterator();
        while (it.hasNext()) {
            AudioProfile audioProfileA = dc.a(it.next());
            if (audioProfileA.getEncapsulationType() != 1 && fy4.R0(audioProfileA.getFormat())) {
                for (int i : audioProfileA.getChannelMasks()) {
                    treeSet.add(Integer.valueOf(i));
                }
            }
        }
        return xi1.p(treeSet);
    }

    public static xi1 g(AudioDeviceInfo audioDeviceInfo) {
        if (mk0.a(audioDeviceInfo.getType())) {
            return a();
        }
        if (mk0.b(audioDeviceInfo.getType())) {
            return xi1.w(4);
        }
        if (mk0.c(audioDeviceInfo.getType())) {
            return b(audioDeviceInfo);
        }
        int i = Build.VERSION.SDK_INT;
        return (i < 31 || !mk0.d(audioDeviceInfo.getType())) ? (i < 31 || !mk0.e(audioDeviceInfo.getType())) ? (i < 31 || !mk0.f(audioDeviceInfo.getType())) ? a : e(audioDeviceInfo) : d(audioDeviceInfo) : c(audioDeviceInfo);
    }
}

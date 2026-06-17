package defpackage;

import android.media.AudioDescriptor;
import android.os.Build;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kc {
    public static /* synthetic */ int a(Integer num, Integer num2) {
        return Integer.bitCount(num2.intValue()) - Integer.bitCount(num.intValue());
    }

    public static xi1 b(List list) {
        if (Build.VERSION.SDK_INT < 34 || list == null) {
            return xi1.u();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AudioDescriptor audioDescriptorA = hc.a(it.next());
            if (audioDescriptorA.getStandard() == 2) {
                byte[] descriptor = audioDescriptorA.getDescriptor();
                if (descriptor.length != 3) {
                    xz1.i("AudioDescriptorUtil", "Invalid SADB length: " + descriptor.length);
                } else {
                    arrayList.add(Integer.valueOf(d(descriptor)));
                }
            }
        }
        arrayList.sort(new Comparator() { // from class: ic
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return kc.a((Integer) obj, (Integer) obj2);
            }
        });
        return xi1.p(arrayList);
    }

    public static xi1 c(List list) {
        if (Build.VERSION.SDK_INT < 31 || list == null) {
            return xi1.u();
        }
        TreeSet treeSet = new TreeSet(Comparator.comparing(new jc()).reversed());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AudioDescriptor audioDescriptorA = hc.a(it.next());
            if (audioDescriptorA.getStandard() == 1) {
                byte[] descriptor = audioDescriptorA.getDescriptor();
                if (descriptor.length != 3) {
                    xz1.i("AudioDescriptorUtil", "Invalid SAD length: " + descriptor.length);
                } else {
                    byte b = descriptor[0];
                    int i = (b & 7) + 1;
                    if (((b >> 3) & 15) == 1) {
                        treeSet.add(Integer.valueOf(fy4.S(i)));
                    }
                }
            }
        }
        return xi1.p(treeSet);
    }

    public static int d(byte[] bArr) {
        if (Build.VERSION.SDK_INT >= 34 && bArr.length == 3) {
            byte b = bArr[0];
            i = (b & 1) != 0 ? 12 : 0;
            if ((b & 2) != 0) {
                i |= 32;
            }
            if ((b & 4) != 0) {
                i |= 16;
            }
            if ((b & 8) != 0) {
                i |= 192;
            }
            if ((b & 16) != 0) {
                i |= 1024;
            }
            if ((b & 32) != 0) {
                i |= 768;
            }
            if ((b & 128) != 0) {
                i |= 201326592;
            }
            byte b2 = bArr[1];
            if ((b2 & 1) != 0) {
                i |= 81920;
            }
            if ((b2 & 2) != 0) {
                i |= 8192;
            }
            if ((b2 & 4) != 0) {
                i |= 32768;
            }
            if ((b2 & 8) != 0) {
                i |= 6144;
            }
            if ((b2 & 16) != 0) {
                i |= 33554432;
            }
            if ((b2 & 32) != 0) {
                i |= 262144;
            }
            if ((b2 & 64) != 0) {
                i |= 6144;
            }
            if ((b2 & 128) != 0) {
                i |= 3145728;
            }
            byte b3 = bArr[2];
            if ((b3 & 1) != 0) {
                i |= 655360;
            }
            if ((b3 & 2) != 0) {
                i |= 8388608;
            }
            if ((b3 & 4) != 0) {
                return 20971520 | i;
            }
        }
        return i;
    }
}

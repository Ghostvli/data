package okhttp3.internal.idn;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class IdnaMappingTableKt {
    public static final int binarySearch(int i, int i2, Function1<? super Integer, Integer> function1) {
        function1.getClass();
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) / 2;
            int iIntValue = function1.invoke(Integer.valueOf(i4)).intValue();
            if (iIntValue < 0) {
                i3 = i4 - 1;
            } else {
                if (iIntValue <= 0) {
                    return i4;
                }
                i = i4 + 1;
            }
        }
        return (-i) - 1;
    }

    public static final int read14BitInt(String str, int i) {
        str.getClass();
        char cCharAt = str.charAt(i);
        return (cCharAt << 7) + str.charAt(i + 1);
    }
}

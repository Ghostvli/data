package okhttp3.internal.publicsuffix;

import defpackage.bt;
import defpackage.il1;
import defpackage.nw;
import defpackage.ow;
import defpackage.p14;
import defpackage.we0;
import defpackage.wg4;
import defpackage.ww;
import java.net.IDN;
import java.util.List;
import okhttp3.internal._UtilCommonKt;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    private final PublicSuffixList publicSuffixList;
    public static final Companion Companion = new Companion(null);
    private static final ByteString WILDCARD_LABEL = ByteString.Companion.of(42);
    private static final List<String> PREVAILING_RULE = nw.d("*");
    private static PublicSuffixDatabase instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PublicSuffixDatabase(PublicSuffixList publicSuffixList) {
        publicSuffixList.getClass();
        this.publicSuffixList = publicSuffixList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String strBinarySearch;
        String str2;
        List<String> listJ;
        List<String> listJ2;
        this.publicSuffixList.ensureLoaded();
        int size = list.size();
        ByteString[] byteStringArr = new ByteString[size];
        for (int i = 0; i < size; i++) {
            byteStringArr[i] = ByteString.Companion.encodeUtf8(list.get(i));
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                strBinarySearch = null;
                break;
            }
            strBinarySearch = Companion.binarySearch(this.publicSuffixList.getBytes(), byteStringArr, i2);
            if (strBinarySearch != null) {
                break;
            }
            i2++;
        }
        if (size > 1) {
            ByteString[] byteStringArr2 = (ByteString[]) byteStringArr.clone();
            int length = byteStringArr2.length - 1;
            for (int i3 = 0; i3 < length; i3++) {
                byteStringArr2[i3] = WILDCARD_LABEL;
                String strBinarySearch2 = Companion.binarySearch(this.publicSuffixList.getBytes(), byteStringArr2, i3);
                if (strBinarySearch2 != null) {
                    str2 = strBinarySearch2;
                    break;
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int i4 = size - 1;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                String strBinarySearch3 = Companion.binarySearch(this.publicSuffixList.getExceptionBytes(), byteStringArr, i5);
                if (strBinarySearch3 != null) {
                    str = strBinarySearch3;
                    break;
                }
                i5++;
            }
        }
        if (str != null) {
            return wg4.C0("!".concat(str), new char[]{'.'}, false, 0, 6, null);
        }
        if (strBinarySearch == null && str2 == null) {
            return PREVAILING_RULE;
        }
        if (strBinarySearch == null || (listJ = wg4.C0(strBinarySearch, new char[]{'.'}, false, 0, 6, null)) == null) {
            listJ = ow.j();
        }
        if (str2 == null || (listJ2 = wg4.C0(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
            listJ2 = ow.j();
        }
        return listJ.size() > listJ2.size() ? listJ : listJ2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final List<String> splitDomain(String str) {
        List<String> listC0 = wg4.C0(str, new char[]{'.'}, false, 0, 6, null);
        return il1.a(ww.R(listC0), "") ? ww.G(listC0, 1) : listC0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getEffectiveTldPlusOne(String str) {
        int size;
        int size2;
        str.getClass();
        String unicode = IDN.toUnicode(str);
        unicode.getClass();
        List<String> listSplitDomain = splitDomain(unicode);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        return p14.l(p14.i(ww.D(splitDomain(str)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(ByteString byteString, ByteString[] byteStringArr, int i) {
            int i2;
            int iAnd;
            boolean z;
            int iAnd2;
            int size = byteString.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = (i3 + size) / 2;
                while (i4 > -1 && byteString.getByte(i4) != 10) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (byteString.getByte(i2) == 10) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        iAnd = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        iAnd = _UtilCommonKt.and(byteStringArr[i8].getByte(i9), 255);
                        z = z3;
                    }
                    iAnd2 = iAnd - _UtilCommonKt.and(byteString.getByte(i5 + i10), 255);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (byteStringArr[i8].size() != i9) {
                        z2 = z;
                    } else {
                        if (i8 == byteStringArr.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i11 = i7 - i10;
                        int size2 = byteStringArr[i8].size() - i9;
                        int length = byteStringArr.length;
                        for (int i12 = i8 + 1; i12 < length; i12++) {
                            size2 += byteStringArr[i12].size();
                        }
                        if (size2 >= i11) {
                            if (size2 <= i11) {
                                return byteString.substring(i5, i7 + i5).string(bt.b);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                size = i4;
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void resetForTests$okhttp() {
            PublicSuffixDatabase.instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));
        }

        private Companion() {
        }
    }
}

package okhttp3.internal;

import defpackage.sg4;
import defpackage.tp0;
import defpackage.wg4;
import defpackage.wp0;
import defpackage.xp0;
import okhttp3.CacheControl;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class _CacheControlCommonKt {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        builder.getClass();
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int commonClampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl commonForceCache(CacheControl.Companion companion) {
        companion.getClass();
        CacheControl.Builder builderOnlyIfCached = new CacheControl.Builder().onlyIfCached();
        tp0.a aVar = tp0.f;
        return builderOnlyIfCached.m33maxStaleLRDsOJo(wp0.m(Integer.MAX_VALUE, xp0.j)).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        companion.getClass();
        return new CacheControl.Builder().noCache().build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        builder.getClass();
        builder.setImmutable$okhttp(true);
        return builder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        builder.getClass();
        builder.setNoCache$okhttp(true);
        return builder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        builder.getClass();
        builder.setNoStore$okhttp(true);
        return builder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        builder.getClass();
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        builder.getClass();
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CacheControl commonParse(CacheControl.Companion companion, Headers headers) {
        int i;
        String str;
        int iIndexOfElement;
        String string;
        Headers headers2 = headers;
        companion.getClass();
        headers2.getClass();
        int size = headers2.size();
        boolean z = true;
        boolean z2 = true;
        int i2 = 0;
        String str2 = null;
        boolean z3 = false;
        boolean z4 = false;
        int nonNegativeInt = -1;
        int nonNegativeInt2 = -1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int nonNegativeInt3 = -1;
        int nonNegativeInt4 = -1;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (i2 < size) {
            String strName = headers2.name(i2);
            String strValue = headers2.value(i2);
            if (sg4.y(strName, "Cache-Control", z)) {
                if (str2 == null) {
                    str2 = strValue;
                }
                i = 0;
                while (i < strValue.length()) {
                    int iIndexOfElement2 = indexOfElement(strValue, "=,;", i);
                    String string2 = wg4.O0(strValue.substring(i, iIndexOfElement2)).toString();
                    boolean z11 = z;
                    if (iIndexOfElement2 == strValue.length() || strValue.charAt(iIndexOfElement2) == ',' || strValue.charAt(iIndexOfElement2) == ';') {
                        str = strValue;
                        iIndexOfElement = iIndexOfElement2 + 1;
                        string = null;
                    } else {
                        int iIndexOfNonWhitespace = _UtilCommonKt.indexOfNonWhitespace(strValue, iIndexOfElement2 + 1);
                        if (iIndexOfNonWhitespace >= strValue.length() || strValue.charAt(iIndexOfNonWhitespace) != '\"') {
                            str = strValue;
                            iIndexOfElement = indexOfElement(str, ",;", iIndexOfNonWhitespace);
                            string = wg4.O0(str.substring(iIndexOfNonWhitespace, iIndexOfElement)).toString();
                        } else {
                            int i3 = iIndexOfNonWhitespace + 1;
                            String str3 = strValue;
                            int iZ = wg4.Z(str3, '\"', i3, false, 4, null);
                            str = str3;
                            iIndexOfElement = iZ + 1;
                            string = str.substring(i3, iZ);
                        }
                    }
                    int i4 = size;
                    if (sg4.y("no-cache", string2, z11)) {
                        z3 = z11;
                        i = iIndexOfElement;
                        strValue = str;
                        z = z3;
                    } else if (sg4.y("no-store", string2, z11)) {
                        z4 = z11;
                        i = iIndexOfElement;
                        strValue = str;
                        z = z4;
                    } else {
                        if (sg4.y("max-age", string2, z11)) {
                            nonNegativeInt = _UtilCommonKt.toNonNegativeInt(string, -1);
                        } else if (sg4.y("s-maxage", string2, z11)) {
                            nonNegativeInt2 = _UtilCommonKt.toNonNegativeInt(string, -1);
                        } else if (sg4.y("private", string2, z11)) {
                            z5 = z11;
                            i = iIndexOfElement;
                            strValue = str;
                            z = z5;
                        } else if (sg4.y("public", string2, z11)) {
                            z6 = z11;
                            i = iIndexOfElement;
                            strValue = str;
                            z = z6;
                        } else if (sg4.y("must-revalidate", string2, z11)) {
                            z7 = z11;
                            i = iIndexOfElement;
                            strValue = str;
                            z = z7;
                        } else if (sg4.y("max-stale", string2, z11)) {
                            nonNegativeInt3 = _UtilCommonKt.toNonNegativeInt(string, Integer.MAX_VALUE);
                        } else if (sg4.y("min-fresh", string2, z11)) {
                            nonNegativeInt4 = _UtilCommonKt.toNonNegativeInt(string, -1);
                        } else if (sg4.y("only-if-cached", string2, z11)) {
                            z8 = z11;
                            i = iIndexOfElement;
                            strValue = str;
                            z = z8;
                        } else if (sg4.y("no-transform", string2, z11)) {
                            z9 = z11;
                            i = iIndexOfElement;
                            strValue = str;
                            z = z9;
                        } else if (sg4.y("immutable", string2, z11)) {
                            z10 = z11;
                            i = iIndexOfElement;
                            strValue = str;
                            z = z10;
                        }
                        i = iIndexOfElement;
                        strValue = str;
                        z = z11;
                    }
                    size = i4;
                }
                i2++;
                headers2 = headers;
                z = z;
                size = size;
            } else if (!sg4.y(strName, "Pragma", z)) {
                i2++;
                headers2 = headers;
                z = z;
                size = size;
            }
            z2 = false;
            i = 0;
            while (i < strValue.length()) {
            }
            i2++;
            headers2 = headers;
            z = z;
            size = size;
        }
        return new CacheControl(z3, z4, nonNegativeInt, nonNegativeInt2, z5, z6, z7, nonNegativeInt3, nonNegativeInt4, z8, z9, z10, !z2 ? null : str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String commonToString(CacheControl cacheControl) {
        cacheControl.getClass();
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp != null) {
            return headerValue$okhttp;
        }
        StringBuilder sb = new StringBuilder();
        if (cacheControl.noCache()) {
            sb.append("no-cache, ");
        }
        if (cacheControl.noStore()) {
            sb.append("no-store, ");
        }
        if (cacheControl.maxAgeSeconds() != -1) {
            sb.append("max-age=");
            sb.append(cacheControl.maxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.sMaxAgeSeconds() != -1) {
            sb.append("s-maxage=");
            sb.append(cacheControl.sMaxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.isPrivate()) {
            sb.append("private, ");
        }
        if (cacheControl.isPublic()) {
            sb.append("public, ");
        }
        if (cacheControl.mustRevalidate()) {
            sb.append("must-revalidate, ");
        }
        if (cacheControl.maxStaleSeconds() != -1) {
            sb.append("max-stale=");
            sb.append(cacheControl.maxStaleSeconds());
            sb.append(", ");
        }
        if (cacheControl.minFreshSeconds() != -1) {
            sb.append("min-fresh=");
            sb.append(cacheControl.minFreshSeconds());
            sb.append(", ");
        }
        if (cacheControl.onlyIfCached()) {
            sb.append("only-if-cached, ");
        }
        if (cacheControl.noTransform()) {
            sb.append("no-transform, ");
        }
        if (cacheControl.immutable()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length()).getClass();
        String string = sb.toString();
        cacheControl.setHeaderValue$okhttp(string);
        return string;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static final int indexOfElement(String str, String str2, int i) {
        int length = str.length();
        while (i < length) {
            if (wg4.O(str2, str.charAt(i), false, 2, null)) {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int indexOfElement$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOfElement(str, str2, i);
    }
}

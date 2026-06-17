package okhttp3;

import defpackage.il1;
import defpackage.j52;
import defpackage.l52;
import defpackage.qh3;
import defpackage.rp3;
import defpackage.sg4;
import defpackage.we0;
import defpackage.wg4;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final rp3 TYPE_SUBTYPE = new rp3("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final rp3 PARAMETER = new rp3(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MediaType(String str, String str2, String str3, String[] strArr) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        strArr.getClass();
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m87deprecated_subtype() {
        return this.subtype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final String m88deprecated_type() {
        return this.type;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Charset charset(Charset charset) {
        String strParameter = parameter("charset");
        if (strParameter == null) {
            return charset;
        }
        try {
            return Charset.forName(strParameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && il1.a(((MediaType) obj).mediaType, this.mediaType);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getMediaType$okhttp() {
        return this.mediaType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String parameter(String str) {
        str.getClass();
        int i = 0;
        int iB = qh3.b(0, this.parameterNamesAndValues.length - 1, 2);
        if (iB < 0) {
            return null;
        }
        while (!sg4.y(this.parameterNamesAndValues[i], str, true)) {
            if (i == iB) {
                return null;
            }
            i += 2;
        }
        return this.parameterNamesAndValues[i + 1];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String subtype() {
        return this.subtype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.mediaType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String type() {
        return this.type;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.MediaType.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m89deprecated_get(String str) {
            str.getClass();
            return get(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m90deprecated_parse(String str) {
            str.getClass();
            return parse(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final MediaType get(String str) {
            str.getClass();
            l52 l52VarA = MediaType.TYPE_SUBTYPE.a(str, 0);
            if (l52VarA == null) {
                throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
            }
            String str2 = (String) l52VarA.a().get(1);
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            lowerCase.getClass();
            String lowerCase2 = ((String) l52VarA.a().get(2)).toLowerCase(locale);
            lowerCase2.getClass();
            ArrayList arrayList = new ArrayList();
            int iC = l52VarA.c().c();
            while (true) {
                int i = iC + 1;
                if (i >= str.length()) {
                    return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
                }
                l52 l52VarA2 = MediaType.PARAMETER.a(str, i);
                if (l52VarA2 == null) {
                    throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + str.substring(i) + "\" for: \"" + str + '\"').toString());
                }
                j52 j52Var = l52VarA2.b().get(1);
                String strA = j52Var != null ? j52Var.a() : null;
                if (strA == null) {
                    iC = l52VarA2.c().c();
                } else {
                    j52 j52Var2 = l52VarA2.b().get(2);
                    String strA2 = j52Var2 != null ? j52Var2.a() : null;
                    if (strA2 == null) {
                        j52 j52Var3 = l52VarA2.b().get(3);
                        j52Var3.getClass();
                        strA2 = j52Var3.a();
                    } else if (wg4.F0(strA2, '\'', false, 2, null) && wg4.S(strA2, '\'', false, 2, null) && strA2.length() > 2) {
                        strA2 = strA2.substring(1, strA2.length() - 1);
                    }
                    arrayList.add(strA);
                    arrayList.add(strA2);
                    iC = l52VarA2.c().c();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final MediaType parse(String str) {
            str.getClass();
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }
}

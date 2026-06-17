package okhttp3;

import defpackage.gt0;
import defpackage.ht0;
import defpackage.jl;
import defpackage.we0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class TlsVersion {
    private static final /* synthetic */ gt0 $ENTRIES;
    private static final /* synthetic */ TlsVersion[] $VALUES;
    public static final Companion Companion;
    private final String javaName;
    public static final TlsVersion TLS_1_3 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
    public static final TlsVersion TLS_1_2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
    public static final TlsVersion TLS_1_1 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
    public static final TlsVersion TLS_1_0 = new TlsVersion("TLS_1_0", 3, "TLSv1");
    public static final TlsVersion SSL_3_0 = new TlsVersion("SSL_3_0", 4, "SSLv3");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static final /* synthetic */ TlsVersion[] $values() {
        return new TlsVersion[]{TLS_1_3, TLS_1_2, TLS_1_1, TLS_1_0, SSL_3_0};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        TlsVersion[] tlsVersionArr$values = $values();
        $VALUES = tlsVersionArr$values;
        $ENTRIES = ht0.a(tlsVersionArr$values);
        Companion = new Companion(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private TlsVersion(String str, int i, String str2) {
        this.javaName = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final TlsVersion forJavaName(String str) {
        return Companion.forJavaName(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static gt0 getEntries() {
        return $ENTRIES;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static TlsVersion valueOf(String str) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static TlsVersion[] values() {
        return (TlsVersion[]) $VALUES.clone();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m152deprecated_javaName() {
        return this.javaName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String javaName() {
        return this.javaName;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.TlsVersion.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final TlsVersion forJavaName(String str) {
            str.getClass();
            int iHashCode = str.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return TlsVersion.SSL_3_0;
            }
            jl.a("Unexpected TLS version: ".concat(str));
            return null;
        }

        private Companion() {
        }
    }
}

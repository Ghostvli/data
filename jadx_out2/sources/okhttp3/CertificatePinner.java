package okhttp3;

import defpackage.c;
import defpackage.il1;
import defpackage.jl;
import defpackage.ow;
import defpackage.pw;
import defpackage.sg4;
import defpackage.ua;
import defpackage.vu4;
import defpackage.we0;
import defpackage.wg4;
import defpackage.ww;
import defpackage.zt;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.functions.Function0;
import okhttp3.CertificatePinner;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder add(String str, String... strArr) {
            str.getClass();
            strArr.getClass();
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner build() {
            return new CertificatePinner(ww.e0(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Pin(String str, String str2) {
            String str3;
            String canonicalHost;
            str.getClass();
            str2.getClass();
            if (sg4.K(str, "*.", false, 2, null)) {
                str3 = str;
                if (wg4.a0(str3, "*", 1, false, 4, null) != -1) {
                }
                canonicalHost = _HostnamesCommonKt.toCanonicalHost(str3);
                if (canonicalHost != null) {
                    c.a("Invalid pattern: ", str3);
                    throw null;
                }
                this.pattern = canonicalHost;
                if (sg4.K(str2, "sha1/", false, 2, null)) {
                    this.hashAlgorithm = "sha1";
                    ByteString byteStringDecodeBase64 = ByteString.Companion.decodeBase64(str2.substring(5));
                    if (byteStringDecodeBase64 != null) {
                        this.hash = byteStringDecodeBase64;
                        return;
                    } else {
                        jl.a("Invalid pin hash: ".concat(str2));
                        throw null;
                    }
                }
                if (!sg4.K(str2, "sha256/", false, 2, null)) {
                    c.a("pins must start with 'sha256/' or 'sha1/': ", str2);
                    throw null;
                }
                this.hashAlgorithm = "sha256";
                ByteString byteStringDecodeBase642 = ByteString.Companion.decodeBase64(str2.substring(7));
                if (byteStringDecodeBase642 != null) {
                    this.hash = byteStringDecodeBase642;
                    return;
                } else {
                    jl.a("Invalid pin hash: ".concat(str2));
                    throw null;
                }
            }
            str3 = str;
            if ((!sg4.K(str3, "**.", false, 2, null) || wg4.a0(str3, "*", 2, false, 4, null) != -1) && wg4.a0(str3, "*", 0, false, 6, null) != -1) {
                zt.a("Unexpected pattern: ", str3);
                throw null;
            }
            canonicalHost = _HostnamesCommonKt.toCanonicalHost(str3);
            if (canonicalHost != null) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return il1.a(this.pattern, pin.pattern) && il1.a(this.hashAlgorithm, pin.hashAlgorithm) && il1.a(this.hash, pin.hash);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ByteString getHash() {
            return this.hash;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String getPattern() {
            return this.pattern;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            x509Certificate.getClass();
            String str = this.hashAlgorithm;
            if (il1.a(str, "sha256")) {
                return il1.a(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (il1.a(str, "sha1")) {
                return il1.a(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean matchesHostname(String str) {
            str.getClass();
            boolean zK = sg4.K(this.pattern, "**.", false, 2, null);
            String str2 = this.pattern;
            if (zK) {
                int length = str2.length() - 3;
                int length2 = str.length() - length;
                return sg4.B(str, str.length() - length, this.pattern, 3, length, false, 16, null) && (length2 == 0 || str.charAt(length2 - 1) == '.');
            }
            boolean zK2 = sg4.K(str2, "*.", false, 2, null);
            String str3 = this.pattern;
            if (!zK2) {
                return il1.a(str, str3);
            }
            int length3 = str3.length() - 1;
            return sg4.B(str, str.length() - length3, this.pattern, 1, length3, false, 16, null) && wg4.f0(str, '.', (str.length() - length3) + (-1), false, 4, null) == -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        set.getClass();
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List a(CertificatePinner certificatePinner, List list, String str) {
        List<Certificate> listClean;
        CertificateChainCleaner certificateChainCleaner = certificatePinner.certificateChainCleaner;
        if (certificateChainCleaner != null && (listClean = certificateChainCleaner.clean(list, str)) != null) {
            list = listClean;
        }
        ArrayList arrayList = new ArrayList(pw.t(list, 10));
        for (Certificate certificate : list) {
            certificate.getClass();
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void check(final String str, final List<? extends Certificate> list) {
        str.getClass();
        list.getClass();
        check$okhttp(str, new Function0() { // from class: jr
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CertificatePinner.a(this.f, list, str);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void check$okhttp(String str, Function0<? extends List<? extends X509Certificate>> function0) throws SSLPeerUnverifiedException {
        str.getClass();
        function0.getClass();
        List<Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = function0.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            ByteString byteStringSha256Hash = null;
            ByteString byteStringSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (il1.a(hashAlgorithm, "sha256")) {
                    if (byteStringSha256Hash == null) {
                        byteStringSha256Hash = Companion.sha256Hash(x509Certificate);
                    }
                    if (il1.a(pin.getHash(), byteStringSha256Hash)) {
                        return;
                    }
                } else {
                    if (!il1.a(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (byteStringSha1Hash == null) {
                        byteStringSha1Hash = Companion.sha1Hash(x509Certificate);
                    }
                    if (il1.a(pin.getHash(), byteStringSha1Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return il1.a(certificatePinner.pins, this.pins) && il1.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List<Pin> findMatchingPins(String str) {
        str.getClass();
        Set<Pin> set = this.pins;
        List<Pin> listJ = ow.j();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(str)) {
                if (listJ.isEmpty()) {
                    listJ = new ArrayList<>();
                }
                vu4.a(listJ).add(obj);
            }
        }
        return listJ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Set<Pin> getPins() {
        return this.pins;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        int iHashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        certificateChainCleaner.getClass();
        return il1.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.CertificatePinner.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String pin(Certificate certificate) {
            certificate.getClass();
            if (!(certificate instanceof X509Certificate)) {
                jl.a("Certificate pinning requires X509 certificates");
                return null;
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ByteString sha1Hash(X509Certificate x509Certificate) {
            x509Certificate.getClass();
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            encoded.getClass();
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ByteString sha256Hash(X509Certificate x509Certificate) {
            x509Certificate.getClass();
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            encoded.getClass();
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0005: CONSTRUCTOR 
      (r1v0 java.util.Set)
      (wrap:okhttp3.internal.tls.CertificateChainCleaner:?: TERNARY null = ((wrap:int:0x0000: ARITH (r3v0 int) & (2 int) A[WRAPPED]) != (0 int)) ? (null okhttp3.internal.tls.CertificateChainCleaner) : (r2v0 okhttp3.internal.tls.CertificateChainCleaner))
     A[MD:(java.util.Set<okhttp3.CertificatePinner$Pin>, okhttp3.internal.tls.CertificateChainCleaner):void (m)] (LINE:12) call: okhttp3.CertificatePinner.<init>(java.util.Set, okhttp3.internal.tls.CertificateChainCleaner):void type: THIS */
    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i, we0 we0Var) {
        this(set, (i & 2) != 0 ? null : certificateChainCleaner);
    }

    public final void check(String str, Certificate... certificateArr) {
        str.getClass();
        certificateArr.getClass();
        check(str, ua.L(certificateArr));
    }
}

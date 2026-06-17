package okhttp3;

import defpackage.c;
import defpackage.e04;
import defpackage.il1;
import defpackage.jl;
import defpackage.o24;
import defpackage.ow;
import defpackage.pw;
import defpackage.qh3;
import defpackage.qk1;
import defpackage.rp3;
import defpackage.sg4;
import defpackage.vx4;
import defpackage.we0;
import defpackage.wg1;
import defpackage.wg4;
import defpackage.xg1;
import defpackage.xn3;
import defpackage.yg4;
import defpackage.zt;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.url._UrlKt;
import org.jupnp.model.ServiceReference;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpUrl {
    public static final Companion Companion = new Companion(null);
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private HttpUrl(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m64deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m65deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m66deprecated_encodedPath() {
        return encodedPath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m67deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m68deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m69deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m70deprecated_fragment() {
        return this.fragment;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m71deprecated_host() {
        return this.host;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m72deprecated_password() {
        return this.password;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m73deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m74deprecated_pathSize() {
        return pathSize();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m75deprecated_port() {
        return this.port;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m76deprecated_query() {
        return query();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m77deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m78deprecated_querySize() {
        return querySize();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m79deprecated_scheme() {
        return this.scheme;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m80deprecated_uri() {
        return uri();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m81deprecated_url() {
        return url();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m82deprecated_username() {
        return this.username;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(wg4.Z(this.url, '#', 0, false, 6, null) + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        return this.url.substring(wg4.Z(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1, wg4.Z(this.url, '@', 0, false, 6, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String encodedPath() {
        int iZ = wg4.Z(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        return this.url.substring(iZ, _UtilCommonKt.delimiterOffset(str, "?#", iZ, str.length()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List<String> encodedPathSegments() {
        int iZ = wg4.Z(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int iDelimiterOffset = _UtilCommonKt.delimiterOffset(str, "?#", iZ, str.length());
        ArrayList arrayList = new ArrayList();
        while (iZ < iDelimiterOffset) {
            int i = iZ + 1;
            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(this.url, '/', i, iDelimiterOffset);
            arrayList.add(this.url.substring(i, iDelimiterOffset2));
            iZ = iDelimiterOffset2;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iZ = wg4.Z(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        return this.url.substring(iZ, _UtilCommonKt.delimiterOffset(str, '#', iZ, str.length()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, _UtilCommonKt.delimiterOffset(str, ":@", length, str.length()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && il1.a(((HttpUrl) obj).url, this.url);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String fragment() {
        return this.fragment;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.url.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String host() {
        return this.host;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isHttps() {
        return il1.a(this.scheme, "https");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String password() {
        return this.password;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int pathSize() {
        return this.pathSegments.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int port() {
        return this.port;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String queryParameter(String str) {
        str.getClass();
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        qk1 qk1VarI = xn3.i(xn3.j(0, list.size()), 2);
        int iB = qk1VarI.b();
        int iC = qk1VarI.c();
        int iD = qk1VarI.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (!il1.a(str, this.queryNamesAndValues.get(iB))) {
                if (iB != iC) {
                    iB += iD;
                }
            }
            return this.queryNamesAndValues.get(iB + 1);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String queryParameterName(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i * 2);
        str.getClass();
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return o24.d();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.queryNamesAndValues.size() / 2, 1.0f);
        qk1 qk1VarI = xn3.i(xn3.j(0, this.queryNamesAndValues.size()), 2);
        int iB = qk1VarI.b();
        int iC = qk1VarI.c();
        int iD = qk1VarI.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                String str = this.queryNamesAndValues.get(iB);
                str.getClass();
                linkedHashSet.add(str);
                if (iB == iC) {
                    break;
                }
                iB += iD;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        setUnmodifiableSet.getClass();
        return setUnmodifiableSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String queryParameterValue(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List<String> queryParameterValues(String str) {
        str.getClass();
        if (this.queryNamesAndValues == null) {
            return ow.j();
        }
        ArrayList arrayList = new ArrayList(4);
        qk1 qk1VarI = xn3.i(xn3.j(0, this.queryNamesAndValues.size()), 2);
        int iB = qk1VarI.b();
        int iC = qk1VarI.c();
        int iD = qk1VarI.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                if (il1.a(str, this.queryNamesAndValues.get(iB))) {
                    arrayList.add(this.queryNamesAndValues.get(iB + 1));
                }
                if (iB == iC) {
                    break;
                }
                iB += iD;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        builderNewBuilder.getClass();
        return builderNewBuilder.username("").password("").build().toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final HttpUrl resolve(String str) {
        str.getClass();
        Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String scheme() {
        return this.scheme;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.url;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String topPrivateDomain() {
        if (_HostnamesCommonKt.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final URI uri() {
        String string = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new rp3("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").c(string, ""));
                uriCreate.getClass();
                return uriCreate;
            } catch (Exception unused) {
                wg1.a(e);
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            wg1.a(e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String username() {
        return this.username;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.HttpUrl.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public final void toQueryString(List<String> list, StringBuilder sb) {
            qk1 qk1VarI = xn3.i(xn3.j(0, list.size()), 2);
            int iB = qk1VarI.b();
            int iC = qk1VarI.c();
            int iD = qk1VarI.d();
            if ((iD <= 0 || iB > iC) && (iD >= 0 || iC > iB)) {
                return;
            }
            while (true) {
                String str = list.get(iB);
                String str2 = list.get(iB + 1);
                if (iB > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (iB == iC) {
                    return;
                } else {
                    iB += iD;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m83deprecated_get(String str) {
            str.getClass();
            return get(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m86deprecated_parse(String str) {
            str.getClass();
            return parse(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int defaultPort(String str) {
            str.getClass();
            if (il1.a(str, "http")) {
                return 80;
            }
            return il1.a(str, "https") ? 443 : -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final HttpUrl get(String str) {
            str.getClass();
            return new Builder().parse$okhttp(null, str).build();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final HttpUrl parse(String str) {
            str.getClass();
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m85deprecated_get(URL url) {
            url.getClass();
            return get(url);
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m84deprecated_get(URI uri) {
            uri.getClass();
            return get(uri);
        }

        public final HttpUrl get(URL url) {
            url.getClass();
            String string = url.toString();
            string.getClass();
            return parse(string);
        }

        public final HttpUrl get(URI uri) {
            uri.getClass();
            String string = uri.toString();
            string.getClass();
            return parse(string);
        }
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR 
      (r1v0 java.lang.String)
      (r2v0 java.lang.String)
      (r3v0 java.lang.String)
      (r4v0 java.lang.String)
      (r5v0 int)
      (r6v0 java.util.List)
      (r7v0 java.util.List)
      (r8v0 java.lang.String)
      (r9v0 java.lang.String)
     A[MD:(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.util.List<java.lang.String>, java.util.List<java.lang.String>, java.lang.String, java.lang.String):void (m)] (LINE:23) call: okhttp3.HttpUrl.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.util.List, java.util.List, java.lang.String, java.lang.String):void type: THIS */
    public /* synthetic */ HttpUrl(String str, String str2, String str3, String str4, int i, List list, List list2, String str5, String str6, we0 we0Var) {
        this(str, str2, str3, str4, i, list, list2, str5, str6);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Builder {
        private String encodedFragment;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;
        private final List<String> encodedPathSegments = ow.o("");

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final Builder addPathSegments(String str, boolean z) {
            boolean z2;
            Builder builder;
            String str2;
            boolean z3;
            int i = 0;
            while (true) {
                int iDelimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i, str.length());
                if (iDelimiterOffset < str.length()) {
                    z2 = true;
                    str2 = str;
                    z3 = z;
                    builder = this;
                } else {
                    z2 = false;
                    builder = this;
                    str2 = str;
                    z3 = z;
                }
                builder.push(str2, i, iDelimiterOffset, z2, z3);
                i = iDelimiterOffset + 1;
                if (i > str2.length()) {
                    return builder;
                }
                this = builder;
                str = str2;
                z = z3;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            str.getClass();
            return companion.defaultPort(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final boolean isDot(String str) {
            return il1.a(str, ".") || sg4.y(str, "%2e", true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final boolean isDotDot(String str) {
            return il1.a(str, "..") || sg4.y(str, "%2e.", true) || sg4.y(str, ".%2e", true) || sg4.y(str, "%2e%2e", true);
        }

        /* JADX DEBUG: Class process forced to load method for inline: okhttp3.internal.url._UrlKt.canonicalize$default(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, int, java.lang.Object):java.lang.String */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final int parsePort(String str, int i, int i2) {
            int i3;
            try {
                i3 = Integer.parseInt(_UrlKt.canonicalize$default(str, i, i2, "", false, false, false, false, 120, null));
            } catch (NumberFormatException unused) {
            }
            if (1 > i3 || i3 >= 65536) {
                return -1;
            }
            return i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r2.size() - 1, "");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final int portColonOffset(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void push(String str, int i, int i2, boolean z, boolean z2) {
            String strCanonicalize$default = _UrlKt.canonicalize$default(str, i, i2, _UrlKt.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, Token.ASSIGN_MOD, null);
            if (isDot(strCanonicalize$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$default)) {
                pop();
                return;
            }
            int length = this.encodedPathSegments.get(r12.size() - 1).length();
            List<String> list = this.encodedPathSegments;
            if (length == 0) {
                list.set(list.size() - 1, strCanonicalize$default);
            } else {
                list.add(strCanonicalize$default);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            list.getClass();
            int size = list.size() - 2;
            int iB = qh3.b(size, 0, -2);
            if (iB > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                list2.getClass();
                if (il1.a(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    list3.getClass();
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    list4.getClass();
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    list5.getClass();
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == iB) {
                    return;
                } else {
                    size -= 2;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void resolvePath(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int iDelimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i3, i2);
                boolean z = iDelimiterOffset < i2;
                Builder builder = this;
                String str2 = str;
                builder.push(str2, i3, iDelimiterOffset, z, true);
                if (z) {
                    i3 = iDelimiterOffset + 1;
                    this = builder;
                    str = str2;
                } else {
                    this = builder;
                    str = str2;
                    i3 = iDelimiterOffset;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((il1.b(cCharAt, 97) >= 0 && il1.b(cCharAt, Token.FUNCTION) <= 0) || (il1.b(cCharAt, 65) >= 0 && il1.b(cCharAt, 90) <= 0)) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if ('a' > cCharAt2 || cCharAt2 >= '{') {
                        if ('A' > cCharAt2 || cCharAt2 >= '[') {
                            if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final int slashCount(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '/' && cCharAt != '\\') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void toPathString(List<String> list, StringBuilder sb) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append('/');
                sb.append(list.get(i));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final List<String> toQueryNamesAndValues(String str) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                String str2 = str;
                int iZ = wg4.Z(str2, '&', i, false, 4, null);
                if (iZ == -1) {
                    iZ = str2.length();
                }
                int iZ2 = wg4.Z(str2, '=', i, false, 4, null);
                if (iZ2 == -1 || iZ2 > iZ) {
                    arrayList.add(str2.substring(i, iZ));
                    arrayList.add(null);
                } else {
                    arrayList.add(str2.substring(i, iZ2));
                    arrayList.add(str2.substring(iZ2 + 1, iZ));
                }
                i = iZ + 1;
                str = str2;
            }
            return arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addEncodedPathSegment(String str) {
            str.getClass();
            push(str, 0, str.length(), false, true);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addEncodedPathSegments(String str) {
            str.getClass();
            return addPathSegments(str, true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addEncodedQueryParameter(String str, String str2) {
            str.getClass();
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            list.getClass();
            list.add(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            list2.getClass();
            list2.add(str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null) : null);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addPathSegment(String str) {
            str.getClass();
            push(str, 0, str.length(), false, false);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder addQueryParameter(String str, String str2) {
            str.getClass();
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            list.getClass();
            list.add(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            list2.getClass();
            list2.add(str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null) : null);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                e04.a("scheme == null");
                return null;
            }
            String strPercentDecode$default = _UrlKt.percentDecode$default(this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$default2 = _UrlKt.percentDecode$default(this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                e04.a("host == null");
                return null;
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(pw.t(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(_UrlKt.percentDecode$default((String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList(pw.t(list2, 10));
                for (String str3 : list2) {
                    arrayList3.add(str3 != null ? _UrlKt.percentDecode$default(str3, 0, 0, true, 3, null) : null);
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$default, strPercentDecode$default2, str2, iEffectivePort, arrayList2, arrayList, str4 != null ? _UrlKt.percentDecode$default(str4, 0, 0, false, 7, null) : null, toString(), null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", true, false, false, true, 51, null) : null;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder encodedPassword(String str) {
            str.getClass();
            this.encodedPassword = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, Token.HOOK, null);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder encodedPath(String str) {
            str.getClass();
            if (sg4.K(str, ServiceReference.DELIMITER, false, 2, null)) {
                resolvePath(str, 0, str.length());
                return this;
            }
            zt.a("unexpected encodedPath: ", str);
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder encodedQuery(String str) {
            String strCanonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 83, null)) == null) ? null : toQueryNamesAndValues(strCanonicalize$default);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder encodedUsername(String str) {
            str.getClass();
            this.encodedUsername = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, Token.HOOK, null);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", false, false, false, true, 59, null) : null;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String getHost$okhttp() {
            return this.host;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int getPort$okhttp() {
            return this.port;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder host(String str) {
            str.getClass();
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            c.a("unexpected host: ", str);
            return null;
        }

        /* JADX DEBUG: Class process forced to load method for inline: okhttp3.internal._UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(java.lang.String, int, int, int, java.lang.Object):int */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            String str2;
            int iDelimiterOffset;
            Builder builder;
            boolean z;
            int i;
            int i2;
            char c;
            String str3 = str;
            str3.getClass();
            Builder builder2 = null;
            int iIndexOfFirstNonAsciiWhitespace$default = _UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(str3, 0, 0, 3, null);
            int iIndexOfLastNonAsciiWhitespace$default = _UtilCommonKt.indexOfLastNonAsciiWhitespace$default(str3, iIndexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            int iSchemeDelimiterOffset = schemeDelimiterOffset(str3, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            boolean z2 = true;
            if (iSchemeDelimiterOffset != -1) {
                if (sg4.H(str3, "https:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!sg4.H(str3, "http:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str3.substring(0, iSchemeDelimiterOffset) + '\'');
                    }
                    this.scheme = "http";
                    iIndexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    if (str3.length() > 6) {
                        str2 = yg4.T0(str3, 6) + "...";
                    } else {
                        str2 = str3;
                    }
                    jl.a("Expected URL scheme 'http' or 'https' but no scheme was found for ".concat(str2));
                    return null;
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = slashCount(str3, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            char c2 = '#';
            if (iSlashCount >= 2 || httpUrl == null || !il1.a(httpUrl.scheme(), this.scheme)) {
                boolean z3 = false;
                boolean z4 = false;
                int i3 = iIndexOfFirstNonAsciiWhitespace$default + iSlashCount;
                while (true) {
                    iDelimiterOffset = _UtilCommonKt.delimiterOffset(str3, "@/\\?#", i3, iIndexOfLastNonAsciiWhitespace$default);
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace$default ? str3.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z3) {
                            builder = builder2;
                            z = z2;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.encodedPassword);
                            sb.append("%40");
                            str3 = str;
                            i = iDelimiterOffset;
                            sb.append(_UrlKt.canonicalize$default(str3, i3, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, Token.ASSIGN_MOD, null));
                            this.encodedPassword = sb.toString();
                        } else {
                            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(str3, ':', i3, iDelimiterOffset);
                            builder = builder2;
                            z = z2;
                            String strCanonicalize$default = _UrlKt.canonicalize$default(str3, i3, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, Token.ASSIGN_MOD, null);
                            if (z4) {
                                strCanonicalize$default = this.encodedUsername + "%40" + strCanonicalize$default;
                            }
                            this.encodedUsername = strCanonicalize$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                i2 = iDelimiterOffset;
                                this.encodedPassword = _UrlKt.canonicalize$default(str, iDelimiterOffset2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, Token.ASSIGN_MOD, null);
                                z3 = z;
                            } else {
                                i2 = iDelimiterOffset;
                            }
                            str3 = str;
                            i = i2;
                            z4 = z;
                        }
                        i3 = i + 1;
                        z2 = z;
                        builder2 = builder;
                        c2 = '#';
                    }
                }
                Builder builder3 = builder2;
                int iPortColonOffset = portColonOffset(str3, i3, iDelimiterOffset);
                int i4 = iPortColonOffset + 1;
                if (i4 < iDelimiterOffset) {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str3, i3, iPortColonOffset, false, 4, null));
                    int port = parsePort(str3, i4, iDelimiterOffset);
                    this.port = port;
                    if (port == -1) {
                        xg1.a("Invalid URL port: \"", str3.substring(i4, iDelimiterOffset));
                        return builder3;
                    }
                } else {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str3, i3, iPortColonOffset, false, 4, null));
                    Companion companion = HttpUrl.Companion;
                    String str4 = this.scheme;
                    str4.getClass();
                    this.port = companion.defaultPort(str4);
                }
                if (this.host == null) {
                    xg1.a("Invalid URL host: \"", str3.substring(i3, iPortColonOffset));
                    return builder3;
                }
                iIndexOfFirstNonAsciiWhitespace$default = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace$default == iIndexOfLastNonAsciiWhitespace$default || str3.charAt(iIndexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int iDelimiterOffset3 = _UtilCommonKt.delimiterOffset(str3, "?#", iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            resolvePath(str3, iIndexOfFirstNonAsciiWhitespace$default, iDelimiterOffset3);
            if (iDelimiterOffset3 >= iIndexOfLastNonAsciiWhitespace$default || str3.charAt(iDelimiterOffset3) != '?') {
                c = '#';
            } else {
                c = '#';
                int iDelimiterOffset4 = _UtilCommonKt.delimiterOffset(str3, '#', iDelimiterOffset3, iIndexOfLastNonAsciiWhitespace$default);
                this.encodedQueryNamesAndValues = toQueryNamesAndValues(_UrlKt.canonicalize$default(str3, iDelimiterOffset3 + 1, iDelimiterOffset4, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 80, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iIndexOfLastNonAsciiWhitespace$default && str3.charAt(iDelimiterOffset3) == c) {
                this.encodedFragment = _UrlKt.canonicalize$default(str3, iDelimiterOffset3 + 1, iIndexOfLastNonAsciiWhitespace$default, "", true, false, false, true, 48, null);
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder password(String str) {
            str.getClass();
            this.encodedPassword = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, Token.EXPORT, null);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder port(int i) {
            if (1 > i || i >= 65536) {
                vx4.a("unexpected port: ", i);
                return null;
            }
            this.port = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder query(String str) {
            String strCanonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, false, false, true, false, 91, null)) == null) ? null : toQueryNamesAndValues(strCanonicalize$default);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new rp3("[\"<>^`{|}]").c(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.encodedPathSegments;
                list.set(i, _UrlKt.canonicalize$default(list.get(i), 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, 99, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list2.get(i2);
                    list2.set(i2, str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, 67, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? _UrlKt.canonicalize$default(str3, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET_URI, true, true, false, true, 35, null) : null;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder removeAllEncodedQueryParameters(String str) {
            str.getClass();
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder removeAllQueryParameters(String str) {
            str.getClass();
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder scheme(String str) {
            str.getClass();
            if (sg4.y(str, "http", true)) {
                this.scheme = "http";
                return this;
            }
            if (sg4.y(str, "https", true)) {
                this.scheme = "https";
                return this;
            }
            c.a("unexpected scheme: ", str);
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setEncodedPassword$okhttp(String str) {
            str.getClass();
            this.encodedPassword = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder setEncodedPathSegment(int i, String str) {
            str.getClass();
            String strCanonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, true, false, false, false, Token.HOOK, null);
            this.encodedPathSegments.set(i, strCanonicalize$default);
            if (!isDot(strCanonicalize$default) && !isDotDot(strCanonicalize$default)) {
                return this;
            }
            zt.a("unexpected path segment: ", str);
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder setEncodedQueryParameter(String str, String str2) {
            str.getClass();
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setEncodedUsername$okhttp(String str) {
            str.getClass();
            this.encodedUsername = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder setPathSegment(int i, String str) {
            str.getClass();
            String strCanonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, false, false, false, false, Token.EXPORT, null);
            if (isDot(strCanonicalize$default) || isDotDot(strCanonicalize$default)) {
                zt.a("unexpected path segment: ", str);
                return null;
            }
            this.encodedPathSegments.set(i, strCanonicalize$default);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder setQueryParameter(String str, String str2) {
            str.getClass();
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                str2.getClass();
                if (wg4.O(str2, ':', false, 2, null)) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 != null) {
                    Companion companion = HttpUrl.Companion;
                    str3.getClass();
                    if (iEffectivePort != companion.defaultPort(str3)) {
                        sb.append(':');
                        sb.append(iEffectivePort);
                    }
                }
            }
            toPathString(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                Companion companion2 = HttpUrl.Companion;
                List<String> list = this.encodedQueryNamesAndValues;
                list.getClass();
                companion2.toQueryString(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Builder username(String str) {
            str.getClass();
            this.encodedUsername = _UrlKt.canonicalize$default(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, Token.EXPORT, null);
            return this;
        }

        public final Builder addPathSegments(String str) {
            str.getClass();
            return addPathSegments(str, false);
        }
    }

    public final Builder newBuilder(String str) {
        str.getClass();
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}

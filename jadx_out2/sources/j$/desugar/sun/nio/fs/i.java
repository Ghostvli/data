package j$.desugar.sun.nio.fs;

import j$.nio.file.FileSystem;
import j$.nio.file.Path;
import j$.nio.file.attribute.a0;
import j$.nio.file.e0;
import j$.nio.file.w;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends FileSystem {
    public final String a;
    public final String b;
    public final m c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i(m mVar, String str, String str2) {
        this.c = mVar;
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final Iterable a() {
        throw new UnsupportedOperationException("");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0120, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x013b, code lost:
    
        if (r7 != ']') goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x013d, code lost:
    
        r1.append("]]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x014d, code lost:
    
        throw new java.util.regex.PatternSyntaxException("Missing ']", r0, r3 - 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00fe A[SYNTHETIC] */
    @Override // j$.nio.file.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final w b(String str) {
        boolean z;
        int iIndexOf = str.indexOf(58);
        if (iIndexOf <= 0 || iIndexOf == str.length()) {
            throw new IllegalArgumentException(String.format("Requested <syntax>:<pattern> spliterator(':') position(%d) is out of bound in %s", Integer.valueOf(iIndexOf), str));
        }
        int i = 0;
        String strSubstring = str.substring(0, iIndexOf);
        boolean z2 = true;
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring.equalsIgnoreCase("glob")) {
            StringBuilder sb = new StringBuilder("^");
            int i2 = 0;
            boolean z3 = false;
            while (i2 < strSubstring2.length()) {
                int i3 = i2 + 1;
                char cCharAt = strSubstring2.charAt(i2);
                if (cCharAt != '*') {
                    if (cCharAt != ',') {
                        char c = '/';
                        if (cCharAt == '/') {
                            z = z2;
                            sb.append(cCharAt);
                        } else if (cCharAt == '?') {
                            z = z2;
                            sb.append("[^/]");
                        } else if (cCharAt == '{') {
                            z = z2;
                            if (z3) {
                                throw new PatternSyntaxException("Cannot nest groups", strSubstring2, i2);
                            }
                            sb.append("(?:(?:");
                            z3 = z;
                        } else if (cCharAt == '}') {
                            z = z2;
                            if (z3) {
                                sb.append("))");
                                z3 = false;
                            } else {
                                sb.append('}');
                            }
                        } else if (cCharAt == '[') {
                            sb.append("[[^/]&&[");
                            if (g.x(strSubstring2, i3) == '^') {
                                sb.append("\\^");
                                i2 += 2;
                            } else {
                                if (g.x(strSubstring2, i3) == '!') {
                                    sb.append('^');
                                    i3 = i2 + 2;
                                }
                                if (g.x(strSubstring2, i3) == '-') {
                                    sb.append('-');
                                    i2 = i3 + 1;
                                } else {
                                    i2 = i3;
                                }
                            }
                            boolean z4 = false;
                            char c2 = 0;
                            while (true) {
                                if (i2 >= strSubstring2.length()) {
                                    z = z2;
                                    break;
                                }
                                int i4 = i2 + 1;
                                char cCharAt2 = strSubstring2.charAt(i2);
                                if (cCharAt2 == ']') {
                                    z = z2;
                                    i2 = i4;
                                    cCharAt = cCharAt2;
                                    break;
                                }
                                if (cCharAt2 == c) {
                                    throw new PatternSyntaxException("Explicit 'name separator' in class", strSubstring2, i2);
                                }
                                if (cCharAt2 == '\\' || cCharAt2 == '[') {
                                    z = z2;
                                } else {
                                    z = z2;
                                    if (cCharAt2 == '&' && g.x(strSubstring2, i4) == '&') {
                                    }
                                    sb.append(cCharAt2);
                                    if (cCharAt2 == '-') {
                                        c = '/';
                                        z2 = z;
                                        z4 = z2;
                                        i2 = i4;
                                        cCharAt = cCharAt2;
                                        c2 = cCharAt;
                                    } else {
                                        if (!z4) {
                                            throw new PatternSyntaxException("Invalid range", strSubstring2, i2);
                                        }
                                        int i5 = i2 + 2;
                                        cCharAt = g.x(strSubstring2, i4);
                                        if (cCharAt == 0 || cCharAt == ']') {
                                            break;
                                        }
                                        if (cCharAt < c2) {
                                            throw new PatternSyntaxException("Invalid range", strSubstring2, i2 - 1);
                                        }
                                        sb.append(cCharAt);
                                        c = '/';
                                        z2 = z;
                                        i2 = i5;
                                        z4 = false;
                                    }
                                }
                                sb.append('\\');
                                sb.append(cCharAt2);
                                if (cCharAt2 == '-') {
                                }
                            }
                        } else if (cCharAt != '\\') {
                            if (".^$+{[]|()".indexOf(cCharAt) != -1) {
                                sb.append('\\');
                            }
                            sb.append(cCharAt);
                            z = z2;
                        } else {
                            if (i3 == strSubstring2.length()) {
                                throw new PatternSyntaxException("No character to escape", strSubstring2, i2);
                            }
                            i2 += 2;
                            char cCharAt3 = strSubstring2.charAt(i3);
                            if ("\\*?[{".indexOf(cCharAt3) != -1 || ".^$+{[]|()".indexOf(cCharAt3) != -1) {
                                sb.append('\\');
                            }
                            sb.append(cCharAt3);
                            z = z2;
                        }
                    } else {
                        z = z2;
                        if (z3) {
                            sb.append(")|(?:");
                        } else {
                            sb.append(',');
                        }
                    }
                    i2 = i3;
                } else {
                    z = z2;
                    if (g.x(strSubstring2, i3) == '*') {
                        sb.append(".*");
                        i2 += 2;
                    } else {
                        sb.append("[^/]*");
                        i2 = i3;
                    }
                }
                z2 = z;
            }
            if (z3) {
                throw new PatternSyntaxException("Missing '}", strSubstring2, i2 - 1);
            }
            sb.append('$');
            strSubstring2 = sb.toString();
        } else if (!strSubstring.equalsIgnoreCase("regex")) {
            j$.nio.file.j.e("Syntax '", strSubstring, "' not recognized");
            return null;
        }
        return new h(Pattern.compile(strSubstring2), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final Iterable c() {
        return g.o(new Object[]{new o(this, ServiceReference.DELIMITER, this.a, this.b)});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final String d() {
        return ServiceReference.DELIMITER;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final a0 e() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final boolean f() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final e0 g() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final Path getPath(String str, String[] strArr) {
        if (strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            for (String str2 : strArr) {
                if (!str2.isEmpty()) {
                    if (sb.length() > 0) {
                        sb.append('/');
                    }
                    sb.append(str2);
                }
            }
            str = sb.toString();
        }
        return new o(this, str, this.a, this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final j$.nio.file.spi.c h() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final Set i() {
        return g.p(new Object[]{"basic"});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.nio.file.FileSystem
    public final boolean isOpen() {
        return true;
    }
}

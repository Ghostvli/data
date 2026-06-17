package defpackage;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sp3 {
    public static final boolean b = b();
    public final Pattern a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements b {
        public final Matcher a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Matcher matcher) {
            this.a = matcher;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // sp3.b
        public boolean find() {
            return this.a.find();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        boolean find();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sp3(Pattern pattern) {
        this.a = pattern;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sp3 a(String str) {
        if (d()) {
            return eo3.a(str);
        }
        try {
            return new sp3(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            throw new az4("Pattern syntax error: " + e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b() {
        try {
            try {
                Class<?> cls = Class.forName("com.google.re2j.Pattern", false, sp3.class.getClassLoader());
                try {
                    Class<?> cls2 = Class.forName("java.lang.Module");
                    Method method = Class.class.getMethod("getModule", null);
                    Object objInvoke = method.invoke(sp3.class, null);
                    Object objInvoke2 = method.invoke(cls, null);
                    if (((Boolean) cls2.getMethod("canRead", cls2).invoke(objInvoke, objInvoke2)).booleanValue()) {
                        return true;
                    }
                    cls2.getMethod("addReads", cls2).invoke(objInvoke, objInvoke2);
                    return true;
                } catch (ClassNotFoundException unused) {
                    return true;
                }
            } catch (ClassNotFoundException unused2) {
                return false;
            }
        } catch (ReflectiveOperationException e) {
            System.err.println("Warning: (bug? please report) couldn't access re2j from jsoup due to modules: " + e);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean d() {
        return b && e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e() {
        return Boolean.parseBoolean(System.getProperty("jsoup.useRe2j", "true"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b c(CharSequence charSequence) {
        return new a(this.a.matcher(charSequence));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.a.toString();
    }
}

package defpackage;

import com.google.re2j.Matcher;
import defpackage.sp3;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class eo3 extends sp3 {
    public static final Pattern d = Pattern.compile("");
    public final com.google.re2j.Pattern c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements sp3.b {
        public final Matcher a;

        public a(Matcher matcher) {
            this.a = matcher;
        }

        @Override // sp3.b
        public boolean find() {
            return this.a.find();
        }
    }

    public eo3(com.google.re2j.Pattern pattern) {
        super(d);
        this.c = pattern;
    }

    public static sp3 a(String str) {
        try {
            return new eo3(com.google.re2j.Pattern.compile(str));
        } catch (OutOfMemoryError | StackOverflowError e) {
            throw new az4("Pattern complexity error: " + e.getMessage());
        } catch (RuntimeException e2) {
            throw new az4("Pattern syntax error: " + e2.getMessage());
        }
    }

    @Override // defpackage.sp3
    public sp3.b c(CharSequence charSequence) {
        return new a(this.c.matcher(charSequence));
    }

    @Override // defpackage.sp3
    public String toString() {
        return this.c.toString();
    }
}

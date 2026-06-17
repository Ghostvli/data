package defpackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class wn1 {
    public final String a;

    public wn1(String str) {
        this.a = (String) gg3.q(str);
    }

    public static wn1 g(char c) {
        return new wn1(String.valueOf(c));
    }

    public static wn1 h(String str) {
        return new wn1(str);
    }

    public Appendable b(Appendable appendable, Iterator it) throws IOException {
        gg3.q(appendable);
        if (it.hasNext()) {
            appendable.append(i(it.next()));
            while (it.hasNext()) {
                appendable.append(this.a);
                appendable.append(i(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder c(StringBuilder sb, Iterable iterable) {
        return d(sb, iterable.iterator());
    }

    public final StringBuilder d(StringBuilder sb, Iterator it) {
        try {
            b(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public String e(Iterable iterable) {
        return f(iterable.iterator());
    }

    public final String f(Iterator it) {
        return d(new StringBuilder(), it).toString();
    }

    public CharSequence i(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public a j(String str) {
        return new a(this, str, null);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final wn1 a;
        public final String b;

        public a(wn1 wn1Var, String str) {
            this.a = wn1Var;
            this.b = (String) gg3.q(str);
        }

        public Appendable a(Appendable appendable, Iterator it) throws IOException {
            gg3.q(appendable);
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                appendable.append(this.a.i(entry.getKey()));
                appendable.append(this.b);
                appendable.append(this.a.i(entry.getValue()));
                while (it.hasNext()) {
                    appendable.append(this.a.a);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    appendable.append(this.a.i(entry2.getKey()));
                    appendable.append(this.b);
                    appendable.append(this.a.i(entry2.getValue()));
                }
            }
            return appendable;
        }

        public StringBuilder b(StringBuilder sb, Iterable iterable) {
            return c(sb, iterable.iterator());
        }

        public StringBuilder c(StringBuilder sb, Iterator it) {
            try {
                a(sb, it);
                return sb;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ a(wn1 wn1Var, String str, vn1 vn1Var) {
            this(wn1Var, str);
        }
    }
}

package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ja1 extends Exception {
    public static final StackTraceElement[] l = new StackTraceElement[0];
    public final List f;
    public wq1 g;
    public ba0 h;
    public Class i;
    public String j;
    public Exception k;

    public ja1(String str, List list) {
        this.j = str;
        setStackTrace(l);
        this.f = list;
    }

    public static void b(List list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e) {
            wg1.a(e);
        }
    }

    public static void c(List list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof ja1) {
                ((ja1) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i = i2;
        }
    }

    public static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            wg1.a(th);
        }
    }

    public final void a(Throwable th, List list) {
        if (th instanceof ja1) {
            Iterator it = ((ja1) th).e().iterator();
            while (it.hasNext()) {
                a((Throwable) it.next(), list);
            }
        } else if (th != null) {
            list.add(th);
        }
    }

    public List e() {
        return this.f;
    }

    public List f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List listF = f();
        int size = listF.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), (Throwable) listF.get(i));
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.j);
        sb.append(this.i != null ? ", " + this.i : "");
        sb.append(this.h != null ? ", " + this.h : "");
        sb.append(this.g != null ? ", " + this.g : "");
        List<Throwable> listF = f();
        if (listF.isEmpty()) {
            return sb.toString();
        }
        if (listF.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listF.size());
            sb.append(" root causes:");
        }
        for (Throwable th : listF) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public final void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public void i(wq1 wq1Var, ba0 ba0Var) {
        j(wq1Var, ba0Var, null);
    }

    public void j(wq1 wq1Var, ba0 ba0Var, Class cls) {
        this.g = wq1Var;
        this.h = ba0Var;
        this.i = cls;
    }

    public void k(Exception exc) {
        this.k = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    public ja1(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    public ja1(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Appendable {
        public final Appendable f;
        public boolean g = true;

        public a(Appendable appendable) {
            this.f = appendable;
        }

        public final CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z = false;
            if (this.g) {
                this.g = false;
                this.f.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.g = z;
            this.f.append(charSequenceA, i, i2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.g) {
                this.g = false;
                this.f.append("  ");
            }
            this.g = c == '\n';
            this.f.append(c);
            return this;
        }
    }
}

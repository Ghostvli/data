package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import defpackage.r95;
import defpackage.w95;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class jk4 {
    public final View a;
    public final ArrayList b = new ArrayList();
    public lk1 c;
    public lk1 d;
    public int e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends View {
        public final /* synthetic */ ViewGroup f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, ViewGroup viewGroup) {
            super(context);
            this.f = viewGroup;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            Drawable background = this.f.getBackground();
            int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
            if (jk4.this.e != color) {
                jk4.this.e = color;
                for (int size = jk4.this.b.size() - 1; size >= 0; size--) {
                    ((c) jk4.this.b.get(size)).e(color);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends r95.b {
        public final HashMap c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i) {
            super(i);
            this.c = new HashMap();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // r95.b
        public void b(r95 r95Var) {
            if (f(r95Var)) {
                this.c.remove(r95Var);
                for (int size = jk4.this.b.size() - 1; size >= 0; size--) {
                    ((c) jk4.this.b.get(size)).d();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // r95.b
        public void c(r95 r95Var) {
            if (f(r95Var)) {
                for (int size = jk4.this.b.size() - 1; size >= 0; size--) {
                    ((c) jk4.this.b.get(size)).c();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // r95.b
        public w95 d(w95 w95Var, List list) {
            RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
            int i = 0;
            for (int size = list.size() - 1; size >= 0; size--) {
                r95 r95Var = (r95) list.get(size);
                Integer num = (Integer) this.c.get(r95Var);
                if (num != null) {
                    int iIntValue = num.intValue();
                    float fA = r95Var.a();
                    if ((iIntValue & 1) != 0) {
                        rectF.left = fA;
                    }
                    if ((iIntValue & 2) != 0) {
                        rectF.top = fA;
                    }
                    if ((iIntValue & 4) != 0) {
                        rectF.right = fA;
                    }
                    if ((iIntValue & 8) != 0) {
                        rectF.bottom = fA;
                    }
                    i |= iIntValue;
                }
            }
            lk1 lk1VarI = jk4.this.i(w95Var);
            for (int size2 = jk4.this.b.size() - 1; size2 >= 0; size2--) {
                ((c) jk4.this.b.get(size2)).a(i, lk1VarI, rectF);
            }
            return w95Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // r95.b
        public r95.a e(r95 r95Var, r95.a aVar) {
            if (!f(r95Var)) {
                return aVar;
            }
            lk1 lk1VarB = aVar.b();
            lk1 lk1VarA = aVar.a();
            int i = lk1VarB.a != lk1VarA.a ? 1 : 0;
            if (lk1VarB.b != lk1VarA.b) {
                i |= 2;
            }
            if (lk1VarB.c != lk1VarA.c) {
                i |= 4;
            }
            if (lk1VarB.d != lk1VarA.d) {
                i |= 8;
            }
            this.c.put(r95Var, Integer.valueOf(i));
            return aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean f(r95 r95Var) {
            return (r95Var.d() & w95.n.e()) != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void a(int i, lk1 lk1Var, RectF rectF);

        void b(lk1 lk1Var, lk1 lk1Var2);

        void c();

        void d();

        void e(int i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jk4(ViewGroup viewGroup) {
        lk1 lk1Var = lk1.e;
        this.c = lk1Var;
        this.d = lk1Var;
        Drawable background = viewGroup.getBackground();
        this.e = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        a aVar = new a(viewGroup.getContext(), viewGroup);
        this.a = aVar;
        aVar.setWillNotDraw(true);
        l35.p0(aVar, new d63() { // from class: hk4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.d63
            public final w95 a(View view, w95 w95Var) {
                return jk4.b(this.a, view, w95Var);
            }
        });
        l35.x0(aVar, new b(0));
        viewGroup.addView(aVar, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(jk4 jk4Var) {
        ViewParent parent = jk4Var.a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(jk4Var.a);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ w95 b(jk4 jk4Var, View view, w95 w95Var) {
        lk1 lk1VarI = jk4Var.i(w95Var);
        lk1 lk1VarJ = jk4Var.j(w95Var);
        if (!lk1VarI.equals(jk4Var.c) || !lk1VarJ.equals(jk4Var.d)) {
            jk4Var.c = lk1VarI;
            jk4Var.d = lk1VarJ;
            for (int size = jk4Var.b.size() - 1; size >= 0; size--) {
                ((c) jk4Var.b.get(size)).b(lk1VarI, lk1VarJ);
            }
        }
        return w95Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(c cVar) {
        if (this.b.contains(cVar)) {
            return;
        }
        this.b.add(cVar);
        cVar.b(this.c, this.d);
        cVar.e(this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        this.a.post(new Runnable() { // from class: ik4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                jk4.a(this.f);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lk1 i(w95 w95Var) {
        return lk1.b(w95Var.f(w95.n.e()), w95Var.f(w95.n.f()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final lk1 j(w95 w95Var) {
        return lk1.b(w95Var.g(w95.n.e()), w95Var.g(w95.n.f()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean k() {
        return !this.b.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(c cVar) {
        this.b.remove(cVar);
    }
}

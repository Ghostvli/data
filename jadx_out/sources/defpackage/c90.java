package defpackage;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import defpackage.dh1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class c90 {
    public final GestureDetector a;
    public bh1 b;
    public RectF c;
    public float d;
    public float e;
    public final GestureDetector.OnGestureListener f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (c90.this.b == null) {
                return false;
            }
            c90.this.b.getOnDanmakuClickListener();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            c90.this.b.getOnDanmakuClickListener();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            dh1 dh1VarL = c90.this.l(motionEvent.getX(), motionEvent.getY());
            boolean zJ = false;
            if (dh1VarL != null && !dh1VarL.isEmpty()) {
                zJ = c90.this.j(dh1VarL, false);
            }
            return !zJ ? c90.this.k() : zJ;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends dh1.c {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ dh1 c;

        public b(float f, float f2, dh1 dh1Var) {
            this.a = f;
            this.b = f2;
            this.c = dh1Var;
        }

        @Override // dh1.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(ih ihVar) {
            if (ihVar == null) {
                return 0;
            }
            c90.this.c.set(ihVar.g(), ihVar.l(), ihVar.i(), ihVar.d());
            if (!c90.this.c.intersect(this.a - c90.this.d, this.b - c90.this.e, this.a + c90.this.d, this.b + c90.this.e)) {
                return 0;
            }
            this.c.c(ihVar);
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c90(bh1 bh1Var) {
        a aVar = new a();
        this.f = aVar;
        this.b = bh1Var;
        this.c = new RectF();
        this.a = new GestureDetector(((View) bh1Var).getContext(), aVar);
    }

    public static synchronized c90 h(bh1 bh1Var) {
        return new c90(bh1Var);
    }

    public boolean i(MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }

    public final boolean j(dh1 dh1Var, boolean z) {
        this.b.getOnDanmakuClickListener();
        return false;
    }

    public final boolean k() {
        this.b.getOnDanmakuClickListener();
        return false;
    }

    public final dh1 l(float f, float f2) {
        e90 e90Var = new e90();
        this.c.setEmpty();
        dh1 currentVisibleDanmakus = this.b.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.g(new b(f, f2, e90Var));
        }
        return e90Var;
    }
}

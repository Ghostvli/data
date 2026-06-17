package defpackage;

import android.view.View;
import android.widget.HorizontalScrollView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s35 implements i35 {
    public final HorizontalScrollView a;
    public final MaterialTextView b;
    public final MaterialTextView c;
    public final MaterialTextView d;
    public final MaterialTextView e;
    public final MaterialTextView f;
    public final MaterialTextView g;
    public final MaterialTextView h;
    public final MaterialTextView i;
    public final MaterialTextView j;
    public final MaterialTextView k;
    public final MaterialTextView l;
    public final MaterialTextView m;
    public final MaterialTextView n;
    public final MaterialTextView o;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s35(HorizontalScrollView horizontalScrollView, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3, MaterialTextView materialTextView4, MaterialTextView materialTextView5, MaterialTextView materialTextView6, MaterialTextView materialTextView7, MaterialTextView materialTextView8, MaterialTextView materialTextView9, MaterialTextView materialTextView10, MaterialTextView materialTextView11, MaterialTextView materialTextView12, MaterialTextView materialTextView13, MaterialTextView materialTextView14) {
        this.a = horizontalScrollView;
        this.b = materialTextView;
        this.c = materialTextView2;
        this.d = materialTextView3;
        this.e = materialTextView4;
        this.f = materialTextView5;
        this.g = materialTextView6;
        this.h = materialTextView7;
        this.i = materialTextView8;
        this.j = materialTextView9;
        this.k = materialTextView10;
        this.l = materialTextView11;
        this.m = materialTextView12;
        this.n = materialTextView13;
        this.o = materialTextView14;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static s35 a(View view) {
        int i = nl3.k;
        MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
        if (materialTextView != null) {
            i = nl3.N;
            MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
            if (materialTextView2 != null) {
                i = nl3.Q;
                MaterialTextView materialTextView3 = (MaterialTextView) j35.a(view, i);
                if (materialTextView3 != null) {
                    i = nl3.Z;
                    MaterialTextView materialTextView4 = (MaterialTextView) j35.a(view, i);
                    if (materialTextView4 != null) {
                        i = nl3.c0;
                        MaterialTextView materialTextView5 = (MaterialTextView) j35.a(view, i);
                        if (materialTextView5 != null) {
                            i = nl3.K0;
                            MaterialTextView materialTextView6 = (MaterialTextView) j35.a(view, i);
                            if (materialTextView6 != null) {
                                i = nl3.T0;
                                MaterialTextView materialTextView7 = (MaterialTextView) j35.a(view, i);
                                if (materialTextView7 != null) {
                                    i = nl3.c1;
                                    MaterialTextView materialTextView8 = (MaterialTextView) j35.a(view, i);
                                    if (materialTextView8 != null) {
                                        i = nl3.t1;
                                        MaterialTextView materialTextView9 = (MaterialTextView) j35.a(view, i);
                                        if (materialTextView9 != null) {
                                            i = nl3.C1;
                                            MaterialTextView materialTextView10 = (MaterialTextView) j35.a(view, i);
                                            if (materialTextView10 != null) {
                                                i = nl3.W1;
                                                MaterialTextView materialTextView11 = (MaterialTextView) j35.a(view, i);
                                                if (materialTextView11 != null) {
                                                    i = nl3.d2;
                                                    MaterialTextView materialTextView12 = (MaterialTextView) j35.a(view, i);
                                                    if (materialTextView12 != null) {
                                                        i = nl3.m2;
                                                        MaterialTextView materialTextView13 = (MaterialTextView) j35.a(view, i);
                                                        if (materialTextView13 != null) {
                                                            i = nl3.A2;
                                                            MaterialTextView materialTextView14 = (MaterialTextView) j35.a(view, i);
                                                            if (materialTextView14 != null) {
                                                                return new s35((HorizontalScrollView) view, materialTextView, materialTextView2, materialTextView3, materialTextView4, materialTextView5, materialTextView6, materialTextView7, materialTextView8, materialTextView9, materialTextView10, materialTextView11, materialTextView12, materialTextView13, materialTextView14);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        om1.a("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getRoot()Landroid/view/View; */
    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public HorizontalScrollView getRoot() {
        return this.a;
    }
}

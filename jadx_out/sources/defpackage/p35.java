package defpackage;

import android.view.View;
import android.widget.HorizontalScrollView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class p35 implements i35 {
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

    public p35(HorizontalScrollView horizontalScrollView, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3, MaterialTextView materialTextView4, MaterialTextView materialTextView5, MaterialTextView materialTextView6, MaterialTextView materialTextView7, MaterialTextView materialTextView8, MaterialTextView materialTextView9, MaterialTextView materialTextView10, MaterialTextView materialTextView11, MaterialTextView materialTextView12, MaterialTextView materialTextView13, MaterialTextView materialTextView14) {
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

    public static p35 a(View view) {
        int i = nl3.c;
        MaterialTextView materialTextView = (MaterialTextView) j35.a(view, i);
        if (materialTextView != null) {
            i = nl3.k;
            MaterialTextView materialTextView2 = (MaterialTextView) j35.a(view, i);
            if (materialTextView2 != null) {
                i = nl3.E;
                MaterialTextView materialTextView3 = (MaterialTextView) j35.a(view, i);
                if (materialTextView3 != null) {
                    i = nl3.I;
                    MaterialTextView materialTextView4 = (MaterialTextView) j35.a(view, i);
                    if (materialTextView4 != null) {
                        i = nl3.Q;
                        MaterialTextView materialTextView5 = (MaterialTextView) j35.a(view, i);
                        if (materialTextView5 != null) {
                            i = nl3.o0;
                            MaterialTextView materialTextView6 = (MaterialTextView) j35.a(view, i);
                            if (materialTextView6 != null) {
                                i = nl3.w0;
                                MaterialTextView materialTextView7 = (MaterialTextView) j35.a(view, i);
                                if (materialTextView7 != null) {
                                    i = nl3.A0;
                                    MaterialTextView materialTextView8 = (MaterialTextView) j35.a(view, i);
                                    if (materialTextView8 != null) {
                                        i = nl3.c1;
                                        MaterialTextView materialTextView9 = (MaterialTextView) j35.a(view, i);
                                        if (materialTextView9 != null) {
                                            i = nl3.z1;
                                            MaterialTextView materialTextView10 = (MaterialTextView) j35.a(view, i);
                                            if (materialTextView10 != null) {
                                                i = nl3.C1;
                                                MaterialTextView materialTextView11 = (MaterialTextView) j35.a(view, i);
                                                if (materialTextView11 != null) {
                                                    i = nl3.W1;
                                                    MaterialTextView materialTextView12 = (MaterialTextView) j35.a(view, i);
                                                    if (materialTextView12 != null) {
                                                        i = nl3.d2;
                                                        MaterialTextView materialTextView13 = (MaterialTextView) j35.a(view, i);
                                                        if (materialTextView13 != null) {
                                                            i = nl3.A2;
                                                            MaterialTextView materialTextView14 = (MaterialTextView) j35.a(view, i);
                                                            if (materialTextView14 != null) {
                                                                return new p35((HorizontalScrollView) view, materialTextView, materialTextView2, materialTextView3, materialTextView4, materialTextView5, materialTextView6, materialTextView7, materialTextView8, materialTextView9, materialTextView10, materialTextView11, materialTextView12, materialTextView13, materialTextView14);
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

    @Override // defpackage.i35
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public HorizontalScrollView getRoot() {
        return this.a;
    }
}

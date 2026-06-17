package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import defpackage.a74;
import defpackage.an3;
import defpackage.e12;
import defpackage.e9;
import defpackage.ei1;
import defpackage.em4;
import defpackage.f12;
import defpackage.g22;
import defpackage.h22;
import defpackage.hq3;
import defpackage.jb;
import defpackage.jl;
import defpackage.k02;
import defpackage.l02;
import defpackage.lk3;
import defpackage.m22;
import defpackage.ma3;
import defpackage.o12;
import defpackage.or1;
import defpackage.q22;
import defpackage.r22;
import defpackage.t22;
import defpackage.uy4;
import defpackage.w82;
import defpackage.y22;
import defpackage.z31;
import defpackage.zq1;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final String v = "LottieAnimationView";
    public static final m22 w = new m22() { // from class: c12
        @Override // defpackage.m22
        public final void onResult(Object obj) {
            LottieAnimationView.d((Throwable) obj);
        }
    };
    public final m22 i;
    public final m22 j;
    public m22 k;
    public int l;
    public final g22 m;
    public String n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final Set s;
    public final Set t;
    public t22 u;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements m22 {
        public final WeakReference a;

        public c(LottieAnimationView lottieAnimationView) {
            this.a = new WeakReference(lottieAnimationView);
        }

        @Override // defpackage.m22
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.a.get();
            if (lottieAnimationView == null) {
                return;
            }
            if (lottieAnimationView.l != 0) {
                lottieAnimationView.setImageResource(lottieAnimationView.l);
            }
            (lottieAnimationView.k == null ? LottieAnimationView.w : lottieAnimationView.k).onResult(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements m22 {
        public final WeakReference a;

        public d(LottieAnimationView lottieAnimationView) {
            this.a = new WeakReference(lottieAnimationView);
        }

        @Override // defpackage.m22
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(f12 f12Var) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.a.get();
            if (lottieAnimationView == null) {
                return;
            }
            lottieAnimationView.setComposition(f12Var);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.i = new d(this);
        this.j = new c(this);
        this.l = 0;
        this.m = new g22();
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = new HashSet();
        this.t = new HashSet();
        o(null, lk3.a);
    }

    public static /* synthetic */ r22 c(LottieAnimationView lottieAnimationView, String str) {
        return lottieAnimationView.r ? o12.l(lottieAnimationView.getContext(), str) : o12.m(lottieAnimationView.getContext(), str, null);
    }

    public static /* synthetic */ void d(Throwable th) {
        if (uy4.k(th)) {
            k02.d("Unable to load composition.", th);
        } else {
            l02.a("Unable to parse composition", th);
        }
    }

    public static /* synthetic */ r22 e(LottieAnimationView lottieAnimationView, int i) {
        return lottieAnimationView.r ? o12.x(lottieAnimationView.getContext(), i) : o12.y(lottieAnimationView.getContext(), i, null);
    }

    private void setCompositionTask(t22 t22Var) {
        r22 r22VarE = t22Var.e();
        g22 g22Var = this.m;
        if (r22VarE != null && g22Var == getDrawable() && g22Var.H() == r22VarE.b()) {
            return;
        }
        this.s.add(b.SET_ANIMATION);
        k();
        j();
        this.u = t22Var.d(this.i).c(this.j);
    }

    public jb getAsyncUpdates() {
        return this.m.C();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.m.D();
    }

    public boolean getClipTextToBoundingBox() {
        return this.m.F();
    }

    public boolean getClipToCompositionBounds() {
        return this.m.G();
    }

    public f12 getComposition() {
        Drawable drawable = getDrawable();
        g22 g22Var = this.m;
        if (drawable == g22Var) {
            return g22Var.H();
        }
        return null;
    }

    public long getDuration() {
        f12 composition = getComposition();
        if (composition != null) {
            return (long) composition.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.m.K();
    }

    public String getImageAssetsFolder() {
        return this.m.M();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.m.O();
    }

    public float getMaxFrame() {
        return this.m.Q();
    }

    public float getMinFrame() {
        return this.m.R();
    }

    public ma3 getPerformanceTracker() {
        return this.m.S();
    }

    public float getProgress() {
        return this.m.T();
    }

    public hq3 getRenderMode() {
        return this.m.U();
    }

    public int getRepeatCount() {
        return this.m.V();
    }

    public int getRepeatMode() {
        return this.m.W();
    }

    public float getSpeed() {
        return this.m.X();
    }

    public void i(zq1 zq1Var, Object obj, y22 y22Var) {
        this.m.q(zq1Var, obj, y22Var);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof g22) && ((g22) drawable).U() == hq3.SOFTWARE) {
            this.m.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        g22 g22Var = this.m;
        if (drawable2 == g22Var) {
            super.invalidateDrawable(g22Var);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public final void j() {
        t22 t22Var = this.u;
        if (t22Var != null) {
            t22Var.k(this.i);
            this.u.j(this.j);
        }
    }

    public final void k() {
        this.m.t();
    }

    public void l(boolean z) {
        this.m.y(h22.MergePathsApi19, z);
    }

    public final t22 m(final String str) {
        return isInEditMode() ? new t22(new Callable() { // from class: b12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieAnimationView.c(this.a, str);
            }
        }, true) : this.r ? o12.j(getContext(), str) : o12.k(getContext(), str, null);
    }

    public final t22 n(final int i) {
        return isInEditMode() ? new t22(new Callable() { // from class: d12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieAnimationView.e(this.a, i);
            }
        }, true) : this.r ? o12.v(getContext(), i) : o12.w(getContext(), i, null);
    }

    public final void o(AttributeSet attributeSet, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, an3.a, i, 0);
        this.r = typedArrayObtainStyledAttributes.getBoolean(an3.f, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(an3.r);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(an3.m);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(an3.w);
        if (zHasValue && zHasValue2) {
            jl.a("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            return;
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(an3.r, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(an3.m);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(an3.w)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(an3.l, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(an3.e, false)) {
            this.q = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(an3.p, false)) {
            this.m.O0(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.u)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(an3.u, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.t)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(an3.t, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.v)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(an3.v, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.h)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(an3.h, true));
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.g)) {
            setClipTextToBoundingBox(typedArrayObtainStyledAttributes.getBoolean(an3.g, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.j)) {
            setDefaultFontFileExtension(typedArrayObtainStyledAttributes.getString(an3.j));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(an3.o));
        v(typedArrayObtainStyledAttributes.getFloat(an3.q, 0.0f), typedArrayObtainStyledAttributes.hasValue(an3.q));
        l(typedArrayObtainStyledAttributes.getBoolean(an3.k, false));
        setApplyingOpacityToLayersEnabled(typedArrayObtainStyledAttributes.getBoolean(an3.b, false));
        setApplyingShadowToLayersEnabled(typedArrayObtainStyledAttributes.getBoolean(an3.c, true));
        if (typedArrayObtainStyledAttributes.hasValue(an3.i)) {
            i(new zq1("**"), q22.N, new y22(new a74(e9.a(getContext(), typedArrayObtainStyledAttributes.getResourceId(an3.i, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.s)) {
            int i2 = an3.s;
            hq3 hq3Var = hq3.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i2, hq3Var.ordinal());
            if (iOrdinal >= hq3.values().length) {
                iOrdinal = hq3Var.ordinal();
            }
            setRenderMode(hq3.values()[iOrdinal]);
        }
        if (typedArrayObtainStyledAttributes.hasValue(an3.d)) {
            int i3 = an3.d;
            jb jbVar = jb.AUTOMATIC;
            int iOrdinal2 = typedArrayObtainStyledAttributes.getInt(i3, jbVar.ordinal());
            if (iOrdinal2 >= hq3.values().length) {
                iOrdinal2 = jbVar.ordinal();
            }
            setAsyncUpdates(jb.values()[iOrdinal2]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(an3.n, false));
        if (typedArrayObtainStyledAttributes.hasValue(an3.x)) {
            setUseCompositionFrameRate(typedArrayObtainStyledAttributes.getBoolean(an3.x, false));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.q) {
            return;
        }
        this.m.j0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.n = aVar.f;
        Set set = this.s;
        b bVar = b.SET_ANIMATION;
        if (!set.contains(bVar) && !TextUtils.isEmpty(this.n)) {
            setAnimation(this.n);
        }
        this.o = aVar.g;
        if (!this.s.contains(bVar) && (i = this.o) != 0) {
            setAnimation(i);
        }
        if (!this.s.contains(b.SET_PROGRESS)) {
            v(aVar.h, false);
        }
        if (!this.s.contains(b.PLAY_OPTION) && aVar.i) {
            r();
        }
        if (!this.s.contains(b.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(aVar.j);
        }
        if (!this.s.contains(b.SET_REPEAT_MODE)) {
            setRepeatMode(aVar.k);
        }
        if (this.s.contains(b.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(aVar.l);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f = this.n;
        aVar.g = this.o;
        aVar.h = this.m.T();
        aVar.i = this.m.c0();
        aVar.j = this.m.M();
        aVar.k = this.m.W();
        aVar.l = this.m.V();
        return aVar;
    }

    public boolean p() {
        return this.m.b0();
    }

    public void q() {
        this.q = false;
        this.m.i0();
    }

    public void r() {
        this.s.add(b.PLAY_OPTION);
        this.m.j0();
    }

    public void s(InputStream inputStream, String str) {
        setCompositionTask(o12.o(inputStream, str));
    }

    public void setAnimation(int i) {
        this.o = i;
        this.n = null;
        setCompositionTask(n(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        t(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.r ? o12.z(getContext(), str) : o12.A(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.m.o0(z);
    }

    public void setApplyingShadowToLayersEnabled(boolean z) {
        this.m.p0(z);
    }

    public void setAsyncUpdates(jb jbVar) {
        this.m.q0(jbVar);
    }

    public void setCacheComposition(boolean z) {
        this.r = z;
    }

    public void setClipTextToBoundingBox(boolean z) {
        this.m.r0(z);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.m.s0(z);
    }

    public void setComposition(f12 f12Var) {
        if (or1.a) {
            Log.v(v, "Set Composition \n" + f12Var);
        }
        this.m.setCallback(this);
        this.p = true;
        boolean zT0 = this.m.t0(f12Var);
        if (this.q) {
            this.m.j0();
        }
        this.p = false;
        if (getDrawable() != this.m || zT0) {
            if (!zT0) {
                u();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.t.iterator();
            if (it.hasNext()) {
                w82.a(it.next());
                throw null;
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.m.u0(str);
    }

    public void setFailureListener(m22 m22Var) {
        this.k = m22Var;
    }

    public void setFallbackResource(int i) {
        this.l = i;
    }

    public void setFontAssetDelegate(z31 z31Var) {
        this.m.v0(z31Var);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.m.w0(map);
    }

    public void setFrame(int i) {
        this.m.x0(i);
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.m.y0(z);
    }

    public void setImageAssetDelegate(ei1 ei1Var) {
        this.m.z0(ei1Var);
    }

    public void setImageAssetsFolder(String str) {
        this.m.A0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.o = 0;
        this.n = null;
        j();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.o = 0;
        this.n = null;
        j();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        this.o = 0;
        this.n = null;
        j();
        super.setImageResource(i);
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.m.B0(z);
    }

    public void setMaxFrame(int i) {
        this.m.C0(i);
    }

    public void setMaxProgress(float f) {
        this.m.E0(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.m.G0(str);
    }

    public void setMinFrame(int i) {
        this.m.H0(i);
    }

    public void setMinProgress(float f) {
        this.m.J0(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.m.K0(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.m.L0(z);
    }

    public void setProgress(float f) {
        v(f, true);
    }

    public void setRenderMode(hq3 hq3Var) {
        this.m.N0(hq3Var);
    }

    public void setRepeatCount(int i) {
        this.s.add(b.SET_REPEAT_COUNT);
        this.m.O0(i);
    }

    public void setRepeatMode(int i) {
        this.s.add(b.SET_REPEAT_MODE);
        this.m.P0(i);
    }

    public void setSafeMode(boolean z) {
        this.m.Q0(z);
    }

    public void setSpeed(float f) {
        this.m.R0(f);
    }

    public void setTextDelegate(em4 em4Var) {
        this.m.S0(em4Var);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.m.T0(z);
    }

    public void t(String str, String str2) {
        s(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public final void u() {
        boolean zP = p();
        setImageDrawable(null);
        setImageDrawable(this.m);
        if (zP) {
            this.m.m0();
        }
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        g22 g22Var;
        if (!this.p && drawable == (g22Var = this.m) && g22Var.b0()) {
            q();
        } else if (!this.p && (drawable instanceof g22)) {
            g22 g22Var2 = (g22) drawable;
            if (g22Var2.b0()) {
                g22Var2.i0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public final void v(float f, boolean z) {
        if (z) {
            this.s.add(b.SET_PROGRESS);
        }
        this.m.M0(f);
    }

    public void setMaxFrame(String str) {
        this.m.D0(str);
    }

    public void setMinFrame(String str) {
        this.m.I0(str);
    }

    public void setAnimation(String str) {
        this.n = str;
        this.o = 0;
        setCompositionTask(m(str));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0050a();
        public String f;
        public int g;
        public float h;
        public boolean i;
        public String j;
        public int k;
        public int l;

        /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0050a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcel parcel) {
            super(parcel);
            this.f = parcel.readString();
            this.h = parcel.readFloat();
            this.i = parcel.readInt() == 1;
            this.j = parcel.readString();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f);
            parcel.writeFloat(this.h);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeString(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        public /* synthetic */ a(Parcel parcel, e12 e12Var) {
            this(parcel);
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new d(this);
        this.j = new c(this);
        this.l = 0;
        this.m = new g22();
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = new HashSet();
        this.t = new HashSet();
        o(attributeSet, lk3.a);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new d(this);
        this.j = new c(this);
        this.l = 0;
        this.m = new g22();
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = new HashSet();
        this.t = new HashSet();
        o(attributeSet, i);
    }
}

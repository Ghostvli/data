package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d61 implements LayoutInflater.Factory2 {
    public final k61 f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ w61 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(w61 w61Var) {
            this.f = w61Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            p51 p51VarK = this.f.k();
            this.f.m();
            ub4.p((ViewGroup) p51VarK.N.getParent(), d61.this.f).l();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d61(k61 k61Var) {
        this.f = k61Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        w61 w61VarW;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, Name.LABEL);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, fn3.a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(fn3.b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(fn3.c, -1);
        String string = typedArrayObtainStyledAttributes.getString(fn3.d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !a61.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        p51 p51VarI0 = resourceId != -1 ? this.f.i0(resourceId) : null;
        if (p51VarI0 == null && string != null) {
            p51VarI0 = this.f.j0(string);
        }
        if (p51VarI0 == null && id != -1) {
            p51VarI0 = this.f.i0(id);
        }
        if (p51VarI0 == null) {
            p51VarI0 = this.f.v0().a(context.getClassLoader(), attributeValue);
            p51VarI0.t = true;
            p51VarI0.C = resourceId != 0 ? resourceId : id;
            p51VarI0.D = id;
            p51VarI0.E = string;
            p51VarI0.u = true;
            k61 k61Var = this.f;
            p51VarI0.y = k61Var;
            p51VarI0.z = k61Var.x0();
            p51VarI0.h1(this.f.x0().f(), attributeSet, p51VarI0.g);
            w61VarW = this.f.j(p51VarI0);
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Fragment " + p51VarI0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (p51VarI0.u) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            p51VarI0.u = true;
            k61 k61Var2 = this.f;
            p51VarI0.y = k61Var2;
            p51VarI0.z = k61Var2.x0();
            p51VarI0.h1(this.f.x0().f(), attributeSet, p51VarI0.g);
            w61VarW = this.f.w(p51VarI0);
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + p51VarI0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        b71.f(p51VarI0, viewGroup);
        p51VarI0.M = viewGroup;
        w61VarW.m();
        w61VarW.j();
        View view2 = p51VarI0.N;
        if (view2 == null) {
            wx1.a("Fragment ", attributeValue, " did not create a view.");
            return null;
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (p51VarI0.N.getTag() == null) {
            p51VarI0.N.setTag(string);
        }
        p51VarI0.N.addOnAttachStateChangeListener(new a(w61VarW));
        return p51VarI0.N;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}

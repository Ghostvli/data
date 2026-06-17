package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fongmi.android.tv.bean.Class;
import com.fongmi.android.tv.bean.Filter;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Value;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class x31 extends uh {
    public Class k0;

    private String C2() {
        return S().getString("key");
    }

    public static x31 I2(String str, Class r3, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("y", i);
        bundle.putString("key", str);
        bundle.putParcelable("type", r3);
        x31 x31Var = new x31();
        x31Var.e2(bundle);
        return x31Var;
    }

    public final tu4 A2() {
        return (tu4) T().i0(nl3.J);
    }

    public final HashMap B2() {
        HashMap map = new HashMap();
        for (Filter filter : this.k0.getFilters()) {
            if (filter.getInit() != null) {
                map.put(filter.getKey(), filter.setActivated(filter.getInit()));
            }
        }
        return map;
    }

    public final o75 D2() {
        return (o75) j0();
    }

    public Result E2() {
        return D2().X2();
    }

    public Class F2() {
        return (Class) S().getParcelable("type");
    }

    public final int G2() {
        return S().getInt("y");
    }

    public void H2() {
        T().X0();
    }

    public void J2(String str, HashMap map) {
        tu4 tu4VarW2 = tu4.W2(C2(), str, this.k0.getStyle(), map, this.k0.isFolder(), G2());
        final d71 d71VarO = T().o();
        Optional optionalOfNullable = Optional.ofNullable(A2());
        Objects.requireNonNull(d71VarO);
        optionalOfNullable.ifPresent(new Consumer() { // from class: u31
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                d71VarO.n((tu4) obj);
            }
        });
        d71VarO.b(nl3.J, tu4VarW2);
        d71VarO.g(null);
        d71VarO.h();
    }

    public void K2() {
        Optional.ofNullable(A2()).ifPresent(new Consumer() { // from class: v31
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((tu4) obj).X2();
            }
        });
    }

    public void j(final String str, final Value value) {
        Optional.ofNullable(A2()).ifPresent(new Consumer() { // from class: w31
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((tu4) obj).j(str, value);
            }
        });
    }

    public void q() {
        Optional.ofNullable(A2()).ifPresent(new Consumer() { // from class: t31
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((tu4) obj).q();
            }
        });
    }

    @Override // defpackage.uh
    public boolean t2() {
        return T().q0() > 0;
    }

    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return b61.c(layoutInflater, viewGroup, false);
    }

    @Override // defpackage.uh
    public void x2() {
        this.k0 = F2();
        T().o().q(nl3.J, tu4.W2(C2(), this.k0.getTypeId(), this.k0.getStyle(), B2(), this.k0.isFolder(), G2())).h();
    }
}

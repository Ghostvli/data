package defpackage;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lz4 {
    public final la a;
    public final la b;
    public final la c;

    public lz4(la laVar, la laVar2, la laVar3) {
        this.a = laVar;
        this.b = laVar2;
        this.c = laVar3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i) {
        w(i);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i) {
        w(i);
        C(charSequence);
    }

    public abstract void E(int i);

    public void F(int i, int i2) {
        w(i2);
        E(i);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i) {
        w(i);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i) {
        w(i);
        I(str);
    }

    public void K(nz4 nz4Var, lz4 lz4Var) {
        try {
            e(nz4Var.getClass()).invoke(null, nz4Var, lz4Var);
        } catch (ClassNotFoundException e) {
            cx4.a("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            cx4.a("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            cx4.a("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            cx4.a("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public void L(nz4 nz4Var) {
        if (nz4Var == null) {
            I(null);
            return;
        }
        N(nz4Var);
        lz4 lz4VarB = b();
        K(nz4Var, lz4VarB);
        lz4VarB.a();
    }

    public void M(nz4 nz4Var, int i) {
        w(i);
        L(nz4Var);
    }

    public final void N(nz4 nz4Var) {
        try {
            I(c(nz4Var.getClass()).getName());
        } catch (ClassNotFoundException e) {
            cx4.a(nz4Var.getClass().getSimpleName().concat(" does not have a Parcelizer"), e);
        }
    }

    public abstract void a();

    public abstract lz4 b();

    public final Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws NoSuchMethodException {
        Method method = (Method) this.a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, lz4.class.getClassLoader()).getDeclaredMethod("read", lz4.class);
        this.a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, lz4.class);
        this.b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z, int i) {
        return !m(i) ? z : g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i) {
        return !m(i) ? bArr : i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i) {
        return !m(i) ? charSequence : k();
    }

    public abstract boolean m(int i);

    public nz4 n(String str, lz4 lz4Var) {
        try {
            return (nz4) d(str).invoke(null, lz4Var);
        } catch (ClassNotFoundException e) {
            cx4.a("VersionedParcel encountered ClassNotFoundException", e);
            return null;
        } catch (IllegalAccessException e2) {
            cx4.a("VersionedParcel encountered IllegalAccessException", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            cx4.a("VersionedParcel encountered NoSuchMethodException", e3);
            return null;
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            cx4.a("VersionedParcel encountered InvocationTargetException", e4);
            return null;
        }
    }

    public abstract int o();

    public int p(int i, int i2) {
        return !m(i2) ? i : o();
    }

    public abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i) {
        return !m(i) ? parcelable : q();
    }

    public abstract String s();

    public String t(String str, int i) {
        return !m(i) ? str : s();
    }

    public nz4 u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public nz4 v(nz4 nz4Var, int i) {
        return !m(i) ? nz4Var : u();
    }

    public abstract void w(int i);

    public void x(boolean z, boolean z2) {
    }

    public abstract void y(boolean z);

    public void z(boolean z, int i) {
        w(i);
        y(z);
    }
}

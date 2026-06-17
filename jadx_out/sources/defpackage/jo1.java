package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class jo1 extends Number {
    public String f;
    public boolean g;

    public jo1(String str, boolean z) {
        this.f = str;
        this.g = z;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f);
    }

    @Override // java.lang.Number
    public int intValue() {
        boolean z = this.g;
        String str = this.f;
        return z ? (int) Double.parseDouble(str) : Integer.parseInt(str);
    }

    @Override // java.lang.Number
    public long longValue() {
        boolean z = this.g;
        String str = this.f;
        return z ? (long) Double.parseDouble(str) : Long.parseLong(str);
    }
}

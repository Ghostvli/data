package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ot1 implements Iterator, op1 {
    public static final a k = new a(null);
    public final CharSequence f;
    public int g;
    public int h;
    public int i;
    public int j;

    public ot1(CharSequence charSequence) {
        charSequence.getClass();
        this.f = charSequence;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            bo.a();
            return null;
        }
        this.g = 0;
        int i = this.i;
        int i2 = this.h;
        this.h = this.j + i;
        return this.f.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        int i2;
        int i3 = this.g;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.j < 0) {
            this.g = 2;
            return false;
        }
        int length = this.f.length();
        int length2 = this.f.length();
        for (int i4 = this.h; i4 < length2; i4++) {
            char cCharAt = this.f.charAt(i4);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i4 + 1) < this.f.length() && this.f.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.g = 1;
                this.j = i;
                this.i = length;
                return true;
            }
        }
        i = -1;
        this.g = 1;
        this.j = i;
        this.i = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}

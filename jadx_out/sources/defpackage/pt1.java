package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class pt1 implements f14 {
    public final BufferedReader a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Iterator, op1 {
        public String f;
        public boolean g;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                bo.a();
                return null;
            }
            String str = this.f;
            this.f = null;
            str.getClass();
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f == null && !this.g) {
                String line = pt1.this.a.readLine();
                this.f = line;
                if (line == null) {
                    this.g = true;
                }
            }
            return this.f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public pt1(BufferedReader bufferedReader) {
        bufferedReader.getClass();
        this.a = bufferedReader;
    }

    @Override // defpackage.f14
    public Iterator iterator() {
        return new a();
    }
}

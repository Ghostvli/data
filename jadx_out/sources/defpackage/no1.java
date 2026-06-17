package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class no1 implements Closeable {
    public static final String[] l = new String[128];
    public int f;
    public int[] g = new int[32];
    public String[] h = new String[32];
    public int[] i = new int[32];
    public boolean j;
    public boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final String[] a;
        public final Options b;

        public a(String[] strArr, Options options) {
            this.a = strArr;
            this.b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    no1.P(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i = 0; i <= 31; i++) {
            l[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = l;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static no1 J(BufferedSource bufferedSource) {
        return new so1(bufferedSource);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void P(okio.BufferedSink r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = defpackage.no1.l
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.no1.P(okio.BufferedSink, java.lang.String):void");
    }

    public abstract String B();

    public abstract String F();

    public abstract b K();

    public final void L(int i) {
        int i2 = this.f;
        int[] iArr = this.g;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new go1("Nesting too deep at " + getPath());
            }
            this.g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.h;
            this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.i;
            this.i = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.g;
        int i3 = this.f;
        this.f = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int M(a aVar);

    public abstract void N();

    public abstract void O();

    public final io1 Q(String str) throws io1 {
        throw new io1(str + " at path " + getPath());
    }

    public abstract void c();

    public final String getPath() {
        return oo1.a(this.f, this.g, this.h, this.i);
    }

    public abstract void h();

    public abstract void i();

    public abstract void l();

    public abstract boolean t();

    public abstract boolean u();

    public abstract double v();

    public abstract int y();
}

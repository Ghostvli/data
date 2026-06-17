package defpackage;

import defpackage.hn;
import defpackage.rs2;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p0 implements rs2 {
    protected int memoizedHashCode = 0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        a.addAll((Iterable) iterable, (List) list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void checkByteStringIsUtf8(hn hnVar) {
        if (hnVar.m()) {
            return;
        }
        jl.a("Byte string is not UTF-8.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String a(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract int getSerializedSize(py3 py3Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cw4 newUninitializedMessageException() {
        return new cw4(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            jv jvVarS = jv.S(bArr);
            writeTo(jvVarS);
            jvVarS.c();
            return bArr;
        } catch (IOException e) {
            cx4.a(a("byte array"), e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hn toByteString() {
        try {
            hn.h hVarO = hn.o(getSerializedSize());
            writeTo(hVarO.b());
            return hVarO.a();
        } catch (IOException e) {
            cx4.a(this.a("ByteString"), e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        jv jvVarR = jv.R(outputStream, jv.w(jv.K(serializedSize) + serializedSize));
        jvVarR.A0(serializedSize);
        writeTo(jvVarR);
        jvVarR.P();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeTo(OutputStream outputStream) {
        jv jvVarR = jv.R(outputStream, jv.w(getSerializedSize()));
        writeTo(jvVarR);
        jvVarR.P();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a implements rs2.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(Iterable iterable, List list) {
            if (iterable instanceof Collection) {
                int size = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size);
                } else if (list instanceof mi3) {
                    ((mi3) list).e(list.size() + size);
                }
            }
            int size2 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object obj : iterable) {
                    if (obj == null) {
                        c(list, size2);
                    }
                    list.add(obj);
                }
                return;
            }
            List list2 = (List) iterable;
            int size3 = list2.size();
            for (int i = 0; i < size3; i++) {
                Object obj2 = list2.get(i);
                if (obj2 == null) {
                    c(list, size2);
                }
                list.add(obj2);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            bl1.a(iterable);
            if (iterable instanceof rg3) {
                list.addAll((Collection) iterable);
            } else {
                a(iterable, list);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void c(List list, int i) {
            String str = "Element at index " + (list.size() - i) + " is null.";
            for (int size = list.size() - 1; size >= i; size--) {
                list.remove(size);
            }
            throw new NullPointerException(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static cw4 newUninitializedMessageException(rs2 rs2Var) {
            return new cw4(rs2Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String b(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        public abstract a internalMergeFrom(p0 p0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean mergeDelimitedFrom(InputStream inputStream, xy0 xy0Var) throws IOException {
            int i = inputStream.read();
            if (i == -1) {
                return false;
            }
            m190mergeFrom((InputStream) new C0109a(inputStream, hv.z(i, inputStream)), xy0Var);
            return true;
        }

        @Override // rs2.a
        public abstract a mergeFrom(hv hvVar, xy0 xy0Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: mergeFrom(Lrs2;)Lrs2$a; */
        @Override // rs2.a
        public a mergeFrom(rs2 rs2Var) {
            if (getDefaultInstanceForType().getClass().isInstance(rs2Var)) {
                return internalMergeFrom((p0) rs2Var);
            }
            jl.a("mergeFrom(MessageLite) can only merge messages of the same type.");
            return null;
        }

        /* JADX INFO: renamed from: mergeFrom */
        public abstract a m8mergeFrom(byte[] bArr, int i, int i2);

        /* JADX INFO: renamed from: mergeFrom */
        public abstract a m9mergeFrom(byte[] bArr, int i, int i2, xy0 xy0Var);

        @Deprecated
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        /* JADX INFO: renamed from: p0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0109a extends FilterInputStream implements InputStreamRetargetInterface {
            public int f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0109a(InputStream inputStream, int i) {
                super(inputStream);
                this.f = i;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.f;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.f -= i4;
                }
                return i4;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) {
                int iSkip = (int) super.skip(Math.min(j, this.f));
                if (iSkip >= 0) {
                    this.f -= iSkip;
                }
                return iSkip;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
            public /* synthetic */ long transferTo(OutputStream outputStream) {
                return DesugarInputStream.transferTo(this, outputStream);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.f--;
                }
                return i;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, xy0.b());
        }

        /* JADX DEBUG: Method merged with bridge method: mergeFrom(Lhv;)Lrs2$a; */
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m188mergeFrom(hv hvVar) {
            return mergeFrom(hvVar, xy0.b());
        }

        /* JADX DEBUG: Method merged with bridge method: mergeFrom(Lhn;)Lrs2$a; */
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m186mergeFrom(hn hnVar) throws ol1 {
            try {
                hv hvVarP = hnVar.p();
                m188mergeFrom(hvVarP);
                hvVarP.a(0);
                return this;
            } catch (ol1 e) {
                throw e;
            } catch (IOException e2) {
                cx4.a(b("ByteString"), e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method: mergeFrom(Lhn;Lxy0;)Lrs2$a; */
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m187mergeFrom(hn hnVar, xy0 xy0Var) throws ol1 {
            try {
                hv hvVarP = hnVar.p();
                mergeFrom(hvVarP, xy0Var);
                hvVarP.a(0);
                return this;
            } catch (ol1 e) {
                throw e;
            } catch (IOException e2) {
                cx4.a(b("ByteString"), e2);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method: mergeFrom([B)Lrs2$a; */
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m191mergeFrom(byte[] bArr) {
            return m8mergeFrom(bArr, 0, bArr.length);
        }

        /* JADX DEBUG: Method merged with bridge method: mergeFrom([BLxy0;)Lrs2$a; */
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m192mergeFrom(byte[] bArr, xy0 xy0Var) {
            return m9mergeFrom(bArr, 0, bArr.length, xy0Var);
        }

        /* JADX DEBUG: Method merged with bridge method: mergeFrom(Ljava/io/InputStream;)Lrs2$a; */
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m189mergeFrom(InputStream inputStream) {
            hv hvVarH = hv.h(inputStream);
            m188mergeFrom(hvVarH);
            hvVarH.a(0);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method: mergeFrom(Ljava/io/InputStream;Lxy0;)Lrs2$a; */
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m190mergeFrom(InputStream inputStream, xy0 xy0Var) {
            hv hvVarH = hv.h(inputStream);
            mergeFrom(hvVarH, xy0Var);
            hvVarH.a(0);
            return this;
        }
    }
}

package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mr0 implements Closeable {
    public final int f = 1179403647;
    public final FileChannel g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mr0(File file) {
        if (file == null || !file.exists()) {
            jl.a("File is null or does not exist");
            throw null;
        }
        this.g = new FileInputStream(file).getChannel();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long a(hr0 hr0Var, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            ir0 ir0VarB = hr0Var.b(j3);
            if (ir0VarB.a == 1) {
                long j4 = ir0VarB.c;
                if (j4 <= j2 && j2 <= ir0VarB.d + j4) {
                    return (j2 - j4) + ir0VarB.b;
                }
            }
        }
        e04.a("Could not map vma to file offset!");
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hr0 c() throws IOException {
        this.g.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (y(byteBufferAllocate, 0L) != 1179403647) {
            jl.a("Invalid ELF Magic!");
            return null;
        }
        short sL = l(byteBufferAllocate, 4L);
        boolean z = l(byteBufferAllocate, 5L) == 2;
        if (sL == 1) {
            return new kr0(z, this);
        }
        if (sL == 2) {
            return new lr0(z, this);
        }
        e04.a("Invalid class type!");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List h() throws IOException {
        long j;
        long j2;
        this.g.position(0L);
        ArrayList arrayList = new ArrayList();
        hr0 hr0VarC = c();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(hr0VarC.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = hr0VarC.f;
        int i = 0;
        if (j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j3 = hr0VarC.c(0).a;
        }
        long j4 = 0;
        while (true) {
            j = 1;
            if (j4 >= j3) {
                j2 = 0;
                break;
            }
            ir0 ir0VarB = hr0VarC.b(j4);
            if (ir0VarB.a == 2) {
                j2 = ir0VarB.b;
                break;
            }
            j4++;
        }
        if (j2 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j5 = 0;
        while (true) {
            gr0 gr0VarA = hr0VarC.a(j2, i);
            long j6 = j;
            long j7 = gr0VarA.a;
            if (j7 == j6) {
                arrayList2.add(Long.valueOf(gr0VarA.b));
            } else if (j7 == 5) {
                j5 = gr0VarA.b;
            }
            i++;
            if (gr0VarA.a == 0) {
                break;
            }
            j = j6;
            j3 = j3;
        }
        if (j5 == 0) {
            e04.a("String table offset not found!");
            return null;
        }
        long jA = a(hr0VarC, j3, j5);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(v(byteBufferAllocate, ((Long) it.next()).longValue() + jA));
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int i2 = this.g.read(byteBuffer, j + j2);
            if (i2 == -1) {
                ll.a();
                return;
            }
            j2 += (long) i2;
        }
        byteBuffer.position(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public short l(ByteBuffer byteBuffer, long j) throws IOException {
        i(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int t(ByteBuffer byteBuffer, long j) throws IOException {
        i(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long u(ByteBuffer byteBuffer, long j) throws IOException {
        i(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String v(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short sL = l(byteBuffer, j);
            if (sL == 0) {
                return sb.toString();
            }
            sb.append((char) sL);
            j = j2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long y(ByteBuffer byteBuffer, long j) throws IOException {
        i(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }
}

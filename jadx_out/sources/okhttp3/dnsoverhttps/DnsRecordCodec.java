package okhttp3.dnsoverhttps;

import defpackage.bt;
import defpackage.jl;
import defpackage.ow;
import defpackage.wg4;
import defpackage.ww;
import defpackage.zt;
import java.io.EOFException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import okio.Buffer;
import okio.ByteString;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class DnsRecordCodec {
    private static final int NXDOMAIN = 3;
    private static final int SERVFAIL = 2;
    public static final int TYPE_A = 1;
    public static final int TYPE_AAAA = 28;
    private static final int TYPE_PTR = 12;
    public static final DnsRecordCodec INSTANCE = new DnsRecordCodec();
    private static final Charset ASCII = bt.f;

    private DnsRecordCodec() {
    }

    private final void skipName(Buffer buffer) throws EOFException {
        byte b = buffer.readByte();
        if (b < 0) {
            buffer.skip(1L);
            return;
        }
        while (b > 0) {
            buffer.skip(b);
            b = buffer.readByte();
        }
    }

    public final List<InetAddress> decodeAnswers(String str, ByteString byteString) throws EOFException, UnknownHostException {
        str.getClass();
        byteString.getClass();
        ArrayList arrayList = new ArrayList();
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.readShort();
        short s = buffer.readShort();
        if (((s & 65535) >> 15) == 0) {
            jl.a("not a response");
            return null;
        }
        int i = s & 15;
        if (i == 2) {
            throw new UnknownHostException(str + ": SERVFAIL");
        }
        if (i == 3) {
            throw new UnknownHostException(str + ": NXDOMAIN");
        }
        int i2 = buffer.readShort() & 65535;
        int i3 = buffer.readShort() & 65535;
        buffer.readShort();
        buffer.readShort();
        for (int i4 = 0; i4 < i2; i4++) {
            skipName(buffer);
            buffer.readShort();
            buffer.readShort();
        }
        for (int i5 = 0; i5 < i3; i5++) {
            skipName(buffer);
            int i6 = buffer.readShort() & 65535;
            buffer.readShort();
            buffer.readInt();
            int i7 = buffer.readShort() & 65535;
            if (i6 == 1 || i6 == 28) {
                byte[] bArr = new byte[i7];
                buffer.read(bArr);
                InetAddress byAddress = InetAddress.getByAddress(bArr);
                byAddress.getClass();
                arrayList.add(byAddress);
            } else {
                buffer.skip(i7);
            }
        }
        return arrayList;
    }

    public final ByteString encodeQuery(String str, int i) {
        List<String> listJ;
        str.getClass();
        Buffer buffer = new Buffer();
        buffer.writeShort(0);
        buffer.writeShort(com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE);
        buffer.writeShort(1);
        buffer.writeShort(0);
        buffer.writeShort(0);
        buffer.writeShort(0);
        Buffer buffer2 = new Buffer();
        List listC0 = wg4.C0(str, new char[]{'.'}, false, 0, 6, null);
        if (listC0.isEmpty()) {
            listJ = ow.j();
        } else {
            ListIterator listIterator = listC0.listIterator(listC0.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listJ = ww.Y(listC0, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listJ = ow.j();
        }
        for (String str2 : listJ) {
            long jSize$default = Utf8.size$default(str2, 0, 0, 3, null);
            if (jSize$default != str2.length()) {
                zt.a("non-ascii hostname: ", str);
                return null;
            }
            buffer2.writeByte((int) jSize$default);
            buffer2.writeUtf8(str2);
        }
        buffer2.writeByte(0);
        buffer2.copyTo(buffer, 0L, buffer2.size());
        buffer.writeShort(i);
        buffer.writeShort(1);
        return buffer.readByteString();
    }
}

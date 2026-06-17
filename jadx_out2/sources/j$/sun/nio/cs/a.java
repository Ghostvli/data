package j$.sun.nio.cs;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends CharsetDecoder {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(c cVar) {
        super(cVar, 1.0f, 1.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x005f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.nio.CharBuffer] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.nio.ByteBuffer] */
    @Override // java.nio.charset.CharsetDecoder
    public final CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) throws Throwable {
        CoderResult coderResult;
        CoderResult coderResult2;
        if (!byteBuffer.hasArray() || !charBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            while (true) {
                try {
                    if (!byteBuffer.hasRemaining()) {
                        coderResult = CoderResult.UNDERFLOW;
                        break;
                    }
                    byte b = byteBuffer.get();
                    if (!charBuffer.hasRemaining()) {
                        coderResult = CoderResult.OVERFLOW;
                        break;
                    }
                    charBuffer.put((char) (b & 255));
                    iPosition++;
                } finally {
                }
            }
            return coderResult;
        }
        byte[] bArrArray = byteBuffer.array();
        int iPosition2 = byteBuffer.position() + byteBuffer.arrayOffset();
        int iLimit = byteBuffer.limit() + byteBuffer.arrayOffset();
        if (iPosition2 > iLimit) {
            iPosition2 = iLimit;
        }
        char[] cArrArray = charBuffer.array();
        int iPosition3 = charBuffer.position() + charBuffer.arrayOffset();
        int iLimit2 = charBuffer.limit() + charBuffer.arrayOffset();
        if (iPosition3 > iLimit2) {
            iPosition3 = iLimit2;
        }
        while (true) {
            if (iPosition2 >= iLimit) {
                coderResult2 = CoderResult.UNDERFLOW;
                break;
            }
            try {
                byte b2 = bArrArray[iPosition2];
                if (iPosition3 >= iLimit2) {
                    coderResult2 = CoderResult.OVERFLOW;
                    break;
                }
                int i = iPosition3 + 1;
                try {
                    cArrArray[iPosition3] = (char) (b2 & 255);
                    iPosition2++;
                    iPosition3 = i;
                } catch (Throwable th) {
                    th = th;
                    iPosition3 = i;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        iPosition2 -= byteBuffer.arrayOffset();
        iPosition3 -= charBuffer.arrayOffset();
        byteBuffer = (CharBuffer) charBuffer.position(iPosition3);
        return coderResult2;
    }
}

package okio.internal;

import defpackage.fw4;
import defpackage.i04;
import defpackage.ta;
import defpackage.ux4;
import kotlin.jvm.functions.Function3;
import okio.Buffer;
import okio.ByteString;
import okio.C0158SegmentedByteString;
import okio.Segment;

/* JADX INFO: renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class SegmentedByteString {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        iArr.getClass();
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void commonCopyInto(C0158SegmentedByteString c0158SegmentedByteString, int i, byte[] bArr, int i2, int i3) {
        c0158SegmentedByteString.getClass();
        bArr.getClass();
        long j = i3;
        okio.SegmentedByteString.checkOffsetAndCount(c0158SegmentedByteString.size(), i, j);
        okio.SegmentedByteString.checkOffsetAndCount(bArr.length, i2, j);
        int i4 = i3 + i;
        int iSegment = segment(c0158SegmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : c0158SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = c0158SegmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            int i8 = i7 + (i - i5);
            ta.d(c0158SegmentedByteString.getSegments$okio()[iSegment], bArr, i2, i8, i8 + iMin);
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean commonEquals(C0158SegmentedByteString c0158SegmentedByteString, Object obj) {
        c0158SegmentedByteString.getClass();
        if (obj == c0158SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == c0158SegmentedByteString.size() && c0158SegmentedByteString.rangeEquals(0, byteString, 0, c0158SegmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int commonGetSize(C0158SegmentedByteString c0158SegmentedByteString) {
        c0158SegmentedByteString.getClass();
        return c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length - 1];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int commonHashCode(C0158SegmentedByteString c0158SegmentedByteString) {
        c0158SegmentedByteString.getClass();
        int hashCode$okio = c0158SegmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = c0158SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = c0158SegmentedByteString.getDirectory$okio()[length + i];
            int i5 = c0158SegmentedByteString.getDirectory$okio()[i];
            byte[] bArr = c0158SegmentedByteString.getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        c0158SegmentedByteString.setHashCode$okio(i2);
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final byte commonInternalGet(C0158SegmentedByteString c0158SegmentedByteString, int i) {
        c0158SegmentedByteString.getClass();
        okio.SegmentedByteString.checkOffsetAndCount(c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length - 1], i, 1L);
        int iSegment = segment(c0158SegmentedByteString, i);
        return c0158SegmentedByteString.getSegments$okio()[iSegment][(i - (iSegment == 0 ? 0 : c0158SegmentedByteString.getDirectory$okio()[iSegment - 1])) + c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length + iSegment]];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean commonRangeEquals(C0158SegmentedByteString c0158SegmentedByteString, int i, byte[] bArr, int i2, int i3) {
        c0158SegmentedByteString.getClass();
        bArr.getClass();
        if (i < 0 || i > c0158SegmentedByteString.size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(c0158SegmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : c0158SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = c0158SegmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!okio.SegmentedByteString.arrayRangeEquals(c0158SegmentedByteString.getSegments$okio()[iSegment], i7 + (i - i5), bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ByteString commonSubstring(C0158SegmentedByteString c0158SegmentedByteString, int i, int i2) {
        c0158SegmentedByteString.getClass();
        int iResolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(c0158SegmentedByteString, i2);
        if (i < 0) {
            i04.a("beginIndex=", i, " < 0");
            return null;
        }
        if (iResolveDefaultParameter > c0158SegmentedByteString.size()) {
            throw new IllegalArgumentException(("endIndex=" + iResolveDefaultParameter + " > length(" + c0158SegmentedByteString.size() + ')').toString());
        }
        int i3 = iResolveDefaultParameter - i;
        if (i3 < 0) {
            ux4.a("endIndex=", iResolveDefaultParameter, " < beginIndex=", i);
            return null;
        }
        if (i == 0 && iResolveDefaultParameter == c0158SegmentedByteString.size()) {
            return c0158SegmentedByteString;
        }
        if (i == iResolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(c0158SegmentedByteString, i);
        int iSegment2 = segment(c0158SegmentedByteString, iResolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) ta.l(c0158SegmentedByteString.getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i4 = iSegment;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(c0158SegmentedByteString.getDirectory$okio()[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr.length] = c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length + i4];
                if (i4 == iSegment2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = iSegment != 0 ? c0158SegmentedByteString.getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new C0158SegmentedByteString(bArr, iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final byte[] commonToByteArray(C0158SegmentedByteString c0158SegmentedByteString) {
        c0158SegmentedByteString.getClass();
        byte[] bArr = new byte[c0158SegmentedByteString.size()];
        int length = c0158SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = c0158SegmentedByteString.getDirectory$okio()[length + i];
            int i5 = c0158SegmentedByteString.getDirectory$okio()[i];
            int i6 = i5 - i2;
            ta.d(c0158SegmentedByteString.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void commonWrite(C0158SegmentedByteString c0158SegmentedByteString, Buffer buffer, int i, int i2) {
        c0158SegmentedByteString.getClass();
        buffer.getClass();
        int i3 = i + i2;
        int iSegment = segment(c0158SegmentedByteString, i);
        while (i < i3) {
            int i4 = iSegment == 0 ? 0 : c0158SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i5 = c0158SegmentedByteString.getDirectory$okio()[iSegment] - i4;
            int i6 = c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            Segment segment = new Segment(c0158SegmentedByteString.getSegments$okio()[iSegment], i7, i7 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.getClass();
                Segment segment3 = segment2.prev;
                segment3.getClass();
                segment3.push(segment);
            }
            i += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static final void forEachSegment(C0158SegmentedByteString c0158SegmentedByteString, int i, int i2, Function3<? super byte[], ? super Integer, ? super Integer, fw4> function3) {
        int iSegment = segment(c0158SegmentedByteString, i);
        while (i < i2) {
            int i3 = iSegment == 0 ? 0 : c0158SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i4 = c0158SegmentedByteString.getDirectory$okio()[iSegment] - i3;
            int i5 = c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - i;
            function3.invoke(c0158SegmentedByteString.getSegments$okio()[iSegment], Integer.valueOf(i5 + (i - i3)), Integer.valueOf(iMin));
            i += iMin;
            iSegment++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int segment(C0158SegmentedByteString c0158SegmentedByteString, int i) {
        c0158SegmentedByteString.getClass();
        int iBinarySearch = binarySearch(c0158SegmentedByteString.getDirectory$okio(), i + 1, 0, c0158SegmentedByteString.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    public static final void forEachSegment(C0158SegmentedByteString c0158SegmentedByteString, Function3<? super byte[], ? super Integer, ? super Integer, fw4> function3) {
        c0158SegmentedByteString.getClass();
        function3.getClass();
        int length = c0158SegmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = c0158SegmentedByteString.getDirectory$okio()[length + i];
            int i4 = c0158SegmentedByteString.getDirectory$okio()[i];
            function3.invoke(c0158SegmentedByteString.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    public static final boolean commonRangeEquals(C0158SegmentedByteString c0158SegmentedByteString, int i, ByteString byteString, int i2, int i3) {
        c0158SegmentedByteString.getClass();
        byteString.getClass();
        if (i < 0 || i > c0158SegmentedByteString.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(c0158SegmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : c0158SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = c0158SegmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = c0158SegmentedByteString.getDirectory$okio()[c0158SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!byteString.rangeEquals(i2, c0158SegmentedByteString.getSegments$okio()[iSegment], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }
}

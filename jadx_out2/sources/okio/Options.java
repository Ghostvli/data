package okio;

import defpackage.e04;
import defpackage.i0;
import defpackage.jl;
import defpackage.ow;
import defpackage.sw;
import defpackage.ua;
import defpackage.we0;
import defpackage.zt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Options extends i0 implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u
    public int getSize() {
        return this.byteStrings.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int[] getTrie$okio() {
        return this.trie;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i0, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i0, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okio.Options.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void buildTrieRecursive(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            long j2;
            int i6;
            long j3;
            int i7 = i;
            if (i2 >= i3) {
                jl.a("Failed requirement.");
                return;
            }
            for (int i8 = i2; i8 < i3; i8++) {
                if (list.get(i8).size() < i7) {
                    jl.a("Failed requirement.");
                    return;
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            byte b = -1;
            if (i7 == byteString.size()) {
                int iIntValue = list2.get(i2).intValue();
                int i9 = i2 + 1;
                ByteString byteString3 = list.get(i9);
                i4 = i9;
                i5 = iIntValue;
                byteString = byteString3;
            } else {
                i4 = i2;
                i5 = -1;
            }
            long j4 = 2;
            if (byteString.getByte(i7) == byteString2.getByte(i7)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i10 = 0;
                int i11 = i7;
                while (true) {
                    byte b2 = b;
                    if (i11 >= iMin) {
                        j2 = j4;
                        break;
                    }
                    j2 = j4;
                    if (byteString.getByte(i11) != byteString2.getByte(i11)) {
                        break;
                    }
                    i10++;
                    i11++;
                    b = b2;
                    j4 = j2;
                }
                long intCount = j + getIntCount(buffer) + j2 + ((long) i10) + 1;
                buffer.writeInt(-i10);
                buffer.writeInt(i5);
                int i12 = i7 + i10;
                while (i7 < i12) {
                    buffer.writeInt(byteString.getByte(i7) & 255);
                    i7++;
                }
                if (i4 + 1 == i3) {
                    if (i12 == list.get(i4).size()) {
                        buffer.writeInt(list2.get(i4).intValue());
                        return;
                    } else {
                        e04.a("Check failed.");
                        return;
                    }
                }
                Buffer buffer2 = new Buffer();
                buffer.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                buildTrieRecursive(intCount, buffer2, i12, list, i4, i3, list2);
                buffer.writeAll(buffer2);
                return;
            }
            int i13 = 1;
            for (int i14 = i4 + 1; i14 < i3; i14++) {
                if (list.get(i14 - 1).getByte(i7) != list.get(i14).getByte(i7)) {
                    i13++;
                }
            }
            long intCount2 = j + getIntCount(buffer) + 2 + ((long) (i13 * 2));
            buffer.writeInt(i13);
            buffer.writeInt(i5);
            for (int i15 = i4; i15 < i3; i15++) {
                byte b3 = list.get(i15).getByte(i7);
                if (i15 == i4 || b3 != list.get(i15 - 1).getByte(i7)) {
                    buffer.writeInt(b3 & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i4 < i3) {
                byte b4 = list.get(i4).getByte(i7);
                int i16 = i4 + 1;
                int i17 = i16;
                while (true) {
                    if (i17 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (b4 != list.get(i17).getByte(i7)) {
                            i6 = i17;
                            break;
                        }
                        i17++;
                    }
                }
                if (i16 == i6 && i7 + 1 == list.get(i4).size()) {
                    buffer.writeInt(list2.get(i4).intValue());
                    j3 = intCount2;
                } else {
                    buffer.writeInt(((int) (getIntCount(buffer3) + intCount2)) * (-1));
                    j3 = intCount2;
                    buildTrieRecursive(j3, buffer3, i7 + 1, list, i4, i6, list2);
                }
                intCount2 = j3;
                i4 = i6;
            }
            buffer.writeAll(buffer3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j = 0;
            }
            companion.buildTrieRecursive(j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00b4, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options of(ByteString... byteStringArr) {
            byteStringArr.getClass();
            we0 we0Var = null;
            if (byteStringArr.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, we0Var);
            }
            List listM = ua.M(byteStringArr);
            sw.u(listM);
            int size = listM.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(-1);
            }
            int length = byteStringArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                arrayList.set(ow.i(listM, byteStringArr[i2], 0, 0, 6, null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((ByteString) listM.get(0)).size() <= 0) {
                jl.a("the empty byte string is not a supported option");
                return null;
            }
            int i4 = 0;
            while (i4 < listM.size()) {
                ByteString byteString = (ByteString) listM.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < listM.size()) {
                    ByteString byteString2 = (ByteString) listM.get(i6);
                    if (byteString2.startsWith(byteString)) {
                        if (byteString2.size() == byteString.size()) {
                            zt.a("duplicate option: ", byteString2);
                            return null;
                        }
                        if (((Number) arrayList.get(i6)).intValue() > ((Number) arrayList.get(i4)).intValue()) {
                            listM.remove(i6);
                            ((Number) arrayList.remove(i6)).intValue();
                        } else {
                            i6++;
                        }
                    }
                }
                i4 = i5;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive$default(this, 0L, buffer, 0, listM, 0, 0, arrayList, 53, null);
            int intCount = (int) getIntCount(buffer);
            int[] iArr = new int[intCount];
            for (int i7 = 0; i7 < intCount; i7++) {
                iArr[i7] = buffer.readInt();
            }
            return new Options((ByteString[]) Arrays.copyOf(byteStringArr, byteStringArr.length), iArr, we0Var);
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Method merged with bridge method: get(I)Ljava/lang/Object; */
    @Override // defpackage.i0, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 okio.ByteString[]), (r2v0 int[]) A[MD:(okio.ByteString[], int[]):void (m)] (LINE:9) call: okio.Options.<init>(okio.ByteString[], int[]):void type: THIS */
    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, we0 we0Var) {
        this(byteStringArr, iArr);
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}

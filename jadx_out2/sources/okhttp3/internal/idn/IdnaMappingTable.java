package okhttp3.internal.idn;

import defpackage.fw4;
import defpackage.il1;
import okio.BufferedSink;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class IdnaMappingTable {
    private final String mappings;
    private final String ranges;
    private final String sections;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IdnaMappingTable(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.sections = str;
        this.ranges = str2;
        this.mappings = str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final int findRangesOffset(int i, int i2, int i3) {
        int i4;
        int i5 = i & 127;
        int i6 = i3 - 1;
        while (true) {
            if (i2 > i6) {
                i4 = (-i2) - 1;
                break;
            }
            i4 = (i2 + i6) / 2;
            int iB = il1.b(i5, this.ranges.charAt(i4 * 4));
            if (iB >= 0) {
                if (iB <= 0) {
                    break;
                }
                i2 = i4 + 1;
            } else {
                i6 = i4 - 1;
            }
        }
        return i4 >= 0 ? i4 * 4 : ((-i4) - 2) * 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final int findSectionsIndex(int i) {
        int i2;
        int i3 = (i & 2097024) >> 7;
        int length = (this.sections.length() / 4) - 1;
        int i4 = 0;
        while (true) {
            if (i4 > length) {
                i2 = (-i4) - 1;
                break;
            }
            i2 = (i4 + length) / 2;
            int iB = il1.b(i3, IdnaMappingTableKt.read14BitInt(this.sections, i2 * 4));
            if (iB >= 0) {
                if (iB <= 0) {
                    break;
                }
                i4 = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return i2 >= 0 ? i2 * 4 : ((-i2) - 2) * 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getMappings() {
        return this.mappings;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getRanges() {
        return this.ranges;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getSections() {
        return this.sections;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean map(int i, BufferedSink bufferedSink) {
        bufferedSink.getClass();
        int iFindSectionsIndex = findSectionsIndex(i);
        int iFindRangesOffset = findRangesOffset(i, IdnaMappingTableKt.read14BitInt(this.sections, iFindSectionsIndex + 2), iFindSectionsIndex + 4 < this.sections.length() ? IdnaMappingTableKt.read14BitInt(this.sections, iFindSectionsIndex + 6) : this.ranges.length() / 4);
        char cCharAt = this.ranges.charAt(iFindRangesOffset + 1);
        if (cCharAt >= 0 && cCharAt < '@') {
            int i2 = IdnaMappingTableKt.read14BitInt(this.ranges, iFindRangesOffset + 2);
            bufferedSink.writeUtf8(this.mappings, i2, cCharAt + i2);
            return true;
        }
        if ('@' <= cCharAt && cCharAt < 'P') {
            bufferedSink.writeUtf8CodePoint(i - (this.ranges.charAt(iFindRangesOffset + 3) | (((cCharAt & 15) << 14) | (this.ranges.charAt(iFindRangesOffset + 2) << 7))));
            return true;
        }
        if ('P' <= cCharAt && cCharAt < '`') {
            bufferedSink.writeUtf8CodePoint(i + (this.ranges.charAt(iFindRangesOffset + 3) | ((cCharAt & 15) << 14) | (this.ranges.charAt(iFindRangesOffset + 2) << 7)));
            return true;
        }
        if (cCharAt == 'w') {
            fw4 fw4Var = fw4.a;
            return true;
        }
        if (cCharAt == 'x') {
            bufferedSink.writeUtf8CodePoint(i);
            return true;
        }
        if (cCharAt == 'y') {
            bufferedSink.writeUtf8CodePoint(i);
            return false;
        }
        if (cCharAt == 'z') {
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            return true;
        }
        if (cCharAt == '{') {
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            return true;
        }
        if (cCharAt == '|') {
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 3));
            return true;
        }
        if (cCharAt == '}') {
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 3));
            return true;
        }
        if (cCharAt == '~') {
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 3) | 128);
            return true;
        }
        if (cCharAt == 127) {
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            bufferedSink.writeByte(this.ranges.charAt(iFindRangesOffset + 3) | 128);
            return true;
        }
        throw new IllegalStateException(("unexpected rangesIndex for " + i).toString());
    }
}

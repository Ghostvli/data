package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import defpackage.b;
import defpackage.jl;
import defpackage.qn;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int check(String str, Map<EncodeHintType, ?> map) {
        String string;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.FORCE_CODE_SET;
            if (map.containsKey(encodeHintType)) {
                string = map.get(encodeHintType).toString();
                string.getClass();
                switch (string) {
                    case "A":
                        break;
                    case "B":
                        break;
                    case "C":
                        break;
                    default:
                        jl.a("Unsupported code set hint: ".concat(string));
                        return 0;
                }
            }
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        b.a("Bad character in input: ASCII value=", cCharAt);
                        return 0;
                    }
                    break;
            }
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Switch insn not found in header
                	at java.base/java.util.Objects.requireNonNull(Unknown Source)
                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:195)
                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                */
            /*
                Method dump skipped, instruction units count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.check(java.lang.String, java.util.Map):int");
        }

        private static int chooseCode(CharSequence charSequence, int i, int i2) {
            CType cTypeFindCType;
            CType cTypeFindCType2;
            char cCharAt;
            CType cTypeFindCType3 = findCType(charSequence, i);
            CType cType = CType.ONE_DIGIT;
            if (cTypeFindCType3 == cType) {
                return i2 == 101 ? 101 : 100;
            }
            CType cType2 = CType.UNCODABLE;
            if (cTypeFindCType3 == cType2) {
                return (i >= charSequence.length() || ((cCharAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
            }
            if (i2 == 101 && cTypeFindCType3 == CType.FNC_1) {
                return 101;
            }
            if (i2 == 99) {
                return 99;
            }
            if (i2 != 100) {
                if (cTypeFindCType3 == CType.FNC_1) {
                    cTypeFindCType3 = findCType(charSequence, i + 1);
                }
                return cTypeFindCType3 == CType.TWO_DIGITS ? 99 : 100;
            }
            CType cType3 = CType.FNC_1;
            if (cTypeFindCType3 == cType3 || (cTypeFindCType = findCType(charSequence, i + 2)) == cType2 || cTypeFindCType == cType) {
                return 100;
            }
            if (cTypeFindCType == cType3) {
                return findCType(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
            }
            int i3 = i + 4;
            while (true) {
                cTypeFindCType2 = findCType(charSequence, i3);
                if (cTypeFindCType2 != CType.TWO_DIGITS) {
                    break;
                }
                i3 += 2;
            }
            return cTypeFindCType2 == CType.ONE_DIGIT ? 100 : 99;
        }

        private static boolean[] encodeFast(String str, int i) {
            int length = str.length();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            while (i2 < length) {
                int iChooseCode = i == -1 ? chooseCode(str, i2, i4) : i;
                int iCharAt = 100;
                if (iChooseCode == i4) {
                    switch (str.charAt(i2)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            if (i4 == 101) {
                                iCharAt = 101;
                            }
                            break;
                        default:
                            if (i4 == 100) {
                                iCharAt = str.charAt(i2) - ' ';
                            } else if (i4 == 101) {
                                char cCharAt = str.charAt(i2);
                                iCharAt = cCharAt - ' ';
                                if (iCharAt < 0) {
                                    iCharAt = cCharAt + '@';
                                }
                            } else {
                                int i6 = i2 + 1;
                                if (i6 == length) {
                                    jl.a("Bad number of characters for digit only encoding.");
                                    return null;
                                }
                                iCharAt = Integer.parseInt(str.substring(i2, i2 + 2));
                                i2 = i6;
                            }
                            break;
                    }
                    i2++;
                } else {
                    iCharAt = i4 == 0 ? iChooseCode != 100 ? iChooseCode != 101 ? 105 : 103 : 104 : iChooseCode;
                    i4 = iChooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[iCharAt]);
                i3 += iCharAt * i5;
                if (i2 != 0) {
                    i5++;
                }
            }
            return produceResult(arrayList, i3);
        }

        private static CType findCType(CharSequence charSequence, int i) {
            int length = charSequence.length();
            if (i >= length) {
                return CType.UNCODABLE;
            }
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 241) {
                return CType.FNC_1;
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return CType.UNCODABLE;
            }
            int i2 = i + 1;
            if (i2 >= length) {
                return CType.ONE_DIGIT;
            }
            char cCharAt2 = charSequence.charAt(i2);
            return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
        }

        public static boolean[] produceResult(Collection<int[]> collection, int i) {
            int i2 = i % 103;
            if (i2 < 0) {
                jl.a("Unable to compute a valid input checksum");
                return null;
            }
            int[][] iArr = Code128Reader.CODE_PATTERNS;
            collection.add(iArr[i2]);
            collection.add(iArr[106]);
            int iAppendPattern = 0;
            int i3 = 0;
            for (int[] iArr2 : collection) {
                for (int i4 : iArr2) {
                    i3 += i4;
                }
            }
            boolean[] zArr = new boolean[i3];
            Iterator<int[]> it = collection.iterator();
            while (it.hasNext()) {
                iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, it.next(), true);
            }
            return zArr;
        }

        @Override // com.google.zxing.oned.OneDimensionalCodeWriter
        public boolean[] encode(String str, Map<EncodeHintType, ?> map) {
            int iCheck = check(str, map);
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.CODE128_COMPACT;
                if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                    return new MinimalEncoder().encode(str);
                }
            }
            return encodeFast(str, iCheck);
        }

        @Override // com.google.zxing.oned.OneDimensionalCodeWriter
        public Collection<BarcodeFormat> getSupportedWriteFormats() {
            return Collections.singleton(BarcodeFormat.CODE_128);
        }

        @Override // com.google.zxing.oned.OneDimensionalCodeWriter
        public boolean[] encode(String str) {
            return encode(str, null);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class MinimalEncoder {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            static final String A = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ";
            static final String B = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ";
            private static final int CODE_SHIFT = 98;
            private int[][] memoizedCost;
            private Latch[][] minPath;

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public enum Charset {
                A,
                B,
                C,
                NONE
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public enum Latch {
                A,
                B,
                C,
                SHIFT,
                NONE
            }

            private MinimalEncoder() {
            }

            private static void addPattern(Collection<int[]> collection, int i, int[] iArr, int[] iArr2, int i2) {
                collection.add(Code128Reader.CODE_PATTERNS[i]);
                if (i2 != 0) {
                    iArr2[0] = iArr2[0] + 1;
                }
                iArr[0] = iArr[0] + (i * iArr2[0]);
            }

            private boolean canEncode(CharSequence charSequence, Charset charset, int i) {
                int i2;
                char cCharAt = charSequence.charAt(i);
                int iOrdinal = charset.ordinal();
                if (iOrdinal == 0) {
                    return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || A.indexOf(cCharAt) >= 0;
                }
                if (iOrdinal == 1) {
                    return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || B.indexOf(cCharAt) >= 0;
                }
                if (iOrdinal != 2) {
                    return false;
                }
                return cCharAt == 241 || ((i2 = i + 1) < charSequence.length() && isDigit(cCharAt) && isDigit(charSequence.charAt(i2)));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean[] encode(String str) {
                this.memoizedCost = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, str.length());
                this.minPath = (Latch[][]) Array.newInstance((Class<?>) Latch.class, 4, str.length());
                Charset charset = Charset.NONE;
                encode(str, charset, 0);
                ArrayList arrayList = new ArrayList();
                int[] iArr = {0};
                int[] iArr2 = {1};
                int length = str.length();
                int i = 0;
                while (i < length) {
                    Latch latch = this.minPath[charset.ordinal()][i];
                    int iOrdinal = latch.ordinal();
                    int iCharAt = 101;
                    if (iOrdinal == 0) {
                        charset = Charset.A;
                        addPattern(arrayList, i == 0 ? 103 : 101, iArr, iArr2, i);
                    } else if (iOrdinal == 1) {
                        charset = Charset.B;
                        addPattern(arrayList, i == 0 ? 104 : 100, iArr, iArr2, i);
                    } else if (iOrdinal == 2) {
                        charset = Charset.C;
                        addPattern(arrayList, i == 0 ? 105 : 99, iArr, iArr2, i);
                    } else if (iOrdinal == 3) {
                        addPattern(arrayList, 98, iArr, iArr2, i);
                    }
                    if (charset != Charset.C) {
                        switch (str.charAt(i)) {
                            case 241:
                                iCharAt = 102;
                                break;
                            case 242:
                                iCharAt = 97;
                                break;
                            case 243:
                                iCharAt = 96;
                                break;
                            case 244:
                                if ((charset != Charset.A || latch == Latch.SHIFT) && (charset != Charset.B || latch != Latch.SHIFT)) {
                                    iCharAt = 100;
                                }
                                break;
                            default:
                                iCharAt = str.charAt(i) - ' ';
                                break;
                        }
                        if (((charset == Charset.A && latch != Latch.SHIFT) || (charset == Charset.B && latch == Latch.SHIFT)) && iCharAt < 0) {
                            iCharAt += 96;
                        }
                        addPattern(arrayList, iCharAt, iArr, iArr2, i);
                    } else if (str.charAt(i) == 241) {
                        addPattern(arrayList, 102, iArr, iArr2, i);
                    } else {
                        addPattern(arrayList, Integer.parseInt(str.substring(i, i + 2)), iArr, iArr2, i);
                        int i2 = i + 1;
                        if (i2 < length) {
                            i = i2;
                        }
                    }
                    i++;
                }
                this.memoizedCost = null;
                this.minPath = null;
                return Code128Writer.produceResult(arrayList, iArr[0]);
            }

            private static boolean isDigit(char c) {
                return c >= '0' && c <= '9';
            }

            private int encode(CharSequence charSequence, Charset charset, int i) {
                int iEncode;
                int iEncode2;
                int i2 = this.memoizedCost[charset.ordinal()][i];
                if (i2 > 0) {
                    return i2;
                }
                Latch latch = Latch.NONE;
                int i3 = i + 1;
                boolean z = i3 >= charSequence.length();
                Charset[] charsetArr = {Charset.A, Charset.B};
                int i4 = Integer.MAX_VALUE;
                int i5 = 0;
                while (true) {
                    if (i5 > 1) {
                        break;
                    }
                    if (canEncode(charSequence, charsetArr[i5], i)) {
                        Latch latchValueOf = Latch.NONE;
                        Charset charset2 = charsetArr[i5];
                        if (charset != charset2) {
                            latchValueOf = Latch.valueOf(charset2.toString());
                            iEncode2 = 2;
                        } else {
                            iEncode2 = 1;
                        }
                        if (!z) {
                            iEncode2 += encode(charSequence, charsetArr[i5], i3);
                        }
                        if (iEncode2 < i4) {
                            latch = latchValueOf;
                            i4 = iEncode2;
                        }
                        if (charset == charsetArr[(i5 + 1) % 2]) {
                            Latch latch2 = Latch.SHIFT;
                            int iEncode3 = z ? 2 : 2 + encode(charSequence, charset, i3);
                            if (iEncode3 < i4) {
                                latch = latch2;
                                i4 = iEncode3;
                            }
                        }
                    }
                    i5++;
                }
                Charset charset3 = Charset.C;
                if (canEncode(charSequence, charset3, i)) {
                    Latch latch3 = Latch.NONE;
                    if (charset != charset3) {
                        latch3 = Latch.C;
                        iEncode = 2;
                    } else {
                        iEncode = 1;
                    }
                    int i6 = (charSequence.charAt(i) != 241 ? 2 : 1) + i;
                    if (i6 < charSequence.length()) {
                        iEncode += encode(charSequence, charset3, i6);
                    }
                    if (iEncode < i4) {
                        latch = latch3;
                        i4 = iEncode;
                    }
                }
                if (i4 != Integer.MAX_VALUE) {
                    this.memoizedCost[charset.ordinal()][i] = i4;
                    this.minPath[charset.ordinal()][i] = latch;
                    return i4;
                }
                qn.a("Bad character in input: ASCII value=", charSequence.charAt(i));
                return 0;
            }
        }
    }

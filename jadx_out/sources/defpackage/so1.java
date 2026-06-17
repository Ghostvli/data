package defpackage;

import defpackage.no1;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class so1 extends no1 {
    public static final ByteString s = ByteString.encodeUtf8("'\\");
    public static final ByteString t = ByteString.encodeUtf8("\"\\");
    public static final ByteString u = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final ByteString v = ByteString.encodeUtf8("\n\r");
    public static final ByteString w = ByteString.encodeUtf8("*/");
    public final BufferedSource m;
    public final Buffer n;
    public int o = 0;
    public long p;
    public int q;
    public String r;

    public so1(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            om1.a("source == null");
            throw null;
        }
        this.m = bufferedSource;
        this.n = bufferedSource.buffer();
        L(6);
    }

    @Override // defpackage.no1
    public String B() throws io1, EOFException {
        String strW;
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 14) {
            strW = Z();
        } else if (iS == 13) {
            strW = W(t);
        } else if (iS == 12) {
            strW = W(s);
        } else {
            if (iS != 15) {
                StringBuilder sb = new StringBuilder("Expected a name but was ");
                sb.append(K());
                ro1.a(sb, " at path ", getPath());
                return null;
            }
            strW = this.r;
        }
        this.o = 0;
        this.h[this.f - 1] = strW;
        return strW;
    }

    @Override // defpackage.no1
    public String F() throws io1, EOFException {
        String utf8;
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 10) {
            utf8 = Z();
        } else if (iS == 9) {
            utf8 = W(t);
        } else if (iS == 8) {
            utf8 = W(s);
        } else if (iS == 11) {
            utf8 = this.r;
            this.r = null;
        } else if (iS == 16) {
            utf8 = Long.toString(this.p);
        } else {
            if (iS != 17) {
                StringBuilder sb = new StringBuilder("Expected a string but was ");
                sb.append(K());
                ro1.a(sb, " at path ", getPath());
                return null;
            }
            utf8 = this.n.readUtf8(this.q);
        }
        this.o = 0;
        int[] iArr = this.i;
        int i = this.f - 1;
        iArr[i] = iArr[i] + 1;
        return utf8;
    }

    @Override // defpackage.no1
    public no1.b K() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        switch (iS) {
            case 1:
                return no1.b.BEGIN_OBJECT;
            case 2:
                return no1.b.END_OBJECT;
            case 3:
                return no1.b.BEGIN_ARRAY;
            case 4:
                return no1.b.END_ARRAY;
            case 5:
            case 6:
                return no1.b.BOOLEAN;
            case 7:
                return no1.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return no1.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return no1.b.NAME;
            case 16:
            case 17:
                return no1.b.NUMBER;
            case 18:
                return no1.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // defpackage.no1
    public int M(no1.a aVar) throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS < 12 || iS > 15) {
            return -1;
        }
        if (iS == 15) {
            return T(this.r, aVar);
        }
        int iSelect = this.m.select(aVar.b);
        if (iSelect != -1) {
            this.o = 0;
            this.h[this.f - 1] = aVar.a[iSelect];
            return iSelect;
        }
        String str = this.h[this.f - 1];
        String strB = B();
        int iT = T(strB, aVar);
        if (iT == -1) {
            this.o = 15;
            this.r = strB;
            this.h[this.f - 1] = str;
        }
        return iT;
    }

    @Override // defpackage.no1
    public void N() throws io1, EOFException {
        if (this.k) {
            StringBuilder sb = new StringBuilder("Cannot skip unexpected ");
            sb.append(K());
            ro1.a(sb, " at ", getPath());
            return;
        }
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 14) {
            h0();
        } else if (iS == 13) {
            e0(t);
        } else if (iS == 12) {
            e0(s);
        } else if (iS != 15) {
            StringBuilder sb2 = new StringBuilder("Expected a name but was ");
            sb2.append(K());
            ro1.a(sb2, " at path ", getPath());
            return;
        }
        this.o = 0;
        this.h[this.f - 1] = "null";
    }

    @Override // defpackage.no1
    public void O() throws io1, EOFException {
        if (this.k) {
            StringBuilder sb = new StringBuilder("Cannot skip unexpected ");
            sb.append(K());
            ro1.a(sb, " at ", getPath());
            return;
        }
        int i = 0;
        do {
            int iS = this.o;
            if (iS == 0) {
                iS = S();
            }
            if (iS == 3) {
                L(1);
            } else if (iS == 1) {
                L(3);
            } else {
                if (iS == 4) {
                    i--;
                    if (i < 0) {
                        StringBuilder sb2 = new StringBuilder("Expected a value but was ");
                        sb2.append(K());
                        ro1.a(sb2, " at path ", getPath());
                        return;
                    }
                    this.f--;
                } else if (iS == 2) {
                    i--;
                    if (i < 0) {
                        StringBuilder sb3 = new StringBuilder("Expected a value but was ");
                        sb3.append(K());
                        ro1.a(sb3, " at path ", getPath());
                        return;
                    }
                    this.f--;
                } else if (iS == 14 || iS == 10) {
                    h0();
                } else if (iS == 9 || iS == 13) {
                    e0(t);
                } else if (iS == 8 || iS == 12) {
                    e0(s);
                } else if (iS == 17) {
                    this.n.skip(this.q);
                } else if (iS == 18) {
                    StringBuilder sb4 = new StringBuilder("Expected a value but was ");
                    sb4.append(K());
                    ro1.a(sb4, " at path ", getPath());
                    return;
                }
                this.o = 0;
            }
            i++;
            this.o = 0;
        } while (i != 0);
        int[] iArr = this.i;
        int i2 = this.f;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.h[i2 - 1] = "null";
    }

    public final void R() throws io1 {
        if (!this.j) {
            throw Q("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final int S() throws io1, EOFException {
        int[] iArr = this.g;
        int i = this.f;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iV = V(true);
            this.n.readByte();
            if (iV != 44) {
                if (iV != 59) {
                    if (iV != 93) {
                        throw Q("Unterminated array");
                    }
                    this.o = 4;
                    return 4;
                }
                R();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int iV2 = V(true);
                    this.n.readByte();
                    if (iV2 != 44) {
                        if (iV2 != 59) {
                            if (iV2 != 125) {
                                throw Q("Unterminated object");
                            }
                            this.o = 2;
                            return 2;
                        }
                        R();
                    }
                }
                int iV3 = V(true);
                if (iV3 == 34) {
                    this.n.readByte();
                    this.o = 13;
                    return 13;
                }
                if (iV3 == 39) {
                    this.n.readByte();
                    R();
                    this.o = 12;
                    return 12;
                }
                if (iV3 != 125) {
                    R();
                    if (!U((char) iV3)) {
                        throw Q("Expected name");
                    }
                    this.o = 14;
                    return 14;
                }
                if (i2 == 5) {
                    throw Q("Expected name");
                }
                this.n.readByte();
                this.o = 2;
                return 2;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iV4 = V(true);
                this.n.readByte();
                if (iV4 != 58) {
                    if (iV4 != 61) {
                        throw Q("Expected ':'");
                    }
                    R();
                    if (this.m.request(1L) && this.n.getByte(0L) == 62) {
                        this.n.readByte();
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (V(false) == -1) {
                    this.o = 18;
                    return 18;
                }
                R();
            } else if (i2 == 8) {
                e04.a("JsonReader is closed");
                return 0;
            }
        }
        int iV5 = V(true);
        if (iV5 == 34) {
            this.n.readByte();
            this.o = 9;
            return 9;
        }
        if (iV5 == 39) {
            R();
            this.n.readByte();
            this.o = 8;
            return 8;
        }
        if (iV5 != 44 && iV5 != 59) {
            if (iV5 == 91) {
                this.n.readByte();
                this.o = 3;
                return 3;
            }
            if (iV5 != 93) {
                if (iV5 == 123) {
                    this.n.readByte();
                    this.o = 1;
                    return 1;
                }
                int iB0 = b0();
                if (iB0 != 0) {
                    return iB0;
                }
                int iC0 = c0();
                if (iC0 != 0) {
                    return iC0;
                }
                if (!U(this.n.getByte(0L))) {
                    throw Q("Expected value");
                }
                R();
                this.o = 10;
                return 10;
            }
            if (i2 == 1) {
                this.n.readByte();
                this.o = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw Q("Unexpected value");
        }
        R();
        this.o = 7;
        return 7;
    }

    public final int T(String str, no1.a aVar) {
        int length = aVar.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.a[i])) {
                this.o = 0;
                this.h[this.f - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean U(int i) throws io1 {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case Token.SEMI /* 91 */:
                        case Token.RB /* 93 */:
                            return false;
                        case Token.LB /* 92 */:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        R();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.n.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r6.m.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        R();
        r3 = r6.n.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r6.n.readByte();
        r6.n.readByte();
        g0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r6.n.readByte();
        r6.n.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        if (f0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        throw Q("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        R();
        g0();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int V(boolean r7) throws defpackage.io1, java.io.EOFException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            okio.BufferedSource r2 = r6.m
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L80
            okio.Buffer r2 = r6.n
            long r4 = (long) r1
            byte r2 = r2.getByte(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            okio.Buffer r3 = r6.n
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L72
            okio.BufferedSource r3 = r6.m
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3a
            goto L7d
        L3a:
            r6.R()
            okio.Buffer r3 = r6.n
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            goto L7d
        L4c:
            okio.Buffer r1 = r6.n
            r1.readByte()
            okio.Buffer r1 = r6.n
            r1.readByte()
            r6.g0()
            goto L1
        L5a:
            okio.Buffer r1 = r6.n
            r1.readByte()
            okio.Buffer r1 = r6.n
            r1.readByte()
            boolean r1 = r6.f0()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            io1 r6 = r6.Q(r7)
            throw r6
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.R()
            r6.g0()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r6 = -1
            return r6
        L84:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "End of input"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.so1.V(boolean):int");
    }

    public final String W(ByteString byteString) throws io1, EOFException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.m.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw Q("Unterminated string");
            }
            if (this.n.getByte(jIndexOfElement) != 92) {
                Buffer buffer = this.n;
                if (sb == null) {
                    String utf8 = buffer.readUtf8(jIndexOfElement);
                    this.n.readByte();
                    return utf8;
                }
                sb.append(buffer.readUtf8(jIndexOfElement));
                this.n.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.n.readUtf8(jIndexOfElement));
            this.n.readByte();
            sb.append(d0());
        }
    }

    public final String Z() {
        long jIndexOfElement = this.m.indexOfElement(u);
        Buffer buffer = this.n;
        return jIndexOfElement != -1 ? buffer.readUtf8(jIndexOfElement) : buffer.readUtf8();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int b0() throws EOFException {
        String str;
        String str2;
        int i;
        byte b = this.n.getByte(0L);
        if (b == 116 || b == 84) {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (b == 102 || b == 70) {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (b != 110 && b != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (true) {
            BufferedSource bufferedSource = this.m;
            if (i2 >= length) {
                if (bufferedSource.request(length + 1) && U(this.n.getByte(length))) {
                    return 0;
                }
                this.n.skip(length);
                this.o = i;
                return i;
            }
            int i3 = i2 + 1;
            if (!bufferedSource.request(i3)) {
                return 0;
            }
            byte b2 = this.n.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
    }

    @Override // defpackage.no1
    public void c() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 3) {
            L(1);
            this.i[this.f - 1] = 0;
            this.o = 0;
        } else {
            StringBuilder sb = new StringBuilder("Expected BEGIN_ARRAY but was ");
            sb.append(K());
            ro1.a(sb, " at path ", getPath());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
    
        if (U(r1) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (r6 != 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
    
        if (r7 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        if (r10 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
    
        if (r8 != r16) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009b, code lost:
    
        if (r10 != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
    
        if (r10 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a0, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
    
        r19.p = r8;
        r19.n.skip(r5);
        r19.o = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ae, code lost:
    
        if (r6 == 2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
    
        if (r6 == 4) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
    
        if (r6 != 7) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b6, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        r19.q = r5;
        r19.o = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00be, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c0() throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.so1.c0():int");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.o = 0;
        this.g[0] = 8;
        this.f = 1;
        this.n.clear();
        this.m.close();
    }

    public final char d0() throws io1, EOFException {
        int i;
        if (!this.m.request(1L)) {
            throw Q("Unterminated escape sequence");
        }
        byte b = this.n.readByte();
        if (b == 10 || b == 34 || b == 39 || b == 47 || b == 92) {
            return (char) b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            if (this.j) {
                return (char) b;
            }
            throw Q("Invalid escape sequence: \\" + ((char) b));
        }
        if (!this.m.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        int i2 = 0;
        char c = 0;
        while (true) {
            Buffer buffer = this.n;
            if (i2 >= 4) {
                buffer.skip(4L);
                return c;
            }
            byte b2 = buffer.getByte(i2);
            char c2 = (char) (c << 4);
            if (b2 >= 48 && b2 <= 57) {
                i = b2 - 48;
            } else if (b2 >= 97 && b2 <= 102) {
                i = b2 - 87;
            } else {
                if (b2 < 65 || b2 > 70) {
                    break;
                }
                i = b2 - 55;
            }
            c = (char) (c2 + i);
            i2++;
        }
        throw Q("\\u" + this.n.readUtf8(4L));
    }

    public final void e0(ByteString byteString) throws io1, EOFException {
        while (true) {
            long jIndexOfElement = this.m.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw Q("Unterminated string");
            }
            byte b = this.n.getByte(jIndexOfElement);
            Buffer buffer = this.n;
            if (b != 92) {
                buffer.skip(jIndexOfElement + 1);
                return;
            } else {
                buffer.skip(jIndexOfElement + 1);
                d0();
            }
        }
    }

    public final boolean f0() throws EOFException {
        BufferedSource bufferedSource = this.m;
        ByteString byteString = w;
        long jIndexOf = bufferedSource.indexOf(byteString);
        boolean z = jIndexOf != -1;
        Buffer buffer = this.n;
        buffer.skip(z ? jIndexOf + ((long) byteString.size()) : buffer.size());
        return z;
    }

    public final void g0() throws EOFException {
        long jIndexOfElement = this.m.indexOfElement(v);
        Buffer buffer = this.n;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    @Override // defpackage.no1
    public void h() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 1) {
            L(3);
            this.o = 0;
        } else {
            StringBuilder sb = new StringBuilder("Expected BEGIN_OBJECT but was ");
            sb.append(K());
            ro1.a(sb, " at path ", getPath());
        }
    }

    public final void h0() throws EOFException {
        long jIndexOfElement = this.m.indexOfElement(u);
        Buffer buffer = this.n;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // defpackage.no1
    public void i() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS != 4) {
            StringBuilder sb = new StringBuilder("Expected END_ARRAY but was ");
            sb.append(K());
            ro1.a(sb, " at path ", getPath());
        } else {
            int i = this.f;
            this.f = i - 1;
            int[] iArr = this.i;
            int i2 = i - 2;
            iArr[i2] = iArr[i2] + 1;
            this.o = 0;
        }
    }

    @Override // defpackage.no1
    public void l() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS != 2) {
            StringBuilder sb = new StringBuilder("Expected END_OBJECT but was ");
            sb.append(K());
            ro1.a(sb, " at path ", getPath());
            return;
        }
        int i = this.f;
        int i2 = i - 1;
        this.f = i2;
        this.h[i2] = null;
        int[] iArr = this.i;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.o = 0;
    }

    @Override // defpackage.no1
    public boolean t() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        return (iS == 2 || iS == 4 || iS == 18) ? false : true;
    }

    public String toString() {
        return "JsonReader(" + this.m + ")";
    }

    @Override // defpackage.no1
    public boolean u() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 5) {
            this.o = 0;
            int[] iArr = this.i;
            int i = this.f - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iS != 6) {
            StringBuilder sb = new StringBuilder("Expected a boolean but was ");
            sb.append(K());
            ro1.a(sb, " at path ", getPath());
            return false;
        }
        this.o = 0;
        int[] iArr2 = this.i;
        int i2 = this.f - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    @Override // defpackage.no1
    public double v() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 16) {
            this.o = 0;
            int[] iArr = this.i;
            int i = this.f - 1;
            iArr[i] = iArr[i] + 1;
            return this.p;
        }
        if (iS == 17) {
            this.r = this.n.readUtf8(this.q);
        } else if (iS == 9) {
            this.r = W(t);
        } else if (iS == 8) {
            this.r = W(s);
        } else if (iS == 10) {
            this.r = Z();
        } else if (iS != 11) {
            StringBuilder sb = new StringBuilder("Expected a double but was ");
            sb.append(K());
            ro1.a(sb, " at path ", getPath());
            return 0.0d;
        }
        this.o = 11;
        try {
            double d = Double.parseDouble(this.r);
            if (this.j || !(Double.isNaN(d) || Double.isInfinite(d))) {
                this.r = null;
                this.o = 0;
                int[] iArr2 = this.i;
                int i2 = this.f - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return d;
            }
            throw new io1("JSON forbids NaN and infinities: " + d + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new go1("Expected a double but was " + this.r + " at path " + getPath());
        }
    }

    @Override // defpackage.no1
    public int y() throws io1, EOFException {
        int iS = this.o;
        if (iS == 0) {
            iS = S();
        }
        if (iS == 16) {
            long j = this.p;
            int i = (int) j;
            if (j == i) {
                this.o = 0;
                int[] iArr = this.i;
                int i2 = this.f - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new go1("Expected an int but was " + this.p + " at path " + getPath());
        }
        if (iS == 17) {
            this.r = this.n.readUtf8(this.q);
        } else if (iS == 9 || iS == 8) {
            String strW = iS == 9 ? W(t) : W(s);
            this.r = strW;
            try {
                int i3 = Integer.parseInt(strW);
                this.o = 0;
                int[] iArr2 = this.i;
                int i4 = this.f - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iS != 11) {
            StringBuilder sb = new StringBuilder("Expected an int but was ");
            sb.append(K());
            ro1.a(sb, " at path ", getPath());
            return 0;
        }
        this.o = 11;
        try {
            double d = Double.parseDouble(this.r);
            int i5 = (int) d;
            if (i5 == d) {
                this.r = null;
                this.o = 0;
                int[] iArr3 = this.i;
                int i6 = this.f - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new go1("Expected an int but was " + this.r + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new go1("Expected an int but was " + this.r + " at path " + getPath());
        }
    }
}

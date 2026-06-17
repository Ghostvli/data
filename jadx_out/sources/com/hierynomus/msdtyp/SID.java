package com.hierynomus.msdtyp;

import com.hierynomus.protocol.commons.ByteArrayUtils;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import defpackage.c;
import defpackage.jl;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SID {
    public static final SID EVERYONE = new SID((byte) 1, new byte[]{0, 0, 0, 0, 0, 1}, new long[]{0});
    private static final Pattern SID_REGEX = Pattern.compile("S-([0-9]+)-((?:0x[0-9a-fA-F]+)|(?:[0-9]+))(-[0-9]+)+");
    private byte revision;
    private byte[] sidIdentifierAuthority;
    private long[] subAuthorities;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum SidType implements EnumWithValue<SidType> {
        SID_TYPE_NONE(0, "0"),
        SID_TYPE_USER(1, "User"),
        SID_TYPE_DOM_GRP(2, "Domain group"),
        SID_TYPE_DOMAIN(3, "Domain"),
        SID_TYPE_ALIAS(4, "Local group"),
        SID_TYPE_WKN_GRP(5, "Builtin group"),
        SID_TYPE_DELETED(6, "Deleted"),
        SID_TYPE_INVALID(7, "Invalid"),
        SID_TYPE_UNKNOWN(8, "Unknown"),
        SID_TYPE_COMPUTER(9, "Computer"),
        SID_TYPE_LABEL(10, "Label");

        private String name;
        private long value;

        SidType(long j, String str) {
            this.value = j;
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    public SID(byte b, byte[] bArr, long[] jArr) {
        this.revision = b;
        this.sidIdentifierAuthority = bArr;
        this.subAuthorities = jArr;
    }

    public static SID fromString(String str) {
        Matcher matcher = SID_REGEX.matcher(str);
        if (!matcher.matches()) {
            c.a("Invalid SID literal: ", str);
            return null;
        }
        int i = Integer.parseInt(matcher.group(1));
        String strGroup = matcher.group(2);
        long j = strGroup.startsWith("0x") ? Long.parseLong(strGroup.substring(2), 16) : Long.parseLong(strGroup);
        int i2 = 0;
        byte[] bArr = {(byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
        String[] strArrSplit = str.substring(matcher.end(2)).split("-");
        int length = strArrSplit.length - 1;
        long[] jArr = new long[length];
        while (i2 < length) {
            int i3 = i2 + 1;
            jArr[i2] = Long.parseLong(strArrSplit[i3]);
            i2 = i3;
        }
        return new SID((byte) i, bArr, jArr);
    }

    public static SID read(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        byte b = sMBBuffer.readByte();
        int i = sMBBuffer.readByte();
        byte[] rawBytes = sMBBuffer.readRawBytes(6);
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = sMBBuffer.readUInt32();
        }
        return new SID(b, rawBytes, jArr);
    }

    public int byteCount() {
        return (this.subAuthorities.length * 4) + 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SID sid = (SID) obj;
        if (this.revision == sid.revision && Arrays.equals(this.sidIdentifierAuthority, sid.sidIdentifierAuthority)) {
            return Arrays.equals(this.subAuthorities, sid.subAuthorities);
        }
        return false;
    }

    public byte getRevision() {
        return this.revision;
    }

    public byte[] getSidIdentifierAuthority() {
        return this.sidIdentifierAuthority;
    }

    public long[] getSubAuthorities() {
        return this.subAuthorities;
    }

    public int hashCode() {
        return (((this.revision * 31) + Arrays.hashCode(this.sidIdentifierAuthority)) * 31) + Arrays.hashCode(this.subAuthorities);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("S-");
        sb.append(this.revision & 255);
        sb.append("-");
        byte[] bArr = this.sidIdentifierAuthority;
        if (bArr[0] == 0 && bArr[1] == 0) {
            long j = 0;
            long j2 = 0;
            for (int i = 5; i > 1; i--) {
                j += (((long) this.sidIdentifierAuthority[i]) & 255) << ((int) j2);
                j2 += 8;
            }
            sb.append(j);
        } else {
            sb.append("0x");
            sb.append(ByteArrayUtils.printHex(this.sidIdentifierAuthority, 0, 6));
        }
        for (long j3 : this.subAuthorities) {
            sb.append("-");
            sb.append(j3 & 4294967295L);
        }
        return sb.toString();
    }

    public void write(SMBBuffer sMBBuffer) {
        sMBBuffer.putByte(this.revision);
        sMBBuffer.putByte((byte) this.subAuthorities.length);
        byte[] bArr = this.sidIdentifierAuthority;
        if (bArr.length > 6) {
            jl.a("The IdentifierAuthority can not be larger than 6 bytes");
            return;
        }
        sMBBuffer.putRawBytes(bArr);
        for (long j : this.subAuthorities) {
            sMBBuffer.putUInt32(j);
        }
    }

    public SID() {
    }
}

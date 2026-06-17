package com.hierynomus.ntlm.messages;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class WindowsVersion {
    private ProductMajorVersion majorVersion;
    private ProductMinorVersion minorVersion;
    private NtlmRevisionCurrent ntlmRevision;
    private int productBuild;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum NtlmRevisionCurrent implements EnumWithValue<NtlmRevisionCurrent> {
        NTLMSSP_REVISION_W2K3(15);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        NtlmRevisionCurrent(int i) {
            this.value = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ProductMajorVersion implements EnumWithValue<ProductMajorVersion> {
        WINDOWS_MAJOR_VERSION_5(5),
        WINDOWS_MAJOR_VERSION_6(6),
        WINDOWS_MAJOR_VERSION_10(10);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        ProductMajorVersion(int i) {
            this.value = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ProductMinorVersion implements EnumWithValue<ProductMinorVersion> {
        WINDOWS_MINOR_VERSION_0(0),
        WINDOWS_MINOR_VERSION_1(1),
        WINDOWS_MINOR_VERSION_2(2),
        WINDOWS_MINOR_VERSION_3(3);

        private long value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        ProductMinorVersion(int i) {
            this.value = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public WindowsVersion(ProductMajorVersion productMajorVersion, ProductMinorVersion productMinorVersion, int i, NtlmRevisionCurrent ntlmRevisionCurrent) {
        this.majorVersion = productMajorVersion;
        this.minorVersion = productMinorVersion;
        this.productBuild = i;
        this.ntlmRevision = ntlmRevisionCurrent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            WindowsVersion windowsVersion = (WindowsVersion) obj;
            if (this.productBuild == windowsVersion.productBuild && this.majorVersion == windowsVersion.majorVersion && this.minorVersion == windowsVersion.minorVersion && this.ntlmRevision == windowsVersion.ntlmRevision) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NtlmRevisionCurrent getNtlmRevision() {
        return this.ntlmRevision;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(this.majorVersion, this.minorVersion, Integer.valueOf(this.productBuild), this.ntlmRevision);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public WindowsVersion readFrom(Buffer.PlainBuffer plainBuffer) throws Buffer.BufferException {
        this.majorVersion = (ProductMajorVersion) EnumWithValue.EnumUtils.valueOf(plainBuffer.readByte(), ProductMajorVersion.class, null);
        this.minorVersion = (ProductMinorVersion) EnumWithValue.EnumUtils.valueOf(plainBuffer.readByte(), ProductMinorVersion.class, null);
        this.productBuild = plainBuffer.readUInt16();
        plainBuffer.skip(3);
        this.ntlmRevision = (NtlmRevisionCurrent) EnumWithValue.EnumUtils.valueOf(plainBuffer.readByte(), NtlmRevisionCurrent.class, null);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return String.format("WindowsVersion[%s, %s, %d, %s]", this.majorVersion, this.minorVersion, Integer.valueOf(this.productBuild), this.ntlmRevision);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeTo(Buffer.PlainBuffer plainBuffer) {
        plainBuffer.putByte((byte) this.majorVersion.value);
        plainBuffer.putByte((byte) this.minorVersion.value);
        plainBuffer.putUInt16(this.productBuild);
        plainBuffer.putRawBytes(new byte[]{0, 0, 0});
        plainBuffer.putByte((byte) this.ntlmRevision.getValue());
    }

    public WindowsVersion() {
    }
}

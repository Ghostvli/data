package com.hierynomus.ntlm;

import com.hierynomus.ntlm.messages.WindowsVersion;
import defpackage.jl;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NtlmConfig {
    private boolean integrity;
    private byte[] machineID;
    private boolean omitVersion;
    private WindowsVersion windowsVersion;
    private String workstationName;

    private NtlmConfig(NtlmConfig ntlmConfig) {
        this.windowsVersion = ntlmConfig.windowsVersion;
        this.workstationName = ntlmConfig.workstationName;
        this.integrity = ntlmConfig.integrity;
        this.omitVersion = ntlmConfig.omitVersion;
        this.machineID = ntlmConfig.machineID;
    }

    public static Builder builder(Random random) {
        return new Builder(random);
    }

    public static NtlmConfig defaultConfig() {
        return builder(new SecureRandom()).build();
    }

    public byte[] getMachineID() {
        return this.machineID;
    }

    public WindowsVersion getWindowsVersion() {
        return this.windowsVersion;
    }

    public String getWorkstationName() {
        return this.workstationName;
    }

    public boolean isIntegrityEnabled() {
        return this.integrity;
    }

    public boolean isOmitVersion() {
        return this.omitVersion;
    }

    public static Builder builder(NtlmConfig ntlmConfig) {
        return new Builder(ntlmConfig);
    }

    private NtlmConfig() {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Builder {
        private NtlmConfig config;

        public Builder(Random random) {
            NtlmConfig ntlmConfig = new NtlmConfig();
            this.config = ntlmConfig;
            ntlmConfig.windowsVersion = new WindowsVersion(WindowsVersion.ProductMajorVersion.WINDOWS_MAJOR_VERSION_6, WindowsVersion.ProductMinorVersion.WINDOWS_MINOR_VERSION_1, 7600, WindowsVersion.NtlmRevisionCurrent.NTLMSSP_REVISION_W2K3);
            this.config.integrity = true;
            this.config.omitVersion = false;
            this.config.machineID = new byte[32];
            random.nextBytes(this.config.machineID);
        }

        public NtlmConfig build() {
            return new NtlmConfig();
        }

        public Builder withIntegrity(boolean z) {
            this.config.integrity = z;
            return this;
        }

        public Builder withMachineID(byte[] bArr) {
            if (bArr == null) {
                jl.a("MachineID must not be null");
                return null;
            }
            if (bArr.length == 32) {
                this.config.machineID = bArr;
                return this;
            }
            jl.a("MachineID must be 32 bytes");
            return null;
        }

        public Builder withOmitVersion(boolean z) {
            this.config.omitVersion = z;
            return this;
        }

        public Builder withWindowsVersion(WindowsVersion windowsVersion) {
            this.config.windowsVersion = windowsVersion;
            return this;
        }

        public Builder withWorkstationName(String str) {
            this.config.workstationName = str;
            return this;
        }

        public Builder(NtlmConfig ntlmConfig) {
            this.config = new NtlmConfig();
        }
    }
}

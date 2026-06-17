package com.hierynomus.smbj.share;

import com.hierynomus.msdtyp.SecurityDescriptor;
import com.hierynomus.msdtyp.SecurityInformation;
import com.hierynomus.msfscc.fileinformation.FileAllInformation;
import com.hierynomus.msfscc.fileinformation.FileLinkInformation;
import com.hierynomus.msfscc.fileinformation.FileQueryableInformation;
import com.hierynomus.msfscc.fileinformation.FileRenameInformation;
import com.hierynomus.msfscc.fileinformation.FileSettableInformation;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.smbj.common.SmbPath;
import defpackage.j02;
import defpackage.n02;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DiskEntry extends Open<DiskShare> {
    protected final j02 logger;

    public DiskEntry(SMB2FileId sMB2FileId, DiskShare diskShare, SmbPath smbPath) {
        super(sMB2FileId, smbPath, diskShare);
        this.logger = n02.k(getClass());
    }

    public void closeNoWait() {
        ((DiskShare) this.share).closeFileIdNoWait(this.fileId);
    }

    public void createHardlink(String str, boolean z) {
        setFileInformation(new FileLinkInformation(z, str));
    }

    public void deleteOnClose() {
        ((DiskShare) this.share).deleteOnClose(this.fileId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiskEntry diskEntry = (DiskEntry) obj;
        SmbPath smbPath = this.name;
        SmbPath smbPath2 = diskEntry.name;
        if (smbPath == null) {
            if (smbPath2 != null) {
                return false;
            }
        } else if (!smbPath.equals(smbPath2)) {
            return false;
        }
        S s = this.share;
        if (s == 0) {
            if (diskEntry.share != 0) {
                return false;
            }
        } else if (!((DiskShare) s).equals(diskEntry.share)) {
            return false;
        }
        return true;
    }

    public void flush() {
        ((DiskShare) this.share).flush(this.fileId);
    }

    public DiskShare getDiskShare() {
        return (DiskShare) this.share;
    }

    public <F extends FileQueryableInformation> F getFileInformation(Class<F> cls) {
        return (F) ((DiskShare) this.share).getFileInformation(this.fileId, cls);
    }

    @Deprecated
    public String getFileName() {
        return this.name.toUncPath();
    }

    public String getPath() {
        return this.name.getPath();
    }

    public SecurityDescriptor getSecurityInformation(Set<SecurityInformation> set) {
        return ((DiskShare) this.share).getSecurityInfo(this.fileId, set);
    }

    public String getUncPath() {
        return this.name.toUncPath();
    }

    public int hashCode() {
        SmbPath smbPath = this.name;
        int iHashCode = ((smbPath == null ? 0 : smbPath.hashCode()) + 31) * 31;
        S s = this.share;
        return iHashCode + (s != 0 ? ((DiskShare) s).hashCode() : 0);
    }

    public int ioctl(int i, boolean z, byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        return ((DiskShare) this.share).ioctl(this.fileId, i, z, bArr, i2, i3, bArr2, i4, i5);
    }

    public void rename(String str, boolean z, long j) {
        setFileInformation(new FileRenameInformation(z, j, str));
    }

    public <F extends FileSettableInformation> void setFileInformation(F f) {
        ((DiskShare) this.share).setFileInformation(this.fileId, f);
    }

    public void setSecurityInformation(SecurityDescriptor securityDescriptor) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(SecurityInformation.class);
        if (securityDescriptor.getOwnerSid() != null) {
            enumSetNoneOf.add(SecurityInformation.OWNER_SECURITY_INFORMATION);
        }
        if (securityDescriptor.getGroupSid() != null) {
            enumSetNoneOf.add(SecurityInformation.GROUP_SECURITY_INFORMATION);
        }
        if (securityDescriptor.getControl().contains(SecurityDescriptor.Control.DP)) {
            enumSetNoneOf.add(SecurityInformation.DACL_SECURITY_INFORMATION);
        }
        if (securityDescriptor.getControl().contains(SecurityDescriptor.Control.SP)) {
            enumSetNoneOf.add(SecurityInformation.SACL_SECURITY_INFORMATION);
        }
        ((DiskShare) this.share).setSecurityInfo(this.fileId, enumSetNoneOf, securityDescriptor);
    }

    public void createHardlink(String str) {
        createHardlink(str, false);
    }

    public void rename(String str, boolean z) {
        rename(str, z, 0L);
    }

    public void rename(String str) {
        rename(str, false);
    }

    public FileAllInformation getFileInformation() {
        return (FileAllInformation) getFileInformation(FileAllInformation.class);
    }

    public byte[] ioctl(int i, boolean z, byte[] bArr, int i2, int i3, int i4) {
        return ((DiskShare) this.share).ioctl(this.fileId, i, z, bArr, i2, i3, i4);
    }

    public byte[] ioctl(int i, boolean z, byte[] bArr, int i2, int i3) {
        return ((DiskShare) this.share).ioctl(this.fileId, i, z, bArr, i2, i3);
    }

    public void setSecurityInformation(SecurityDescriptor securityDescriptor, Set<SecurityInformation> set) {
        ((DiskShare) this.share).setSecurityInfo(this.fileId, set, securityDescriptor);
    }
}

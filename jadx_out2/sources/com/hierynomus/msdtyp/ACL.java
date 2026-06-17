package com.hierynomus.msdtyp;

import com.hierynomus.msdtyp.ace.ACE;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ACL {
    public static final byte ACL_REVISION = 2;
    public static final byte ACL_REVISION_DS = 4;
    private List<ACE> aces;
    private byte revision;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ACL(byte b, List<ACE> list) {
        this.revision = b;
        this.aces = list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ACL read(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        byte b = sMBBuffer.readByte();
        sMBBuffer.skip(1);
        sMBBuffer.readUInt16();
        int uInt16 = sMBBuffer.readUInt16();
        sMBBuffer.skip(2);
        ArrayList arrayList = new ArrayList(uInt16);
        for (int i = 0; i < uInt16; i++) {
            arrayList.add(ACE.read(sMBBuffer));
        }
        return new ACL(b, arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<ACE> getAces() {
        return this.aces;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte getRevision() {
        return this.revision;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRevision(byte b) {
        this.revision = b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "ACL{revision=" + ((int) this.revision) + ", aceCount=" + this.aces.size() + ", aces=" + this.aces + '}';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void write(SMBBuffer sMBBuffer) {
        int iWpos = sMBBuffer.wpos();
        sMBBuffer.putByte(this.revision);
        sMBBuffer.putReserved1();
        int iWpos2 = sMBBuffer.wpos();
        sMBBuffer.wpos(iWpos2 + 2);
        sMBBuffer.putUInt16(this.aces.size());
        sMBBuffer.putReserved2();
        Iterator<ACE> it = this.aces.iterator();
        while (it.hasNext()) {
            it.next().write(sMBBuffer);
        }
        int iWpos3 = sMBBuffer.wpos();
        sMBBuffer.wpos(iWpos2);
        sMBBuffer.putUInt16(iWpos3 - iWpos);
        sMBBuffer.wpos(iWpos3);
    }
}

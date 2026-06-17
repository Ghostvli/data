package com.hierynomus.mssmb2.messages;

import com.hierynomus.msfscc.directory.FileNotifyInformation;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketHeader;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2ChangeNotifyResponse extends SMB2Packet {
    List<FileNotifyInformation> fileNotifyInfoList = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private List<FileNotifyInformation> readFileNotifyInfo(SMBBuffer sMBBuffer, int i) {
        ArrayList arrayList = new ArrayList();
        sMBBuffer.rpos(((SMB2PacketHeader) this.header).getHeaderStartPosition() + i);
        while (true) {
            int iRpos = sMBBuffer.rpos();
            FileNotifyInformation fileNotifyInformation = new FileNotifyInformation();
            fileNotifyInformation.read(sMBBuffer);
            arrayList.add(fileNotifyInformation);
            if (fileNotifyInformation.getNextEntryOffset() == 0) {
                return arrayList;
            }
            sMBBuffer.rpos(iRpos + fileNotifyInformation.getNextEntryOffset());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<FileNotifyInformation> getFileNotifyInfoList() {
        return this.fileNotifyInfoList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.mssmb2.SMB2Packet
    public void readMessage(SMBBuffer sMBBuffer) throws Buffer.BufferException {
        sMBBuffer.skip(2);
        int uInt16 = sMBBuffer.readUInt16();
        int uInt32AsInt = sMBBuffer.readUInt32AsInt();
        if (uInt16 > 0 && uInt32AsInt > 0) {
            this.fileNotifyInfoList = readFileNotifyInfo(sMBBuffer, uInt16);
        }
        sMBBuffer.rpos(((SMB2PacketHeader) this.header).getHeaderStartPosition() + uInt16 + uInt32AsInt);
    }
}

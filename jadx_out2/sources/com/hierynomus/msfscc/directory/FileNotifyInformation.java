package com.hierynomus.msfscc.directory;

import com.hierynomus.msfscc.FileNotifyAction;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileNotifyInformation {
    private FileNotifyAction action;
    private String fileName;
    private int nextEntryOffset;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileNotifyAction getAction() {
        return this.action;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFileName() {
        return this.fileName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getNextEntryOffset() {
        return this.nextEntryOffset;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void read(Buffer<?> buffer) {
        this.nextEntryOffset = buffer.readUInt32AsInt();
        this.action = (FileNotifyAction) EnumWithValue.EnumUtils.valueOf(buffer.readUInt32(), FileNotifyAction.class, null);
        this.fileName = buffer.readString(Charsets.UTF_16LE, ((int) buffer.readUInt32()) / 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "FileNotifyInformation{action=" + this.action + ", fileName='" + this.fileName + "'}";
    }
}

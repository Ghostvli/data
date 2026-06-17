package com.hierynomus.msdtyp;

import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MsDataTypes {
    private MsDataTypes() {
    }

    public static long nowAsFileTime() {
        return FileTime.now().getWindowsTimeStamp();
    }

    public static void putFileTime(FileTime fileTime, Buffer<?> buffer) {
        long windowsTimeStamp = fileTime.getWindowsTimeStamp();
        buffer.putUInt32(windowsTimeStamp & 4294967295L);
        buffer.putUInt32((windowsTimeStamp >> 32) & 4294967295L);
    }

    public static void putGuid(UUID uuid, Buffer<?> buffer) {
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long mostSignificantBits = uuid.getMostSignificantBits();
        buffer.putUInt32(mostSignificantBits >>> 32);
        buffer.putUInt16((int) ((mostSignificantBits >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        buffer.putUInt16((int) (mostSignificantBits & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        buffer.putLong(leastSignificantBits, Endian.BE);
    }

    public static FileTime readFileTime(Buffer<?> buffer) {
        return new FileTime(buffer.readUInt32() | (buffer.readUInt32() << 32));
    }

    public static UUID readGuid(Buffer<?> buffer) {
        return new UUID((((buffer.readUInt32() << 16) | ((long) buffer.readUInt16())) << 16) | ((long) buffer.readUInt16()), buffer.readLong(Endian.BE));
    }
}

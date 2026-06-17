package com.hierynomus.msfscc;

import com.hierynomus.protocol.commons.EnumWithValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum FileNotifyAction implements EnumWithValue<FileNotifyAction> {
    FILE_ACTION_ADDED(1),
    FILE_ACTION_REMOVED(2),
    FILE_ACTION_MODIFIED(3),
    FILE_ACTION_RENAMED_OLD_NAME(4),
    FILE_ACTION_RENAMED_NEW_NAME(5),
    FILE_ACTION_ADDED_STREAM(6),
    FILE_ACTION_REMOVED_STREAM(7),
    FILE_ACTION_MODIFIED_STREAM(8),
    FILE_ACTION_REMOVED_BY_DELETE(9),
    FILE_ACTION_ID_NOT_TUNNELLED(10),
    FILE_ACTION_TUNNELLED_ID_COLLISION(11);

    private long value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    FileNotifyAction(long j) {
        this.value = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.protocol.commons.EnumWithValue
    public long getValue() {
        return this.value;
    }
}

package com.xunlei.downloadlib.parameter;

import com.xunlei.downloadlib.parameter.XLConstant;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorCode {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String get(int i) {
        switch (i) {
            case XLConstant.XLErrorCode.FILE_NAME_TOO_LONG /* 9125 */:
            case XLConstant.XLErrorCode.FILE_PATH_TOO_LONG /* 111120 */:
                return "檔案名稱太長";
            case XLConstant.XLErrorCode.NO_ENOUGH_BUFFER /* 9301 */:
            case XLConstant.XLErrorCode.INSUFFICIENT_DISK_SPACE /* 111085 */:
                return "儲存空間不足";
            case XLConstant.XLErrorCode.TORRENT_IMCOMPLETE /* 9304 */:
            case 111154:
            case XLConstant.XLErrorCode.TASK_FAILURE_QUERY_EMULE_HUB_FAILED /* 114001 */:
            case XLConstant.XLErrorCode.TASK_FAILURE_QUERY_BT_HUB_FAILED /* 114004 */:
            case XLConstant.XLErrorCode.TASK_FAILURE_PARSE_TORRENT_FAILED /* 114005 */:
            case XLConstant.XLErrorCode.TASK_FAILURE_GET_TORRENT_FAILED /* 114006 */:
            case XLConstant.XLErrorCode.TASK_FAILURE_SAVE_TORRENT_FAILED /* 114007 */:
            case XLConstant.XLErrorCode.TASK_FAILURE_PART_SUBTASK_FAILED /* 114011 */:
                return "版權限制";
            case XLConstant.XLErrorCode.TASK_FAILURE_EMULE_NO_RECORD /* 114101 */:
                return "已失效";
            default:
                return "ErrorCode=" + i;
        }
    }
}

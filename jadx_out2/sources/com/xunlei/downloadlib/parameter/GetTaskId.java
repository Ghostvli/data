package com.xunlei.downloadlib.parameter;

import com.github.catvod.utils.Path;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class GetTaskId {
    public String mFileName;
    public String mRealUrl;
    public File mSavePath;
    public long mTaskId;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GetTaskId(String str, File file) {
        File file2 = new File(str.substring(7));
        Path.copy(file2, new File(file, file2.getName()));
        this.mFileName = file2.getName();
        this.mSavePath = file;
        this.mRealUrl = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFileName() {
        return this.mFileName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRealUrl() {
        return this.mRealUrl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File getSaveFile() {
        return new File(getSavePath(), getFileName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File getSavePath() {
        return this.mSavePath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getTaskId() {
        return this.mTaskId;
    }

    public GetTaskId(File file) {
        this.mSavePath = file;
    }

    public GetTaskId(File file, String str, String str2) {
        this.mSavePath = file;
        this.mFileName = str;
        this.mRealUrl = str2;
    }
}

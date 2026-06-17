package com.xunlei.downloadlib.parameter;

import android.text.TextUtils;
import com.xunlei.downloadlib.Util;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TorrentFileInfo implements Comparable<TorrentFileInfo> {
    public boolean isSelected;
    public File mFile;
    public int mFileIndex;
    public String mFileName;
    public long mFileSize;
    public int mRealIndex;
    public String mSubPath;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // java.lang.Comparable
    public int compareTo(TorrentFileInfo torrentFileInfo) {
        return getFileName().compareToIgnoreCase(torrentFileInfo.getFileName());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TorrentFileInfo file(File file) {
        this.mFile = file;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getExt() {
        return getFileName().contains(".") ? getFileName().substring(getFileName().lastIndexOf(".") + 1).toLowerCase() : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File getFile() {
        return this.mFile;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getFileIndex() {
        return this.mFileIndex;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFileName() {
        return TextUtils.isEmpty(this.mFileName) ? "" : this.mFileName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getFileSize() {
        return this.mFileSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPlayUrl() {
        return "magnet://" + getFile().getAbsolutePath() + "?name=" + getFileName() + "&index=" + getFileIndex();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSize() {
        return Util.size(this.mFileSize);
    }
}

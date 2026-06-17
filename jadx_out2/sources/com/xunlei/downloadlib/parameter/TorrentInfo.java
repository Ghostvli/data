package com.xunlei.downloadlib.parameter;

import com.xunlei.downloadlib.Util;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;
import j$.util.stream.Stream$EL;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TorrentInfo {
    public File mFile;
    public int mFileCount;
    public String mInfoHash;
    public boolean mIsMultiFiles;
    public String mMultiFileBaseFolder;
    public TorrentFileInfo[] mSubFileInfo;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TorrentInfo(File file) {
        this.mFile = file;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private List<TorrentFileInfo> getSubFileList() {
        TorrentFileInfo[] torrentFileInfoArr = this.mSubFileInfo;
        return torrentFileInfoArr == null ? Collections.EMPTY_LIST : Arrays.asList(torrentFileInfoArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ TorrentFileInfo lambda$getMedias$1(TorrentFileInfo torrentFileInfo) {
        return torrentFileInfo.file(getFile());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File getFile() {
        return this.mFile;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<TorrentFileInfo> getMedias() {
        return Stream$EL.toList(getSubFileList().stream().filter(new Predicate() { // from class: aq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                TorrentFileInfo torrentFileInfo = (TorrentFileInfo) obj;
                return Util.isMedia(torrentFileInfo.getExt(), torrentFileInfo.getFileSize());
            }
        }).map(new Function() { // from class: bq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$getMedias$1((TorrentFileInfo) obj);
            }
        }).sorted());
    }
}

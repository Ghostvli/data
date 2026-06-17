package com.xunlei.downloadlib;

import com.github.catvod.utils.Path;
import com.xunlei.downloadlib.parameter.BtIndexSet;
import com.xunlei.downloadlib.parameter.BtSubTaskDetail;
import com.xunlei.downloadlib.parameter.BtTaskParam;
import com.xunlei.downloadlib.parameter.EmuleTaskParam;
import com.xunlei.downloadlib.parameter.GetTaskId;
import com.xunlei.downloadlib.parameter.MagnetTaskParam;
import com.xunlei.downloadlib.parameter.P2spTaskParam;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.downloadlib.parameter.XLTaskLocalUrl;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XLTaskHelper {
    private XLDownloadManager manager;
    private AtomicInteger seq;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Loader {
        static volatile XLTaskHelper INSTANCE = new XLTaskHelper();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private Loader() {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void deleteFile(File file) {
        if (file.isDirectory()) {
            Iterator<File> it = Path.list(file).iterator();
            while (it.hasNext()) {
                deleteFile(it.next());
            }
        }
        if (!file.isFile() || file.getAbsolutePath().endsWith(".torrent")) {
            return;
        }
        Path.clear(file);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized XLTaskHelper get() {
        return Loader.INSTANCE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private synchronized XLDownloadManager getManager() {
        XLDownloadManager xLDownloadManager;
        try {
            xLDownloadManager = this.manager;
            if (xLDownloadManager == null) {
                xLDownloadManager = new XLDownloadManager();
            }
            this.manager = xLDownloadManager;
        } catch (Throwable th) {
            throw th;
        }
        return xLDownloadManager;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private synchronized AtomicInteger getSeq() {
        AtomicInteger atomicInteger;
        try {
            atomicInteger = this.seq;
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(0);
            }
            this.seq = atomicInteger;
        } catch (Throwable th) {
            throw th;
        }
        return atomicInteger;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private synchronized GetTaskId startTask(GetTaskId getTaskId, int i) {
        getManager().setTaskGsState(getTaskId.getTaskId(), i, 2);
        getManager().startTask(getTaskId.getTaskId());
        return getTaskId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized GetTaskId addThunderTask(String str, File file) {
        String fileNameFromUrl = getManager().getFileNameFromUrl(str);
        GetTaskId getTaskId = new GetTaskId(file, fileNameFromUrl, str);
        if (str.startsWith("ftp://")) {
            P2spTaskParam p2spTaskParam = new P2spTaskParam();
            p2spTaskParam.setFilePath(file.getAbsolutePath());
            p2spTaskParam.setSeqId(getSeq().incrementAndGet());
            p2spTaskParam.setFileName(fileNameFromUrl);
            p2spTaskParam.setCreateMode(1);
            p2spTaskParam.setUrl(str);
            p2spTaskParam.setCookie("");
            p2spTaskParam.setRefUrl("");
            p2spTaskParam.setUser("");
            p2spTaskParam.setPass("");
            if (getManager().createP2spTask(p2spTaskParam, getTaskId) != 9000) {
                return getTaskId;
            }
        } else if (str.startsWith("ed2k://")) {
            EmuleTaskParam emuleTaskParam = new EmuleTaskParam();
            emuleTaskParam.setFilePath(file.getAbsolutePath());
            emuleTaskParam.setSeqId(getSeq().incrementAndGet());
            emuleTaskParam.setFileName(fileNameFromUrl);
            emuleTaskParam.setCreateMode(1);
            emuleTaskParam.setUrl(str);
            if (getManager().createEmuleTask(emuleTaskParam, getTaskId) != 9000) {
                return getTaskId;
            }
        }
        getManager().setDownloadTaskOrigin(getTaskId.getTaskId(), "out_app/out_app_paste");
        getManager().setOriginUserAgent(getTaskId.getTaskId(), "AndroidDownloadManager/4.4.4 (Linux; U; Android 4.4.4; Build/KTU84Q)");
        return startTask(getTaskId, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized GetTaskId addTorrentTask(File file, File file2, int i) {
        try {
            TorrentFileInfo[] torrentFileInfoArr = getTorrentInfo(file).mSubFileInfo;
            BtTaskParam btTaskParam = new BtTaskParam();
            btTaskParam.setCreateMode(1);
            btTaskParam.setMaxConcurrent(3);
            btTaskParam.setSeqId(getSeq().incrementAndGet());
            btTaskParam.setFilePath(file2.getAbsolutePath());
            btTaskParam.setTorrentPath(file.getAbsolutePath());
            GetTaskId getTaskId = new GetTaskId(file2);
            if (getManager().createBtTask(btTaskParam, getTaskId) != 9000) {
                return getTaskId;
            }
            if (torrentFileInfoArr.length > 1) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                for (TorrentFileInfo torrentFileInfo : torrentFileInfoArr) {
                    int i2 = torrentFileInfo.mFileIndex;
                    if (i2 != i) {
                        copyOnWriteArrayList.add(Integer.valueOf(i2));
                    }
                }
                BtIndexSet btIndexSet = new BtIndexSet(copyOnWriteArrayList.size());
                for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                    btIndexSet.mIndexSet[i3] = ((Integer) copyOnWriteArrayList.get(i3)).intValue();
                }
                getManager().deselectBtSubTask(getTaskId.getTaskId(), btIndexSet);
            }
            return startTask(getTaskId, i);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void deleteTask(GetTaskId getTaskId) {
        stopTask(getTaskId);
        deleteFile(getTaskId.getSavePath());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized BtSubTaskDetail getBtSubTaskInfo(GetTaskId getTaskId, int i) {
        BtSubTaskDetail btSubTaskDetail;
        btSubTaskDetail = new BtSubTaskDetail();
        getManager().getBtSubTaskInfo(getTaskId.getTaskId(), i, btSubTaskDetail);
        return btSubTaskDetail;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized String getLocalUrl(File file) {
        XLTaskLocalUrl xLTaskLocalUrl;
        xLTaskLocalUrl = new XLTaskLocalUrl();
        getManager().getLocalUrl(file.getAbsolutePath(), xLTaskLocalUrl);
        return xLTaskLocalUrl.mStrUrl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized XLTaskInfo getTaskInfo(GetTaskId getTaskId) {
        XLTaskInfo xLTaskInfo;
        try {
            xLTaskInfo = new XLTaskInfo();
            if (getTaskId.getSaveFile().exists()) {
                xLTaskInfo.setTaskStatus(2);
            } else {
                getManager().getTaskInfo(getTaskId.getTaskId(), 1, xLTaskInfo);
            }
        } catch (Throwable th) {
            throw th;
        }
        return xLTaskInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized TorrentInfo getTorrentInfo(File file) {
        TorrentInfo torrentInfo;
        torrentInfo = new TorrentInfo(file);
        getManager().getTorrentInfo(torrentInfo);
        return torrentInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized GetTaskId parse(String str, File file) {
        if (str.startsWith("file://")) {
            return new GetTaskId(str, file);
        }
        if (str.startsWith("thunder://")) {
            str = getManager().parserThunderUrl(str);
        }
        String fileNameFromUrl = getManager().getFileNameFromUrl(str);
        GetTaskId getTaskId = new GetTaskId(file, fileNameFromUrl, str);
        if (!str.startsWith("magnet:?")) {
            return getTaskId;
        }
        MagnetTaskParam magnetTaskParam = new MagnetTaskParam();
        magnetTaskParam.setFilePath(file.getAbsolutePath());
        magnetTaskParam.setFileName(fileNameFromUrl);
        magnetTaskParam.setUrl(str);
        if (getManager().createBtMagnetTask(magnetTaskParam, getTaskId) != 9000) {
            return getTaskId;
        }
        return startTask(getTaskId, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void release() {
        try {
            XLDownloadManager xLDownloadManager = this.manager;
            if (xLDownloadManager != null) {
                xLDownloadManager.release();
            }
            Path.clear(Path.files("setting.cfg"));
            Path.clear(Path.files("seq_id"));
            this.manager = null;
            this.seq = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void stopTask(GetTaskId getTaskId) {
        getManager().stopTask(getTaskId.getTaskId());
        getManager().releaseTask(getTaskId.getTaskId());
    }
}

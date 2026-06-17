package com.xunlei.downloadlib;

import android.content.Context;
import android.os.Build;
import com.github.catvod.utils.Prefers;
import com.xunlei.downloadlib.android.XLUtil;
import com.xunlei.downloadlib.parameter.BtIndexSet;
import com.xunlei.downloadlib.parameter.BtSubTaskDetail;
import com.xunlei.downloadlib.parameter.BtTaskParam;
import com.xunlei.downloadlib.parameter.EmuleTaskParam;
import com.xunlei.downloadlib.parameter.GetDownloadLibVersion;
import com.xunlei.downloadlib.parameter.GetFileName;
import com.xunlei.downloadlib.parameter.GetTaskId;
import com.xunlei.downloadlib.parameter.InitParam;
import com.xunlei.downloadlib.parameter.MagnetTaskParam;
import com.xunlei.downloadlib.parameter.P2spTaskParam;
import com.xunlei.downloadlib.parameter.ThunderUrlInfo;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.downloadlib.parameter.XLTaskLocalUrl;
import defpackage.yj1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XLDownloadManager {
    private Context context = yj1.a();
    private XLLoader loader = new XLLoader();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XLDownloadManager() {
        init();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getGuid() {
        return XLUtil.getGuid();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getPeerId() {
        String string = Prefers.getString("phoneId5");
        if (!string.isEmpty()) {
            return string;
        }
        String peerId = XLUtil.getPeerId();
        Prefers.put("phoneId5", peerId);
        return peerId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setLocalProperty(String str, String str2) {
        this.loader.setLocalProperty(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int createBtMagnetTask(MagnetTaskParam magnetTaskParam, GetTaskId getTaskId) {
        return this.loader.createBtMagnetTask(magnetTaskParam.mUrl, magnetTaskParam.mFilePath, magnetTaskParam.mFileName, getTaskId);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int createBtTask(BtTaskParam btTaskParam, GetTaskId getTaskId) {
        return this.loader.createBtTask(btTaskParam.mTorrentPath, btTaskParam.mFilePath, btTaskParam.mMaxConcurrent, btTaskParam.mCreateMode, btTaskParam.mSeqId, getTaskId);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int createEmuleTask(EmuleTaskParam emuleTaskParam, GetTaskId getTaskId) {
        return this.loader.createEmuleTask(emuleTaskParam.mUrl, emuleTaskParam.mFilePath, emuleTaskParam.mFileName, emuleTaskParam.mCreateMode, emuleTaskParam.mSeqId, getTaskId);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int createP2spTask(P2spTaskParam p2spTaskParam, GetTaskId getTaskId) {
        return this.loader.createP2spTask(p2spTaskParam.mUrl, p2spTaskParam.mRefUrl, p2spTaskParam.mCookie, p2spTaskParam.mUser, p2spTaskParam.mPass, p2spTaskParam.mFilePath, p2spTaskParam.mFileName, p2spTaskParam.mCreateMode, p2spTaskParam.mSeqId, getTaskId);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void deselectBtSubTask(long j, BtIndexSet btIndexSet) {
        this.loader.deselectBtSubTask(j, btIndexSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void getBtSubTaskInfo(long j, int i, BtSubTaskDetail btSubTaskDetail) {
        this.loader.getBtSubTaskInfo(j, i, btSubTaskDetail);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void getDownloadLibVersion(GetDownloadLibVersion getDownloadLibVersion) {
        this.loader.getDownloadLibVersion(getDownloadLibVersion);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFileNameFromUrl(String str) {
        GetFileName getFileName = new GetFileName();
        this.loader.getFileNameFromUrl(str, getFileName);
        return getFileName.getFileName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void getLocalUrl(String str, XLTaskLocalUrl xLTaskLocalUrl) {
        this.loader.getLocalUrl(str, xLTaskLocalUrl);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void getTaskInfo(long j, int i, XLTaskInfo xLTaskInfo) {
        this.loader.getTaskInfo(j, i, xLTaskInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void getTorrentInfo(TorrentInfo torrentInfo) {
        this.loader.getTorrentInfo(torrentInfo.getFile().getAbsolutePath(), torrentInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void init() {
        InitParam initParam = new InitParam(this.context.getFilesDir().getPath());
        this.loader.init(initParam.getSoKey(), "com.android.providers.downloads", initParam.mAppVersion, "", getPeerId(), getGuid(), initParam.mStatSavePath, initParam.mStatCfgSavePath, 0, initParam.mPermissionLevel, initParam.mQueryConfOnInit);
        getDownloadLibVersion(new GetDownloadLibVersion());
        setOSVersion(Build.VERSION.INCREMENTAL + "_alpha");
        setLocalProperty("PhoneModel", Build.MODEL);
        setStatReportSwitch(false);
        setSpeedLimit(-1L, -1L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String parserThunderUrl(String str) {
        ThunderUrlInfo thunderUrlInfo = new ThunderUrlInfo();
        this.loader.parserThunderUrl(str, thunderUrlInfo);
        return thunderUrlInfo.mUrl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void release() {
        XLLoader xLLoader = this.loader;
        if (xLLoader != null) {
            xLLoader.unInit();
        }
        this.context = null;
        this.loader = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void releaseTask(long j) {
        this.loader.releaseTask(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDownloadTaskOrigin(long j, String str) {
        this.loader.setDownloadTaskOrigin(j, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOSVersion(String str) {
        this.loader.setMiUiVersion(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOriginUserAgent(long j, String str) {
        this.loader.setOriginUserAgent(j, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSpeedLimit(long j, long j2) {
        this.loader.setSpeedLimit(j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setStatReportSwitch(boolean z) {
        this.loader.setStatReportSwitch(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTaskGsState(long j, int i, int i2) {
        this.loader.setTaskGsState(j, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void startTask(long j) {
        this.loader.startTask(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void stopTask(long j) {
        this.loader.stopTask(j);
    }
}

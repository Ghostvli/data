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

    public XLDownloadManager() {
        init();
    }

    private String getGuid() {
        return XLUtil.getGuid();
    }

    private String getPeerId() {
        String string = Prefers.getString("phoneId5");
        if (!string.isEmpty()) {
            return string;
        }
        String peerId = XLUtil.getPeerId();
        Prefers.put("phoneId5", peerId);
        return peerId;
    }

    private void setLocalProperty(String str, String str2) {
        this.loader.setLocalProperty(str, str2);
    }

    public int createBtMagnetTask(MagnetTaskParam magnetTaskParam, GetTaskId getTaskId) {
        return this.loader.createBtMagnetTask(magnetTaskParam.mUrl, magnetTaskParam.mFilePath, magnetTaskParam.mFileName, getTaskId);
    }

    public int createBtTask(BtTaskParam btTaskParam, GetTaskId getTaskId) {
        return this.loader.createBtTask(btTaskParam.mTorrentPath, btTaskParam.mFilePath, btTaskParam.mMaxConcurrent, btTaskParam.mCreateMode, btTaskParam.mSeqId, getTaskId);
    }

    public int createEmuleTask(EmuleTaskParam emuleTaskParam, GetTaskId getTaskId) {
        return this.loader.createEmuleTask(emuleTaskParam.mUrl, emuleTaskParam.mFilePath, emuleTaskParam.mFileName, emuleTaskParam.mCreateMode, emuleTaskParam.mSeqId, getTaskId);
    }

    public int createP2spTask(P2spTaskParam p2spTaskParam, GetTaskId getTaskId) {
        return this.loader.createP2spTask(p2spTaskParam.mUrl, p2spTaskParam.mRefUrl, p2spTaskParam.mCookie, p2spTaskParam.mUser, p2spTaskParam.mPass, p2spTaskParam.mFilePath, p2spTaskParam.mFileName, p2spTaskParam.mCreateMode, p2spTaskParam.mSeqId, getTaskId);
    }

    public void deselectBtSubTask(long j, BtIndexSet btIndexSet) {
        this.loader.deselectBtSubTask(j, btIndexSet);
    }

    public void getBtSubTaskInfo(long j, int i, BtSubTaskDetail btSubTaskDetail) {
        this.loader.getBtSubTaskInfo(j, i, btSubTaskDetail);
    }

    public void getDownloadLibVersion(GetDownloadLibVersion getDownloadLibVersion) {
        this.loader.getDownloadLibVersion(getDownloadLibVersion);
    }

    public String getFileNameFromUrl(String str) {
        GetFileName getFileName = new GetFileName();
        this.loader.getFileNameFromUrl(str, getFileName);
        return getFileName.getFileName();
    }

    public void getLocalUrl(String str, XLTaskLocalUrl xLTaskLocalUrl) {
        this.loader.getLocalUrl(str, xLTaskLocalUrl);
    }

    public void getTaskInfo(long j, int i, XLTaskInfo xLTaskInfo) {
        this.loader.getTaskInfo(j, i, xLTaskInfo);
    }

    public void getTorrentInfo(TorrentInfo torrentInfo) {
        this.loader.getTorrentInfo(torrentInfo.getFile().getAbsolutePath(), torrentInfo);
    }

    public void init() {
        InitParam initParam = new InitParam(this.context.getFilesDir().getPath());
        this.loader.init(initParam.getSoKey(), "com.android.providers.downloads", initParam.mAppVersion, "", getPeerId(), getGuid(), initParam.mStatSavePath, initParam.mStatCfgSavePath, 0, initParam.mPermissionLevel, initParam.mQueryConfOnInit);
        getDownloadLibVersion(new GetDownloadLibVersion());
        setOSVersion(Build.VERSION.INCREMENTAL + "_alpha");
        setLocalProperty("PhoneModel", Build.MODEL);
        setStatReportSwitch(false);
        setSpeedLimit(-1L, -1L);
    }

    public String parserThunderUrl(String str) {
        ThunderUrlInfo thunderUrlInfo = new ThunderUrlInfo();
        this.loader.parserThunderUrl(str, thunderUrlInfo);
        return thunderUrlInfo.mUrl;
    }

    public void release() {
        XLLoader xLLoader = this.loader;
        if (xLLoader != null) {
            xLLoader.unInit();
        }
        this.context = null;
        this.loader = null;
    }

    public void releaseTask(long j) {
        this.loader.releaseTask(j);
    }

    public void setDownloadTaskOrigin(long j, String str) {
        this.loader.setDownloadTaskOrigin(j, str);
    }

    public void setOSVersion(String str) {
        this.loader.setMiUiVersion(str);
    }

    public void setOriginUserAgent(long j, String str) {
        this.loader.setOriginUserAgent(j, str);
    }

    public void setSpeedLimit(long j, long j2) {
        this.loader.setSpeedLimit(j, j2);
    }

    public void setStatReportSwitch(boolean z) {
        this.loader.setStatReportSwitch(z);
    }

    public void setTaskGsState(long j, int i, int i2) {
        this.loader.setTaskGsState(j, i, i2);
    }

    public void startTask(long j) {
        this.loader.startTask(j);
    }

    public void stopTask(long j) {
        this.loader.stopTask(j);
    }
}

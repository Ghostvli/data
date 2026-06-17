package com.xunlei.downloadlib.parameter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XLTaskInfo {
    public int mAddedHighSourceState;
    public int mAdditionalResCount;
    public long mAdditionalResDCDNBytes;
    public long mAdditionalResDCDNSpeed;
    public long mAdditionalResPeerBytes;
    public long mAdditionalResPeerSpeed;
    public int mAdditionalResType;
    public long mAdditionalResVipRecvBytes;
    public long mAdditionalResVipSpeed;
    public long mCheckedSize;
    public String mCid;
    public int mDcdnState;
    public long mDownloadFileCount;
    public long mDownloadSize;
    public long mDownloadSpeed;
    public int mErrorCode;
    public String mFileName;
    public long mFileSize;
    public String mGcid;
    public int mInfoLen;
    public int mLanPeerResState;
    public int mOriginErrcode;
    public long mOriginRecvBytes;
    public long mOriginSpeed;
    public long mP2PRecvBytes;
    public long mP2PSpeed;
    public long mP2SRecvBytes;
    public long mP2SSpeed;
    public int mQueryIndexStatus;
    public long mScdnRecvBytes;
    public long mScdnSpeed;
    public long mTaskId;
    public int mTaskStatus;
    public long mTotalFileCount;

    public String getErrorMsg() {
        return ErrorCode.get(this.mErrorCode);
    }

    public int getTaskStatus() {
        return this.mTaskStatus;
    }

    public void setTaskStatus(int i) {
        this.mTaskStatus = i;
    }
}

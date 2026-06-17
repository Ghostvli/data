package okio;

import defpackage.il1;
import defpackage.jl;
import defpackage.ta;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class PriorityQueue {
    public AsyncTimeout[] array = new AsyncTimeout[8];
    public int size;

    private final int compareTo(AsyncTimeout asyncTimeout, AsyncTimeout asyncTimeout2) {
        asyncTimeout.getClass();
        return il1.c(0L, asyncTimeout2.getTimeoutAt$okio() - asyncTimeout.getTimeoutAt$okio());
    }

    private final void heapifyDown(int i, AsyncTimeout asyncTimeout) {
        AsyncTimeout asyncTimeout2;
        while (true) {
            int i2 = i << 1;
            int i3 = i2 + 1;
            int i4 = this.size;
            if (i3 > i4) {
                if (i2 > i4) {
                    break;
                }
                asyncTimeout2 = this.array[i2];
                asyncTimeout2.getClass();
            } else {
                asyncTimeout2 = this.array[i2];
                asyncTimeout2.getClass();
                AsyncTimeout asyncTimeout3 = this.array[i3];
                asyncTimeout3.getClass();
                if (il1.c(0L, asyncTimeout3.getTimeoutAt$okio() - asyncTimeout2.getTimeoutAt$okio()) >= 0) {
                    asyncTimeout2 = asyncTimeout3;
                }
            }
            if (il1.c(0L, asyncTimeout2.getTimeoutAt$okio() - asyncTimeout.getTimeoutAt$okio()) <= 0) {
                break;
            }
            int i5 = asyncTimeout2.index;
            asyncTimeout2.index = i;
            this.array[i] = asyncTimeout2;
            i = i5;
        }
        this.array[i] = asyncTimeout;
        asyncTimeout.index = i;
    }

    private final void heapifyUp(int i, AsyncTimeout asyncTimeout) {
        while (true) {
            int i2 = i >> 1;
            if (i2 == 0) {
                break;
            }
            AsyncTimeout asyncTimeout2 = this.array[i2];
            asyncTimeout2.getClass();
            if (il1.c(0L, asyncTimeout.getTimeoutAt$okio() - asyncTimeout2.getTimeoutAt$okio()) <= 0) {
                break;
            }
            asyncTimeout2.index = i;
            this.array[i] = asyncTimeout2;
            i = i2;
        }
        this.array[i] = asyncTimeout;
        asyncTimeout.index = i;
    }

    public final void add(AsyncTimeout asyncTimeout) {
        asyncTimeout.getClass();
        int i = this.size + 1;
        this.size = i;
        AsyncTimeout[] asyncTimeoutArr = this.array;
        if (i == asyncTimeoutArr.length) {
            AsyncTimeout[] asyncTimeoutArr2 = new AsyncTimeout[i * 2];
            ta.j(asyncTimeoutArr, asyncTimeoutArr2, 0, 0, 0, 14, null);
            this.array = asyncTimeoutArr2;
        }
        heapifyUp(i, asyncTimeout);
    }

    public final AsyncTimeout first() {
        return this.array[1];
    }

    public final void remove(AsyncTimeout asyncTimeout) {
        asyncTimeout.getClass();
        int i = asyncTimeout.index;
        if (i == -1) {
            jl.a("Failed requirement.");
            return;
        }
        int i2 = this.size;
        AsyncTimeout asyncTimeout2 = this.array[i2];
        asyncTimeout2.getClass();
        asyncTimeout.index = -1;
        this.array[i2] = null;
        this.size = i2 - 1;
        if (asyncTimeout == asyncTimeout2) {
            return;
        }
        int iC = il1.c(0L, asyncTimeout2.getTimeoutAt$okio() - asyncTimeout.getTimeoutAt$okio());
        if (iC == 0) {
            this.array[i] = asyncTimeout2;
            asyncTimeout2.index = i;
        } else if (iC < 0) {
            heapifyDown(i, asyncTimeout2);
        } else {
            heapifyUp(i, asyncTimeout2);
        }
    }
}

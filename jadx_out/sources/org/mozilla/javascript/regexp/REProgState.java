package org.mozilla.javascript.regexp;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class REProgState {
    final REBackTrackData backTrack;
    final int continuationOp;
    final int continuationPc;
    final int index;
    final int max;
    final int min;
    final REProgState previous;

    public REProgState(REProgState rEProgState, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        this.previous = rEProgState;
        this.min = i;
        this.max = i2;
        this.index = i3;
        this.continuationOp = i4;
        this.continuationPc = i5;
        this.backTrack = rEBackTrackData;
    }
}

package com.google.zxing.pdf417.detector;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class PDF417DetectorResult {
    private final BitMatrix bits;
    private final List<ResultPoint[]> points;
    private final int rotation;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PDF417DetectorResult(BitMatrix bitMatrix, List<ResultPoint[]> list, int i) {
        this.bits = bitMatrix;
        this.points = list;
        this.rotation = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BitMatrix getBits() {
        return this.bits;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<ResultPoint[]> getPoints() {
        return this.points;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getRotation() {
        return this.rotation;
    }

    public PDF417DetectorResult(BitMatrix bitMatrix, List<ResultPoint[]> list) {
        this(bitMatrix, list, 0);
    }
}

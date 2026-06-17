package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.common.HybridBinarizer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class rt2 extends eb0 {
    public boolean c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rt2(Reader reader) {
        super(reader);
        this.c = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.eb0
    public BinaryBitmap d(LuminanceSource luminanceSource) {
        if (this.c) {
            this.c = false;
            return new BinaryBitmap(new HybridBinarizer(luminanceSource.invert()));
        }
        this.c = true;
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }
}

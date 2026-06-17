package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class eb0 implements ResultPointCallback {
    public Reader a;
    public List b = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public eb0(Reader reader) {
        this.a = reader;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Result a(BinaryBitmap binaryBitmap) {
        this.b.clear();
        try {
            Reader reader = this.a;
            Result resultDecodeWithState = reader instanceof MultiFormatReader ? ((MultiFormatReader) reader).decodeWithState(binaryBitmap) : reader.decode(binaryBitmap);
            this.a.reset();
            return resultDecodeWithState;
        } catch (Exception unused) {
            this.a.reset();
            return null;
        } catch (Throwable th) {
            this.a.reset();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Result b(LuminanceSource luminanceSource) {
        return a(d(luminanceSource));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List c() {
        return new ArrayList(this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BinaryBitmap d(LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.b.add(resultPoint);
    }
}

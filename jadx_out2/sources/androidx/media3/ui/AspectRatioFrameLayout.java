package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.gn3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public final c f;
    public float g;
    public int h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements Runnable {
        public float f;
        public float g;
        public boolean h;
        public boolean i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(float f, float f2, boolean z) {
            this.f = f;
            this.g = f2;
            this.h = z;
            if (this.i) {
                return;
            }
            this.i = true;
            AspectRatioFrameLayout.this.post(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            this.i = false;
            AspectRatioFrameLayout.a(AspectRatioFrameLayout.this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, gn3.a, 0, 0);
            try {
                this.h = typedArrayObtainStyledAttributes.getInt(gn3.b, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f = new c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ b a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getResizeMode() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (r4 > 0.0f) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r2 = r2 * r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        r1 = r1 / r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        if (r4 > 0.0f) goto L21;
     */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        float f;
        super.onMeasure(i, i2);
        if (this.g <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = measuredWidth;
        float f3 = measuredHeight;
        float f4 = f2 / f3;
        float f5 = (this.g / f4) - 1.0f;
        if (Math.abs(f5) <= 0.01f) {
            this.f.a(this.g, f4, false);
            return;
        }
        int i3 = this.h;
        if (i3 == 0) {
            f = this.g;
        } else if (i3 == 1) {
            float f6 = f2 / this.g;
            measuredHeight = (int) f6;
        } else if (i3 == 2) {
            float f7 = f3 * this.g;
            measuredWidth = (int) f7;
        } else if (i3 == 4) {
            f = this.g;
        }
        this.f.a(this.g, f4, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Buffer.MAX_SIZE), View.MeasureSpec.makeMeasureSpec(measuredHeight, Buffer.MAX_SIZE));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAspectRatio(float f) {
        if (this.g != f) {
            this.g = f;
            requestLayout();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAspectRatioListener(b bVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setResizeMode(int i) {
        if (this.h != i) {
            this.h = i;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }
}

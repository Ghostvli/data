package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.hierynomus.protocol.commons.buffer.Buffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fl extends f23 {
    public final int g0;
    public final int h0;
    public final int i0;
    public final int j0;
    public boolean k0;
    public final List l0;

    public fl(Context context) {
        super(context);
        this.l0 = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.g0 = resources.getDimensionPixelSize(zk3.f);
        this.h0 = resources.getDimensionPixelSize(zk3.g);
        this.i0 = resources.getDimensionPixelSize(zk3.d);
        this.j0 = resources.getDimensionPixelSize(zk3.e);
    }

    @Override // defpackage.f23
    public b23 h(Context context) {
        return new el(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (getLayoutDirection() == 1) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int iMax;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        int childCount = getChildCount();
        this.l0.clear();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE);
        int i5 = 0;
        if (getItemIconGravity() == 0) {
            if (j(getLabelVisibilityMode(), currentVisibleContentItemCount) && r()) {
                View childAt = getChildAt(getSelectedItemPosition());
                int iMax2 = this.j0;
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.i0, Integer.MIN_VALUE), iMakeMeasureSpec);
                    iMax2 = Math.max(iMax2, childAt.getMeasuredWidth());
                }
                int i6 = currentVisibleContentItemCount - (childAt.getVisibility() != 8 ? 1 : 0);
                int iMin = Math.min(size - (this.h0 * i6), Math.min(iMax2, this.i0));
                int i7 = size - iMin;
                int iMin2 = Math.min(i7 / (i6 != 0 ? i6 : 1), this.g0);
                int i8 = i7 - (i6 * iMin2);
                int i9 = 0;
                while (i9 < childCount) {
                    if (getChildAt(i9).getVisibility() != 8) {
                        i4 = i9 == getSelectedItemPosition() ? iMin : iMin2;
                        if (i8 > 0) {
                            i4++;
                            i8--;
                        }
                    } else {
                        i4 = 0;
                    }
                    this.l0.add(Integer.valueOf(i4));
                    i9++;
                }
            } else {
                int iMin3 = Math.min(size / (currentVisibleContentItemCount != 0 ? currentVisibleContentItemCount : 1), this.i0);
                int i10 = size - (currentVisibleContentItemCount * iMin3);
                for (int i11 = 0; i11 < childCount; i11++) {
                    if (getChildAt(i11).getVisibility() == 8) {
                        i3 = 0;
                    } else if (i10 > 0) {
                        i3 = iMin3 + 1;
                        i10--;
                    } else {
                        i3 = iMin3;
                    }
                    this.l0.add(Integer.valueOf(i3));
                }
            }
            measuredWidth = 0;
            iMax = 0;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) this.l0.get(i5)).intValue(), Buffer.MAX_SIZE), iMakeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    measuredWidth += childAt2.getMeasuredWidth();
                    iMax = Math.max(iMax, childAt2.getMeasuredHeight());
                }
                i5++;
            }
        } else {
            if (currentVisibleContentItemCount == 0) {
                currentVisibleContentItemCount = 1;
            }
            float f = size;
            float fMin = Math.min((currentVisibleContentItemCount + 3) / 10.0f, 0.9f) * f;
            float f2 = currentVisibleContentItemCount;
            int iRound = Math.round(fMin / f2);
            int iRound2 = Math.round(f / f2);
            int measuredWidth2 = 0;
            int iMax3 = 0;
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                if (childAt3.getVisibility() != 8) {
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(iRound2, Integer.MIN_VALUE), iMakeMeasureSpec);
                    if (childAt3.getMeasuredWidth() < iRound) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(iRound, Buffer.MAX_SIZE), iMakeMeasureSpec);
                    }
                    measuredWidth2 += childAt3.getMeasuredWidth();
                    iMax3 = Math.max(iMax3, childAt3.getMeasuredHeight());
                }
                i5++;
            }
            measuredWidth = measuredWidth2;
            iMax = iMax3;
        }
        setMeasuredDimension(measuredWidth, Math.max(iMax, getSuggestedMinimumHeight()));
    }

    public boolean r() {
        return this.k0;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.k0 = z;
    }
}

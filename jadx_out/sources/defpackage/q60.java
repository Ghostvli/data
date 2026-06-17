package defpackage;

import android.graphics.RectF;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class q60 extends ScrollingMovementMethod {
    public static final Object a = new NoCopySpan.Concrete();
    public static q60 b;

    public static void b(TextView textView) {
        CharSequence text = textView.getText();
        textView.setMovementMethod((!(text instanceof Spannable) || ((ClickableSpan[]) ((Spannable) text).getSpans(0, text.length(), ClickableSpan.class)).length <= 0) ? null : g());
    }

    public static q60 g() {
        if (b == null) {
            b = new q60();
        }
        return b;
    }

    public final boolean a(int i, TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (layout == null) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(spannable);
        int selectionEnd = Selection.getSelectionEnd(spannable);
        int iMin = Math.min(selectionStart, selectionEnd);
        int iMax = Math.max(selectionStart, selectionEnd);
        if (iMin < 0 && spannable.getSpanStart(a) >= 0) {
            iMin = spannable.length();
            iMax = iMin;
        }
        if (i == 1) {
            return c(spannable, textView, iMin, iMax);
        }
        int totalPaddingTop = textView.getTotalPaddingTop() + textView.getTotalPaddingBottom();
        int lineStart = layout.getLineStart(layout.getLineForVertical(textView.getScrollY()));
        int lineEnd = layout.getLineEnd(layout.getLineForVertical((textView.getScrollY() + textView.getHeight()) - totalPaddingTop));
        if (iMin > lineEnd) {
            iMax = Integer.MAX_VALUE;
            iMin = Integer.MAX_VALUE;
        }
        if (iMax < lineStart) {
            iMax = -1;
            iMin = -1;
        }
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(lineStart, lineEnd, ClickableSpan.class);
        return i == 2 ? e(spannable, clickableSpanArr, iMin, iMax) : d(spannable, clickableSpanArr, iMin, iMax);
    }

    public final boolean c(Spannable spannable, TextView textView, int i, int i2) {
        if (i == i2) {
            return false;
        }
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(i, i2, ClickableSpan.class);
        if (clickableSpanArr.length != 1) {
            return false;
        }
        clickableSpanArr[0].onClick(textView);
        return true;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return true;
    }

    public final boolean d(Spannable spannable, ClickableSpan[] clickableSpanArr, int i, int i2) {
        int spanEnd = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (ClickableSpan clickableSpan : clickableSpanArr) {
            int spanStart = spannable.getSpanStart(clickableSpan);
            if ((spanStart > i || i == i2) && spanStart < i3) {
                spanEnd = spannable.getSpanEnd(clickableSpan);
                i3 = spanStart;
            }
        }
        if (spanEnd == Integer.MAX_VALUE) {
            return false;
        }
        Selection.setSelection(spannable, i3, spanEnd);
        return true;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean down(TextView textView, Spannable spannable) {
        if (a(3, textView, spannable) || f(textView, 130)) {
            return true;
        }
        return super.down(textView, spannable);
    }

    public final boolean e(Spannable spannable, ClickableSpan[] clickableSpanArr, int i, int i2) {
        int spanStart = -1;
        int i3 = -1;
        for (ClickableSpan clickableSpan : clickableSpanArr) {
            int spanEnd = spannable.getSpanEnd(clickableSpan);
            if ((spanEnd < i2 || i == i2) && spanEnd > i3) {
                spanStart = spannable.getSpanStart(clickableSpan);
                i3 = spanEnd;
            }
        }
        if (spanStart < 0) {
            return false;
        }
        Selection.setSelection(spannable, i3, spanStart);
        return true;
    }

    public final boolean f(TextView textView, int i) {
        View viewFocusSearch = textView.focusSearch(i);
        if (viewFocusSearch == null) {
            return false;
        }
        viewFocusSearch.requestFocus();
        return true;
    }

    @Override // android.text.method.BaseMovementMethod
    public boolean handleMovementKey(TextView textView, Spannable spannable, int i, int i2, KeyEvent keyEvent) {
        if ((i == 23 || i == 66) && KeyEvent.metaStateHasNoModifiers(i2) && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && a(1, textView, spannable)) {
            return true;
        }
        return super.handleMovementKey(textView, spannable, i, i2, keyEvent);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(TextView textView, Spannable spannable) {
        Selection.removeSelection(spannable);
        spannable.removeSpan(a);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean left(TextView textView, Spannable spannable) {
        a(2, textView, spannable);
        return true;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void onTakeFocus(TextView textView, Spannable spannable, int i) {
        Selection.removeSelection(spannable);
        if (i == 1) {
            spannable.setSpan(a, 0, 0, 34);
        } else {
            spannable.removeSpan(a);
        }
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        Layout layout = textView.getLayout();
        if (layout == null) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        int lineForVertical = layout.getLineForVertical(y);
        float f = x;
        if (!new RectF(layout.getLineLeft(lineForVertical), layout.getLineTop(lineForVertical), layout.getLineLeft(lineForVertical) + layout.getLineWidth(lineForVertical), layout.getLineBottom(lineForVertical)).contains(f, y)) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpanArr.length == 0) {
            Selection.removeSelection(spannable);
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (action == 1) {
            clickableSpanArr[0].onClick(textView);
        }
        return true;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean right(TextView textView, Spannable spannable) {
        a(3, textView, spannable);
        return true;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean up(TextView textView, Spannable spannable) {
        if (a(2, textView, spannable) || f(textView, 33)) {
            return true;
        }
        return super.up(textView, spannable);
    }
}

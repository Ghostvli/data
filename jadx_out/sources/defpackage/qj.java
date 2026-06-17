package defpackage;

import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextDirectionHeuristics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.HTTP;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qj {
    public static final cd4 a = cd4.h("\n");
    public static final cd4 b = cd4.h(HTTP.CRLF);
    public static final wn1 c = wn1.h("\n");

    public static boolean a(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            byte directionality = Character.getDirectionality(iCodePointAt);
            if (directionality == 1 || directionality == 2 || directionality == 16 || directionality == 17) {
                return true;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return false;
    }

    public static CharSequence b(CharSequence charSequence) {
        Spanned spanned;
        Object[] spans;
        int[] iArr;
        int[] iArr2;
        List<String> listI;
        int i;
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        int i2 = 0;
        if (charSequence instanceof Spanned) {
            spanned = (Spanned) charSequence;
            spans = spanned.getSpans(0, charSequence.length(), Object.class);
            iArr = new int[spans.length];
            iArr2 = new int[spans.length];
            Arrays.fill(iArr, -1);
            Arrays.fill(iArr2, -1);
        } else {
            spanned = null;
            spans = null;
            iArr = null;
            iArr2 = null;
        }
        if (charSequence.toString().contains(HTTP.CRLF)) {
            listI = b.i(charSequence);
            i = 2;
        } else {
            listI = a.i(charSequence);
            i = 1;
        }
        ArrayList arrayList = new ArrayList(listI.size());
        int i3 = 0;
        int length = 0;
        for (String str : listI) {
            String strUnicodeWrap = bidiFormatter.unicodeWrap(str, TextDirectionHeuristics.LTR);
            if (spans != null) {
                gg3.q(spanned);
                gg3.q(iArr);
                gg3.q(iArr2);
                int length2 = strUnicodeWrap.length() - str.length();
                if (length2 > 0) {
                    i3++;
                }
                for (int i4 = i2; i4 < spans.length; i4++) {
                    if (iArr[i4] < 0 && spanned.getSpanStart(spans[i4]) >= length) {
                        if (spanned.getSpanStart(spans[i4]) < length + str.length()) {
                            iArr[i4] = i3;
                        }
                    }
                    if (iArr2[i4] < 0 && spanned.getSpanEnd(spans[i4]) - 1 >= length && spanned.getSpanEnd(spans[i4]) - 1 < str.length() + length) {
                        iArr2[i4] = i3;
                    }
                }
                length += str.length() + i;
                if (length2 > 0) {
                    i3++;
                }
            }
            arrayList.add(strUnicodeWrap);
            i2 = 0;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c.e(arrayList));
        if (spans != null) {
            gg3.q(spanned);
            gg3.q(iArr);
            gg3.q(iArr2);
            for (int i5 = 0; i5 < spans.length; i5++) {
                int spanStart = spanned.getSpanStart(spans[i5]) + iArr[i5];
                int spanEnd = spanned.getSpanEnd(spans[i5]) + iArr2[i5];
                int spanFlags = spanned.getSpanFlags(spans[i5]);
                if (spanStart < 0 || spanStart >= spannableStringBuilder.length() || spanEnd < 0 || spanEnd > spannableStringBuilder.length()) {
                    xz1.i("BidiUtils", "Span out of bounds: start=" + spanStart + ",end=" + spanEnd + ",len=" + spannableStringBuilder.length());
                } else {
                    spannableStringBuilder.setSpan(spans[i5], spanStart, spanEnd, spanFlags);
                }
            }
        }
        return spannableStringBuilder;
    }
}

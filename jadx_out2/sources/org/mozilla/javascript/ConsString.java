package org.mozilla.javascript;

import java.io.Serializable;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ConsString implements CharSequence, Serializable {
    private static final long serialVersionUID = -8432806714471372570L;
    private boolean isFlat;
    private CharSequence left;
    private final int length;
    private CharSequence right;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ConsString(CharSequence charSequence, CharSequence charSequence2) {
        if (!(charSequence instanceof String) && !(charSequence instanceof ConsString)) {
            charSequence = charSequence.toString();
        }
        if (!(charSequence2 instanceof String) && !(charSequence2 instanceof ConsString)) {
            charSequence2 = charSequence2.toString();
        }
        this.left = charSequence;
        this.right = charSequence2;
        this.length = charSequence.length() + this.right.length();
        this.isFlat = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0015, B:8:0x0019, B:12:0x0023, B:20:0x004a, B:15:0x002b, B:18:0x0042, B:21:0x0058), top: B:26:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized String flatten() {
        try {
            if (!this.isFlat) {
                int length = this.length;
                char[] cArr = new char[length];
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.addFirst(this.left);
                CharSequence charSequence = this.right;
                do {
                    if (charSequence instanceof ConsString) {
                        ConsString consString = (ConsString) charSequence;
                        boolean z = consString.isFlat;
                        CharSequence charSequence2 = consString.left;
                        if (z) {
                            charSequence = charSequence2;
                            String str = (String) charSequence;
                            length -= str.length();
                            str.getChars(0, str.length(), cArr, length);
                            charSequence = !arrayDeque.isEmpty() ? null : (CharSequence) arrayDeque.removeFirst();
                        } else {
                            arrayDeque.addFirst(charSequence2);
                            charSequence = consString.right;
                        }
                    } else {
                        String str2 = (String) charSequence;
                        length -= str2.length();
                        str2.getChars(0, str2.length(), cArr, length);
                        if (!arrayDeque.isEmpty()) {
                        }
                    }
                } while (charSequence != null);
                this.left = new String(cArr);
                this.right = "";
                this.isFlat = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.left;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Object writeReplace() {
        return toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return (this.isFlat ? (String) this.left : flatten()).charAt(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return (this.isFlat ? (String) this.left : flatten()).substring(i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.CharSequence
    public String toString() {
        return this.isFlat ? (String) this.left : flatten();
    }
}

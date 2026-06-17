package org.mozilla.javascript;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ConsString implements CharSequence, Serializable {
    private static final long serialVersionUID = -8432806714471372570L;
    private boolean isFlat;
    private CharSequence left;
    private final int length;
    private CharSequence right;

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

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0015, B:8:0x0019, B:12:0x0023, B:20:0x004a, B:15:0x002b, B:18:0x0042, B:21:0x0058), top: B:26:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.lang.String flatten() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.isFlat     // Catch: java.lang.Throwable -> L29
            if (r0 != 0) goto L58
            int r0 = r6.length     // Catch: java.lang.Throwable -> L29
            char[] r1 = new char[r0]     // Catch: java.lang.Throwable -> L29
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: java.lang.Throwable -> L29
            r2.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.CharSequence r3 = r6.left     // Catch: java.lang.Throwable -> L29
            r2.addFirst(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.CharSequence r3 = r6.right     // Catch: java.lang.Throwable -> L29
        L15:
            boolean r4 = r3 instanceof org.mozilla.javascript.ConsString     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L2b
            org.mozilla.javascript.ConsString r3 = (org.mozilla.javascript.ConsString) r3     // Catch: java.lang.Throwable -> L29
            boolean r4 = r3.isFlat     // Catch: java.lang.Throwable -> L29
            java.lang.CharSequence r5 = r3.left
            if (r4 == 0) goto L23
            r3 = r5
            goto L2b
        L23:
            r2.addFirst(r5)     // Catch: java.lang.Throwable -> L29
            java.lang.CharSequence r3 = r3.right     // Catch: java.lang.Throwable -> L29
            goto L48
        L29:
            r0 = move-exception
            goto L5e
        L2b:
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L29
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L29
            int r0 = r0 - r4
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L29
            r5 = 0
            r3.getChars(r5, r4, r1, r0)     // Catch: java.lang.Throwable -> L29
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L29
            if (r3 == 0) goto L42
            r3 = 0
            goto L48
        L42:
            java.lang.Object r3 = r2.removeFirst()     // Catch: java.lang.Throwable -> L29
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Throwable -> L29
        L48:
            if (r3 != 0) goto L15
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L29
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L29
            r6.left = r0     // Catch: java.lang.Throwable -> L29
            java.lang.String r0 = ""
            r6.right = r0     // Catch: java.lang.Throwable -> L29
            r0 = 1
            r6.isFlat = r0     // Catch: java.lang.Throwable -> L29
        L58:
            java.lang.CharSequence r0 = r6.left     // Catch: java.lang.Throwable -> L29
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L29
            monitor-exit(r6)
            return r0
        L5e:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L29
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ConsString.flatten():java.lang.String");
    }

    private Object writeReplace() {
        return toString();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return (this.isFlat ? (String) this.left : flatten()).charAt(i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return (this.isFlat ? (String) this.left : flatten()).substring(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.isFlat ? (String) this.left : flatten();
    }
}

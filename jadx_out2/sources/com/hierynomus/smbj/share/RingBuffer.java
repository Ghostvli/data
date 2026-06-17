package com.hierynomus.smbj.share;

import defpackage.jl;
import defpackage.x32;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class RingBuffer {
    private byte[] buf;
    private int readIndex;
    private int size;
    private int writeIndex;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RingBuffer(int i) {
        this.buf = new byte[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readBytes(byte[] bArr, int i) {
        int i2 = this.readIndex;
        int i3 = i2 + i;
        byte[] bArr2 = this.buf;
        if (i3 <= bArr2.length) {
            System.arraycopy(bArr2, i2, bArr, 0, i);
            return;
        }
        int length = bArr2.length - i2;
        System.arraycopy(bArr2, i2, bArr, 0, length);
        System.arraycopy(this.buf, 0, bArr, length, i - length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeBytes(byte[] bArr, int i, int i2) {
        int i3 = this.writeIndex;
        int i4 = i3 + i2;
        byte[] bArr2 = this.buf;
        if (i4 <= bArr2.length) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            return;
        }
        int length = bArr2.length - i3;
        System.arraycopy(bArr, i, bArr2, i3, length);
        System.arraycopy(bArr, i + length, this.buf, 0, i2 - length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return this.size <= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isFull(int i) {
        byte[] bArr = this.buf;
        if (i <= bArr.length) {
            return this.size + i > bArr.length;
        }
        throw new IllegalArgumentException("RingBuffer of length " + this.buf.length + " cannot accomodate " + i + " bytes.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int maxSize() {
        return this.buf.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int read(byte[] bArr) {
        int length = this.size;
        if (length >= bArr.length) {
            length = bArr.length;
        }
        readBytes(bArr, length);
        this.readIndex = (this.readIndex + length) % this.buf.length;
        this.size -= length;
        return length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int size() {
        return this.size;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void write(byte[] bArr, int i, int i2) {
        if (bArr.length - i < i2) {
            jl.a("Bytes to write do not exist in source");
        } else {
            if (i2 > this.buf.length - this.size) {
                x32.a("Size of bytes to be written is greater than available buffer space");
                return;
            }
            writeBytes(bArr, i, i2);
            this.writeIndex = (this.writeIndex + i2) % this.buf.length;
            this.size += i2;
        }
    }

    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public boolean isFull() {
        return size() == this.buf.length;
    }
}

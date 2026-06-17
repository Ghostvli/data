package com.hierynomus.smbj.share;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.msfscc.fileinformation.FileDirectoryQueryableInformation;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.msfscc.fileinformation.FileInformation;
import com.hierynomus.msfscc.fileinformation.FileInformationFactory;
import com.hierynomus.mssmb2.SMB2ChangeNotifyFlags;
import com.hierynomus.mssmb2.SMB2CompletionFilter;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.messages.SMB2ChangeNotifyResponse;
import com.hierynomus.mssmb2.messages.SMB2QueryDirectoryRequest;
import com.hierynomus.mssmb2.messages.SMB2QueryDirectoryResponse;
import com.hierynomus.smbj.common.SmbPath;
import defpackage.bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Directory extends DiskEntry implements Iterable<FileIdBothDirectoryInformation> {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class DirectoryIterator<F extends FileDirectoryQueryableInformation> implements Iterator<F> {
        private byte[] currentBuffer;
        private Iterator<F> currentIterator;
        private final FileInformation.Decoder<F> decoder;
        private F next;
        private String searchPattern;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DirectoryIterator(Class<F> cls, String str) {
            this.decoder = FileInformationFactory.getDecoder(cls);
            this.searchPattern = str;
            queryDirectory(true);
            this.next = (F) prepareNext();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private F prepareNext() {
            while (true) {
                Iterator<F> it = this.currentIterator;
                if (it == null) {
                    return null;
                }
                if (it.hasNext()) {
                    return this.currentIterator.next();
                }
                queryDirectory(false);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void queryDirectory(boolean z) {
            byte[] bArr;
            SMB2QueryDirectoryResponse sMB2QueryDirectoryResponseQueryDirectory = ((DiskShare) Directory.this.share).queryDirectory(Directory.this.fileId, z ? EnumSet.of(SMB2QueryDirectoryRequest.SMB2QueryDirectoryFlags.SMB2_RESTART_SCANS) : EnumSet.noneOf(SMB2QueryDirectoryRequest.SMB2QueryDirectoryFlags.class), this.decoder.getInformationClass(), this.searchPattern);
            long statusCode = sMB2QueryDirectoryResponseQueryDirectory.getHeader().getStatusCode();
            byte[] outputBuffer = sMB2QueryDirectoryResponseQueryDirectory.getOutputBuffer();
            if (statusCode == NtStatus.STATUS_NO_MORE_FILES.getValue() || statusCode == NtStatus.STATUS_NO_SUCH_FILE.getValue() || ((bArr = this.currentBuffer) != null && Arrays.equals(bArr, outputBuffer))) {
                this.currentIterator = null;
                this.currentBuffer = null;
            } else {
                this.currentBuffer = outputBuffer;
                this.currentIterator = FileInformationFactory.createFileInformationIterator(outputBuffer, this.decoder);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
        @Override // java.util.Iterator
        public F next() {
            if (!hasNext()) {
                bo.a();
                return null;
            }
            F f = this.next;
            this.next = (F) prepareNext();
            return f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Directory(SMB2FileId sMB2FileId, DiskShare diskShare, SmbPath smbPath) {
        super(sMB2FileId, diskShare, smbPath);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.share.Open
    public SMB2FileId getFileId() {
        return this.fileId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Iterable
    public Iterator<FileIdBothDirectoryInformation> iterator() {
        return iterator(FileIdBothDirectoryInformation.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <F extends FileDirectoryQueryableInformation> List<F> list(Class<F> cls, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<F> it = iterator(cls, str);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return String.format("Directory{fileId=%s, fileName='%s'}", this.fileId, this.name.toUncPath());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Future<SMB2ChangeNotifyResponse> watchAsync(Set<SMB2CompletionFilter> set, boolean z) {
        return ((DiskShare) this.share).changeNotifyAsync(this.fileId, set, z ? EnumSet.of(SMB2ChangeNotifyFlags.WATCH_TREE) : EnumSet.noneOf(SMB2ChangeNotifyFlags.class));
    }

    public <F extends FileDirectoryQueryableInformation> Iterator<F> iterator(Class<F> cls) {
        return iterator(cls, null);
    }

    public <F extends FileDirectoryQueryableInformation> Iterator<F> iterator(Class<F> cls, String str) {
        return new DirectoryIterator(cls, str);
    }

    public <F extends FileDirectoryQueryableInformation> List<F> list(Class<F> cls) {
        return list(cls, null);
    }

    public List<FileIdBothDirectoryInformation> list() {
        return list(FileIdBothDirectoryInformation.class);
    }
}

package com.hierynomus.msfscc.fileinformation;

import com.hierynomus.msdtyp.FileTime;
import com.hierynomus.msdtyp.MsDataTypes;
import com.hierynomus.msfscc.FileInformationClass;
import com.hierynomus.msfscc.fileinformation.FileInformation;
import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import com.hierynomus.smbj.common.SMBRuntimeException;
import defpackage.bo;
import defpackage.c;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileInformationFactory {
    private static final Map<Class<?>, FileInformation.Decoder<?>> decoders;
    private static final Map<Class<?>, FileInformation.Encoder<?>> encoders;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class FileInfoIterator<F extends FileDirectoryQueryableInformation> implements Iterator<F> {
        private final Buffer.PlainBuffer buffer;
        private final FileInformation.Decoder<F> decoder;
        private F next = (F) prepareNext();
        private int offsetStart;

        public FileInfoIterator(byte[] bArr, FileInformation.Decoder<F> decoder, int i) {
            this.buffer = new Buffer.PlainBuffer(bArr, Endian.LE);
            this.decoder = decoder;
            this.offsetStart = i;
        }

        private F prepareNext() {
            F f = null;
            while (f == null) {
                try {
                    int i = this.offsetStart;
                    if (i == -1) {
                        break;
                    }
                    this.buffer.rpos(i);
                    f = (F) this.decoder.read(this.buffer);
                    int nextOffset = (int) f.getNextOffset();
                    if (nextOffset == 0) {
                        this.offsetStart = -1;
                    } else {
                        this.offsetStart += nextOffset;
                    }
                } catch (Buffer.BufferException e) {
                    throw new SMBRuntimeException(e);
                }
            }
            return f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public F next() {
            F f = this.next;
            if (f != null) {
                this.next = (F) prepareNext();
                return f;
            }
            bo.a();
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        HashMap map = new HashMap();
        encoders = map;
        HashMap map2 = new HashMap();
        decoders = map2;
        map2.put(FileAccessInformation.class, new FileInformation.Decoder<FileAccessInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.1
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileAccessInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileAccessInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileAccessInformation(buffer);
            }
        });
        map2.put(FileAlignmentInformation.class, new FileInformation.Decoder<FileAlignmentInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.2
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileAlignmentInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileAlignmentInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileAlignmentInformation(buffer);
            }
        });
        map2.put(FileAllInformation.class, new FileInformation.Decoder<FileAllInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.3
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileAllInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileAllInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileAllInformation(buffer);
            }
        });
        FileInformation.Codec<FileAllocationInformation> codec = new FileInformation.Codec<FileAllocationInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.4
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder, com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileAllocationInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileAllocationInformation read(Buffer<?> buffer) {
                return new FileAllocationInformation(buffer.readLong());
            }

            public void write(FileAllocationInformation fileAllocationInformation, Buffer<?> buffer) {
                buffer.putLong(fileAllocationInformation.getAllocationSize());
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder
            public /* bridge */ /* synthetic */ void write(FileInformation fileInformation, Buffer buffer) {
                write((FileAllocationInformation) fileInformation, (Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }
        };
        map2.put(FileAllocationInformation.class, codec);
        map.put(FileAllocationInformation.class, codec);
        FileInformation.Codec<FileBasicInformation> codec2 = new FileInformation.Codec<FileBasicInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.5
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder, com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileBasicInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            public void write(FileBasicInformation fileBasicInformation, Buffer<?> buffer) {
                MsDataTypes.putFileTime(fileBasicInformation.getCreationTime(), buffer);
                MsDataTypes.putFileTime(fileBasicInformation.getLastAccessTime(), buffer);
                MsDataTypes.putFileTime(fileBasicInformation.getLastWriteTime(), buffer);
                MsDataTypes.putFileTime(fileBasicInformation.getChangeTime(), buffer);
                buffer.putUInt32(fileBasicInformation.getFileAttributes());
                buffer.putUInt32(0L);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileBasicInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileBasicInformation(buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder
            public /* bridge */ /* synthetic */ void write(FileInformation fileInformation, Buffer buffer) {
                write((FileBasicInformation) fileInformation, (Buffer<?>) buffer);
            }
        };
        map2.put(FileBasicInformation.class, codec2);
        map.put(FileBasicInformation.class, codec2);
        map.put(FileDispositionInformation.class, new FileInformation.Encoder<FileDispositionInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.6
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder, com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileDispositionInformation;
            }

            public void write(FileDispositionInformation fileDispositionInformation, Buffer<?> buffer) {
                buffer.putBoolean(fileDispositionInformation.isDeleteOnClose());
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder
            public /* bridge */ /* synthetic */ void write(FileInformation fileInformation, Buffer buffer) {
                write((FileDispositionInformation) fileInformation, (Buffer<?>) buffer);
            }
        });
        map2.put(FileEaInformation.class, new FileInformation.Decoder<FileEaInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.7
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileEaInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileEaInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileEaInformation(buffer);
            }
        });
        map2.put(FileStreamInformation.class, new FileInformation.Decoder<FileStreamInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.8
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileStreamInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileStreamInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileStreamInformation(buffer);
            }
        });
        map.put(FileEndOfFileInformation.class, new FileInformation.Encoder<FileEndOfFileInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.9
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder, com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileEndOfFileInformation;
            }

            public void write(FileEndOfFileInformation fileEndOfFileInformation, Buffer<?> buffer) {
                buffer.putLong(fileEndOfFileInformation.getEndOfFile());
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder
            public /* bridge */ /* synthetic */ void write(FileInformation fileInformation, Buffer buffer) {
                write((FileEndOfFileInformation) fileInformation, (Buffer<?>) buffer);
            }
        });
        map2.put(FileInternalInformation.class, new FileInformation.Decoder<FileInternalInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.10
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileInternalInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInternalInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileInternalInformation(buffer);
            }
        });
        FileInformation.Codec<FileModeInformation> codec3 = new FileInformation.Codec<FileModeInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.11
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder, com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileModeInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            public void write(FileModeInformation fileModeInformation, Buffer<?> buffer) {
                buffer.putUInt32(((long) fileModeInformation.getMode()) & 4294967295L);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileModeInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileModeInformation(buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder
            public /* bridge */ /* synthetic */ void write(FileInformation fileInformation, Buffer buffer) {
                write((FileModeInformation) fileInformation, (Buffer<?>) buffer);
            }
        };
        map2.put(FileModeInformation.class, codec3);
        map.put(FileModeInformation.class, codec3);
        map2.put(FilePositionInformation.class, new FileInformation.Decoder<FilePositionInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.12
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FilePositionInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FilePositionInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFilePositionInformation(buffer);
            }
        });
        map2.put(FileStandardInformation.class, new FileInformation.Decoder<FileStandardInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.13
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileStandardInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileStandardInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileStandardInformation(buffer);
            }
        });
        map2.put(FileBothDirectoryInformation.class, new FileInformation.Decoder<FileBothDirectoryInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.14
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileBothDirectoryInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileBothDirectoryInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileBothDirectoryInformation(buffer);
            }
        });
        map2.put(FileDirectoryInformation.class, new FileInformation.Decoder<FileDirectoryInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.15
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileDirectoryInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileDirectoryInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileDirectoryInformation(buffer);
            }
        });
        map2.put(FileFullDirectoryInformation.class, new FileInformation.Decoder<FileFullDirectoryInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.16
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileFullDirectoryInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileFullDirectoryInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileFullDirectoryInformation(buffer);
            }
        });
        map2.put(FileIdBothDirectoryInformation.class, new FileInformation.Decoder<FileIdBothDirectoryInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.17
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileIdBothDirectoryInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileIdBothDirectoryInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileIdBothDirectoryInformation(buffer);
            }
        });
        map2.put(FileIdFullDirectoryInformation.class, new FileInformation.Decoder<FileIdFullDirectoryInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.18
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileIdFullDirectoryInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileIdFullDirectoryInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileIdFullDirectoryInformation(buffer);
            }
        });
        map2.put(FileNamesInformation.class, new FileInformation.Decoder<FileNamesInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.19
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileNamesInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public /* bridge */ /* synthetic */ FileInformation read(Buffer buffer) {
                return read((Buffer<?>) buffer);
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileNamesInformation read(Buffer<?> buffer) {
                return FileInformationFactory.parseFileNamesInformation(buffer);
            }
        });
        map.put(FileRenameInformation.class, new FileInformation.Encoder<FileRenameInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.20
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder, com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileRenameInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder
            public /* bridge */ /* synthetic */ void write(FileInformation fileInformation, Buffer buffer) {
                write((FileRenameInformation) fileInformation, (Buffer<?>) buffer);
            }

            public void write(FileRenameInformation fileRenameInformation, Buffer<?> buffer) {
                FileInformationFactory.writeFileRenameInformation(fileRenameInformation, buffer);
            }
        });
        map.put(FileLinkInformation.class, new FileInformation.Encoder<FileLinkInformation>() { // from class: com.hierynomus.msfscc.fileinformation.FileInformationFactory.21
            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder, com.hierynomus.msfscc.fileinformation.FileInformation.Decoder
            public FileInformationClass getInformationClass() {
                return FileInformationClass.FileLinkInformation;
            }

            @Override // com.hierynomus.msfscc.fileinformation.FileInformation.Encoder
            public /* bridge */ /* synthetic */ void write(FileInformation fileInformation, Buffer buffer) {
                write((FileLinkInformation) fileInformation, (Buffer<?>) buffer);
            }

            public void write(FileLinkInformation fileLinkInformation, Buffer<?> buffer) {
                FileInformationFactory.writeFileRenameInformation(fileLinkInformation, buffer);
            }
        });
    }

    private FileInformationFactory() {
    }

    public static <F extends FileDirectoryQueryableInformation> Iterator<F> createFileInformationIterator(byte[] bArr, FileInformation.Decoder<F> decoder) {
        return new FileInfoIterator(bArr, decoder, 0);
    }

    public static <F extends FileInformation> FileInformation.Decoder<F> getDecoder(Class<F> cls) {
        FileInformation.Decoder<F> decoder = (FileInformation.Decoder) decoders.get(cls);
        if (decoder != null) {
            return decoder;
        }
        c.a("FileInformationClass not supported - ", cls);
        return null;
    }

    public static <F extends FileInformation> FileInformation.Encoder<F> getEncoder(Class<F> cls) {
        FileInformation.Encoder<F> encoder = (FileInformation.Encoder) encoders.get(cls);
        if (encoder != null) {
            return encoder;
        }
        c.a("FileInformationClass not supported - ", cls);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileAccessInformation parseFileAccessInformation(Buffer<?> buffer) {
        return new FileAccessInformation((int) buffer.readUInt32());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileAlignmentInformation parseFileAlignmentInformation(Buffer<?> buffer) {
        return new FileAlignmentInformation(buffer.readUInt32());
    }

    public static FileAllInformation parseFileAllInformation(Buffer<?> buffer) {
        return new FileAllInformation(parseFileBasicInformation(buffer), parseFileStandardInformation(buffer), parseFileInternalInformation(buffer), parseFileEaInformation(buffer), parseFileAccessInformation(buffer), parseFilePositionInformation(buffer), parseFileModeInformation(buffer), parseFileAlignmentInformation(buffer), parseFileNameInformation(buffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileBasicInformation parseFileBasicInformation(Buffer<?> buffer) throws Buffer.BufferException {
        FileTime fileTime = MsDataTypes.readFileTime(buffer);
        FileTime fileTime2 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime3 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime4 = MsDataTypes.readFileTime(buffer);
        long uInt32 = buffer.readUInt32();
        buffer.skip(4);
        return new FileBasicInformation(fileTime, fileTime2, fileTime3, fileTime4, uInt32);
    }

    public static FileBothDirectoryInformation parseFileBothDirectoryInformation(Buffer<?> buffer) throws Buffer.BufferException {
        long uInt32 = buffer.readUInt32();
        long uInt322 = buffer.readUInt32();
        FileTime fileTime = MsDataTypes.readFileTime(buffer);
        FileTime fileTime2 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime3 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime4 = MsDataTypes.readFileTime(buffer);
        long uInt64 = buffer.readUInt64();
        long uInt642 = buffer.readUInt64();
        long uInt323 = buffer.readUInt32();
        long uInt324 = buffer.readUInt32();
        long uInt325 = buffer.readUInt32();
        byte b = buffer.readByte();
        buffer.readByte();
        byte[] rawBytes = buffer.readRawBytes(24);
        Charset charset = Charsets.UTF_16LE;
        return new FileBothDirectoryInformation(uInt32, uInt322, buffer.readString(charset, ((int) uInt324) / 2), fileTime, fileTime2, fileTime3, fileTime4, uInt64, uInt642, uInt323, uInt325, new String(rawBytes, 0, b, charset));
    }

    public static FileDirectoryInformation parseFileDirectoryInformation(Buffer<?> buffer) {
        return new FileDirectoryInformation(buffer.readUInt32(), buffer.readUInt32(), parseFileNameInformation(buffer), MsDataTypes.readFileTime(buffer), MsDataTypes.readFileTime(buffer), MsDataTypes.readFileTime(buffer), MsDataTypes.readFileTime(buffer), buffer.readUInt64(), buffer.readUInt64(), buffer.readUInt32());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileEaInformation parseFileEaInformation(Buffer<?> buffer) {
        return new FileEaInformation(buffer.readUInt32());
    }

    public static FileFullDirectoryInformation parseFileFullDirectoryInformation(Buffer<?> buffer) {
        long uInt32 = buffer.readUInt32();
        long uInt322 = buffer.readUInt32();
        FileTime fileTime = MsDataTypes.readFileTime(buffer);
        FileTime fileTime2 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime3 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime4 = MsDataTypes.readFileTime(buffer);
        long uInt64 = buffer.readUInt64();
        long uInt642 = buffer.readUInt64();
        long uInt323 = buffer.readUInt32();
        long uInt324 = buffer.readUInt32();
        return new FileFullDirectoryInformation(uInt32, uInt322, buffer.readString(Charsets.UTF_16LE, ((int) uInt324) / 2), fileTime, fileTime2, fileTime3, fileTime4, uInt64, uInt642, uInt323, buffer.readUInt32());
    }

    public static FileIdBothDirectoryInformation parseFileIdBothDirectoryInformation(Buffer<?> buffer) throws Buffer.BufferException {
        long uInt32 = buffer.readUInt32();
        long uInt322 = buffer.readUInt32();
        FileTime fileTime = MsDataTypes.readFileTime(buffer);
        FileTime fileTime2 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime3 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime4 = MsDataTypes.readFileTime(buffer);
        long uInt64 = buffer.readUInt64();
        long uInt642 = buffer.readUInt64();
        long uInt323 = buffer.readUInt32();
        long uInt324 = buffer.readUInt32();
        long uInt325 = buffer.readUInt32();
        byte b = buffer.readByte();
        buffer.readByte();
        byte[] rawBytes = buffer.readRawBytes(24);
        Charset charset = Charsets.UTF_16LE;
        String str = new String(rawBytes, 0, b, charset);
        buffer.readUInt16();
        return new FileIdBothDirectoryInformation(uInt32, uInt322, buffer.readString(charset, ((int) uInt324) / 2), fileTime, fileTime2, fileTime3, fileTime4, uInt64, uInt642, uInt323, uInt325, str, buffer.readLong());
    }

    public static FileIdFullDirectoryInformation parseFileIdFullDirectoryInformation(Buffer<?> buffer) throws Buffer.BufferException {
        long uInt32 = buffer.readUInt32();
        long uInt322 = buffer.readUInt32();
        FileTime fileTime = MsDataTypes.readFileTime(buffer);
        FileTime fileTime2 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime3 = MsDataTypes.readFileTime(buffer);
        FileTime fileTime4 = MsDataTypes.readFileTime(buffer);
        long uInt64 = buffer.readUInt64();
        long uInt642 = buffer.readUInt64();
        long uInt323 = buffer.readUInt32();
        long uInt324 = buffer.readUInt32();
        long uInt325 = buffer.readUInt32();
        buffer.skip(4);
        return new FileIdFullDirectoryInformation(uInt32, uInt322, buffer.readString(Charsets.UTF_16LE, ((int) uInt324) / 2), fileTime, fileTime2, fileTime3, fileTime4, uInt64, uInt642, uInt323, uInt325, buffer.readLong());
    }

    public static <F extends FileDirectoryQueryableInformation> List<F> parseFileInformationList(byte[] bArr, FileInformation.Decoder<F> decoder) {
        ArrayList arrayList = new ArrayList();
        Iterator itCreateFileInformationIterator = createFileInformationIterator(bArr, decoder);
        while (itCreateFileInformationIterator.hasNext()) {
            arrayList.add((FileDirectoryQueryableInformation) itCreateFileInformationIterator.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileInternalInformation parseFileInternalInformation(Buffer<?> buffer) {
        return new FileInternalInformation(buffer.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileModeInformation parseFileModeInformation(Buffer<?> buffer) {
        return new FileModeInformation((int) buffer.readUInt32());
    }

    private static String parseFileNameInformation(Buffer<?> buffer) {
        return buffer.readString(Charsets.UTF_16LE, ((int) buffer.readUInt32()) / 2);
    }

    public static FileNamesInformation parseFileNamesInformation(Buffer<?> buffer) {
        return new FileNamesInformation(buffer.readUInt32(), buffer.readUInt32(), buffer.readString(Charsets.UTF_16LE, ((int) buffer.readUInt32()) / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FilePositionInformation parseFilePositionInformation(Buffer<?> buffer) {
        return new FilePositionInformation(buffer.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileStandardInformation parseFileStandardInformation(Buffer<?> buffer) throws Buffer.BufferException {
        long j = buffer.readLong();
        long uInt64 = buffer.readUInt64();
        long uInt32 = buffer.readUInt32();
        boolean z = buffer.readBoolean();
        boolean z2 = buffer.readBoolean();
        buffer.skip(2);
        return new FileStandardInformation(j, uInt64, uInt32, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileStreamInformation parseFileStreamInformation(Buffer<?> buffer) {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        long uInt32 = 0;
        do {
            j += uInt32;
            buffer.rpos((int) j);
            uInt32 = buffer.readUInt32();
            arrayList.add(new FileStreamInformationItem(buffer.readLong(), buffer.readLong(), buffer.readString(Charsets.UTF_16LE, ((int) buffer.readUInt32()) / 2)));
        } while (uInt32 != 0);
        return new FileStreamInformation(arrayList);
    }

    public static void writeFileRenameInformation(FileRenameInformation fileRenameInformation, Buffer<?> buffer) {
        buffer.putByte(fileRenameInformation.isReplaceIfExists() ? (byte) 1 : (byte) 0);
        buffer.putRawBytes(new byte[]{0, 0, 0, 0, 0, 0, 0});
        buffer.putUInt64(fileRenameInformation.getRootDirectory());
        buffer.putUInt32(((long) fileRenameInformation.getFileNameLength()) * 2);
        buffer.putRawBytes(fileRenameInformation.getFileName().getBytes(Charsets.UTF_16LE));
    }

    public static <F extends FileInformation> FileInformation.Encoder<F> getEncoder(F f) {
        return getEncoder(f.getClass());
    }
}

package j$.nio.file;

import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import j$.nio.file.attribute.BasicFileAttributes;
import j$.nio.file.attribute.FileAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class Files {
    public static final /* synthetic */ int a = 0;

    static {
        j$.desugar.sun.nio.fs.g.p(new Object[]{StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(InputStream inputStream, Path path, CopyOption... copyOptionArr) throws IOException {
        Objects.requireNonNull(inputStream);
        int length = copyOptionArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            CopyOption copyOption = copyOptionArr[i];
            if (copyOption != StandardCopyOption.REPLACE_EXISTING) {
                if (copyOption == null) {
                    throw new NullPointerException("options contains 'null'");
                }
                throw new UnsupportedOperationException(copyOption + " not supported");
            }
            i++;
            z = true;
        }
        if (z) {
            try {
                path.getFileSystem().h().g(path);
                e = null;
            } catch (SecurityException e) {
                e = e;
            }
        } else {
            e = null;
        }
        try {
            OutputStream outputStreamNewOutputStream = newOutputStream(path, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
            try {
                if (inputStream instanceof InputStreamRetargetInterface) {
                    ((InputStreamRetargetInterface) inputStream).transferTo(outputStreamNewOutputStream);
                } else {
                    DesugarInputStream.transferTo(inputStream, outputStreamNewOutputStream);
                }
                if (outputStreamNewOutputStream != null) {
                    outputStreamNewOutputStream.close();
                }
            } catch (Throwable th) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileAlreadyExistsException e2) {
            if (e == null) {
                throw e2;
            }
            throw e;
        }
    }

    public static j$.nio.file.spi.c b(Path path) {
        return path.getFileSystem().h();
    }

    public static Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) {
        b(path).c(path, fileAttributeArr);
        return path;
    }

    public static Path createSymbolicLink(Path path, Path path2, FileAttribute<?>... fileAttributeArr) {
        b(path).e(path, path2, fileAttributeArr);
        return path;
    }

    public static void delete(Path path) {
        b(path).f(path);
    }

    public static boolean exists(Path path, LinkOption... linkOptionArr) {
        if (linkOptionArr.length == 0) {
            b(path);
        }
        try {
            int length = linkOptionArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                LinkOption linkOption = linkOptionArr[i];
                if (linkOption != LinkOption.NOFOLLOW_LINKS) {
                    linkOption.getClass();
                    throw new AssertionError("Should not get here");
                }
                i++;
                z = false;
            }
            if (z) {
                b(path).a(path, new a[0]);
            } else {
                readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Path move(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        j$.nio.file.spi.c cVarB = b(path);
        if (b(path2).equals(cVarB)) {
            cVarB.o(path, path2, copyOptionArr);
            return path2;
        }
        int length = copyOptionArr.length;
        int i = length + 2;
        CopyOption[] copyOptionArr2 = new CopyOption[i];
        for (int i2 = 0; i2 < length; i2++) {
            CopyOption copyOption = copyOptionArr[i2];
            if (copyOption == StandardCopyOption.ATOMIC_MOVE) {
                throw new AtomicMoveNotSupportedException(null, null, "Atomic move between providers is not supported");
            }
            copyOptionArr2[i2] = copyOption;
        }
        copyOptionArr2[length] = LinkOption.NOFOLLOW_LINKS;
        copyOptionArr2[length + 1] = StandardCopyOption.COPY_ATTRIBUTES;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < i; i3++) {
            CopyOption copyOption2 = copyOptionArr2[i3];
            if (copyOption2 == StandardCopyOption.REPLACE_EXISTING) {
                z2 = true;
            } else if (copyOption2 == LinkOption.NOFOLLOW_LINKS) {
                z = false;
            } else {
                if (copyOption2 != StandardCopyOption.COPY_ATTRIBUTES) {
                    copyOption2.getClass();
                    j.e("'", copyOption2, "' is not a recognized copy option");
                    return null;
                }
                z3 = true;
            }
        }
        BasicFileAttributes attributes = readAttributes(path, BasicFileAttributes.class, z ? new LinkOption[0] : new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        if (attributes.isSymbolicLink()) {
            throw new IOException("Copying of symbolic links not supported");
        }
        if (z2) {
            path2.getFileSystem().h().g(path2);
        } else if (exists(path2, new LinkOption[0])) {
            throw new FileAlreadyExistsException(path2.toString());
        }
        if (attributes.isDirectory()) {
            createDirectory(path2, new FileAttribute[0]);
        } else {
            InputStream inputStreamNewInputStream = newInputStream(path, new OpenOption[0]);
            try {
                a(inputStreamNewInputStream, path2, new CopyOption[0]);
                inputStreamNewInputStream.close();
            } catch (Throwable th) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (z3) {
            try {
                ((j$.nio.file.attribute.d) path2.getFileSystem().h().h(path2, j$.nio.file.attribute.d.class, new LinkOption[0])).a(attributes.lastModifiedTime(), attributes.lastAccessTime(), attributes.creationTime());
            } catch (Throwable th3) {
                try {
                    delete(path2);
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
        delete(path);
        return path2;
    }

    public static DirectoryStream<Path> newDirectoryStream(Path path, String str) {
        if (str.equals("*")) {
            return b(path).r(path, k.a);
        }
        FileSystem fileSystem = path.getFileSystem();
        return fileSystem.h().r(path, new j$.desugar.sun.nio.fs.h(fileSystem.b("glob:".concat(str)), 1));
    }

    public static InputStream newInputStream(Path path, OpenOption... openOptionArr) {
        return b(path).v(path, openOptionArr);
    }

    public static OutputStream newOutputStream(Path path, OpenOption... openOptionArr) {
        return b(path).w(path, openOptionArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        if (r2 != r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        r3 = java.util.Arrays.copyOf(r3, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] readAllBytes(j$.nio.file.Path r8) {
        /*
            java.util.Set r0 = java.util.Collections.EMPTY_SET
            r1 = 0
            j$.nio.file.attribute.FileAttribute[] r2 = new j$.nio.file.attribute.FileAttribute[r1]
            j$.nio.file.spi.c r3 = b(r8)
            java.nio.channels.SeekableByteChannel r8 = r3.q(r8, r0, r2)
            java.io.InputStream r0 = java.nio.channels.Channels.newInputStream(r8)     // Catch: java.lang.Throwable -> L66
            long r2 = r8.size()     // Catch: java.lang.Throwable -> L6e
            r4 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            java.lang.String r5 = "Required array size too large"
            if (r4 > 0) goto L68
            int r2 = (int) r2
            byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L6e
        L21:
            int r4 = r2 - r1
            int r4 = r0.read(r3, r1, r4)     // Catch: java.lang.Throwable -> L6e
            if (r4 <= 0) goto L2b
            int r1 = r1 + r4
            goto L21
        L2b:
            if (r4 < 0) goto L58
            int r4 = r0.read()     // Catch: java.lang.Throwable -> L6e
            if (r4 >= 0) goto L34
            goto L58
        L34:
            r6 = 2147483639(0x7ffffff7, float:NaN)
            int r7 = r6 - r2
            if (r2 > r7) goto L44
            int r2 = r2 << 1
            r6 = 8192(0x2000, float:1.148E-41)
            int r2 = java.lang.Math.max(r2, r6)     // Catch: java.lang.Throwable -> L6e
            goto L47
        L44:
            if (r2 == r6) goto L52
            r2 = r6
        L47:
            byte[] r3 = java.util.Arrays.copyOf(r3, r2)     // Catch: java.lang.Throwable -> L6e
            int r6 = r1 + 1
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L6e
            r3[r1] = r4     // Catch: java.lang.Throwable -> L6e
            r1 = r6
            goto L21
        L52:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch: java.lang.Throwable -> L6e
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L6e
            throw r1     // Catch: java.lang.Throwable -> L6e
        L58:
            if (r2 != r1) goto L5b
            goto L5f
        L5b:
            byte[] r3 = java.util.Arrays.copyOf(r3, r1)     // Catch: java.lang.Throwable -> L6e
        L5f:
            r0.close()     // Catch: java.lang.Throwable -> L66
            r8.close()
            return r3
        L66:
            r0 = move-exception
            goto L7a
        L68:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch: java.lang.Throwable -> L6e
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L6e
            throw r1     // Catch: java.lang.Throwable -> L6e
        L6e:
            r1 = move-exception
            if (r0 == 0) goto L79
            r0.close()     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L66
        L79:
            throw r1     // Catch: java.lang.Throwable -> L66
        L7a:
            if (r8 == 0) goto L84
            r8.close()     // Catch: java.lang.Throwable -> L80
            goto L84
        L80:
            r8 = move-exception
            r0.addSuppressed(r8)
        L84:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.nio.file.Files.readAllBytes(j$.nio.file.Path):byte[]");
    }

    public static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) {
        return (A) b(path).x(path, cls, linkOptionArr);
    }

    public static Path readSymbolicLink(Path path) {
        return b(path).z(path);
    }
}

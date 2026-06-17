package org.jupnp.model.meta;

import defpackage.e04;
import j$.io.FileRetargetClass;
import j$.nio.file.Files;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.Validatable;
import org.jupnp.model.ValidationError;
import org.jupnp.model.types.BinHexDatatype;
import org.jupnp.util.MimeType;
import org.jupnp.util.SpecificationViolationReporter;
import org.jupnp.util.URIUtil;
import org.jupnp.util.io.IO;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Icon implements Validatable {
    private final byte[] data;
    private final int depth;
    private Device device;
    private final int height;
    private final MimeType mimeType;
    private final URI uri;
    private final int width;

    public Icon(String str, int i, int i2, int i3, String str2, String str3) {
        this(str, i, i2, i3, str2, (str3 == null || str3.isEmpty()) ? null : new BinHexDatatype().valueOf(str3));
    }

    public Icon deepCopy() {
        return new Icon(getMimeType(), getWidth(), getHeight(), getDepth(), getUri(), getData());
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDepth() {
        return this.depth;
    }

    public Device getDevice() {
        return this.device;
    }

    public int getHeight() {
        return this.height;
    }

    public MimeType getMimeType() {
        return this.mimeType;
    }

    public URI getUri() {
        return this.uri;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDevice(Device device) {
        if (this.device == null) {
            this.device = device;
        } else {
            e04.a("Final value has been set already, model is immutable");
        }
    }

    public String toString() {
        return "Icon(" + getWidth() + "x" + getHeight() + ", MIME: " + String.valueOf(getMimeType()) + ") " + String.valueOf(getUri());
    }

    @Override // org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getMimeType() == null) {
            SpecificationViolationReporter.report(getDevice(), "Invalid icon, missing mime type: {}", this);
        }
        if (getWidth() == 0) {
            SpecificationViolationReporter.report(getDevice(), "Invalid icon, missing width: {}", this);
        }
        if (getHeight() == 0) {
            SpecificationViolationReporter.report(getDevice(), "Invalid icon, missing height: {}", this);
        }
        if (getDepth() == 0) {
            SpecificationViolationReporter.report(getDevice(), "Invalid icon, missing bitmap depth: {}", this);
        }
        if (getUri() == null) {
            arrayList.add(new ValidationError(getClass(), "uri", "URL is required"));
            return arrayList;
        }
        try {
            if (getUri().toURL() == null) {
                throw new MalformedURLException();
            }
        } catch (IllegalArgumentException unused) {
        } catch (MalformedURLException e) {
            arrayList.add(new ValidationError(getClass(), "uri", "URL must be valid: " + e.getMessage()));
        }
        return arrayList;
    }

    public Icon(String str, int i, int i2, int i3, URL url) {
        this(str, i, i2, i3, new File(URIUtil.toURI(url)));
    }

    public Icon(String str, int i, int i2, int i3, File file) {
        this(str, i, i2, i3, file.getName(), Files.readAllBytes(FileRetargetClass.toPath(file)));
    }

    public Icon(String str, int i, int i2, int i3, String str2, InputStream inputStream) {
        this(str, i, i2, i3, str2, IO.readAllBytes(inputStream));
    }

    public Icon(String str, int i, int i2, int i3, String str2, byte[] bArr) {
        this((str == null || str.isEmpty()) ? null : MimeType.valueOf(str), i, i2, i3, URI.create(str2), bArr);
    }

    public Icon(String str, int i, int i2, int i3, URI uri) {
        this((str == null || str.isEmpty()) ? null : MimeType.valueOf(str), i, i2, i3, uri, (byte[]) null);
    }

    public Icon(MimeType mimeType, int i, int i2, int i3, URI uri, byte[] bArr) {
        this.mimeType = mimeType;
        this.width = i;
        this.height = i2;
        this.depth = i3;
        this.uri = uri;
        this.data = bArr;
    }
}

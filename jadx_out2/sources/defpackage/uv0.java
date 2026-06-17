package defpackage;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.wv0;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uv0 {
    public static SimpleDateFormat T;
    public static SimpleDateFormat U;
    public static final d[] Y;
    public static final d[] Z;
    public static final d[] a0;
    public static final d[] b0;
    public static final d[] c0;
    public static final d d0;
    public static final d[] e0;
    public static final d[] f0;
    public static final d[] g0;
    public static final d[] h0;
    public static final d[][] i0;
    public static final d[] j0;
    public static final HashMap[] k0;
    public static final HashMap[] l0;
    public static final HashSet m0;
    public static final HashMap n0;
    public static final Charset o0;
    public static final byte[] p0;
    public static final byte[] q0;
    public static final Pattern r0;
    public static final Pattern s0;
    public static final Pattern t0;
    public static final Pattern u0;
    public String a;
    public FileDescriptor b;
    public AssetManager.AssetInputStream c;
    public int d;
    public boolean e;
    public final HashMap[] f;
    public Set g;
    public ByteOrder h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public byte[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public static final boolean u = Log.isLoggable("ExifInterface", 3);
    public static final List v = Arrays.asList(1, 6, 3, 8);
    public static final List w = Arrays.asList(2, 7, 4, 5);
    public static final int[] x = {8, 8, 8};
    public static final int[] y = {4};
    public static final int[] z = {8};
    public static final byte[] A = {-1, -40, -1};
    public static final byte[] B = {102, 116, 121, 112};
    public static final byte[] C = {109, 105, 102, 49};
    public static final byte[] D = {104, 101, 105, 99};
    public static final byte[] E = {79, 76, 89, 77, 80, 0};
    public static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] G = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final byte[] H = {101, 88, 73, 102};
    public static final byte[] I = {73, 72, 68, 82};
    public static final byte[] J = {73, 69, 78, 68};
    public static final byte[] K = {82, 73, 70, 70};
    public static final byte[] L = {87, 69, 66, 80};
    public static final byte[] M = {69, 88, 73, 70};
    public static final byte[] N = {-99, 1, 42};
    public static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    public static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends MediaDataSource {
        public long f;
        public final /* synthetic */ f g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f fVar) {
            this.g = fVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.f;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + ((long) this.g.available())) {
                        return -1;
                    }
                    this.g.l(j);
                    this.f = j;
                }
                if (i2 > this.g.available()) {
                    i2 = this.g.available();
                }
                int i3 = this.g.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.f += (long) i3;
                    return i3;
                }
            } catch (IOException unused) {
            }
            this.f = -1L;
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public final long a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(long j, long j2) {
            if (j2 == 0) {
                this.a = 0L;
                this.b = 1L;
            } else {
                this.a = j;
                this.b = j2;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public double a() {
            return this.a / this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return this.a + ServiceReference.DELIMITER + this.b;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", Buffer.DEFAULT_SIZE, 3, 4), new d("ImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", Buffer.DEFAULT_SIZE, 3, 4), new d("ThumbnailImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        c0 = dVarArr5;
        d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", Buffer.DEFAULT_SIZE, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)};
        f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        i0 = dVarArr10;
        j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        k0 = new HashMap[dVarArr10.length];
        l0 = new HashMap[dVarArr10.length];
        m0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        n0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        o0 = charsetForName;
        p0 = "Exif\u0000\u0000".getBytes(charsetForName);
        q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            d[][] dVarArr11 = i0;
            if (i >= dVarArr11.length) {
                HashMap map = n0;
                d[] dVarArr12 = j0;
                map.put(Integer.valueOf(dVarArr12[0].a), 5);
                map.put(Integer.valueOf(dVarArr12[1].a), 1);
                map.put(Integer.valueOf(dVarArr12[2].a), 2);
                map.put(Integer.valueOf(dVarArr12[3].a), 3);
                map.put(Integer.valueOf(dVarArr12[4].a), 7);
                map.put(Integer.valueOf(dVarArr12[5].a), 8);
                r0 = Pattern.compile(".*[1-9].*");
                s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            k0[i] = new HashMap();
            l0[i] = new HashMap();
            for (d dVar : dVarArr11[i]) {
                k0[i].put(Integer.valueOf(dVar.a), dVar);
                l0[i].put(dVar.b, dVar);
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public uv0(InputStream inputStream, int i) {
        d[][] dVarArr = i0;
        this.f = new HashMap[dVarArr.length];
        this.g = new HashSet(dVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            om1.a("inputStream cannot be null");
            throw null;
        }
        this.a = null;
        if (i == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, p0.length);
            if (!r(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.e = true;
            this.c = null;
            this.b = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.c = (AssetManager.AssetInputStream) inputStream;
            this.b = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            if (y(fileInputStream.getFD())) {
                this.c = null;
                this.b = fileInputStream.getFD();
            } else {
                this.c = null;
                this.b = null;
            }
        }
        C(inputStream);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean L(int i) {
        return (i == 4 || i == 9 || i == 13 || i == 14) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean r(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = p0;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean t(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean y(FileDescriptor fileDescriptor) {
        try {
            wv0.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!u) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean A(HashMap map) {
        c cVar = (c) map.get("ImageLength");
        c cVar2 = (c) map.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.i(this.h) <= 512 && cVar2.i(this.h) <= 512;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean B(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:13:0x001e, B:15:0x0022, B:16:0x0030, B:18:0x0038, B:20:0x0041, B:31:0x0061, B:21:0x0045, B:23:0x004b, B:26:0x0052, B:29:0x005a, B:30:0x005e, B:32:0x006b, B:34:0x0075, B:37:0x007d, B:40:0x0085, B:43:0x008d, B:48:0x009b, B:50:0x009f), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C(InputStream inputStream) {
        boolean z2;
        if (inputStream == null) {
            om1.a("inputstream shouldn't be null");
            return;
        }
        for (int i = 0; i < i0.length; i++) {
            try {
                try {
                    this.f[i] = new HashMap();
                } catch (Throwable th) {
                    a();
                    if (u) {
                        E();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                z2 = u;
                if (z2) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                a();
                if (z2) {
                    return;
                }
                E();
                return;
            } catch (UnsupportedOperationException e3) {
                e = e3;
                z2 = u;
                if (z2) {
                }
                a();
                if (z2) {
                }
            }
        }
        if (!this.e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.d = g(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (L(this.d)) {
            f fVar = new f(inputStream);
            if (this.e) {
                n(fVar);
            } else {
                int i2 = this.d;
                if (i2 == 12) {
                    e(fVar);
                } else if (i2 == 7) {
                    h(fVar);
                } else if (i2 == 10) {
                    m(fVar);
                } else {
                    k(fVar);
                }
            }
            fVar.l(this.p);
            K(fVar);
        } else {
            b bVar = new b(inputStream);
            int i3 = this.d;
            if (i3 == 4) {
                f(bVar, 0, 0);
            } else if (i3 == 13) {
                i(bVar);
            } else if (i3 == 9) {
                j(bVar);
            } else if (i3 == 14) {
                o(bVar);
            }
        }
        a();
        if (u) {
            E();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(b bVar) throws IOException {
        ByteOrder byteOrderF = F(bVar);
        this.h = byteOrderF;
        bVar.h(byteOrderF);
        int unsignedShort = bVar.readUnsignedShort();
        int i = this.d;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            ze5.a("Invalid start code: ", Integer.toHexString(unsignedShort));
            return;
        }
        int i2 = bVar.readInt();
        if (i2 < 8) {
            ye5.a("Invalid first Ifd offset: ", i2);
            return;
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            bVar.i(i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E() {
        for (int i = 0; i < this.f.length; i++) {
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + this.f[i].size());
            for (Map.Entry entry : this.f[i].entrySet()) {
                c cVar = (c) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + cVar.toString() + ", tagValue: '" + cVar.j(this.h) + "'");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ByteOrder F(b bVar) throws IOException {
        short s = bVar.readShort();
        if (s == 18761) {
            if (u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s != 19789) {
            ze5.a("Invalid byte order: ", Integer.toHexString(s));
            return null;
        }
        if (u) {
            Log.d("ExifInterface", "readExifSegment: Byte Align MM");
        }
        return ByteOrder.BIG_ENDIAN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(byte[] bArr, int i) throws IOException {
        f fVar = new f(bArr);
        D(fVar);
        H(fVar, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x025b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H(f fVar, int i) throws IOException {
        short s;
        short s2;
        long j;
        int i2;
        d dVar;
        long j2;
        boolean z2;
        boolean z3;
        long j3;
        d dVar2;
        int unsignedShort;
        long jC;
        int i3 = i;
        this.g.add(Integer.valueOf(fVar.h));
        short s3 = fVar.readShort();
        if (u) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s3));
        }
        if (s3 <= 0) {
            return;
        }
        short s4 = 0;
        while (s4 < s3) {
            int unsignedShort2 = fVar.readUnsignedShort();
            int unsignedShort3 = fVar.readUnsignedShort();
            int i4 = fVar.readInt();
            long jA = ((long) fVar.a()) + 4;
            d dVar3 = (d) k0[i3].get(Integer.valueOf(unsignedShort2));
            boolean z4 = u;
            if (z4) {
                j = 4;
                i2 = 4;
                s = s3;
                s2 = s4;
                Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i3), Integer.valueOf(unsignedShort2), dVar3 != null ? dVar3.b : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i4)));
            } else {
                s = s3;
                s2 = s4;
                j = 4;
                i2 = 4;
            }
            if (dVar3 != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = W;
                    if (unsignedShort3 < iArr.length) {
                        if (dVar3.a(unsignedShort3)) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = dVar3.c;
                            }
                            dVar = dVar3;
                            j2 = ((long) i4) * ((long) iArr[unsignedShort3]);
                            if (j2 < 0 || j2 > 2147483647L) {
                                if (z4) {
                                    Log.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i4);
                                }
                                z2 = false;
                                if (z2) {
                                    fVar.l(jA);
                                } else {
                                    if (j2 > j) {
                                        int i5 = fVar.readInt();
                                        if (z4) {
                                            Log.d("ExifInterface", "seek to data offset: " + i5);
                                        }
                                        if (this.d == 7) {
                                            z3 = z4;
                                            dVar2 = dVar;
                                            if ("MakerNote".equals(dVar2.b)) {
                                                this.q = i5;
                                            } else if (i3 == 6 && "ThumbnailImage".equals(dVar2.b)) {
                                                this.r = i5;
                                                this.s = i4;
                                                c cVarF = c.f(6, this.h);
                                                j3 = jA;
                                                c cVarB = c.b(this.r, this.h);
                                                c cVarB2 = c.b(this.s, this.h);
                                                this.f[i2].put("Compression", cVarF);
                                                this.f[i2].put("JPEGInterchangeFormat", cVarB);
                                                this.f[i2].put("JPEGInterchangeFormatLength", cVarB2);
                                            }
                                            j3 = jA;
                                        } else {
                                            z3 = z4;
                                            j3 = jA;
                                            dVar2 = dVar;
                                        }
                                        fVar.l(i5);
                                    } else {
                                        z3 = z4;
                                        j3 = jA;
                                        dVar2 = dVar;
                                    }
                                    Integer num = (Integer) n0.get(Integer.valueOf(unsignedShort2));
                                    if (z3) {
                                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j2);
                                    }
                                    if (num != null) {
                                        if (unsignedShort3 != 3) {
                                            if (unsignedShort3 == i2) {
                                                jC = fVar.c();
                                            } else if (unsignedShort3 == 8) {
                                                unsignedShort = fVar.readShort();
                                            } else if (unsignedShort3 == 9 || unsignedShort3 == 13) {
                                                unsignedShort = fVar.readInt();
                                            } else {
                                                jC = -1;
                                            }
                                            if (z3) {
                                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jC), dVar2.b));
                                            }
                                            if (jC <= 0) {
                                                if (!this.g.contains(Integer.valueOf((int) jC))) {
                                                    fVar.l(jC);
                                                    H(fVar, num.intValue());
                                                } else if (z3) {
                                                    Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jC + ")");
                                                }
                                            } else if (z3) {
                                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jC);
                                            }
                                            fVar.l(j3);
                                        } else {
                                            unsignedShort = fVar.readUnsignedShort();
                                        }
                                        jC = unsignedShort;
                                        if (z3) {
                                        }
                                        if (jC <= 0) {
                                        }
                                        fVar.l(j3);
                                    } else {
                                        int iA = fVar.a() + this.p;
                                        byte[] bArr = new byte[(int) j2];
                                        fVar.readFully(bArr);
                                        long j4 = iA;
                                        d dVar4 = dVar2;
                                        long j5 = j3;
                                        c cVar = new c(unsignedShort3, i4, j4, bArr);
                                        this.f[i].put(dVar4.b, cVar);
                                        if ("DNGVersion".equals(dVar4.b)) {
                                            this.d = 3;
                                        }
                                        if ((("Make".equals(dVar4.b) || "Model".equals(dVar4.b)) && cVar.j(this.h).contains("PENTAX")) || ("Compression".equals(dVar4.b) && cVar.i(this.h) == 65535)) {
                                            this.d = 8;
                                        }
                                        if (fVar.a() != j5) {
                                            fVar.l(j5);
                                        }
                                    }
                                }
                                s4 = (short) (s2 + 1);
                                i3 = i;
                                s3 = s;
                            } else {
                                z2 = true;
                                if (z2) {
                                }
                                s4 = (short) (s2 + 1);
                                i3 = i;
                                s3 = s;
                            }
                        } else if (z4) {
                            Log.d("ExifInterface", "Skip the tag entry since data format (" + V[unsignedShort3] + ") is unexpected for tag: " + dVar3.b);
                        }
                    }
                }
                dVar = dVar3;
                if (z4) {
                    Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                j2 = 0;
                z2 = false;
                if (z2) {
                }
                s4 = (short) (s2 + 1);
                i3 = i;
                s3 = s;
            } else if (z4) {
                Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            }
            dVar = dVar3;
            j2 = 0;
            z2 = false;
            if (z2) {
            }
            s4 = (short) (s2 + 1);
            i3 = i;
            s3 = s;
        }
        int i6 = fVar.readInt();
        boolean z5 = u;
        if (z5) {
            Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i6)));
        }
        long j6 = i6;
        if (j6 <= 0) {
            if (z5) {
                Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i6);
                return;
            }
            return;
        }
        if (this.g.contains(Integer.valueOf(i6))) {
            if (z5) {
                Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i6);
                return;
            }
            return;
        }
        fVar.l(j6);
        if (this.f[4].isEmpty()) {
            H(fVar, 4);
        } else if (this.f[5].isEmpty()) {
            H(fVar, 5);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I(int i, String str, String str2) {
        if (this.f[i].isEmpty() || this.f[i].get(str) == null) {
            return;
        }
        HashMap map = this.f[i];
        map.put(str2, map.get(str));
        this.f[i].remove(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J(f fVar, int i) throws Throwable {
        c cVar = (c) this.f[i].get("ImageLength");
        c cVar2 = (c) this.f[i].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = (c) this.f[i].get("JPEGInterchangeFormat");
            c cVar4 = (c) this.f[i].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int i2 = cVar3.i(this.h);
            int i3 = cVar3.i(this.h);
            fVar.l(i2);
            byte[] bArr = new byte[i3];
            fVar.read(bArr);
            f(new b(bArr), i2, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(b bVar) throws Throwable {
        HashMap map = this.f[4];
        c cVar = (c) map.get("Compression");
        if (cVar == null) {
            this.o = 6;
            p(bVar, map);
            return;
        }
        int i = cVar.i(this.h);
        this.o = i;
        if (i != 1) {
            if (i == 6) {
                p(bVar, map);
                return;
            } else if (i != 7) {
                return;
            }
        }
        if (z(map)) {
            q(bVar, map);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M(int i, int i2) throws Throwable {
        if (this.f[i].isEmpty() || this.f[i2].isEmpty()) {
            if (u) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = (c) this.f[i].get("ImageLength");
        c cVar2 = (c) this.f[i].get("ImageWidth");
        c cVar3 = (c) this.f[i2].get("ImageLength");
        c cVar4 = (c) this.f[i2].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (u) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (cVar3 == null || cVar4 == null) {
            if (u) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int i3 = cVar.i(this.h);
        int i4 = cVar2.i(this.h);
        int i5 = cVar3.i(this.h);
        int i6 = cVar4.i(this.h);
        if (i3 >= i5 || i4 >= i6) {
            return;
        }
        HashMap[] mapArr = this.f;
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N(f fVar, int i) throws Throwable {
        c cVarF;
        c cVarF2;
        c cVar = (c) this.f[i].get("DefaultCropSize");
        c cVar2 = (c) this.f[i].get("SensorTopBorder");
        c cVar3 = (c) this.f[i].get("SensorLeftBorder");
        c cVar4 = (c) this.f[i].get("SensorBottomBorder");
        c cVar5 = (c) this.f[i].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                J(fVar, i);
                return;
            }
            int i2 = cVar2.i(this.h);
            int i3 = cVar4.i(this.h);
            int i4 = cVar5.i(this.h);
            int i5 = cVar3.i(this.h);
            if (i3 <= i2 || i4 <= i5) {
                return;
            }
            c cVarF3 = c.f(i3 - i2, this.h);
            c cVarF4 = c.f(i4 - i5, this.h);
            this.f[i].put("ImageLength", cVarF3);
            this.f[i].put("ImageWidth", cVarF4);
            return;
        }
        int i6 = cVar.a;
        ByteOrder byteOrder = this.h;
        if (i6 == 5) {
            e[] eVarArr = (e[]) cVar.k(byteOrder);
            if (eVarArr == null || eVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                return;
            }
            cVarF = c.d(eVarArr[0], this.h);
            cVarF2 = c.d(eVarArr[1], this.h);
        } else {
            int[] iArr = (int[]) cVar.k(byteOrder);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            cVarF = c.f(iArr[0], this.h);
            cVarF2 = c.f(iArr[1], this.h);
        }
        this.f[i].put("ImageWidth", cVarF);
        this.f[i].put("ImageLength", cVarF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O() throws Throwable {
        M(0, 5);
        M(0, 4);
        M(5, 4);
        c cVar = (c) this.f[1].get("PixelXDimension");
        c cVar2 = (c) this.f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f[0].put("ImageWidth", cVar);
            this.f[0].put("ImageLength", cVar2);
        }
        if (this.f[4].isEmpty() && A(this.f[5])) {
            HashMap[] mapArr = this.f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!A(this.f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        I(0, "ThumbnailOrientation", "Orientation");
        I(0, "ThumbnailImageLength", "ImageLength");
        I(0, "ThumbnailImageWidth", "ImageWidth");
        I(5, "ThumbnailOrientation", "Orientation");
        I(5, "ThumbnailImageLength", "ImageLength");
        I(5, "ThumbnailImageWidth", "ImageWidth");
        I(4, "Orientation", "ThumbnailOrientation");
        I(4, "ImageLength", "ThumbnailImageLength");
        I(4, "ImageWidth", "ThumbnailImageWidth");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        String strB = b("DateTimeOriginal");
        if (strB != null && b("DateTime") == null) {
            this.f[0].put("DateTime", c.a(strB));
        }
        if (b("ImageWidth") == null) {
            this.f[0].put("ImageWidth", c.b(0L, this.h));
        }
        if (b("ImageLength") == null) {
            this.f[0].put("ImageLength", c.b(0L, this.h));
        }
        if (b("Orientation") == null) {
            this.f[0].put("Orientation", c.b(0L, this.h));
        }
        if (b("LightSource") == null) {
            this.f[1].put("LightSource", c.b(0L, this.h));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String b(String str) {
        if (str == null) {
            om1.a("tag shouldn't be null");
            return null;
        }
        c cVarD = d(str);
        if (cVarD != null) {
            if (!m0.contains(str)) {
                return cVarD.j(this.h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = cVarD.a;
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + cVarD.a);
                    return null;
                }
                e[] eVarArr = (e[]) cVarD.k(this.h);
                if (eVarArr == null || eVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (eVar.a / eVar.b));
                e eVar2 = eVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (eVar2.a / eVar2.b));
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (eVar3.a / eVar3.b)));
            }
            try {
                return Double.toString(cVarD.h(this.h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c(String str, int i) {
        if (str == null) {
            om1.a("tag shouldn't be null");
            return 0;
        }
        c cVarD = d(str);
        if (cVarD != null) {
            try {
                return cVarD.i(this.h);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c d(String str) {
        if (str == null) {
            om1.a("tag shouldn't be null");
            return null;
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (u) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < i0.length; i++) {
            c cVar = (c) this.f[i].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(f fVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            fn.a("Reading EXIF from HEIF files is supported from SDK 28 and above");
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                wv0.b.a(mediaMetadataRetriever, new a(fVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.f[0].put("ImageWidth", c.f(Integer.parseInt(strExtractMetadata), this.h));
                }
                if (strExtractMetadata2 != null) {
                    this.f[0].put("ImageLength", c.f(Integer.parseInt(strExtractMetadata2), this.h));
                }
                if (strExtractMetadata3 != null) {
                    int i = Integer.parseInt(strExtractMetadata3);
                    this.f[0].put("Orientation", c.f(i != 90 ? i != 180 ? i != 270 ? 1 : 8 : 3 : 6, this.h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i2 = Integer.parseInt(strExtractMetadata4);
                    int i3 = Integer.parseInt(strExtractMetadata5);
                    if (i3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.l(i2);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i4 = i2 + 6;
                    int i5 = i3 - 6;
                    if (!Arrays.equals(bArr, p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i5];
                    if (fVar.read(bArr2) != i5) {
                        throw new IOException("Can't read exif");
                    }
                    this.p = i4;
                    G(bArr2, 0);
                }
                if (u) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016e A[LOOP:0: B:10:0x0034->B:63:0x016e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0175 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(uv0.b r22, int r23, int r24) throws java.lang.Throwable {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            boolean r3 = defpackage.uv0.u
            java.lang.String r4 = "ExifInterface"
            if (r3 == 0) goto L1d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "getJpegAttributes starting with: "
            r3.<init>(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r4, r3)
        L1d:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.h(r3)
            byte r3 = r1.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r3 != r6) goto L19b
            byte r7 = r1.readByte()
            r8 = -40
            if (r7 != r8) goto L191
            r3 = 2
        L34:
            byte r5 = r1.readByte()
            if (r5 != r6) goto L185
            byte r5 = r1.readByte()
            boolean r7 = defpackage.uv0.u
            if (r7 == 0) goto L59
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Found JPEG segment indicator: "
            r8.<init>(r9)
            r9 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r4, r8)
        L59:
            r8 = -39
            if (r5 == r8) goto L17f
            r8 = -38
            if (r5 != r8) goto L63
            goto L17f
        L63:
            int r8 = r1.readUnsignedShort()
            int r9 = r8 + (-2)
            r10 = 4
            int r3 = r3 + r10
            if (r7 == 0) goto L91
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r11 = "JPEG segment: "
            r7.<init>(r11)
            r11 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r7.append(r11)
            java.lang.String r11 = " (length: "
            r7.append(r11)
            r7.append(r8)
            java.lang.String r11 = ")"
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r4, r7)
        L91:
            java.lang.String r7 = "Invalid length"
            if (r9 < 0) goto L179
            r11 = -31
            r12 = 1
            r13 = 0
            if (r5 == r11) goto L112
            r11 = -2
            if (r5 == r11) goto Le6
            switch(r5) {
                case -64: goto Lae;
                case -63: goto Lae;
                case -62: goto Lae;
                case -61: goto Lae;
                default: goto La1;
            }
        La1:
            switch(r5) {
                case -59: goto Lae;
                case -58: goto Lae;
                case -57: goto Lae;
                default: goto La4;
            }
        La4:
            switch(r5) {
                case -55: goto Lae;
                case -54: goto Lae;
                case -53: goto Lae;
                default: goto La7;
            }
        La7:
            switch(r5) {
                case -51: goto Lae;
                case -50: goto Lae;
                case -49: goto Lae;
                default: goto Laa;
            }
        Laa:
            r20 = r7
            goto L16c
        Lae:
            r1.i(r12)
            java.util.HashMap[] r5 = r0.f
            r5 = r5[r2]
            if (r2 == r10) goto Lba
            java.lang.String r9 = "ImageLength"
            goto Lbc
        Lba:
            java.lang.String r9 = "ThumbnailImageLength"
        Lbc:
            int r11 = r1.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.h
            uv0$c r11 = uv0.c.b(r11, r13)
            r5.put(r9, r11)
            java.util.HashMap[] r5 = r0.f
            r5 = r5[r2]
            if (r2 == r10) goto Ld3
            java.lang.String r9 = "ImageWidth"
            goto Ld5
        Ld3:
            java.lang.String r9 = "ThumbnailImageWidth"
        Ld5:
            int r10 = r1.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.h
            uv0$c r10 = uv0.c.b(r10, r12)
            r5.put(r9, r10)
            int r9 = r8 + (-7)
            goto Laa
        Le6:
            byte[] r5 = new byte[r9]
            int r8 = r1.read(r5)
            if (r8 != r9) goto L10c
            java.lang.String r8 = "UserComment"
            java.lang.String r9 = r0.b(r8)
            if (r9 != 0) goto L108
            java.util.HashMap[] r9 = r0.f
            r9 = r9[r12]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = defpackage.uv0.o0
            r10.<init>(r5, r11)
            uv0$c r5 = uv0.c.a(r10)
            r9.put(r8, r5)
        L108:
            r20 = r7
        L10a:
            r9 = r13
            goto L16c
        L10c:
            java.lang.String r0 = "Invalid exif"
            defpackage.sb1.a(r0)
            return
        L112:
            byte[] r5 = new byte[r9]
            r1.readFully(r5)
            int r8 = r3 + r9
            byte[] r10 = defpackage.uv0.p0
            boolean r11 = defpackage.wv0.c(r5, r10)
            if (r11 == 0) goto L13a
            int r11 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r11, r9)
            int r3 = r23 + r3
            int r9 = r10.length
            int r3 = r3 + r9
            r0.p = r3
            r0.G(r5, r2)
            uv0$b r3 = new uv0$b
            r3.<init>(r5)
            r0.K(r3)
        L137:
            r20 = r7
            goto L16a
        L13a:
            byte[] r10 = defpackage.uv0.q0
            boolean r11 = defpackage.wv0.c(r5, r10)
            if (r11 == 0) goto L137
            int r11 = r10.length
            int r3 = r3 + r11
            int r10 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r10, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r10 = r0.b(r9)
            if (r10 != 0) goto L137
            java.util.HashMap[] r10 = r0.f
            r10 = r10[r13]
            uv0$c r14 = new uv0$c
            int r11 = r5.length
            r20 = r7
            long r6 = (long) r3
            r15 = 1
            r19 = r5
            r17 = r6
            r16 = r11
            r14.<init>(r15, r16, r17, r19)
            r10.put(r9, r14)
            r0.t = r12
        L16a:
            r3 = r8
            goto L10a
        L16c:
            if (r9 < 0) goto L175
            r1.i(r9)
            int r3 = r3 + r9
            r6 = -1
            goto L34
        L175:
            defpackage.sb1.a(r20)
            return
        L179:
            r20 = r7
            defpackage.sb1.a(r20)
            return
        L17f:
            java.nio.ByteOrder r0 = r0.h
            r1.h(r0)
            return
        L185:
            r0 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r0 = java.lang.Integer.toHexString(r0)
            java.lang.String r1 = "Invalid marker:"
            defpackage.ze5.a(r1, r0)
            return
        L191:
            r0 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r0 = java.lang.Integer.toHexString(r0)
            defpackage.ze5.a(r5, r0)
            return
        L19b:
            r0 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r0 = java.lang.Integer.toHexString(r0)
            defpackage.ze5.a(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uv0.f(uv0$b, int, int):void");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (t(bArr)) {
            return 4;
        }
        if (w(bArr)) {
            return 9;
        }
        if (s(bArr)) {
            return 12;
        }
        if (u(bArr)) {
            return 7;
        }
        if (x(bArr)) {
            return 10;
        }
        if (v(bArr)) {
            return 13;
        }
        return B(bArr) ? 14 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(f fVar) throws Throwable {
        int i;
        int i2;
        k(fVar);
        c cVar = (c) this.f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.d);
            fVar2.h(this.h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.l(0L);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.l(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.l(12L);
            }
            H(fVar2, 6);
            c cVar2 = (c) this.f[7].get("PreviewImageStart");
            c cVar3 = (c) this.f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f[5].put("JPEGInterchangeFormat", cVar2);
                this.f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) this.f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                c cVarF = c.f(i5, this.h);
                c cVarF2 = c.f(i6, this.h);
                this.f[0].put("ImageWidth", cVarF);
                this.f[0].put("ImageLength", cVarF2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(b bVar) throws Throwable {
        if (u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.h(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        bVar.i(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i2 = length + 8;
                if (i2 == 16 && !Arrays.equals(bArr2, I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, J)) {
                    return;
                }
                if (Arrays.equals(bArr2, H)) {
                    byte[] bArr3 = new byte[i];
                    if (bVar.read(bArr3) != i) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + wv0.a(bArr2));
                    }
                    int i3 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i3) {
                        this.p = i2;
                        G(bArr3, 0);
                        O();
                        K(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                }
                int i4 = i + 4;
                bVar.i(i4);
                length = i2 + i4;
            } catch (EOFException unused) {
                sb1.a("Encountered corrupt PNG file.");
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(b bVar) throws Throwable {
        boolean z2 = u;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.i(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        bVar.i(i - bVar.a());
        bVar.read(bArr4);
        f(new b(bArr4), i, 5);
        bVar.i(i3 - bVar.a());
        bVar.h(ByteOrder.BIG_ENDIAN);
        int i4 = bVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == d0.a) {
                short s = bVar.readShort();
                short s2 = bVar.readShort();
                c cVarF = c.f(s, this.h);
                c cVarF2 = c.f(s2, this.h);
                this.f[0].put("ImageLength", cVarF);
                this.f[0].put("ImageWidth", cVarF2);
                if (u) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            bVar.i(unsignedShort2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(f fVar) throws Throwable {
        c cVar;
        D(fVar);
        H(fVar, 0);
        N(fVar, 0);
        N(fVar, 5);
        N(fVar, 4);
        O();
        if (this.d != 8 || (cVar = (c) this.f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.d);
        fVar2.h(this.h);
        fVar2.i(6);
        H(fVar2, 9);
        c cVar2 = (c) this.f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f[1].put("ColorSpace", cVar2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int l() {
        switch (c("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(f fVar) throws Throwable {
        if (u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        k(fVar);
        c cVar = (c) this.f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.d), (int) cVar.c, 5);
        }
        c cVar2 = (c) this.f[0].get("ISO");
        c cVar3 = (c) this.f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f[1].put("PhotographicSensitivity", cVar2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(f fVar) throws IOException {
        byte[] bArr = p0;
        fVar.i(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.p = bArr.length;
        G(bArr2, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(b bVar) throws Throwable {
        if (u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.h(ByteOrder.LITTLE_ENDIAN);
        bVar.i(K.length);
        int i = bVar.readInt() + 8;
        byte[] bArr = L;
        bVar.i(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i2 = bVar.readInt();
                int i3 = length + 8;
                if (Arrays.equals(M, bArr2)) {
                    byte[] bArr3 = new byte[i2];
                    if (bVar.read(bArr3) == i2) {
                        this.p = i3;
                        G(bArr3, 0);
                        K(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + wv0.a(bArr2));
                    }
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.i(i2);
            } catch (EOFException unused) {
                sb1.a("Encountered corrupt WebP file.");
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(b bVar, HashMap map) throws Throwable {
        c cVar = (c) map.get("JPEGInterchangeFormat");
        c cVar2 = (c) map.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int i = cVar.i(this.h);
        int i2 = cVar2.i(this.h);
        if (this.d == 7) {
            i += this.q;
        }
        if (i > 0 && i2 > 0) {
            this.i = true;
            if (this.a == null && this.c == null && this.b == null) {
                byte[] bArr = new byte[i2];
                bVar.skip(i);
                bVar.read(bArr);
                this.n = bArr;
            }
            this.l = i;
            this.m = i2;
        }
        if (u) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i + ", length: " + i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(b bVar, HashMap map) {
        c cVar = (c) map.get("StripOffsets");
        c cVar2 = (c) map.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] jArrB = wv0.b(cVar.k(this.h));
        long[] jArrB2 = wv0.b(cVar2.k(this.h));
        if (jArrB == null || jArrB.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrB2 == null || jArrB2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrB.length != jArrB2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j = 0;
        for (long j2 : jArrB2) {
            j += j2;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        this.k = true;
        this.j = true;
        this.i = true;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < jArrB.length; i4++) {
            int i5 = (int) jArrB[i4];
            int i6 = (int) jArrB2[i4];
            if (i4 < jArrB.length - 1 && i5 + i6 != jArrB[i4 + 1]) {
                this.k = false;
            }
            int i7 = i5 - i2;
            if (i7 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            long j3 = i7;
            if (bVar.skip(j3) != j3) {
                Log.d("ExifInterface", "Failed to skip " + i7 + " bytes.");
                return;
            }
            int i8 = i2 + i7;
            byte[] bArr2 = new byte[i6];
            if (bVar.read(bArr2) != i6) {
                Log.d("ExifInterface", "Failed to read " + i6 + " bytes.");
                return;
            }
            i2 = i8 + i6;
            System.arraycopy(bArr2, 0, bArr, i3, i6);
            i3 += i6;
        }
        this.n = bArr;
        if (this.k) {
            this.l = (int) jArrB[0];
            this.m = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean s(byte[] bArr) throws Throwable {
        b bVar;
        long j;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long length = bVar.readInt();
            byte[] bArr2 = new byte[4];
            bVar.read(bArr2);
            if (!Arrays.equals(bArr2, B)) {
                bVar.close();
                return false;
            }
            if (length == 1) {
                length = bVar.readLong();
                j = 16;
                if (length < 16) {
                    bVar.close();
                    return false;
                }
            } else {
                j = 8;
            }
            if (length > bArr.length) {
                length = bArr.length;
            }
            long j2 = length - j;
            if (j2 < 8) {
                bVar.close();
                return false;
            }
            byte[] bArr3 = new byte[4];
            boolean z2 = false;
            boolean z3 = false;
            for (long j3 = 0; j3 < j2 / 4; j3++) {
                if (bVar.read(bArr3) != 4) {
                    bVar.close();
                    return false;
                }
                if (j3 != 1) {
                    if (Arrays.equals(bArr3, C)) {
                        z2 = true;
                    } else if (Arrays.equals(bArr3, D)) {
                        z3 = true;
                    }
                    if (z2 && z3) {
                        bVar.close();
                        return true;
                    }
                }
            }
            bVar.close();
        } catch (Exception e3) {
            e = e3;
            bVar2 = bVar;
            if (u) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean u(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderF = F(bVar2);
                this.h = byteOrderF;
                bVar2.h(byteOrderF);
                short s = bVar2.readShort();
                boolean z2 = s == 20306 || s == 21330;
                bVar2.close();
                return z2;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean x(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderF = F(bVar2);
                this.h = byteOrderF;
                bVar2.h(byteOrderF);
                boolean z2 = bVar2.readShort() == 85;
                bVar2.close();
                return z2;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean z(HashMap map) {
        c cVar;
        int i;
        c cVar2 = (c) map.get("BitsPerSample");
        if (cVar2 != null) {
            int[] iArr = (int[]) cVar2.k(this.h);
            int[] iArr2 = x;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.d == 3 && (cVar = (c) map.get("PhotometricInterpretation")) != null && (((i = cVar.i(this.h)) == 1 && Arrays.equals(iArr, z)) || (i == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!u) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends InputStream implements DataInput, InputStreamRetargetInterface {
        public static final ByteOrder j = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder k = ByteOrder.BIG_ENDIAN;
        public final DataInputStream f;
        public ByteOrder g;
        public int h;
        public byte[] i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(InputStream inputStream, ByteOrder byteOrder) {
            this.g = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f = dataInputStream;
            dataInputStream.mark(0);
            this.h = 0;
            this.g = byteOrder;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int a() {
            return this.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public int available() {
            return this.f.available();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long c() {
            return ((long) readInt()) & 4294967295L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h(ByteOrder byteOrder) {
            this.g = byteOrder;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(int i) throws IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int iSkip = (int) this.f.skip(i3);
                if (iSkip <= 0) {
                    if (this.i == null) {
                        this.i = new byte[8192];
                    }
                    iSkip = this.f.read(this.i, 0, Math.min(8192, i3));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i + " bytes.");
                    }
                }
                i2 += iSkip;
            }
            this.h += i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public int read() {
            this.h++;
            return this.f.read();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.h++;
            return this.f.readBoolean();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.h++;
            int i = this.f.read();
            if (i >= 0) {
                return (byte) i;
            }
            ll.a();
            return (byte) 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public char readChar() {
            this.h += 2;
            return this.f.readChar();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.h += bArr.length;
            this.f.readFully(bArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.h += 4;
            int i = this.f.read();
            int i2 = this.f.read();
            int i3 = this.f.read();
            int i4 = this.f.read();
            if ((i | i2 | i3 | i4) < 0) {
                ll.a();
                return 0;
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == k) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            ze5.a("Invalid byte order: ", this.g);
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.h += 8;
            int i = this.f.read();
            int i2 = this.f.read();
            int i3 = this.f.read();
            int i4 = this.f.read();
            int i5 = this.f.read();
            int i6 = this.f.read();
            int i7 = this.f.read();
            int i8 = this.f.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                ll.a();
                return 0L;
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8) + ((long) i);
            }
            if (byteOrder == k) {
                return (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8) + ((long) i8);
            }
            ze5.a("Invalid byte order: ", this.g);
            return 0L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.h += 2;
            int i = this.f.read();
            int i2 = this.f.read();
            if ((i | i2) < 0) {
                ll.a();
                return (short) 0;
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (short) ((i2 << 8) + i);
            }
            if (byteOrder == k) {
                return (short) ((i << 8) + i2);
            }
            ze5.a("Invalid byte order: ", this.g);
            return (short) 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public String readUTF() {
            this.h += 2;
            return this.f.readUTF();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.h++;
            return this.f.readUnsignedByte();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.h += 2;
            int i = this.f.read();
            int i2 = this.f.read();
            if ((i | i2) < 0) {
                ll.a();
                return 0;
            }
            ByteOrder byteOrder = this.g;
            if (byteOrder == j) {
                return (i2 << 8) + i;
            }
            if (byteOrder == k) {
                return (i << 8) + i2;
            }
            ze5.a("Invalid byte order: ", this.g);
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.DataInput
        public int skipBytes(int i) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
        public /* synthetic */ long transferTo(OutputStream outputStream) {
            return DesugarInputStream.transferTo(this, outputStream);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.h += i2;
            this.f.readFully(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f.read(bArr, i, i2);
            this.h += i3;
            return i3;
        }

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, int i2, long j, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = bArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(uv0.o0);
            return new c(2, bytes.length, bytes);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c b(long j, ByteOrder byteOrder) {
            return c(new long[]{j}, byteOrder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[uv0.W[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new c(4, jArr.length, byteBufferWrap.array());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[uv0.W[5] * eVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (e eVar : eVarArr) {
                byteBufferWrap.putInt((int) eVar.a);
                byteBufferWrap.putInt((int) eVar.b);
            }
            return new c(5, eVarArr.length, byteBufferWrap.array());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c f(int i, ByteOrder byteOrder) {
            return g(new int[]{i}, byteOrder);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[uv0.W[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new c(3, iArr.length, byteBufferWrap.array());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public double h(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objK instanceof String) {
                return Double.parseDouble((String) objK);
            }
            if (objK instanceof long[]) {
                if (((long[]) objK).length == 1) {
                    return r3[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof int[]) {
                if (((int[]) objK).length == 1) {
                    return r3[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) objK;
            if (eVarArr.length == 1) {
                return eVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int i(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objK instanceof String) {
                return Integer.parseInt((String) objK);
            }
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objK;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String j(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                return null;
            }
            if (objK instanceof String) {
                return (String) objK;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objK instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) objK;
            while (i < eVarArr.length) {
                sb.append(eVarArr[i].a);
                sb.append('/');
                sb.append(eVarArr[i].b);
                i++;
                if (i != eVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0030: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:49), block:B:18:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:113:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object k(ByteOrder byteOrder) throws Throwable {
            b bVar;
            InputStream inputStream;
            byte b;
            String str;
            byte b2;
            Object str2;
            InputStream inputStream2 = null;
            try {
                try {
                    bVar = new b(this.d);
                    try {
                        bVar.h(byteOrder);
                        int length = 0;
                        switch (this.a) {
                            case 1:
                            case 6:
                                byte[] bArr = this.d;
                                if (bArr.length != 1 || (b = bArr[0]) < 0 || b > 1) {
                                    str2 = new String(bArr, uv0.o0);
                                    try {
                                        bVar.close();
                                        return str2;
                                    } catch (IOException e) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                        return str2;
                                    }
                                }
                                str = new String(new char[]{(char) (b + 48)});
                                try {
                                    bVar.close();
                                    return str;
                                } catch (IOException e2) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                    return str;
                                }
                            case 2:
                            case 7:
                                if (this.b >= uv0.X.length) {
                                    int i = 0;
                                    while (true) {
                                        byte[] bArr2 = uv0.X;
                                        if (i >= bArr2.length) {
                                            length = bArr2.length;
                                        } else if (this.d[i] == bArr2[i]) {
                                            i++;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (length < this.b && (b2 = this.d[length]) != 0) {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                str = sb.toString();
                                bVar.close();
                                return str;
                            case 3:
                                int[] iArr = new int[this.b];
                                while (true) {
                                    str2 = iArr;
                                    if (length < this.b) {
                                        iArr[length] = bVar.readUnsignedShort();
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            case 4:
                                long[] jArr = new long[this.b];
                                while (true) {
                                    str2 = jArr;
                                    if (length < this.b) {
                                        jArr[length] = bVar.c();
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            case 5:
                                e[] eVarArr = new e[this.b];
                                while (true) {
                                    str2 = eVarArr;
                                    if (length < this.b) {
                                        eVarArr[length] = new e(bVar.c(), bVar.c());
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            case 8:
                                int[] iArr2 = new int[this.b];
                                while (true) {
                                    str2 = iArr2;
                                    if (length < this.b) {
                                        iArr2[length] = bVar.readShort();
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            case 9:
                                int[] iArr3 = new int[this.b];
                                while (true) {
                                    str2 = iArr3;
                                    if (length < this.b) {
                                        iArr3[length] = bVar.readInt();
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            case 10:
                                e[] eVarArr2 = new e[this.b];
                                while (true) {
                                    str2 = eVarArr2;
                                    if (length < this.b) {
                                        eVarArr2[length] = new e(bVar.readInt(), bVar.readInt());
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            case 11:
                                double[] dArr = new double[this.b];
                                while (true) {
                                    str2 = dArr;
                                    if (length < this.b) {
                                        dArr[length] = bVar.readFloat();
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            case 12:
                                double[] dArr2 = new double[this.b];
                                while (true) {
                                    str2 = dArr2;
                                    if (length < this.b) {
                                        dArr2[length] = bVar.readDouble();
                                        length++;
                                    }
                                    bVar.close();
                                    return str2;
                                }
                            default:
                                try {
                                    bVar.close();
                                    return null;
                                } catch (IOException e3) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                                    return null;
                                }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e6) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                bVar = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "(" + uv0.V[this.a] + ", data length:" + this.d.length + ")";
        }

        public c(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(String str, int i, int i2) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a(int i) {
            int i2;
            int i3 = this.c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }

        public d(String str, int i, int i2, int i3) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f extends b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f.mark(Integer.MAX_VALUE);
            } else {
                jl.a("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
                throw null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l(long j) throws IOException {
            int i = this.h;
            if (i > j) {
                this.h = 0;
                this.f.reset();
            } else {
                j -= (long) i;
            }
            i((int) j);
        }

        public f(byte[] bArr) {
            super(bArr);
            this.f.mark(Integer.MAX_VALUE);
        }
    }

    public uv0(InputStream inputStream) {
        this(inputStream, 0);
    }
}

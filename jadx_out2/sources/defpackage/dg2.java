package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.util.Arrays;
import java.util.function.Predicate;
import okhttp3.internal.http2.Http2;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum dg2 {
    MPEG_4(0, "MPEG-4", "mp4", DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4),
    v3GPP(16, "3GPP", "3gp", DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP),
    WEBM(32, "WebM", "webm", "video/webm"),
    M4A(Buffer.DEFAULT_SIZE, "m4a", "m4a", DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG_4),
    WEBMA(512, "WebM", "webm", "audio/webm"),
    MP3(768, "MP3", "mp3", DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG),
    MP2(784, "MP2", "mp2", DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG),
    OPUS(1024, "opus", "opus", "audio/opus"),
    OGG(1280, "ogg", "ogg", "audio/ogg"),
    WEBMA_OPUS(512, "WebM Opus", "webm", "audio/webm"),
    AIFF(1536, "AIFF", "aiff", "audio/aiff"),
    AIF(1536, "AIFF", "aif", "audio/aiff"),
    WAV(1792, "WAV", "wav", "audio/wav"),
    FLAC(2048, "FLAC", "flac", "audio/flac"),
    ALAC(2304, "ALAC", "alac", "audio/alac"),
    VTT(okio.internal.Buffer.SEGMENTING_THRESHOLD, "WebVTT", "vtt", "text/vtt"),
    TTML(8192, "Timed Text Markup Language", "ttml", "application/ttml+xml"),
    TRANSCRIPT1(12288, "TranScript v1", "srv1", "text/xml"),
    TRANSCRIPT2(Http2.INITIAL_MAX_FRAME_SIZE, "TranScript v2", "srv2", "text/xml"),
    TRANSCRIPT3(20480, "TranScript v3", "srv3", "text/xml"),
    SRT(24576, "SubRip file format", "srt", "text/srt");

    public final int f;
    public final String g;
    public final String h;
    public final String i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    dg2(int i, String str, String str2, String str3) {
        this.f = i;
        this.g = str;
        this.h = str2;
        this.i = str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static dg2 b(final String str) {
        return (dg2) Arrays.stream(values()).filter(new Predicate() { // from class: cg2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((dg2) obj).h.equals(str);
            }
        }).findFirst().orElse(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String e() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String f() {
        return this.h;
    }
}

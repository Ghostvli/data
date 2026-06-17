package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class FormatStyle {
    public static final FormatStyle FULL;
    public static final FormatStyle LONG;
    public static final FormatStyle MEDIUM;
    public static final FormatStyle SHORT;
    public static final /* synthetic */ FormatStyle[] a;

    static {
        FormatStyle formatStyle = new FormatStyle("FULL", 0);
        FULL = formatStyle;
        FormatStyle formatStyle2 = new FormatStyle("LONG", 1);
        LONG = formatStyle2;
        FormatStyle formatStyle3 = new FormatStyle("MEDIUM", 2);
        MEDIUM = formatStyle3;
        FormatStyle formatStyle4 = new FormatStyle("SHORT", 3);
        SHORT = formatStyle4;
        a = new FormatStyle[]{formatStyle, formatStyle2, formatStyle3, formatStyle4};
    }

    public static FormatStyle valueOf(String str) {
        return (FormatStyle) Enum.valueOf(FormatStyle.class, str);
    }

    public static FormatStyle[] values() {
        return (FormatStyle[]) a.clone();
    }
}

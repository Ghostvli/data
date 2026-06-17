package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ur extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"سیکنڈ", "سیکنڈز"};
    private static final String[] MINUTES = {"منٹ", "منٹس"};
    private static final String[] HOURS = {"گھنٹہ", "گھنٹے"};
    private static final String[] DAYS = {"دن"};
    private static final String[] WEEKS = {"ہفتہ", "ہفتے"};
    private static final String[] MONTHS = {"ماہ"};
    private static final String[] YEARS = {"سال"};
    private static final ur INSTANCE = new ur();

    private ur() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ur getInstance() {
        return INSTANCE;
    }
}

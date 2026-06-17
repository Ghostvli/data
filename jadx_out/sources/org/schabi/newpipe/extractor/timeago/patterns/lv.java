package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class lv extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundes", "sekundēm"};
    private static final String[] MINUTES = {"minūtes", "minūtēm", "minūtes"};
    private static final String[] HOURS = {"stundas", "stundām"};
    private static final String[] DAYS = {"dienas", "dienām"};
    private static final String[] WEEKS = {"nedēļas", "nedēļām"};
    private static final String[] MONTHS = {"mēneša", "mēnešiem"};
    private static final String[] YEARS = {"gada", "gadiem"};
    private static final lv INSTANCE = new lv();

    private lv() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static lv getInstance() {
        return INSTANCE;
    }
}

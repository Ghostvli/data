package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ne extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"सेकेन्ड"};
    private static final String[] MINUTES = {"मिनेट"};
    private static final String[] HOURS = {"घन्टा"};
    private static final String[] DAYS = {"दिन"};
    private static final String[] WEEKS = {"हप्ता"};
    private static final String[] MONTHS = {"महिना"};
    private static final String[] YEARS = {"वर्ष"};
    private static final ne INSTANCE = new ne();

    private ne() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ne getInstance() {
        return INSTANCE;
    }
}

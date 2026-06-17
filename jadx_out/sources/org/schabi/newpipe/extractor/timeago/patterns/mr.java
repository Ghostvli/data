package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class mr extends t93 {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"सेकंदांपूर्वी", "सेकंदापूर्वी"};
    private static final String[] MINUTES = {"मिनिटांपूर्वी", "मिनिटापूर्वी"};
    private static final String[] HOURS = {"तासांपूर्वी", "तासापूर्वी"};
    private static final String[] DAYS = {"दिवसांपूर्वी", "दिवसापूर्वी"};
    private static final String[] WEEKS = {"आठवड्यांपूर्वी", "आठवड्यापूर्वी"};
    private static final String[] MONTHS = {"महिन्यांपूर्वी", "महिन्यापूर्वी"};
    private static final String[] YEARS = {"वर्षांपूर्वी", "वर्षापूर्वी"};
    private static final mr INSTANCE = new mr();

    private mr() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static mr getInstance() {
        return INSTANCE;
    }
}

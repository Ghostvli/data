package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class hi extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"सेकंड"};
    private static final String[] MINUTES = {"मिनट"};
    private static final String[] HOURS = {"घंटा", "घंटे"};
    private static final String[] DAYS = {"दिन"};
    private static final String[] WEEKS = {"सप्ताह", "हफ़्ते"};
    private static final String[] MONTHS = {"महीना", "महीने"};
    private static final String[] YEARS = {"वर्ष"};
    private static final hi INSTANCE = new hi();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private hi() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hi getInstance() {
        return INSTANCE;
    }
}

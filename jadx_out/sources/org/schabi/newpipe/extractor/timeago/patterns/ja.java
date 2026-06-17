package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ja extends t93 {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"秒前"};
    private static final String[] MINUTES = {"分前"};
    private static final String[] HOURS = {"時間前"};
    private static final String[] DAYS = {"日前"};
    private static final String[] WEEKS = {"週間前"};
    private static final String[] MONTHS = {"か月前"};
    private static final String[] YEARS = {"年前"};
    private static final ja INSTANCE = new ja();

    private ja() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static ja getInstance() {
        return INSTANCE;
    }
}

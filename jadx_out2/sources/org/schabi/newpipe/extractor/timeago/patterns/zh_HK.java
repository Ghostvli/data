package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class zh_HK extends t93 {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"秒前"};
    private static final String[] MINUTES = {"分鐘前"};
    private static final String[] HOURS = {"小時前"};
    private static final String[] DAYS = {"天前"};
    private static final String[] WEEKS = {"週前"};
    private static final String[] MONTHS = {"個月前"};
    private static final String[] YEARS = {"年前"};
    private static final zh_HK INSTANCE = new zh_HK();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private zh_HK() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zh_HK getInstance() {
        return INSTANCE;
    }
}

package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class zh_CN extends t93 {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"秒前"};
    private static final String[] MINUTES = {"分钟前"};
    private static final String[] HOURS = {"小时前"};
    private static final String[] DAYS = {"天前"};
    private static final String[] WEEKS = {"周前"};
    private static final String[] MONTHS = {"个月前"};
    private static final String[] YEARS = {"年前"};
    private static final zh_CN INSTANCE = new zh_CN();

    private zh_CN() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    public static zh_CN getInstance() {
        return INSTANCE;
    }
}

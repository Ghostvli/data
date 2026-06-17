package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class km extends t93 {
    private static final String WORD_SEPARATOR = "";
    private static final String[] SECONDS = {"វិនាទី\u200bមុន", "១វិនាទីមុន"};
    private static final String[] MINUTES = {"នាទីមុន", "១នាទីមុន"};
    private static final String[] HOURS = {"ម៉ោង\u200bមុន", "១ម៉ោង\u200bមុន"};
    private static final String[] DAYS = {"ថ្ងៃមុន", "១ថ្ងៃ\u200bមុន"};
    private static final String[] WEEKS = {"ស\u200bប្តា\u200bហ៍\u200bមុន", "១ស\u200bប្តា\u200bហ៍\u200bមុន"};
    private static final String[] MONTHS = {"ខែមុន", "១ខែមុន"};
    private static final String[] YEARS = {"ឆ្នាំ\u200bមុន", "១ឆ្នាំមុន"};
    private static final km INSTANCE = new km();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private km() {
        super("", SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static km getInstance() {
        return INSTANCE;
    }
}

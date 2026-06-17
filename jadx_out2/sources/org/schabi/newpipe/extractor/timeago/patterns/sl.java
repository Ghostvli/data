package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sl extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekundama", "sekundami", "sekundo"};
    private static final String[] MINUTES = {"minutama", "minutami", "minuto"};
    private static final String[] HOURS = {"urama", "urami", "uro"};
    private static final String[] DAYS = {"dnem", "dnevi", "dnevoma"};
    private static final String[] WEEKS = {"tedni", "tednom", "tednoma"};
    private static final String[] MONTHS = {"mesecem", "mesecema", "meseci"};
    private static final String[] YEARS = {"leti", "letom", "letoma"};
    private static final sl INSTANCE = new sl();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private sl() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sl getInstance() {
        return INSTANCE;
    }
}

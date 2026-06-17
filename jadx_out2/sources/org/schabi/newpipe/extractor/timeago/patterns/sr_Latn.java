package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sr_Latn extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"sekunde", "sekundi"};
    private static final String[] MINUTES = {"minuta"};
    private static final String[] HOURS = {"sat", "sati", "sata"};
    private static final String[] DAYS = {"Pre 1 dan", "Pre 2 dana", "Pre 3 dana", "Pre 4 dana", "Pre 5 dana", "Pre 6 dana"};
    private static final String[] WEEKS = {"nedelja", "nedelje", "nedelju"};
    private static final String[] MONTHS = {"mesec", "meseci", "meseca"};
    private static final String[] YEARS = {"godine", "godina", "godinu"};
    private static final sr_Latn INSTANCE = new sr_Latn();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private sr_Latn() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sr_Latn getInstance() {
        return INSTANCE;
    }
}

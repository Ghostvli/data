package org.schabi.newpipe.extractor.timeago.patterns;

import defpackage.t93;
import org.jupnp.binding.xml.Descriptor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class en extends t93 {
    private static final String WORD_SEPARATOR = " ";
    private static final String[] SECONDS = {"second", "seconds", Descriptor.Device.SEC_PREFIX};
    private static final String[] MINUTES = {"minute", "minutes", "min"};
    private static final String[] HOURS = {"hour", "hours", "h"};
    private static final String[] DAYS = {"day", "days", "d"};
    private static final String[] WEEKS = {"week", "weeks", "w"};
    private static final String[] MONTHS = {"month", "months", "mo"};
    private static final String[] YEARS = {"year", "years", "y"};
    private static final en INSTANCE = new en();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private en() {
        super(WORD_SEPARATOR, SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static en getInstance() {
        return INSTANCE;
    }
}

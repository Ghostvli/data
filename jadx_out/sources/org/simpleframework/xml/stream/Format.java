package org.simpleframework.xml.stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Format {
    private final int indent;
    private final String prolog;
    private final Style style;
    private final Verbosity verbosity;

    public Format(int i, String str, Style style, Verbosity verbosity) {
        this.verbosity = verbosity;
        this.prolog = str;
        this.indent = i;
        this.style = style;
    }

    public int getIndent() {
        return this.indent;
    }

    public String getProlog() {
        return this.prolog;
    }

    public Style getStyle() {
        return this.style;
    }

    public Verbosity getVerbosity() {
        return this.verbosity;
    }

    public Format(int i) {
        this(i, (String) null, new IdentityStyle());
    }

    public Format(String str) {
        this(3, str);
    }

    public Format(int i, String str) {
        this(i, str, new IdentityStyle());
    }

    public Format(Verbosity verbosity) {
        this(3, verbosity);
    }

    public Format(int i, Verbosity verbosity) {
        this(i, new IdentityStyle(), verbosity);
    }

    public Format(Style style) {
        this(3, style);
    }

    public Format(Style style, Verbosity verbosity) {
        this(3, style, verbosity);
    }

    public Format(int i, Style style) {
        this(i, (String) null, style);
    }

    public Format(int i, Style style, Verbosity verbosity) {
        this(i, null, style, verbosity);
    }

    public Format(int i, String str, Style style) {
        this(i, str, style, Verbosity.HIGH);
    }

    public Format() {
        this(3);
    }
}

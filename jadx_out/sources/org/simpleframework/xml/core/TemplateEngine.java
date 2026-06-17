package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class TemplateEngine {
    private Filter filter;
    private int off;
    private Template source = new Template();
    private Template name = new Template();
    private Template text = new Template();

    public TemplateEngine(Filter filter) {
        this.filter = filter;
    }

    private void name() {
        while (true) {
            int i = this.off;
            Template template = this.source;
            if (i >= template.count) {
                break;
            }
            char[] cArr = template.buf;
            this.off = i + 1;
            char c = cArr[i];
            if (c == '}') {
                replace();
                break;
            }
            this.name.append(c);
        }
        if (this.name.length() > 0) {
            this.text.append("${");
            this.text.append(this.name);
        }
    }

    private void parse() {
        while (true) {
            int i = this.off;
            Template template = this.source;
            int i2 = template.count;
            if (i >= i2) {
                return;
            }
            char[] cArr = template.buf;
            int i3 = i + 1;
            this.off = i3;
            char c = cArr[i];
            if (c == '$' && i3 < i2) {
                this.off = i + 2;
                if (cArr[i3] == '{') {
                    name();
                } else {
                    this.off = i + 1;
                }
            }
            this.text.append(c);
        }
    }

    private void replace(String str) {
        String strReplace = this.filter.replace(str);
        Template template = this.text;
        if (strReplace != null) {
            template.append(strReplace);
            return;
        }
        template.append("${");
        this.text.append(str);
        this.text.append("}");
    }

    public void clear() {
        this.name.clear();
        this.text.clear();
        this.source.clear();
        this.off = 0;
    }

    public String process(String str) {
        if (str.indexOf(36) < 0) {
            return str;
        }
        try {
            this.source.append(str);
            parse();
            return this.text.toString();
        } finally {
            clear();
        }
    }

    private void replace(Template template) {
        replace(template.toString());
    }

    private void replace() {
        if (this.name.length() > 0) {
            replace(this.name);
        }
        this.name.clear();
    }
}

package org.simpleframework.xml.stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class Indenter {
    private Cache cache;
    private int count;
    private int indent;
    private int index;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Cache {
        private int count;
        private String[] list;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Cache(int i) {
            this.list = new String[i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void resize(int i) {
            String[] strArr = new String[i];
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.list;
                if (i2 >= strArr2.length) {
                    this.list = strArr;
                    return;
                } else {
                    strArr[i2] = strArr2[i2];
                    i2++;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String get(int i) {
            String[] strArr = this.list;
            if (i < strArr.length) {
                return strArr[i];
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void set(int i, String str) {
            if (i >= this.list.length) {
                resize(i * 2);
            }
            if (i > this.count) {
                this.count = i;
            }
            this.list[i] = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int size() {
            return this.count;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Indenter(Format format, int i) {
        this.indent = format.getIndent();
        this.cache = new Cache(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String create() {
        int i = this.count;
        char[] cArr = new char[i + 1];
        if (i <= 0) {
            return "\n";
        }
        cArr[0] = '\n';
        for (int i2 = 1; i2 <= this.count; i2++) {
            cArr[i2] = ' ';
        }
        return new String(cArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String indent(int i) {
        if (this.indent <= 0) {
            return "";
        }
        String strCreate = this.cache.get(i);
        if (strCreate == null) {
            strCreate = create();
            this.cache.set(i, strCreate);
        }
        return this.cache.size() > 0 ? strCreate : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String pop() {
        int i = this.index - 1;
        this.index = i;
        String strIndent = indent(i);
        int i2 = this.indent;
        if (i2 > 0) {
            this.count -= i2;
        }
        return strIndent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String push() {
        int i = this.index;
        this.index = i + 1;
        String strIndent = indent(i);
        int i2 = this.indent;
        if (i2 > 0) {
            this.count += i2;
        }
        return strIndent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String top() {
        return indent(this.index);
    }

    public Indenter(Format format) {
        this(format, 16);
    }

    public Indenter() {
        this(new Format());
    }
}

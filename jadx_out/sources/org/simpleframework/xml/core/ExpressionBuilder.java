package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.LimitedCache;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class ExpressionBuilder {
    private final Cache<Expression> cache = new LimitedCache();
    private final Format format;
    private final Class type;

    public ExpressionBuilder(Detail detail, Support support) {
        this.format = support.getFormat();
        this.type = detail.getType();
    }

    private Expression create(String str) {
        PathParser pathParser = new PathParser(str, new ClassType(this.type), this.format);
        Cache<Expression> cache = this.cache;
        if (cache != null) {
            cache.cache(str, pathParser);
        }
        return pathParser;
    }

    public Expression build(String str) {
        Expression expressionFetch = this.cache.fetch(str);
        return expressionFetch == null ? create(str) : expressionFetch;
    }
}

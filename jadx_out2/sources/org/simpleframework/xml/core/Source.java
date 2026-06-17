package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class Source implements Context {
    private TemplateEngine engine;
    private Filter filter;
    private Session session;
    private Strategy strategy;
    private Support support;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Source(Strategy strategy, Support support, Session session) {
        TemplateFilter templateFilter = new TemplateFilter(this, support);
        this.filter = templateFilter;
        this.engine = new TemplateEngine(templateFilter);
        this.strategy = strategy;
        this.support = support;
        this.session = session;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Scanner getScanner(Class cls) {
        return this.support.getScanner(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Object getAttribute(Object obj) {
        return this.session.get(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Caller getCaller(Class cls) {
        return getScanner(cls).getCaller(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Decorator getDecorator(Class cls) {
        return getScanner(cls).getDecorator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Instance getInstance(Class cls) {
        return this.support.getInstance(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public String getName(Class cls) {
        return this.support.getName(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Value getOverride(Type type, InputNode inputNode) throws PersistenceException {
        NodeMap<InputNode> attributes = inputNode.getAttributes();
        if (attributes != null) {
            return this.strategy.read(type, attributes, this.session);
        }
        throw new PersistenceException("No attributes for %s", inputNode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public String getProperty(String str) {
        return this.engine.process(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Schema getSchema(Class cls) throws PersistenceException {
        Scanner scanner = getScanner(cls);
        if (scanner != null) {
            return new ClassSchema(scanner, this);
        }
        throw new PersistenceException("Invalid schema class %s", cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Session getSession() {
        return this.session;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Style getStyle() {
        return this.support.getStyle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Support getSupport() {
        return this.support;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Class getType(Type type, Object obj) {
        return obj != null ? obj.getClass() : type.getType();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public Version getVersion(Class cls) {
        return getScanner(cls).getRevision();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public boolean isFloat(Type type) {
        return isFloat(type.getType());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public boolean isPrimitive(Type type) {
        return isPrimitive(type.getType());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public boolean isStrict() {
        return this.session.isStrict();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.core.Context
    public boolean setOverride(Type type, Object obj, OutputNode outputNode) throws PersistenceException {
        NodeMap<OutputNode> attributes = outputNode.getAttributes();
        if (attributes != null) {
            return this.strategy.write(type, obj, attributes, this.session);
        }
        throw new PersistenceException("No attributes for %s", outputNode);
    }

    @Override // org.simpleframework.xml.core.Context
    public Instance getInstance(Value value) {
        return this.support.getInstance(value);
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean isFloat(Class cls) {
        return Support.isFloat(cls);
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean isPrimitive(Class cls) {
        return this.support.isPrimitive(cls);
    }
}

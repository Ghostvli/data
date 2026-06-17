package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class Introspector {
    private final Contact contact;
    private final Format format;
    private final Label label;
    private final Annotation marker;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Introspector(Contact contact, Label label, Format format) {
        this.marker = contact.getAnnotation();
        this.contact = contact;
        this.format = format;
        this.label = label;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getDefault() {
        String override = this.label.getOverride();
        return !isEmpty(override) ? override : this.contact.getName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getRoot(Class<?> cls, Class<?> cls2) {
        String simpleName = cls2.getSimpleName();
        Root root = (Root) cls2.getAnnotation(Root.class);
        if (root == null) {
            return null;
        }
        String strName = root.name();
        return !isEmpty(strName) ? strName : Reflector.getName(simpleName);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Contact getContact() {
        return this.contact;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Type getDependent() {
        return this.label.getDependent();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getEntry() {
        Class<?> type = getDependent().getType();
        if (type.isArray()) {
            type = type.getComponentType();
        }
        return getName(type);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Expression getExpression() {
        String path = getPath();
        return path != null ? new PathParser(path, this.contact, this.format) : new EmptyExpression(this.format);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return !this.label.isInline() ? getDefault() : this.label.getEntry();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPath() {
        Path path = (Path) this.contact.getAnnotation(Path.class);
        if (path == null) {
            return null;
        }
        return path.value();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return String.format("%s on %s", this.marker, this.contact);
    }

    private String getName(Class cls) {
        String root = getRoot(cls);
        return root != null ? root : Reflector.getName(cls.getSimpleName());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.simpleframework.xml.core.Introspector */
    /* JADX WARN: Multi-variable type inference failed */
    private String getRoot(Class cls) {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            String root = getRoot(cls, superclass);
            if (root != null) {
                return root;
            }
        }
        return null;
    }
}

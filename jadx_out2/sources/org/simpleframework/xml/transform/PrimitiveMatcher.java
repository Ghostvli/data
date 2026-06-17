package org.simpleframework.xml.transform;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class PrimitiveMatcher implements Matcher {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) {
        if (cls == Integer.TYPE) {
            return new IntegerTransform();
        }
        if (cls == Boolean.TYPE) {
            return new BooleanTransform();
        }
        if (cls == Long.TYPE) {
            return new LongTransform();
        }
        if (cls == Double.TYPE) {
            return new DoubleTransform();
        }
        if (cls == Float.TYPE) {
            return new FloatTransform();
        }
        if (cls == Short.TYPE) {
            return new ShortTransform();
        }
        if (cls == Byte.TYPE) {
            return new ByteTransform();
        }
        if (cls == Character.TYPE) {
            return new CharacterTransform();
        }
        return null;
    }
}

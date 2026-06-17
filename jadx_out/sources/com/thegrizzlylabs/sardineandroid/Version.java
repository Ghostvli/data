package com.thegrizzlylabs.sardineandroid;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Version {
    private Version() {
    }

    public static String getImplementation() {
        Package r0 = Version.class.getPackage();
        if (r0 == null) {
            return null;
        }
        return r0.getImplementationVersion();
    }

    public static String getSpecification() {
        Package r0 = Version.class.getPackage();
        if (r0 == null) {
            return null;
        }
        return r0.getSpecificationVersion();
    }

    public static void main(String[] strArr) {
        System.out.println("Version: " + getSpecification());
        System.out.println("Implementation: " + getImplementation());
    }
}

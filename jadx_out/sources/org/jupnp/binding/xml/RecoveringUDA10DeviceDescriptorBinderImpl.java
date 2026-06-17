package org.jupnp.binding.xml;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.model.ValidationException;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RecoveringUDA10DeviceDescriptorBinderImpl extends UDA10DeviceDescriptorBinderImpl {
    private final j02 logger = n02.k(RecoveringUDA10DeviceDescriptorBinderImpl.class);

    private String fixGarbageLeadingChars(String str) {
        int iIndexOf = str.indexOf("<?xml");
        return iIndexOf == -1 ? str : str.substring(iIndexOf);
    }

    private boolean isGroupInformationAvailable(RemoteDevice remoteDevice) {
        return (remoteDevice == null || remoteDevice.getType() == null || remoteDevice.getIdentity() == null || remoteDevice.getDetails() == null || remoteDevice.getDetails().getManufacturerDetails() == null || remoteDevice.getDetails().getManufacturerDetails().getManufacturer() == null || remoteDevice.getIdentity().getDescriptorURL() == null) ? false : true;
    }

    private <D extends Device> boolean isSonosGroupDevice(D d) {
        if (d instanceof RemoteDevice) {
            RemoteDevice remoteDevice = (RemoteDevice) d;
            if (isGroupInformationAvailable(remoteDevice) && remoteDevice.getDetails().getManufacturerDetails().getManufacturer().toLowerCase().contains("sonos") && remoteDevice.getType().toString().contains("urn:smartspeaker-audio:device:SpeakerGroup") && remoteDevice.getIdentity().getDescriptorURL().toString().endsWith("group_description.xml")) {
                return true;
            }
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:41:0x0080
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.processExcHandler(ExcHandlersRegionMaker.java:154)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:77)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderImpl, org.jupnp.binding.xml.DeviceDescriptorBinder
    public <D extends org.jupnp.model.meta.Device> D describe(D r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = 0
            if (r11 == 0) goto L12
            java.lang.String r11 = r11.trim()     // Catch: org.jupnp.model.ValidationException -> L8 java.lang.IllegalArgumentException -> Lc org.jupnp.binding.xml.DescriptorBindingException -> Lf
            goto L12
        L8:
            r10 = move-exception
            r1 = r0
            goto L9c
        Lc:
            r1 = move-exception
            r2 = r0
            goto L3e
        Lf:
            r1 = move-exception
            r2 = r0
            goto L4f
        L12:
            java.lang.String r1 = r9.fixMimeTypes(r11)     // Catch: org.jupnp.model.ValidationException -> L8 java.lang.IllegalArgumentException -> Lc org.jupnp.binding.xml.DescriptorBindingException -> Lf
            java.lang.String r1 = r9.fixWrongNamespaces(r1)     // Catch: org.jupnp.model.ValidationException -> L8 java.lang.IllegalArgumentException -> Lc org.jupnp.binding.xml.DescriptorBindingException -> Lf
            java.lang.String r1 = r9.fixWemoMakerUDN(r1)     // Catch: org.jupnp.model.ValidationException -> L8 java.lang.IllegalArgumentException -> Lc org.jupnp.binding.xml.DescriptorBindingException -> Lf
            org.jupnp.model.meta.Device r1 = super.describe(r10, r1)     // Catch: org.jupnp.model.ValidationException -> L8 java.lang.IllegalArgumentException -> Lc org.jupnp.binding.xml.DescriptorBindingException -> Lf
            boolean r2 = r9.isSonosGroupDevice(r1)     // Catch: org.jupnp.model.ValidationException -> L31 java.lang.IllegalArgumentException -> L34 org.jupnp.binding.xml.DescriptorBindingException -> L39
            if (r2 != 0) goto L29
            return r1
        L29:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch: org.jupnp.model.ValidationException -> L31 java.lang.IllegalArgumentException -> L34 org.jupnp.binding.xml.DescriptorBindingException -> L39
            java.lang.String r3 = "Ignore Sonos group devices due to invalid descriptor content."
            r2.<init>(r3)     // Catch: org.jupnp.model.ValidationException -> L31 java.lang.IllegalArgumentException -> L34 org.jupnp.binding.xml.DescriptorBindingException -> L39
            throw r2     // Catch: org.jupnp.model.ValidationException -> L31 java.lang.IllegalArgumentException -> L34 org.jupnp.binding.xml.DescriptorBindingException -> L39
        L31:
            r10 = move-exception
            goto L9c
        L34:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L3e
        L39:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L4f
        L3e:
            org.jupnp.binding.xml.DescriptorBindingException r3 = new org.jupnp.binding.xml.DescriptorBindingException     // Catch: org.jupnp.model.ValidationException -> L4c
            java.lang.String r1 = r1.getMessage()     // Catch: org.jupnp.model.ValidationException -> L4c
            r3.<init>(r1)     // Catch: org.jupnp.model.ValidationException -> L4c
            r9.handleInvalidDescriptor(r11, r3)     // Catch: org.jupnp.model.ValidationException -> L4c
            r1 = r0
            goto L56
        L4c:
            r10 = move-exception
            r1 = r2
            goto L9c
        L4f:
            j02 r3 = r9.logger     // Catch: org.jupnp.model.ValidationException -> L4c
            java.lang.String r4 = "Regular parsing failed"
            r3.u(r4, r1)     // Catch: org.jupnp.model.ValidationException -> L4c
        L56:
            java.lang.String r3 = r9.fixGarbageLeadingChars(r11)     // Catch: org.jupnp.model.ValidationException -> L4c
            if (r3 == 0) goto L69
            org.jupnp.model.meta.Device r9 = super.describe(r10, r3)     // Catch: org.jupnp.model.ValidationException -> L4c org.jupnp.binding.xml.DescriptorBindingException -> L61
            return r9
        L61:
            r3 = move-exception
            j02 r4 = r9.logger     // Catch: org.jupnp.model.ValidationException -> L4c
            java.lang.String r5 = "Removing leading garbage didn't work"
            r4.u(r5, r3)     // Catch: org.jupnp.model.ValidationException -> L4c
        L69:
            java.lang.String r3 = r9.fixGarbageTrailingChars(r11, r1)     // Catch: org.jupnp.model.ValidationException -> L4c
            if (r3 == 0) goto L7c
            org.jupnp.model.meta.Device r9 = super.describe(r10, r3)     // Catch: org.jupnp.model.ValidationException -> L4c org.jupnp.binding.xml.DescriptorBindingException -> L74
            return r9
        L74:
            r3 = move-exception
            j02 r4 = r9.logger     // Catch: org.jupnp.model.ValidationException -> L4c
            java.lang.String r5 = "Removing trailing garbage didn't work"
            r4.u(r5, r3)     // Catch: org.jupnp.model.ValidationException -> L4c
        L7c:
            r3 = 0
            r4 = r11
            r5 = r1
        L7f:
            r6 = 5
            if (r3 >= r6) goto L98
            java.lang.String r4 = r9.fixMissingNamespaces(r4, r5)     // Catch: org.jupnp.model.ValidationException -> L4c
            if (r4 == 0) goto L98
            org.jupnp.model.meta.Device r9 = super.describe(r10, r4)     // Catch: org.jupnp.model.ValidationException -> L4c org.jupnp.binding.xml.DescriptorBindingException -> L8d
            return r9
        L8d:
            r5 = move-exception
            j02 r6 = r9.logger     // Catch: org.jupnp.model.ValidationException -> L4c
            java.lang.String r7 = "Fixing namespace prefix didn't work"
            r6.u(r7, r5)     // Catch: org.jupnp.model.ValidationException -> L4c
            int r3 = r3 + 1
            goto L7f
        L98:
            r9.handleInvalidDescriptor(r11, r1)     // Catch: org.jupnp.model.ValidationException -> L4c
            goto La3
        L9c:
            org.jupnp.model.meta.Device r9 = r9.handleInvalidDevice(r11, r1, r10)
            if (r9 == 0) goto La3
            return r9
        La3:
            java.lang.String r9 = "No device produced, did you swallow exceptions in your subclass?"
            defpackage.e04.a(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jupnp.binding.xml.RecoveringUDA10DeviceDescriptorBinderImpl.describe(org.jupnp.model.meta.Device, java.lang.String):org.jupnp.model.meta.Device");
    }

    public String fixGarbageTrailingChars(String str, DescriptorBindingException descriptorBindingException) {
        int iIndexOf = str.indexOf("</root>");
        if (iIndexOf == -1) {
            SpecificationViolationReporter.report("No closing </root> element in descriptor", new Object[0]);
            return null;
        }
        if (str.length() == iIndexOf + 7) {
            return null;
        }
        SpecificationViolationReporter.report("Detected garbage characters after <root> node, removing", new Object[0]);
        return str.substring(0, iIndexOf).concat("</root>");
    }

    public String fixMimeTypes(String str) {
        if (!str.contains("<mimetype>jpg</mimetype>")) {
            return str;
        }
        SpecificationViolationReporter.report("Detected invalid mimetype 'jpg', replacing it with 'image/jpeg'", new Object[0]);
        return str.replaceAll("<mimetype>jpg</mimetype>", "<mimetype>image/jpeg</mimetype>");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[PHI: r0
      0x0044: PHI (r0v7 java.util.regex.Matcher) = (r0v6 java.util.regex.Matcher), (r0v3 java.util.regex.Matcher) binds: [B:17:0x0040, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String fixMissingNamespaces(java.lang.String r7, org.jupnp.binding.xml.DescriptorBindingException r8) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jupnp.binding.xml.RecoveringUDA10DeviceDescriptorBinderImpl.fixMissingNamespaces(java.lang.String, org.jupnp.binding.xml.DescriptorBindingException):java.lang.String");
    }

    public String fixWemoMakerUDN(String str) {
        if (!str.contains(":sensor:switch")) {
            return str;
        }
        SpecificationViolationReporter.report("Detected invalid UDN value ':sensor:switch', replacing it", new Object[0]);
        return str.replaceAll(":sensor:switch", "").replaceAll(":sensor:switch", "");
    }

    public String fixWrongNamespaces(String str) {
        if (!str.contains("<root xmlns=\"urn:Belkin:device-1-0\">")) {
            return str;
        }
        SpecificationViolationReporter.report("Detected invalid root namespace 'urn:Belkin', replacing it with 'urn:schemas-upnp-org'", new Object[0]);
        return str.replaceAll("<root xmlns=\"urn:Belkin:device-1-0\">", "<root xmlns=\"urn:schemas-upnp-org:device-1-0\">");
    }

    public void handleInvalidDescriptor(String str, DescriptorBindingException descriptorBindingException) throws DescriptorBindingException {
        throw descriptorBindingException;
    }

    public <D extends Device> D handleInvalidDevice(String str, D d, ValidationException validationException) throws ValidationException {
        throw validationException;
    }
}

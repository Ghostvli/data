package org.jupnp.binding.xml;

import defpackage.j02;
import defpackage.n02;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.jupnp.binding.staging.MutableDevice;
import org.jupnp.binding.staging.MutableIcon;
import org.jupnp.binding.staging.MutableService;
import org.jupnp.binding.staging.MutableUDAVersion;
import org.jupnp.binding.xml.Descriptor;
import org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl;
import org.jupnp.model.ValidationException;
import org.jupnp.model.meta.Device;
import org.jupnp.model.types.DLNACaps;
import org.jupnp.model.types.DLNADoc;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.model.types.ServiceId;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDN;
import org.jupnp.util.MimeType;
import org.jupnp.util.SpecificationViolationReporter;
import org.jupnp.xml.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDA10DeviceDescriptorBinderSAXImpl extends UDA10DeviceDescriptorBinderImpl {
    private final j02 logger = n02.k(DeviceDescriptorBinder.class);

    /* JADX INFO: renamed from: org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[Descriptor.Device.ELEMENT.values().length];
            $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT = iArr;
            try {
                iArr[Descriptor.Device.ELEMENT.URLBase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.major.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.minor.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.deviceType.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.friendlyName.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.manufacturer.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.manufacturerURL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.modelDescription.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.modelName.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.modelNumber.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.modelURL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.presentationURL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.UPC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.serialNumber.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.UDN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.X_DLNADOC.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.X_DLNACAP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.width.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.height.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.depth.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.url.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.mimetype.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.serviceType.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.serviceId.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.SCPDURL.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.controlURL.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[Descriptor.Device.ELEMENT.eventSubURL.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class DeviceHandler extends DeviceDescriptorHandler<MutableDevice> {
        public static final Descriptor.Device.ELEMENT EL = Descriptor.Device.ELEMENT.device;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DeviceHandler(MutableDevice mutableDevice, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableDevice, deviceDescriptorHandler);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) {
            switch (AnonymousClass1.$SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[element.ordinal()]) {
                case 4:
                    getInstance().deviceType = getCharacters();
                    break;
                case 5:
                    getInstance().friendlyName = getCharacters();
                    break;
                case 6:
                    getInstance().manufacturer = getCharacters();
                    break;
                case 7:
                    getInstance().manufacturerURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    break;
                case 8:
                    getInstance().modelDescription = getCharacters();
                    break;
                case 9:
                    getInstance().modelName = getCharacters();
                    break;
                case 10:
                    getInstance().modelNumber = getCharacters();
                    break;
                case 11:
                    getInstance().modelURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    break;
                case 12:
                    getInstance().presentationURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    break;
                case 13:
                    getInstance().upc = getCharacters();
                    break;
                case 14:
                    getInstance().serialNumber = getCharacters();
                    break;
                case 15:
                    getInstance().udn = UDN.valueOf(getCharacters());
                    break;
                case 16:
                    String characters = getCharacters();
                    try {
                        getInstance().dlnaDocs.add(DLNADoc.valueOf(characters));
                    } catch (InvalidValueException unused) {
                        SpecificationViolationReporter.report("Invalid X_DLNADOC value, ignoring value: {}", characters);
                        return;
                    }
                    break;
                case 17:
                    getInstance().dlnaCaps = DLNACaps.valueOf(getCharacters());
                    break;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(EL);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) {
            if (element.equals(IconListHandler.EL)) {
                ArrayList arrayList = new ArrayList();
                getInstance().icons = arrayList;
                new IconListHandler(arrayList, this);
            }
            if (element.equals(ServiceListHandler.EL)) {
                ArrayList arrayList2 = new ArrayList();
                getInstance().services = arrayList2;
                new ServiceListHandler(arrayList2, this);
            }
            if (element.equals(DeviceListHandler.EL)) {
                ArrayList arrayList3 = new ArrayList();
                getInstance().embeddedDevices = arrayList3;
                new DeviceListHandler(arrayList3, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class DeviceListHandler extends DeviceDescriptorHandler<List<MutableDevice>> {
        public static final Descriptor.Device.ELEMENT EL = Descriptor.Device.ELEMENT.deviceList;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DeviceListHandler(List<MutableDevice> list, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(list, deviceDescriptorHandler);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(EL);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) {
            if (element.equals(DeviceHandler.EL)) {
                MutableDevice mutableDevice = new MutableDevice();
                getInstance().add(mutableDevice);
                new DeviceHandler(mutableDevice, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class IconHandler extends DeviceDescriptorHandler<MutableIcon> {
        public static final Descriptor.Device.ELEMENT EL = Descriptor.Device.ELEMENT.icon;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public IconHandler(MutableIcon mutableIcon, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableIcon, deviceDescriptorHandler);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) {
            switch (AnonymousClass1.$SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[element.ordinal()]) {
                case 18:
                    getInstance().width = Integer.parseInt(getCharacters());
                    break;
                case 19:
                    getInstance().height = Integer.parseInt(getCharacters());
                    break;
                case 20:
                    try {
                        getInstance().depth = Integer.parseInt(getCharacters());
                    } catch (NumberFormatException e) {
                        SpecificationViolationReporter.report("Invalid icon depth '{}', using 16 as default: {}", getCharacters(), e);
                        getInstance().depth = 16;
                        return;
                    }
                    break;
                case 21:
                    getInstance().uri = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                    break;
                case 22:
                    try {
                        getInstance().mimeType = getCharacters();
                        MimeType.valueOf(getInstance().mimeType);
                    } catch (IllegalArgumentException unused) {
                        SpecificationViolationReporter.report("Ignoring invalid icon mime type: {}", getInstance().mimeType);
                        getInstance().mimeType = "";
                        return;
                    }
                    break;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(EL);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class IconListHandler extends DeviceDescriptorHandler<List<MutableIcon>> {
        public static final Descriptor.Device.ELEMENT EL = Descriptor.Device.ELEMENT.iconList;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public IconListHandler(List<MutableIcon> list, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(list, deviceDescriptorHandler);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(EL);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) {
            if (element.equals(IconHandler.EL)) {
                MutableIcon mutableIcon = new MutableIcon();
                getInstance().add(mutableIcon);
                new IconHandler(mutableIcon, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class RootHandler extends DeviceDescriptorHandler<MutableDevice> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public RootHandler(MutableDevice mutableDevice, SAXParser sAXParser) {
            super(mutableDevice, sAXParser);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) throws SAXException {
            if (AnonymousClass1.$SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[element.ordinal()] != 1) {
                return;
            }
            try {
                String characters = getCharacters();
                if (characters == null || characters.isEmpty()) {
                    return;
                }
                getInstance().baseURL = new URL(characters);
            } catch (Exception e) {
                throw new SAXException("Invalid URLBase", e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) {
            if (element.equals(SpecVersionHandler.EL)) {
                MutableUDAVersion mutableUDAVersion = new MutableUDAVersion();
                getInstance().udaVersion = mutableUDAVersion;
                new SpecVersionHandler(mutableUDAVersion, this);
            }
            if (element.equals(DeviceHandler.EL)) {
                new DeviceHandler(getInstance(), this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ServiceHandler extends DeviceDescriptorHandler<MutableService> {
        public static final Descriptor.Device.ELEMENT EL = Descriptor.Device.ELEMENT.service;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ServiceHandler(MutableService mutableService, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableService, deviceDescriptorHandler);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) {
            try {
                switch (AnonymousClass1.$SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[element.ordinal()]) {
                    case 23:
                        getInstance().serviceType = ServiceType.valueOf(getCharacters());
                        break;
                    case 24:
                        getInstance().serviceId = ServiceId.valueOf(getCharacters());
                        break;
                    case 25:
                        getInstance().descriptorURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                        break;
                    case 26:
                        getInstance().controlURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                        break;
                    case 27:
                        getInstance().eventSubscriptionURI = UDA10DeviceDescriptorBinderImpl.parseURI(getCharacters());
                        break;
                }
            } catch (InvalidValueException e) {
                SpecificationViolationReporter.report("Skipping invalid service declaration. " + e.getMessage(), new Object[0]);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(EL);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ServiceListHandler extends DeviceDescriptorHandler<List<MutableService>> {
        public static final Descriptor.Device.ELEMENT EL = Descriptor.Device.ELEMENT.serviceList;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ServiceListHandler(List<MutableService> list, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(list, deviceDescriptorHandler);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ boolean a(MutableService mutableService) {
            return mutableService.serviceType == null || mutableService.serviceId == null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            boolean zEquals = element.equals(EL);
            if (zEquals) {
                getInstance().removeIf(new Predicate() { // from class: nv4
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return UDA10DeviceDescriptorBinderSAXImpl.ServiceListHandler.a((MutableService) obj);
                    }
                });
            }
            return zEquals;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) {
            if (element.equals(ServiceHandler.EL)) {
                MutableService mutableService = new MutableService();
                getInstance().add(mutableService);
                new ServiceHandler(mutableService, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class SpecVersionHandler extends DeviceDescriptorHandler<MutableUDAVersion> {
        public static final Descriptor.Device.ELEMENT EL = Descriptor.Device.ELEMENT.specVersion;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public SpecVersionHandler(MutableUDAVersion mutableUDAVersion, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(mutableUDAVersion, deviceDescriptorHandler);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public void endElement(Descriptor.Device.ELEMENT element) {
            int i = AnonymousClass1.$SwitchMap$org$jupnp$binding$xml$Descriptor$Device$ELEMENT[element.ordinal()];
            if (i == 2) {
                String strTrim = getCharacters().trim();
                if (!strTrim.equals("1")) {
                    SpecificationViolationReporter.report("Unsupported UDA major version, ignoring: ".concat(strTrim), new Object[0]);
                    strTrim = "1";
                }
                getInstance().major = Integer.parseInt(strTrim);
                return;
            }
            if (i != 3) {
                return;
            }
            String strTrim2 = getCharacters().trim();
            if (!strTrim2.equals("0")) {
                SpecificationViolationReporter.report("Unsupported UDA minor version, ignoring: ".concat(strTrim2), new Object[0]);
                strTrim2 = "0";
            }
            getInstance().minor = Integer.parseInt(strTrim2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderSAXImpl.DeviceDescriptorHandler
        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return element.equals(EL);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.binding.xml.UDA10DeviceDescriptorBinderImpl, org.jupnp.binding.xml.DeviceDescriptorBinder
    public <D extends Device> D describe(D d, String str) throws ValidationException, DescriptorBindingException {
        if (str == null || str.isEmpty()) {
            throw new DescriptorBindingException("Null or empty descriptor");
        }
        try {
            this.logger.h("Populating device from XML descriptor: {}", d);
            SAXParser sAXParser = new SAXParser();
            MutableDevice mutableDevice = new MutableDevice();
            new RootHandler(mutableDevice, sAXParser);
            sAXParser.parse(new InputSource(new StringReader(str.trim())));
            return (D) mutableDevice.build(d);
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            throw new DescriptorBindingException("Could not parse device descriptor", e2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class DeviceDescriptorHandler<I> extends SAXParser.Handler<I> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DeviceDescriptorHandler(I i) {
            super(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            super.endElement(str, str2, str3);
            Descriptor.Device.ELEMENT elementValueOrNullOf = Descriptor.Device.ELEMENT.valueOrNullOf(str2);
            if (elementValueOrNullOf == null) {
                return;
            }
            endElement(elementValueOrNullOf);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            Descriptor.Device.ELEMENT elementValueOrNullOf = Descriptor.Device.ELEMENT.valueOrNullOf(str2);
            return elementValueOrNullOf != null && isLastElement(elementValueOrNullOf);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            super.startElement(str, str2, str3, attributes);
            Descriptor.Device.ELEMENT elementValueOrNullOf = Descriptor.Device.ELEMENT.valueOrNullOf(str2);
            if (elementValueOrNullOf == null) {
                return;
            }
            startElement(elementValueOrNullOf, attributes);
        }

        public DeviceDescriptorHandler(I i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        public DeviceDescriptorHandler(I i, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(i, deviceDescriptorHandler);
        }

        public DeviceDescriptorHandler(I i, SAXParser sAXParser, DeviceDescriptorHandler deviceDescriptorHandler) {
            super(i, sAXParser, deviceDescriptorHandler);
        }

        public void endElement(Descriptor.Device.ELEMENT element) {
        }

        public void startElement(Descriptor.Device.ELEMENT element, Attributes attributes) {
        }

        public boolean isLastElement(Descriptor.Device.ELEMENT element) {
            return false;
        }
    }
}

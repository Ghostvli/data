package org.jupnp.binding.xml;

import defpackage.j02;
import defpackage.n02;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jupnp.binding.staging.MutableDevice;
import org.jupnp.binding.staging.MutableIcon;
import org.jupnp.binding.staging.MutableService;
import org.jupnp.binding.xml.Descriptor;
import org.jupnp.model.Namespace;
import org.jupnp.model.ValidationException;
import org.jupnp.model.XMLUtil;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.DeviceDetails;
import org.jupnp.model.meta.Icon;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.meta.Service;
import org.jupnp.model.profile.RemoteClientInfo;
import org.jupnp.model.types.DLNACaps;
import org.jupnp.model.types.DLNADoc;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.model.types.ServiceId;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDN;
import org.jupnp.util.MimeType;
import org.jupnp.util.SpecificationViolationReporter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDA10DeviceDescriptorBinderImpl implements DeviceDescriptorBinder, ErrorHandler {
    private final j02 logger = n02.k(DeviceDescriptorBinder.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static URI parseURI(String str) {
        if (str.startsWith("www.")) {
            str = "http://".concat(str);
        }
        if (str.contains(" ")) {
            str = str.replaceAll(" ", "%20");
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | NullPointerException e) {
            n02.k(DeviceDescriptorBinder.class).v("Illegal URI, trying with ./ prefix", e);
            try {
                return URI.create("./" + str);
            } catch (IllegalArgumentException e2) {
                SpecificationViolationReporter.report("Illegal URI '{}', ignoring value", str, e2);
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.binding.xml.DeviceDescriptorBinder
    public Document buildDOM(Device device, RemoteClientInfo remoteClientInfo, Namespace namespace) throws DescriptorBindingException {
        try {
            this.logger.h("Generating DOM from device model: {}", device);
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setNamespaceAware(true);
            Document documentNewDocument = documentBuilderFactoryNewInstance.newDocumentBuilder().newDocument();
            generateRoot(namespace, device, documentNewDocument, remoteClientInfo);
            return documentNewDocument;
        } catch (Exception e) {
            throw new DescriptorBindingException("Could not generate device descriptor: " + e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <D extends Device> D buildInstance(D d, MutableDevice mutableDevice) {
        return (D) mutableDevice.build(d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.binding.xml.DeviceDescriptorBinder
    public <D extends Device> D describe(D d, String str) throws ValidationException, DescriptorBindingException {
        if (str == null || str.isEmpty()) {
            throw new DescriptorBindingException("Null or empty descriptor");
        }
        try {
            this.logger.h("Populating device from XML descriptor: {}", d);
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setNamespaceAware(true);
            try {
                documentBuilderFactoryNewInstance.setAttribute("http://apache.org/xml/properties/locale", Locale.ROOT);
            } catch (IllegalArgumentException e) {
                this.logger.w("Parser does not support 'http://apache.org/xml/properties/locale' attribute", e);
            }
            DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setErrorHandler(this);
            return (D) describe(d, documentBuilderNewDocumentBuilder.parse(new InputSource(new StringReader(str.trim()))));
        } catch (ValidationException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new DescriptorBindingException("Could not parse device descriptor", e3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXParseException {
        throw sAXParseException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
        throw sAXParseException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.binding.xml.DeviceDescriptorBinder
    public String generate(Device device, RemoteClientInfo remoteClientInfo, Namespace namespace) throws DescriptorBindingException {
        try {
            this.logger.h("Generating XML descriptor from device model: {}", device);
            return XMLUtil.documentToString(buildDOM(device, remoteClientInfo, namespace));
        } catch (Exception e) {
            throw new DescriptorBindingException("Could not build DOM: " + e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void generateDevice(Namespace namespace, Device device, Document document, Element element, RemoteClientInfo remoteClientInfo) {
        Element elementAppendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.device);
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.deviceType, device.getType());
        DeviceDetails details = device.getDetails(remoteClientInfo);
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.friendlyName, details.getFriendlyName());
        if (details.getManufacturerDetails() != null) {
            XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.manufacturer, details.getManufacturerDetails().getManufacturer());
            XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.manufacturerURL, details.getManufacturerDetails().getManufacturerURI());
        }
        if (details.getModelDetails() != null) {
            XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.modelDescription, details.getModelDetails().getModelDescription());
            XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.modelName, details.getModelDetails().getModelName());
            XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.modelNumber, details.getModelDetails().getModelNumber());
            XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.modelURL, details.getModelDetails().getModelURI());
        }
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.serialNumber, details.getSerialNumber());
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.UDN, device.getIdentity().getUdn());
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.presentationURL, details.getPresentationURI());
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.UPC, details.getUpc());
        if (details.getDlnaDocs() != null) {
            for (DLNADoc dLNADoc : details.getDlnaDocs()) {
                XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, "dlna:".concat(String.valueOf(Descriptor.Device.ELEMENT.X_DLNADOC)), dLNADoc, Descriptor.Device.DLNA_NAMESPACE_URI);
            }
        }
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, "dlna:".concat(String.valueOf(Descriptor.Device.ELEMENT.X_DLNACAP)), details.getDlnaCaps(), Descriptor.Device.DLNA_NAMESPACE_URI);
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, "sec:".concat(String.valueOf(Descriptor.Device.ELEMENT.ProductCap)), details.getSecProductCaps(), Descriptor.Device.SEC_NAMESPACE_URI);
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, "sec:".concat(String.valueOf(Descriptor.Device.ELEMENT.X_ProductCap)), details.getSecProductCaps(), Descriptor.Device.SEC_NAMESPACE_URI);
        generateIconList(namespace, device, document, elementAppendNewElement);
        generateServiceList(namespace, device, document, elementAppendNewElement);
        generateDeviceList(namespace, device, document, elementAppendNewElement, remoteClientInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void generateDeviceList(Namespace namespace, Device device, Document document, Element element, RemoteClientInfo remoteClientInfo) {
        if (device.hasEmbeddedDevices()) {
            Element elementAppendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.deviceList);
            for (Device device2 : device.getEmbeddedDevices()) {
                generateDevice(namespace, device2, document, elementAppendNewElement, remoteClientInfo);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void generateIconList(Namespace namespace, Device device, Document document, Element element) {
        if (device.hasIcons()) {
            Element elementAppendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.iconList);
            for (Icon icon : device.getIcons()) {
                Element elementAppendNewElement2 = XMLUtil.appendNewElement(document, elementAppendNewElement, Descriptor.Device.ELEMENT.icon);
                XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.mimetype, icon.getMimeType());
                XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.width, Integer.valueOf(icon.getWidth()));
                XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.height, Integer.valueOf(icon.getHeight()));
                XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.depth, Integer.valueOf(icon.getDepth()));
                if (device instanceof RemoteDevice) {
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.url, icon.getUri());
                } else if (device instanceof LocalDevice) {
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.url, namespace.getIconPath(icon));
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void generateRoot(Namespace namespace, Device device, Document document, RemoteClientInfo remoteClientInfo) {
        Element elementCreateElementNS = document.createElementNS(Descriptor.Device.NAMESPACE_URI, Descriptor.Device.ELEMENT.root.toString());
        document.appendChild(elementCreateElementNS);
        generateSpecVersion(namespace, device, document, elementCreateElementNS);
        generateDevice(namespace, device, document, elementCreateElementNS, remoteClientInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void generateServiceList(Namespace namespace, Device device, Document document, Element element) {
        if (device.hasServices()) {
            Element elementAppendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.serviceList);
            for (Service service : device.getServices()) {
                Element elementAppendNewElement2 = XMLUtil.appendNewElement(document, elementAppendNewElement, Descriptor.Device.ELEMENT.service);
                XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.serviceType, service.getServiceType());
                XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.serviceId, service.getServiceId());
                if (service instanceof RemoteService) {
                    RemoteService remoteService = (RemoteService) service;
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.SCPDURL, remoteService.getDescriptorURI());
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.controlURL, remoteService.getControlURI());
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.eventSubURL, remoteService.getEventSubscriptionURI());
                } else if (service instanceof LocalService) {
                    LocalService localService = (LocalService) service;
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.SCPDURL, namespace.getDescriptorPath(localService));
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.controlURL, namespace.getControlPath(localService));
                    XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement2, Descriptor.Device.ELEMENT.eventSubURL, namespace.getEventSubscriptionPath(localService));
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void generateSpecVersion(Namespace namespace, Device device, Document document, Element element) {
        Element elementAppendNewElement = XMLUtil.appendNewElement(document, element, Descriptor.Device.ELEMENT.specVersion);
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.major, Integer.valueOf(device.getVersion().getMajor()));
        XMLUtil.appendNewElementIfNotNull(document, elementAppendNewElement, Descriptor.Device.ELEMENT.minor, Integer.valueOf(device.getVersion().getMinor()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void hydrateDevice(MutableDevice mutableDevice, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1) {
                if (Descriptor.Device.ELEMENT.deviceType.equals(nodeItem)) {
                    mutableDevice.deviceType = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.friendlyName.equals(nodeItem)) {
                    mutableDevice.friendlyName = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.manufacturer.equals(nodeItem)) {
                    mutableDevice.manufacturer = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.manufacturerURL.equals(nodeItem)) {
                    mutableDevice.manufacturerURI = parseURI(XMLUtil.getTextContent(nodeItem));
                } else if (Descriptor.Device.ELEMENT.modelDescription.equals(nodeItem)) {
                    mutableDevice.modelDescription = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.modelName.equals(nodeItem)) {
                    mutableDevice.modelName = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.modelNumber.equals(nodeItem)) {
                    mutableDevice.modelNumber = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.modelURL.equals(nodeItem)) {
                    mutableDevice.modelURI = parseURI(XMLUtil.getTextContent(nodeItem));
                } else if (Descriptor.Device.ELEMENT.presentationURL.equals(nodeItem)) {
                    mutableDevice.presentationURI = parseURI(XMLUtil.getTextContent(nodeItem));
                } else if (Descriptor.Device.ELEMENT.UPC.equals(nodeItem)) {
                    mutableDevice.upc = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.serialNumber.equals(nodeItem)) {
                    mutableDevice.serialNumber = XMLUtil.getTextContent(nodeItem);
                } else if (Descriptor.Device.ELEMENT.UDN.equals(nodeItem)) {
                    mutableDevice.udn = UDN.valueOf(XMLUtil.getTextContent(nodeItem));
                } else if (Descriptor.Device.ELEMENT.iconList.equals(nodeItem)) {
                    hydrateIconList(mutableDevice, nodeItem);
                } else if (Descriptor.Device.ELEMENT.serviceList.equals(nodeItem)) {
                    hydrateServiceList(mutableDevice, nodeItem);
                } else if (Descriptor.Device.ELEMENT.deviceList.equals(nodeItem)) {
                    hydrateDeviceList(mutableDevice, nodeItem);
                } else if (Descriptor.Device.ELEMENT.X_DLNADOC.equals(nodeItem) && Descriptor.Device.DLNA_PREFIX.equals(nodeItem.getPrefix())) {
                    String textContent = XMLUtil.getTextContent(nodeItem);
                    try {
                        mutableDevice.dlnaDocs.add(DLNADoc.valueOf(textContent));
                    } catch (InvalidValueException unused) {
                        this.logger.c("Invalid X_DLNADOC value, ignoring value: {}", textContent);
                    }
                } else if (Descriptor.Device.ELEMENT.X_DLNACAP.equals(nodeItem) && Descriptor.Device.DLNA_PREFIX.equals(nodeItem.getPrefix())) {
                    mutableDevice.dlnaCaps = DLNACaps.valueOf(XMLUtil.getTextContent(nodeItem));
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void hydrateDeviceList(MutableDevice mutableDevice, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1 && Descriptor.Device.ELEMENT.device.equals(nodeItem)) {
                MutableDevice mutableDevice2 = new MutableDevice();
                mutableDevice2.parentDevice = mutableDevice;
                mutableDevice.embeddedDevices.add(mutableDevice2);
                hydrateDevice(mutableDevice2, nodeItem);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void hydrateIconList(MutableDevice mutableDevice, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1 && Descriptor.Device.ELEMENT.icon.equals(nodeItem)) {
                MutableIcon mutableIcon = new MutableIcon();
                NodeList childNodes2 = nodeItem.getChildNodes();
                for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                    Node nodeItem2 = childNodes2.item(i2);
                    if (nodeItem2.getNodeType() == 1) {
                        if (Descriptor.Device.ELEMENT.width.equals(nodeItem2)) {
                            mutableIcon.width = Integer.parseInt(XMLUtil.getTextContent(nodeItem2));
                        } else if (Descriptor.Device.ELEMENT.height.equals(nodeItem2)) {
                            mutableIcon.height = Integer.parseInt(XMLUtil.getTextContent(nodeItem2));
                        } else if (Descriptor.Device.ELEMENT.depth.equals(nodeItem2)) {
                            String textContent = XMLUtil.getTextContent(nodeItem2);
                            try {
                                mutableIcon.depth = Integer.parseInt(textContent);
                            } catch (NumberFormatException e) {
                                SpecificationViolationReporter.report("Invalid icon depth '{}', using 16 as default: {}", textContent, e);
                                mutableIcon.depth = 16;
                            }
                        } else if (Descriptor.Device.ELEMENT.url.equals(nodeItem2)) {
                            mutableIcon.uri = parseURI(XMLUtil.getTextContent(nodeItem2));
                        } else if (Descriptor.Device.ELEMENT.mimetype.equals(nodeItem2)) {
                            try {
                                String textContent2 = XMLUtil.getTextContent(nodeItem2);
                                mutableIcon.mimeType = textContent2;
                                MimeType.valueOf(textContent2);
                            } catch (IllegalArgumentException unused) {
                                SpecificationViolationReporter.report("Ignoring invalid icon mime type: " + mutableIcon.mimeType, new Object[0]);
                                mutableIcon.mimeType = "";
                            }
                        }
                    }
                }
                mutableDevice.icons.add(mutableIcon);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void hydrateRoot(MutableDevice mutableDevice, Element element) throws DescriptorBindingException {
        if (element.getNamespaceURI() == null || !element.getNamespaceURI().equals(Descriptor.Device.NAMESPACE_URI)) {
            SpecificationViolationReporter.report("Wrong XML namespace declared on root element: {}", element.getNamespaceURI());
        }
        if (!element.getNodeName().equals(Descriptor.Device.ELEMENT.root.name())) {
            throw new DescriptorBindingException("Root element name is not <root>: " + element.getNodeName());
        }
        NodeList childNodes = element.getChildNodes();
        Node node = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1) {
                if (Descriptor.Device.ELEMENT.specVersion.equals(nodeItem)) {
                    hydrateSpecVersion(mutableDevice, nodeItem);
                } else if (Descriptor.Device.ELEMENT.URLBase.equals(nodeItem)) {
                    try {
                        String textContent = XMLUtil.getTextContent(nodeItem);
                        if (textContent != null && !textContent.isEmpty()) {
                            mutableDevice.baseURL = new URL(textContent);
                        }
                    } catch (Exception e) {
                        throw new DescriptorBindingException("Invalid URLBase: " + e.getMessage());
                    }
                } else if (!Descriptor.Device.ELEMENT.device.equals(nodeItem)) {
                    this.logger.h("Ignoring unknown element: {}", nodeItem.getNodeName());
                } else {
                    if (node != null) {
                        throw new DescriptorBindingException("Found multiple <device> elements in <root>");
                    }
                    node = nodeItem;
                }
            }
        }
        if (node == null) {
            throw new DescriptorBindingException("No <device> element in <root>");
        }
        hydrateDevice(mutableDevice, node);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void hydrateServiceList(MutableDevice mutableDevice, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1 && Descriptor.Device.ELEMENT.service.equals(nodeItem)) {
                NodeList childNodes2 = nodeItem.getChildNodes();
                try {
                    MutableService mutableService = new MutableService();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node nodeItem2 = childNodes2.item(i2);
                        if (nodeItem2.getNodeType() == 1) {
                            if (Descriptor.Device.ELEMENT.serviceType.equals(nodeItem2)) {
                                mutableService.serviceType = ServiceType.valueOf(XMLUtil.getTextContent(nodeItem2));
                            } else if (Descriptor.Device.ELEMENT.serviceId.equals(nodeItem2)) {
                                mutableService.serviceId = ServiceId.valueOf(XMLUtil.getTextContent(nodeItem2));
                            } else if (Descriptor.Device.ELEMENT.SCPDURL.equals(nodeItem2)) {
                                mutableService.descriptorURI = parseURI(XMLUtil.getTextContent(nodeItem2));
                            } else if (Descriptor.Device.ELEMENT.controlURL.equals(nodeItem2)) {
                                mutableService.controlURI = parseURI(XMLUtil.getTextContent(nodeItem2));
                            } else if (Descriptor.Device.ELEMENT.eventSubURL.equals(nodeItem2)) {
                                mutableService.eventSubscriptionURI = parseURI(XMLUtil.getTextContent(nodeItem2));
                            }
                        }
                    }
                    mutableDevice.services.add(mutableService);
                } catch (InvalidValueException e) {
                    SpecificationViolationReporter.report("Skipping invalid service declaration. " + e.getMessage(), new Object[0]);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void hydrateSpecVersion(MutableDevice mutableDevice, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1) {
                if (Descriptor.Device.ELEMENT.major.equals(nodeItem)) {
                    String strTrim = XMLUtil.getTextContent(nodeItem).trim();
                    if (!strTrim.equals("1")) {
                        SpecificationViolationReporter.report("Unsupported UDA major version, ignoring: ".concat(strTrim), new Object[0]);
                        strTrim = "1";
                    }
                    mutableDevice.udaVersion.major = Integer.parseInt(strTrim);
                } else if (Descriptor.Device.ELEMENT.minor.equals(nodeItem)) {
                    String strTrim2 = XMLUtil.getTextContent(nodeItem).trim();
                    if (!strTrim2.equals("0")) {
                        SpecificationViolationReporter.report("Unsupported UDA minor version, ignoring: ".concat(strTrim2), new Object[0]);
                        strTrim2 = "0";
                    }
                    mutableDevice.udaVersion.minor = Integer.parseInt(strTrim2);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        this.logger.warn(sAXParseException.toString());
    }

    @Override // org.jupnp.binding.xml.DeviceDescriptorBinder
    public <D extends Device> D describe(D d, Document document) throws ValidationException, DescriptorBindingException {
        try {
            this.logger.h("Populating device from DOM: {}", d);
            MutableDevice mutableDevice = new MutableDevice();
            hydrateRoot(mutableDevice, document.getDocumentElement());
            return (D) buildInstance(d, mutableDevice);
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e2) {
            throw new DescriptorBindingException("Could not parse device DOM", e2);
        }
    }
}

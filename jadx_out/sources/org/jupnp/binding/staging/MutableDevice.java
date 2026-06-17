package org.jupnp.binding.staging;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.DeviceDetails;
import org.jupnp.model.meta.Icon;
import org.jupnp.model.meta.ManufacturerDetails;
import org.jupnp.model.meta.ModelDetails;
import org.jupnp.model.meta.Service;
import org.jupnp.model.meta.UDAVersion;
import org.jupnp.model.types.DLNACaps;
import org.jupnp.model.types.DLNADoc;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MutableDevice {
    public URL baseURL;
    public String deviceType;
    public DLNACaps dlnaCaps;
    public String friendlyName;
    public String manufacturer;
    public URI manufacturerURI;
    public String modelDescription;
    public String modelName;
    public String modelNumber;
    public URI modelURI;
    public MutableDevice parentDevice;
    public URI presentationURI;
    public String serialNumber;
    public UDN udn;
    public String upc;
    public MutableUDAVersion udaVersion = new MutableUDAVersion();
    public List<DLNADoc> dlnaDocs = new ArrayList();
    public List<MutableIcon> icons = new ArrayList();
    public List<MutableService> services = new ArrayList();
    public List<MutableDevice> embeddedDevices = new ArrayList();

    public Device build(Device device, UDAVersion uDAVersion, URL url) {
        ArrayList arrayList = new ArrayList();
        Iterator<MutableDevice> it = this.embeddedDevices.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().build(device, uDAVersion, url));
        }
        return device.newInstance(this.udn, uDAVersion, createDeviceType(), createDeviceDetails(url), createIcons(), createServices(device), arrayList);
    }

    public DeviceDetails createDeviceDetails(URL url) {
        String str = this.friendlyName;
        ManufacturerDetails manufacturerDetails = new ManufacturerDetails(this.manufacturer, this.manufacturerURI);
        ModelDetails modelDetails = new ModelDetails(this.modelName, this.modelDescription, this.modelNumber, this.modelURI);
        String str2 = this.serialNumber;
        String str3 = this.upc;
        URI uri = this.presentationURI;
        List<DLNADoc> list = this.dlnaDocs;
        return new DeviceDetails(url, str, manufacturerDetails, modelDetails, str2, str3, uri, (DLNADoc[]) list.toArray(new DLNADoc[list.size()]), this.dlnaCaps);
    }

    public DeviceType createDeviceType() {
        return DeviceType.valueOf(this.deviceType);
    }

    public UDAVersion createDeviceVersion() {
        MutableUDAVersion mutableUDAVersion = this.udaVersion;
        return new UDAVersion(mutableUDAVersion.major, mutableUDAVersion.minor);
    }

    public Icon[] createIcons() {
        Icon[] iconArr = new Icon[this.icons.size()];
        Iterator<MutableIcon> it = this.icons.iterator();
        int i = 0;
        while (it.hasNext()) {
            iconArr[i] = it.next().build();
            i++;
        }
        return iconArr;
    }

    public Service[] createServices(Device device) {
        Service[] serviceArrNewServiceArray = device.newServiceArray(this.services.size());
        Iterator<MutableService> it = this.services.iterator();
        int i = 0;
        while (it.hasNext()) {
            serviceArrNewServiceArray[i] = it.next().build(device);
            i++;
        }
        return serviceArrNewServiceArray;
    }

    public Device build(Device device) {
        return build(device, createDeviceVersion(), this.baseURL);
    }
}

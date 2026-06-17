package org.jupnp.model.meta;

import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ManufacturerDetails {
    private String manufacturer;
    private URI manufacturerURI;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ManufacturerDetails(String str, String str2) {
        this.manufacturer = str;
        this.manufacturerURI = URI.create(str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getManufacturerURI() {
        return this.manufacturerURI;
    }

    public ManufacturerDetails(String str) {
        this.manufacturer = str;
    }

    public ManufacturerDetails(URI uri) {
        this.manufacturerURI = uri;
    }

    public ManufacturerDetails(String str, URI uri) {
        this.manufacturer = str;
        this.manufacturerURI = uri;
    }

    public ManufacturerDetails() {
    }
}

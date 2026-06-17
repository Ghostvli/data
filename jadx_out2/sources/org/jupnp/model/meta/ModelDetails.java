package org.jupnp.model.meta;

import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ModelDetails {
    private String modelDescription;
    private String modelName;
    private String modelNumber;
    private URI modelURI;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ModelDetails(String str, String str2, String str3, String str4) {
        this.modelName = str;
        this.modelDescription = str2;
        this.modelNumber = str3;
        this.modelURI = URI.create(str4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getModelDescription() {
        return this.modelDescription;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getModelName() {
        return this.modelName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getModelNumber() {
        return this.modelNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getModelURI() {
        return this.modelURI;
    }

    public ModelDetails(String str) {
        this.modelName = str;
    }

    public ModelDetails(String str, String str2) {
        this.modelName = str;
        this.modelDescription = str2;
    }

    public ModelDetails(String str, String str2, String str3) {
        this.modelName = str;
        this.modelDescription = str2;
        this.modelNumber = str3;
    }

    public ModelDetails(String str, String str2, String str3, URI uri) {
        this.modelName = str;
        this.modelDescription = str2;
        this.modelNumber = str3;
        this.modelURI = uri;
    }

    public ModelDetails() {
    }
}

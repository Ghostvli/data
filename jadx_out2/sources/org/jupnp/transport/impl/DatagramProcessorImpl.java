package org.jupnp.transport.impl;

import defpackage.j02;
import defpackage.n02;
import java.io.ByteArrayInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.json.HTTP;
import org.jupnp.http.Headers;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.OutgoingDatagramMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.transport.spi.DatagramProcessor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DatagramProcessorImpl implements DatagramProcessor {
    private final j02 logger = n02.k(DatagramProcessor.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x005c */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.net.DatagramPacket */
    /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: java.net.DatagramPacket */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.net.DatagramPacket */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    @Override // org.jupnp.transport.spi.DatagramProcessor
    public IncomingDatagramMessage read(InetAddress inetAddress, DatagramPacket datagramPacket) {
        ?? StartsWith;
        Exception exc;
        DatagramPacket datagramPacket2;
        try {
            if (this.logger.n()) {
                try {
                    this.logger.y("===================================== DATAGRAM BEGIN ============================================");
                    this.logger.y(new String(datagramPacket.getData()));
                    this.logger.y("-===================================== DATAGRAM END =============================================");
                } catch (Exception e) {
                    exc = e;
                    datagramPacket2 = datagramPacket;
                }
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData());
            String[] strArrSplit = Headers.readLine(byteArrayInputStream).split(" ");
            StartsWith = strArrSplit[0].startsWith("HTTP/1.");
            try {
                return StartsWith != 0 ? readResponseMessage(inetAddress, datagramPacket, byteArrayInputStream, Integer.parseInt(strArrSplit[1]), strArrSplit[2], strArrSplit[0]) : readRequestMessage(inetAddress, datagramPacket, byteArrayInputStream, strArrSplit[0], strArrSplit[2]);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            StartsWith = datagramPacket;
        }
        exc = e;
        datagramPacket2 = StartsWith;
        throw new UnsupportedDataException("Could not parse headers", exc, datagramPacket2.getData());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IncomingDatagramMessage readRequestMessage(InetAddress inetAddress, DatagramPacket datagramPacket, ByteArrayInputStream byteArrayInputStream, String str, String str2) {
        UpnpHeaders upnpHeaders = new UpnpHeaders(byteArrayInputStream);
        UpnpRequest upnpRequest = new UpnpRequest(UpnpRequest.Method.getByHttpName(str));
        upnpRequest.setHttpMinorVersion(str2.toUpperCase(Locale.ENGLISH).equals("HTTP/1.1") ? 1 : 0);
        IncomingDatagramMessage incomingDatagramMessage = new IncomingDatagramMessage(upnpRequest, datagramPacket.getAddress(), datagramPacket.getPort(), inetAddress);
        incomingDatagramMessage.setHeaders(upnpHeaders);
        return incomingDatagramMessage;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IncomingDatagramMessage readResponseMessage(InetAddress inetAddress, DatagramPacket datagramPacket, ByteArrayInputStream byteArrayInputStream, int i, String str, String str2) {
        UpnpHeaders upnpHeaders = new UpnpHeaders(byteArrayInputStream);
        UpnpResponse upnpResponse = new UpnpResponse(i, str);
        upnpResponse.setHttpMinorVersion(str2.toUpperCase(Locale.ENGLISH).equals("HTTP/1.1") ? 1 : 0);
        IncomingDatagramMessage incomingDatagramMessage = new IncomingDatagramMessage(upnpResponse, datagramPacket.getAddress(), datagramPacket.getPort(), inetAddress);
        incomingDatagramMessage.setHeaders(upnpHeaders);
        return incomingDatagramMessage;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.jupnp.model.message.UpnpOperation] */
    @Override // org.jupnp.transport.spi.DatagramProcessor
    public DatagramPacket write(OutgoingDatagramMessage outgoingDatagramMessage) {
        StringBuilder sb = new StringBuilder();
        ?? operation = outgoingDatagramMessage.getOperation();
        if (operation instanceof UpnpRequest) {
            sb.append(((UpnpRequest) operation).getHttpMethodName());
            sb.append(" * HTTP/1.");
            sb.append(operation.getHttpMinorVersion());
            sb.append(HTTP.CRLF);
        } else {
            if (!(operation instanceof UpnpResponse)) {
                throw new UnsupportedDataException("Message operation is not request or response, don't know how to process: ".concat(String.valueOf(outgoingDatagramMessage)));
            }
            UpnpResponse upnpResponse = (UpnpResponse) operation;
            sb.append("HTTP/1.");
            sb.append(operation.getHttpMinorVersion());
            sb.append(" ");
            sb.append(upnpResponse.getStatusCode());
            sb.append(" ");
            sb.append(upnpResponse.getStatusMessage());
            sb.append(HTTP.CRLF);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) sb);
        sb2.append(outgoingDatagramMessage.getHeaders().toString());
        sb2.append(HTTP.CRLF);
        if (this.logger.n()) {
            this.logger.h("Writing message data for: {}", outgoingDatagramMessage);
            this.logger.y("---------------------------------------------------------------------------------");
            this.logger.y(sb2.substring(0, sb2.length() - 2));
            this.logger.y("---------------------------------------------------------------------------------");
        }
        byte[] bytes = sb2.toString().getBytes(StandardCharsets.US_ASCII);
        this.logger.i("Writing new datagram packet with {} bytes for: {}", Integer.valueOf(bytes.length), outgoingDatagramMessage);
        return new DatagramPacket(bytes, bytes.length, outgoingDatagramMessage.getDestinationAddress(), outgoingDatagramMessage.getDestinationPort());
    }
}

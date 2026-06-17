package org.jupnp.transport.impl;

import defpackage.j02;
import defpackage.n02;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PooledXmlProcessor {
    private final ConcurrentLinkedQueue<DocumentBuilder> builderPool;
    private final DocumentBuilderFactory documentBuilderFactory;
    private final transient j02 logger;
    private boolean reuseDocumentBuilders;

    public PooledXmlProcessor(int i) {
        j02 j02VarK = n02.k(PooledXmlProcessor.class);
        this.logger = j02VarK;
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        this.documentBuilderFactory = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        this.builderPool = new ConcurrentLinkedQueue<>();
        try {
            boolean zIsDocumentBuilderReusable = isDocumentBuilderReusable();
            this.reuseDocumentBuilders = zIsDocumentBuilderReusable;
            if (!zIsDocumentBuilderReusable) {
                j02VarK.b("Not adding instances to the pool because DocumentBuilders cannot be reused");
                return;
            }
            j02VarK.q("Adding {} instances to the pool because DocumentBuilders can be reused", Integer.valueOf(i));
            for (int i2 = 0; i2 < i; i2++) {
                this.builderPool.add(this.documentBuilderFactory.newDocumentBuilder());
            }
        } catch (ParserConfigurationException e) {
            this.logger.a("Error when invoking newDocumentBuilder()", e);
        }
    }

    private Document getDocument(InputSource inputSource, ErrorHandler errorHandler) throws ParserConfigurationException {
        DocumentBuilder documentBuilderPoll = this.reuseDocumentBuilders ? this.builderPool.poll() : null;
        if (documentBuilderPoll == null) {
            documentBuilderPoll = this.documentBuilderFactory.newDocumentBuilder();
        }
        if (errorHandler != null) {
            try {
                documentBuilderPoll.setErrorHandler(errorHandler);
            } catch (Throwable th) {
                returnBuilder(documentBuilderPoll);
                throw th;
            }
        }
        if (inputSource != null) {
            Document document = documentBuilderPoll.parse(inputSource);
            returnBuilder(documentBuilderPoll);
            return document;
        }
        Document documentNewDocument = documentBuilderPoll.newDocument();
        returnBuilder(documentBuilderPoll);
        return documentNewDocument;
    }

    private boolean isDocumentBuilderReusable() throws ParserConfigurationException {
        DocumentBuilder documentBuilderNewDocumentBuilder = this.documentBuilderFactory.newDocumentBuilder();
        documentBuilderNewDocumentBuilder.reset();
        return documentBuilderNewDocumentBuilder.isNamespaceAware();
    }

    private void returnBuilder(DocumentBuilder documentBuilder) {
        if (this.reuseDocumentBuilders) {
            documentBuilder.reset();
            this.builderPool.add(documentBuilder);
        }
    }

    public Document newDocument() {
        return getDocument(null, null);
    }

    public Document readDocument(InputSource inputSource) {
        return getDocument(inputSource, null);
    }

    public Document readDocument(InputSource inputSource, ErrorHandler errorHandler) {
        return getDocument(inputSource, errorHandler);
    }

    public PooledXmlProcessor() {
        this(20);
    }
}

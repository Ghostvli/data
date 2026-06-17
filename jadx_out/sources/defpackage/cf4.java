package defpackage;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cf4 extends hz1 {
    public static final UriMatcher j;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        j = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public cf4(ContentResolver contentResolver, Uri uri, boolean z) {
        super(contentResolver, uri, z);
    }

    @Override // defpackage.t90
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.hz1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // defpackage.hz1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public InputStream f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamJ = j(uri, contentResolver);
        if (inputStreamJ != null) {
            return inputStreamJ;
        }
        xe5.a("InputStream is null for ", uri);
        return null;
    }

    public final InputStream j(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = j.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return k(contentResolver, uri);
            }
            if (iMatch != 5) {
                return (this.f && kr2.d(uri) && kr2.c()) ? l(uri, contentResolver) : contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return k(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    public final InputStream k(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    public final InputStream l(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorH = kr2.h(uri, contentResolver);
        if (assetFileDescriptorH == null) {
            xe5.a("FileDescriptor is null for: ", uri);
            return null;
        }
        try {
            return assetFileDescriptorH.createInputStream();
        } catch (IOException e) {
            try {
                assetFileDescriptorH.close();
            } catch (Exception unused) {
            }
            throw ((FileNotFoundException) new FileNotFoundException("Unable to create stream").initCause(e));
        }
    }
}

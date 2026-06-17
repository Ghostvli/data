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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cf4(ContentResolver contentResolver, Uri uri, boolean z) {
        super(contentResolver, uri, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t90
    public Class a() {
        return InputStream.class;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(Ljava/lang/Object;)V */
    @Override // defpackage.hz1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: f(Landroid/net/Uri;Landroid/content/ContentResolver;)Ljava/lang/Object; */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final InputStream k(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

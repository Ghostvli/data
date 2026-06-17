package org.jupnp.support.model.container;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.jupnp.support.model.DIDLObject;
import org.jupnp.support.model.Person;
import org.jupnp.support.model.PersonWithRole;
import org.jupnp.support.model.item.Item;
import org.jupnp.support.model.item.MusicTrack;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MusicAlbum extends Album {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.container.album.musicAlbum");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MusicAlbum(String str, Container container, String str2, String str3, Integer num) {
        this(str, container.getId(), str2, str3, num, new ArrayList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void addMusicTracks(MusicTrack[] musicTrackArr) {
        if (musicTrackArr != null) {
            for (MusicTrack musicTrack : musicTrackArr) {
                musicTrack.setAlbum(getTitle());
                addItem(musicTrack);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI[] getAlbumArtURIs() {
        List propertyValues = getPropertyValues(DIDLObject.Property.UPNP.ALBUM_ART_URI.class);
        return (URI[]) propertyValues.toArray(new URI[propertyValues.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PersonWithRole[] getArtists() {
        List propertyValues = getPropertyValues(DIDLObject.Property.UPNP.ARTIST.class);
        return (PersonWithRole[]) propertyValues.toArray(new PersonWithRole[propertyValues.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getFirstAlbumArtURI() {
        return (URI) getFirstPropertyValue(DIDLObject.Property.UPNP.ALBUM_ART_URI.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PersonWithRole getFirstArtist() {
        return (PersonWithRole) getFirstPropertyValue(DIDLObject.Property.UPNP.ARTIST.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFirstGenre() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.GENRE.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Person getFirstProducer() {
        return (Person) getFirstPropertyValue(DIDLObject.Property.UPNP.PRODUCER.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String[] getGenres() {
        List propertyValues = getPropertyValues(DIDLObject.Property.UPNP.GENRE.class);
        return (String[]) propertyValues.toArray(new String[propertyValues.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MusicTrack[] getMusicTracks() {
        ArrayList arrayList = new ArrayList();
        for (Item item : getItems()) {
            if (item instanceof MusicTrack) {
                arrayList.add((MusicTrack) item);
            }
        }
        return (MusicTrack[]) arrayList.toArray(new MusicTrack[arrayList.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Person[] getProducers() {
        List propertyValues = getPropertyValues(DIDLObject.Property.UPNP.PRODUCER.class);
        return (Person[]) propertyValues.toArray(new Person[propertyValues.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getToc() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.TOC.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MusicAlbum setAlbumArtURIs(URI[] uriArr) {
        removeProperties(DIDLObject.Property.UPNP.ALBUM_ART_URI.class);
        for (URI uri : uriArr) {
            addProperty(new DIDLObject.Property.UPNP.ALBUM_ART_URI(uri));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MusicAlbum setArtists(PersonWithRole[] personWithRoleArr) {
        removeProperties(DIDLObject.Property.UPNP.ARTIST.class);
        for (PersonWithRole personWithRole : personWithRoleArr) {
            addProperty(new DIDLObject.Property.UPNP.ARTIST(personWithRole));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MusicAlbum setGenres(String[] strArr) {
        removeProperties(DIDLObject.Property.UPNP.GENRE.class);
        for (String str : strArr) {
            addProperty(new DIDLObject.Property.UPNP.GENRE(str));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MusicAlbum setProducers(Person[] personArr) {
        removeProperties(DIDLObject.Property.UPNP.PRODUCER.class);
        for (Person person : personArr) {
            addProperty(new DIDLObject.Property.UPNP.PRODUCER(person));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MusicAlbum setToc(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.TOC(str));
        return this;
    }

    public MusicAlbum(Container container) {
        super(container);
    }

    public MusicAlbum() {
        setClazz(CLASS);
    }

    public MusicAlbum(String str, Container container, String str2, String str3, Integer num, List<MusicTrack> list) {
        this(str, container.getId(), str2, str3, num, list);
    }

    public MusicAlbum(String str, String str2, String str3, String str4, Integer num) {
        this(str, str2, str3, str4, num, new ArrayList());
    }

    public void addMusicTracks(List<MusicTrack> list) {
        addMusicTracks((MusicTrack[]) list.toArray(new MusicTrack[list.size()]));
    }

    public MusicAlbum(String str, String str2, String str3, String str4, Integer num, List<MusicTrack> list) {
        super(str, str2, str3, str4, num);
        setClazz(CLASS);
        addMusicTracks(list);
    }
}

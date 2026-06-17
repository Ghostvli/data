package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class rf1 extends PackageManager {
    public final String a;
    public final String b;

    public rf1(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    @Override // android.content.pm.PackageManager
    public void addPackageToPreferred(String str) {
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermission(PermissionInfo permissionInfo) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermissionAsync(PermissionInfo permissionInfo) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
    }

    @Override // android.content.pm.PackageManager
    public boolean canRequestPackageInstalls() {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public String[] canonicalToCurrentPackageNames(String[] strArr) {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public int checkPermission(String str, String str2) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(String str, String str2) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public void clearInstantAppCookie() {
    }

    @Override // android.content.pm.PackageManager
    public void clearPackagePreferredActivities(String str) {
    }

    @Override // android.content.pm.PackageManager
    public String[] currentToCanonicalPackageNames(String[] strArr) {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public void extendVerificationTimeout(int i, int i2, long j) {
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(ComponentName componentName) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(ComponentName componentName) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getActivityInfo(ComponentName componentName, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(ComponentName componentName) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List getAllPermissionGroups(int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getApplicationEnabledSetting(String str) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ApplicationInfo getApplicationInfo(String str, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ChangedPackages getChangedPackages(int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getComponentEnabledSetting(ComponentName componentName) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDefaultActivityIcon() {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDrawable(String str, int i, ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List getInstalledApplications(int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List getInstalledPackages(int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public String getInstallerPackageName(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public byte[] getInstantAppCookie() {
        return new byte[0];
    }

    @Override // android.content.pm.PackageManager
    public int getInstantAppCookieMaxBytes() {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Intent getLaunchIntentForPackage(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Intent getLeanbackLaunchIntentForPackage(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public String getNameForUid(int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str) {
        return new int[0];
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(String str, int i) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.signatures = new Signature[]{new Signature(this.a)};
        return packageInfo;
    }

    @Override // android.content.pm.PackageManager
    public PackageInstaller getPackageInstaller() {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getPackageUid(String str, int i) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public String[] getPackagesForUid(int i) {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public List getPackagesHoldingPermissions(String[] strArr, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public PermissionGroupInfo getPermissionGroupInfo(String str, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public PermissionInfo getPermissionInfo(String str, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getPreferredActivities(List list, List list2, String str) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public List getPreferredPackages(int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo getProviderInfo(ComponentName componentName, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForActivity(ComponentName componentName) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ServiceInfo getServiceInfo(ComponentName componentName, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List getSharedLibraries(int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public FeatureInfo[] getSystemAvailableFeatures() {
        return new FeatureInfo[0];
    }

    @Override // android.content.pm.PackageManager
    public String[] getSystemSharedLibraryNames() {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getText(String str, int i, ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedDrawableForDensity(Drawable drawable, UserHandle userHandle, Rect rect, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedIcon(Drawable drawable, UserHandle userHandle) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getUserBadgedLabel(CharSequence charSequence, UserHandle userHandle) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public XmlResourceParser getXml(String str, int i, ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp() {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isPermissionRevokedByPolicy(String str, String str2) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isSafeMode() {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public List queryBroadcastReceivers(Intent intent, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List queryContentProviders(String str, int i, int i2) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List queryInstrumentation(String str, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List queryIntentActivities(Intent intent, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List queryIntentContentProviders(Intent intent, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List queryIntentServices(Intent intent, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List queryPermissionsByGroup(String str, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public void removePackageFromPreferred(String str) {
    }

    @Override // android.content.pm.PackageManager
    public void removePermission(String str) {
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveActivity(Intent intent, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo resolveContentProvider(String str, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveService(Intent intent, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationCategoryHint(String str, int i) {
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationEnabledSetting(String str, int i, int i2) {
    }

    @Override // android.content.pm.PackageManager
    public void setComponentEnabledSetting(ComponentName componentName, int i, int i2) {
    }

    @Override // android.content.pm.PackageManager
    public void setInstallerPackageName(String str, String str2) {
    }

    @Override // android.content.pm.PackageManager
    public void updateInstantAppCookie(byte[] bArr) {
    }

    @Override // android.content.pm.PackageManager
    public void verifyPendingInstall(int i, int i2) {
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(int i, int i2) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(Intent intent) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(Intent intent) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(Intent intent) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str, int i) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp(String str) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str, int i) {
        return new int[0];
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(VersionedPackage versionedPackage, int i) {
        return getPackageInfo(versionedPackage.getPackageName(), i);
    }
}

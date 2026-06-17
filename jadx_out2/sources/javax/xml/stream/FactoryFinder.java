package javax.xml.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class FactoryFinder {
    static /* synthetic */ Class class$javax$xml$stream$FactoryFinder;
    private static boolean debug;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class ClassLoaderFinder {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private ClassLoaderFinder() {
        }

        public abstract ClassLoader getContextClassLoader();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ClassLoaderFinderConcrete extends ClassLoaderFinder {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ClassLoaderFinderConcrete() {
            super();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // javax.xml.stream.FactoryFinder.ClassLoaderFinder
        public ClassLoader getContextClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        try {
            debug = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void debugPrintln(String str) {
        if (debug) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer("STREAM: ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object find(String str, String str2, ClassLoader classLoader) {
        try {
            String property = System.getProperty(str);
            if (property != null) {
                debugPrintln("found system property".concat(property));
                return newInstance(property, classLoader);
            }
        } catch (SecurityException unused) {
        }
        try {
            String property2 = System.getProperty("java.home");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(property2);
            String str3 = File.separator;
            stringBuffer.append(str3);
            stringBuffer.append("lib");
            stringBuffer.append(str3);
            stringBuffer.append("jaxp.properties");
            File file = new File(stringBuffer.toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property3 = properties.getProperty(str);
                if (property3 != null && property3.length() > 0) {
                    debugPrintln("found java.home property ".concat(property3));
                    return newInstance(property3, classLoader);
                }
            }
        } catch (Exception e) {
            if (debug) {
                e.printStackTrace();
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer("META-INF/services/");
        stringBuffer2.append(str);
        String string = stringBuffer2.toString();
        try {
            InputStream systemResourceAsStream = classLoader == null ? ClassLoader.getSystemResourceAsStream(string) : classLoader.getResourceAsStream(string);
            if (systemResourceAsStream != null) {
                StringBuffer stringBuffer3 = new StringBuffer("found ");
                stringBuffer3.append(string);
                debugPrintln(stringBuffer3.toString());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(systemResourceAsStream, "UTF-8"));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                if (line != null && !"".equals(line)) {
                    debugPrintln("loaded from services: ".concat(line));
                    return newInstance(line, classLoader);
                }
            }
        } catch (Exception e2) {
            if (debug) {
                e2.printStackTrace();
            }
        }
        if (str2 != null) {
            debugPrintln("loaded from fallback value: ".concat(str2));
            return newInstance(str2, classLoader);
        }
        StringBuffer stringBuffer4 = new StringBuffer("Provider for ");
        stringBuffer4.append(str);
        stringBuffer4.append(" cannot be found");
        throw new FactoryConfigurationError(stringBuffer4.toString(), (Exception) null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static ClassLoader findClassLoader() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Class clsClass$ = class$javax$xml$stream$FactoryFinder;
            if (clsClass$ == null) {
                clsClass$ = class$("javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$;
            }
            stringBuffer.append(clsClass$.getName());
            stringBuffer.append("$ClassLoaderFinderConcrete");
            return ((ClassLoaderFinder) Class.forName(stringBuffer.toString()).newInstance()).getContextClassLoader();
        } catch (ClassNotFoundException unused) {
            Class clsClass$2 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$2 == null) {
                clsClass$2 = class$("javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$2;
            }
            return clsClass$2.getClassLoader();
        } catch (Exception e) {
            throw new FactoryConfigurationError(e.toString(), e);
        } catch (LinkageError unused2) {
            Class clsClass$3 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$3 == null) {
                clsClass$3 = class$("javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$3;
            }
            return clsClass$3.getClassLoader();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object newInstance(String str, ClassLoader classLoader) {
        try {
            return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
        } catch (ClassNotFoundException e) {
            StringBuffer stringBuffer = new StringBuffer("Provider ");
            stringBuffer.append(str);
            stringBuffer.append(" not found");
            throw new FactoryConfigurationError(stringBuffer.toString(), e);
        } catch (Exception e2) {
            StringBuffer stringBuffer2 = new StringBuffer("Provider ");
            stringBuffer2.append(str);
            stringBuffer2.append(" could not be instantiated: ");
            stringBuffer2.append(e2);
            throw new FactoryConfigurationError(stringBuffer2.toString(), e2);
        }
    }

    public static Object find(String str, String str2) {
        return find(str, str2, findClassLoader());
    }

    public static Object find(String str) {
        return find(str, null);
    }
}

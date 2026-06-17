package org.jupnp.http;

import defpackage.j02;
import defpackage.n02;
import java.util.Enumeration;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RequestInfo {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void dumpRequestHeaders(long j, String str, HttpServletRequest httpServletRequest) {
        j02 j02VarK = n02.k(RequestInfo.class);
        j02VarK.info(str);
        dumpRequestString(j, httpServletRequest);
        Enumeration headerNames = httpServletRequest.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String str2 = (String) headerNames.nextElement();
                j02VarK.A("{}: {}", str2, httpServletRequest.getHeader(str2));
            }
        }
        j02VarK.info("----------------------------------------");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void dumpRequestString(long j, HttpServletRequest httpServletRequest) {
        n02.k(RequestInfo.class).info(getRequestInfoString(j, httpServletRequest));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getRequestFullURL(HttpServletRequest httpServletRequest) {
        String scheme = httpServletRequest.getScheme();
        String serverName = httpServletRequest.getServerName();
        int serverPort = httpServletRequest.getServerPort();
        String contextPath = httpServletRequest.getContextPath();
        String servletPath = httpServletRequest.getServletPath();
        String pathInfo = httpServletRequest.getPathInfo();
        String queryString = httpServletRequest.getQueryString();
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        sb.append(serverName);
        if (serverPort != 80 && serverPort != 443) {
            sb.append(":");
            sb.append(serverPort);
        }
        sb.append(contextPath);
        sb.append(servletPath);
        if (pathInfo != null) {
            sb.append(pathInfo);
        }
        if (queryString != null) {
            sb.append("?");
            sb.append(queryString);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getRequestInfoString(long j, HttpServletRequest httpServletRequest) {
        return String.format("%s %s %s %s %s %d", httpServletRequest.getMethod(), httpServletRequest.getRequestURI(), httpServletRequest.getProtocol(), httpServletRequest.getParameterMap(), httpServletRequest.getRemoteAddr(), Long.valueOf(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isAndroidBubbleUPnPRequest(String str) {
        return str != null && str.contains("BubbleUPnP");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isJRiverRequest(String str) {
        if (str != null) {
            return str.contains("J-River") || str.contains("J. River");
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isPS3Request(String str, String str2) {
        if (str == null || !str.contains("PLAYSTATION 3")) {
            return str2 != null && str2.contains("PLAYSTATION 3");
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isWMPRequest(String str) {
        return (str == null || !str.contains("Windows-Media-Player") || isJRiverRequest(str)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isXbox360AlbumArtRequest(HttpServletRequest httpServletRequest) {
        return "true".equals(httpServletRequest.getParameter("albumArt")) && isXbox360Request(httpServletRequest);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isXbox360Request(String str, String str2) {
        if (str == null || !(str.contains("Xbox") || str.contains("Xenon"))) {
            return str2 != null && str2.contains("Xbox");
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void reportClient(StringBuilder sb, HttpServletRequest httpServletRequest) {
        sb.append("Remote Address: ");
        sb.append(httpServletRequest.getRemoteAddr());
        sb.append("\n");
        if (!httpServletRequest.getRemoteAddr().equals(httpServletRequest.getRemoteHost())) {
            sb.append("Remote Host: ");
            sb.append(httpServletRequest.getRemoteHost());
            sb.append("\n");
        }
        sb.append("Remote Port: ");
        sb.append(httpServletRequest.getRemotePort());
        sb.append("\n");
        if (httpServletRequest.getRemoteUser() != null) {
            sb.append("Remote User: ");
            sb.append(httpServletRequest.getRemoteUser());
            sb.append("\n");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void reportCookies(StringBuilder sb, HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            sb.append("Cookies:\n");
            for (Cookie cookie : cookies) {
                sb.append("    ");
                sb.append(cookie.getName());
                sb.append(" = ");
                sb.append(cookie.getValue());
                sb.append('\n');
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void reportHeaders(StringBuilder sb, HttpServletRequest httpServletRequest) {
        Enumeration headerNames = httpServletRequest.getHeaderNames();
        if (headerNames != null && headerNames.hasMoreElements()) {
            sb.append("Headers:\n");
            while (headerNames.hasMoreElements()) {
                String str = (String) headerNames.nextElement();
                String header = httpServletRequest.getHeader(str);
                sb.append("    ");
                sb.append(str);
                sb.append(": ");
                sb.append(header);
                sb.append('\n');
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void reportParameters(StringBuilder sb, HttpServletRequest httpServletRequest) {
        Enumeration parameterNames = httpServletRequest.getParameterNames();
        if (parameterNames != null && parameterNames.hasMoreElements()) {
            sb.append("Parameters:\n");
            while (parameterNames.hasMoreElements()) {
                String str = (String) parameterNames.nextElement();
                String[] parameterValues = httpServletRequest.getParameterValues(str);
                if (parameterValues != null) {
                    for (String str2 : parameterValues) {
                        sb.append("    ");
                        sb.append(str);
                        sb.append(" = ");
                        sb.append(str2);
                        sb.append('\n');
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void reportRequest(StringBuilder sb, HttpServletRequest httpServletRequest) {
        sb.append("Request: ");
        sb.append(httpServletRequest.getMethod());
        sb.append(' ');
        sb.append(httpServletRequest.getRequestURL());
        String queryString = httpServletRequest.getQueryString();
        if (queryString != null) {
            sb.append('?');
            sb.append(queryString);
        }
        sb.append(" - ");
        String requestedSessionId = httpServletRequest.getRequestedSessionId();
        if (requestedSessionId != null) {
            sb.append("\nSession ID: ");
        }
        if (requestedSessionId == null) {
            sb.append("No Session");
            return;
        }
        if (!httpServletRequest.isRequestedSessionIdValid()) {
            sb.append("Invalid Session ID\n");
            return;
        }
        sb.append(requestedSessionId);
        sb.append(" (from ");
        if (httpServletRequest.isRequestedSessionIdFromCookie()) {
            sb.append("cookie)\n");
        } else if (httpServletRequest.isRequestedSessionIdFromURL()) {
            sb.append("url)\n");
        } else {
            sb.append("unknown)\n");
        }
    }

    public static boolean isJRiverRequest(HttpServletRequest httpServletRequest) {
        return isJRiverRequest(httpServletRequest.getHeader("User-Agent"));
    }

    public static boolean isPS3Request(HttpServletRequest httpServletRequest) {
        return isPS3Request(httpServletRequest.getHeader("User-Agent"), httpServletRequest.getHeader("X-AV-Client-Info"));
    }

    public static boolean isXbox360Request(HttpServletRequest httpServletRequest) {
        return isXbox360Request(httpServletRequest.getHeader("User-Agent"), httpServletRequest.getHeader("Server"));
    }

    public static void dumpRequestHeaders(long j, HttpServletRequest httpServletRequest) {
        dumpRequestHeaders(j, "REQUEST HEADERS", httpServletRequest);
    }
}

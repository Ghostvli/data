package com.github.catvod.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 对应 APK 的 zz1
 * 功能：日志导出（收集 crash log + logcat + app log → 写入文件）
 */
public class LogExport {

    public static File export(Context context) {
        return saveToFile(context, collectLogs(context));
    }

    private static String collectLogs(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("========== Log Export ==========\n");
        sb.append("Export Time: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date())).append("\n");
        sb.append("Device: ").append(Build.MANUFACTURER).append(" ").append(Build.MODEL).append("\n");
        sb.append("OS: Android ").append(Build.VERSION.RELEASE).append(" (SDK ").append(Build.VERSION.SDK_INT).append(")\n");
        sb.append("App Version: ").append(getVersionName(context)).append("\n\n");

        String crashLog = readFile(FileLogger.getCrashLogFile(context));
        if (!crashLog.isEmpty()) {
            sb.append("===== Crash Log =====\n");
            sb.append(crashLog).append("\n");
        }

        sb.append("===== Logcat =====\n");
        sb.append(collectLogcat());

        String appLog = readFile(FileLogger.getLatestAppLogFile(context));
        if (!appLog.isEmpty()) {
            sb.append("===== Switch Debug (last 500 lines) =====\n");
            sb.append(filterSwitchDebug(appLog)).append("\n");
            sb.append("===== Persisted App Log (truncated) =====\n");
            sb.append(filterAppLog(appLog)).append("\n");
        }
        return sb.toString();
    }

    private static String filterSwitchDebug(String appLog) {
        StringBuilder sb = new StringBuilder();
        String[] lines = appLog.split("\n");
        int count = 0;
        for (int i = lines.length - 1; i >= 0 && count < 500; i--) {
            String line = lines[i];
            if (line.contains("SWITCH_TEST") || line.contains("MPV_SWITCH")
                || line.contains("setMediaItem") || line.contains("stop() called")
                || line.contains("event START_FILE") || line.contains("event FILE_LOADED")
                || line.contains("event END_FILE") || line.contains("onRefresh called")
                || line.contains("getPlayer called") || line.contains("setPlayer result")
                || line.contains("start() state")) {
                sb.insert(0, line + "\n");
                count++;
            }
        }
        if (count == 0) sb.append("(no switch debug entries found)\n");
        return sb.toString();
    }

    private static String filterAppLog(String appLog) {
        StringBuilder sb = new StringBuilder();
        String[] lines = appLog.split("\n");
        for (String line : lines) {
            if (line.length() > 500) {
                sb.append(line.substring(0, 500)).append("...(truncated)\n");
            } else {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    private static String collectLogcat() {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t", "2000", "-v", "time", "*:W"});
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            boolean hasContent = false;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
                hasContent = true;
            }
            br.close();
            p.destroy();
            if (!hasContent) {
                sb.append("(No WARN/ERROR logcat entries)\n\n");
            }
        } catch (Exception e) {
            sb.append("Failed to collect logcat: ").append(e.getMessage()).append("\n");
        } finally {
            if (br != null) try { br.close(); } catch (Exception ignored) {}
        }

        sb.append("===== Logcat (app verbose, last 500) =====\n");
        BufferedReader br2 = null;
        try {
            Process p2 = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t", "500", "-v", "time", "-s",
                "SpiderDebug:V", "ZTESpider:V", "CTCSpider:V", "HWSpider:V",
                "JarLoader:V", "MpvEngine:V", "PlayerManager:V", "Proxy:V",
                "FileLogAdapter:V", "CrashActivity:V",
                "SWITCH_TEST:D", "MPV_SWITCH:D", "MpvPlayerEngine:D"});
            br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String line;
            while ((line = br2.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br2.close();
            p2.destroy();
        } catch (Exception e) {
            sb.append("Failed to collect app logcat: ").append(e.getMessage()).append("\n");
        } finally {
            if (br2 != null) try { br2.close(); } catch (Exception ignored) {}
        }
        return sb.toString();
    }

    private static File saveToFile(Context context, String content) {
        String filename = "tv_log_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".txt";
        try {
            File dir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            if (dir == null) dir = context.getFilesDir();
            if (!dir.exists()) dir.mkdirs();
            File file = new File(dir, filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes("UTF-8"));
            fos.close();
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    private static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "unknown";
        }
    }

    private static String readFile(File file) {
        if (file == null || !file.exists()) return "";
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
        } catch (Exception e) {
            sb.append("Failed to read: ").append(e.getMessage()).append("\n");
        }
        return sb.toString();
    }
}

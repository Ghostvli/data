package com.github.catvod.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 对应 APK 的 o01，实现 Orhanobut LogAdapter
 * 功能：文件日志写入 + 日志文件路径管理
 */
public class FileLogger implements com.orhanobut.logger.LogAdapter {

    private final File logFile;
    private final SimpleDateFormat dateFormat;
    private final Object lock = new Object();

    public FileLogger(Context context) {
        File logDir = getLogDir(context);
        this.logFile = new File(logDir, "app_log_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt");
        this.dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
        cleanOldLogs(logDir);
    }

    // Orhanobut LogAdapter.log(priority, tag, message)
    @Override
    public void log(int level, String tag, String message) {
        synchronized (lock) {
            try {
                if (logFile.length() > 52428800) return; // 50MB limit
                String levelStr;
                switch (level) {
                    case 2: levelStr = "V"; break;
                    case 3: levelStr = "D"; break;
                    case 4: levelStr = "I"; break;
                    case 5: levelStr = "W"; break;
                    case 6: levelStr = "E"; break;
                    default: levelStr = String.valueOf(level); break;
                }
                FileWriter fw = new FileWriter(logFile, true);
                fw.write(dateFormat.format(new Date()));
                fw.write(" ");
                fw.write(levelStr);
                fw.write("/");
                fw.write(tag != null ? tag : "TV");
                fw.write(": ");
                fw.write(message);
                fw.write("\n");
                fw.flush();
                fw.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public boolean isLoggable(int level, String tag) {
        return true;
    }

    // === static utility methods ===

    public static File getCrashLogFile(Context context) {
        return new File(getLogDir(context), "crash_log.txt");
    }

    public static File getLatestAppLogFile(Context context) {
        File[] files = getLogDir(context).listFiles();
        if (files == null) return null;
        File latest = null;
        long maxTime = 0;
        for (File f : files) {
            if (f.getName().startsWith("app_log_") && f.getName().endsWith(".txt") && f.lastModified() > maxTime) {
                maxTime = f.lastModified();
                latest = f;
            }
        }
        return latest;
    }

    public static File getLogDir(Context context) {
        File dir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (dir == null) dir = context.getFilesDir();
        File logDir = new File(dir, "app_logs");
        if (!logDir.exists()) logDir.mkdirs();
        return logDir;
    }

    public static void writeCrashLog(Context context, String crashInfo) {
        try {
            FileWriter fw = new FileWriter(getCrashLogFile(context), true);
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            fw.write("\n========== CRASH ==========\n");
            fw.write("Time: " + time + "\n");
            fw.write(crashInfo);
            fw.write("\n===========================\n");
            fw.flush();
            fw.close();
        } catch (IOException ignored) {
        }
    }

    private void cleanOldLogs(File logDir) {
        File[] files = logDir.listFiles();
        if (files == null) return;
        long expireTime = System.currentTimeMillis() - 259200000L; // 3 days
        for (File f : files) {
            if (f.getName().startsWith("app_log_") && f.getName().endsWith(".txt")) {
                try {
                    String dateStr = f.getName().replace("app_log_", "").replace(".txt", "");
                    if (new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).parse(dateStr).getTime() < expireTime) {
                        f.delete();
                    }
                } catch (Exception ignored) {
                }
            }
        }
    }
}

import re

path = '/Users/lichenglong/Desktop/fongmitv-release/jadx_out2/sources/com/github/catvod/utils/ZteNatPuncher.java'
with open(path, 'r', encoding='utf-8') as f:
    content = f.read()

# Fix package
content = content.replace('package com.github.catvod.utils;', 'package com.fongmi.android.tv.utils;')

# Remove imports
content = re.sub(r'import org\.json\.HTTP;\n?', '', content)
content = re.sub(r'import org\.jupnp\.model\.ServiceReference;\n?', '', content)
content = re.sub(r'import com\.hierynomus\.msdtyp\.FileTime;\n?', '', content)

# Fix constants
content = content.replace('HTTP.CRLF', '"\\r\\n"')
content = content.replace('ServiceReference.DELIMITER', '"/"')
content = content.replace('FileTime.NANO100_TO_MILLI', '10000')

# Fix jadx artifacts
content = re.sub(r'/\* JADX.*?\*/\n?', '', content)
content = re.sub(r'// from class:.*?\n?', '', content)

# Fix ?? Equals = ...
# First occurrence
content = content.replace('?? Equals = "SETUP".equals(str5);', 'boolean isSetup = "SETUP".equals(str5);')
content = content.replace('if (Equals != 0) {', 'if (isSetup) {')

# Fix ?? r4;
content = content.replace('?? r4;', 'String r4;')

# Fix the rest of Equals usages
# Usually jadx replaces variables with 'Equals' or 'obj'
# Let's just do simple replacements where Equals = "503"
content = content.replace('Equals = "503";', 'r4 = "503";')
content = content.replace('r4 = Equals;', '')
content = content.replace('Object obj = "503";', 'r4 = "503";')
content = content.replace('Equals = obj;', '')

# The method signature for lambda$start$0 etc needs to be public or properly scoped if accessed from lambda, 
# but they are inside the class so it's fine. Wait, jadx created `this.f.lambda$start$0();`. 
# We need to replace the explicit inner classes with proper lambdas.

content = re.sub(r'this\.acceptThread = new Thread\(new Runnable\(\) \{\s+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$start\$0\(\);\s+\}\s+\}, "ZTE-Proxy-Accept"\);', 
                 'this.acceptThread = new Thread(() -> lambda$start$0(), "ZTE-Proxy-Accept");', content)

content = re.sub(r'ZteNatPuncher\.this\.heartbeatThread = new Thread\(new Runnable\(\) \{\s+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startHeartbeatLoop\$3\(\);\s+\}\s+\}, "ZTE-NAT-Heartbeat"\);',
                 'ZteNatPuncher.this.heartbeatThread = new Thread(() -> lambda$startHeartbeatLoop$3(), "ZTE-NAT-Heartbeat");', content)

content = re.sub(r'Thread thread = new Thread\(new Runnable\(\) \{\s+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startRtpRelay\$2\(\);\s+\}\s+\}, "ZTE-RTP-Relay"\);',
                 'Thread thread = new Thread(() -> lambda$startRtpRelay$2(), "ZTE-RTP-Relay");', content)

content = re.sub(r'Thread thread = new Thread\(new Runnable\(\) \{\s+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startTransparentRelay\$0\(inputStream, outputStream2\);\s+\}\s+\}, "ZTE-Transparent-C2U"\);',
                 'Thread thread = new Thread(() -> lambda$startTransparentRelay$0(inputStream, outputStream2), "ZTE-Transparent-C2U");', content)

content = re.sub(r'Thread thread2 = new Thread\(new Runnable\(\) \{\s+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startTransparentRelay\$1\(inputStream2, outputStream\);\s+\}\s+\}, "ZTE-Transparent-U2C"\);',
                 'Thread thread2 = new Thread(() -> lambda$startTransparentRelay$1(inputStream2, outputStream), "ZTE-Transparent-U2C");', content)

content = content.replace('r4 = outputStream;', '')
content = content.replace('return buildRtspResponse(r4, "Proxy error: " + e.getMessage());', 'return buildRtspResponse(r4 != null ? r4 : "503", "Proxy error: " + e.getMessage());')

out_path = '/Users/lichenglong/Desktop/fongmitv-release/app/src/main/java/com/fongmi/android/tv/utils/ZteNatPuncher.java'
with open(out_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Saved to", out_path)

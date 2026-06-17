import re

path = '/Users/lichenglong/Desktop/fongmitv-release/app/src/main/java/com/fongmi/android/tv/utils/ZteNatPuncher.java'
with open(path, 'r', encoding='utf-8') as f:
    content = f.read()

# Fix the failed lambda replacements
content = re.sub(r'ZteNatPuncher\.this\.heartbeatThread = new Thread\(new Runnable\(\) \{[\s/A-Za-z:.*]+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startHeartbeatLoop\$3\(\);\s+\}\s+\}, "ZTE-NAT-Heartbeat"\);',
                 'ZteNatPuncher.this.heartbeatThread = new Thread(() -> lambda$startHeartbeatLoop$3(), "ZTE-NAT-Heartbeat");', content)

content = re.sub(r'Thread thread = new Thread\(new Runnable\(\) \{[\s/A-Za-z:.*]+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startRtpRelay\$2\(\);\s+\}\s+\}, "ZTE-RTP-Relay"\);',
                 'Thread thread = new Thread(() -> lambda$startRtpRelay$2(), "ZTE-RTP-Relay");', content)

content = re.sub(r'Thread thread = new Thread\(new Runnable\(\) \{[\s/A-Za-z:.*]+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startTransparentRelay\$0\(inputStream, outputStream2\);\s+\}\s+\}, "ZTE-Transparent-C2U"\);',
                 'Thread thread = new Thread(() -> lambda$startTransparentRelay$0(inputStream, outputStream2), "ZTE-Transparent-C2U");', content)

content = re.sub(r'Thread thread2 = new Thread\(new Runnable\(\) \{[\s/A-Za-z:.*]+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$startTransparentRelay\$1\(inputStream2, outputStream\);\s+\}\s+\}, "ZTE-Transparent-U2C"\);',
                 'Thread thread2 = new Thread(() -> lambda$startTransparentRelay$1(inputStream2, outputStream), "ZTE-Transparent-U2C");', content)

content = re.sub(r'this\.acceptThread = new Thread\(new Runnable\(\) \{[\s/A-Za-z:.*]+@Override // java\.lang\.Runnable\s+public final void run\(\) \{\s+this\.f\.lambda\$start\$0\(\);\s+\}\s+\}, "ZTE-Proxy-Accept"\);',
                 'this.acceptThread = new Thread(() -> lambda$start$0(), "ZTE-Proxy-Accept");', content)

# Clean up any remaining @Override // java.lang.Runnable that might cause issues, though they should be gone.
content = re.sub(r'@Override // java\.lang\.Runnable\s+public final void run\(\) \{', '', content)

with open(path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Fixed syntax")

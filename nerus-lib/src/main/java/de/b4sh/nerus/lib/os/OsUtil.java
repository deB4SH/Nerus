package de.b4sh.nerus.lib.os;

public class OsUtil implements IOperatingSystem {

    private final String os;

    public OsUtil() {
        this.os = System.getProperty("os.name");
    }

    public boolean isWindows() {
        return this.os.startsWith("Windows");
    }

    public boolean isUnix() {
        return this.os.startsWith("Linux");
    }
}

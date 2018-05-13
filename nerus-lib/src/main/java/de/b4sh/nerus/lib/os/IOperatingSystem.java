package de.b4sh.nerus.lib.os;

/**
 * The IOperatingSystem interface provides the minimal required functions for an OsUtil implementation.
 */
interface IOperatingSystem {

    /**
     * Checks if the underlying infrastructure is windows.
     *
     * @return true (on type windows detected) , false (something else)
     */
    boolean isWindows();

    /**
     * Checks if the underlying infrastructure is a unix based system.
     *
     * @return true (on type unix detected), false (something else)
     */
    boolean isUnix();

}

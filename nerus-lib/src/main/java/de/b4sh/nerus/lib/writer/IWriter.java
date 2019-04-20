package de.b4sh.nerus.lib.writer;

import java.io.File;

/**
 * The IWriter interface describes the baseset of functions that each writer inside the NERUS application should
 * provide.
 */
public interface IWriter {

    /**
     * Writes a bytearray to a desired file.
     * The standard implementation should append the information to the file.
     * Check back for specific notices inside the implemented writers if this behavior is overwritten.
     *
     * @param destination target to write data to
     * @param array       informations that should be appended to the file
     */
    void writeByteArray(File destination, byte[] array);
}

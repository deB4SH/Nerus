package de.b4sh.nerus.lib.writer;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The WriterImplementation enumerator provides a link between easy keys and the desired implemented writer.
 */
public enum WriterImplementation {
    NULLWRITER("null", NullWriter.class),
    BUFFEREDWRITER("buffered", BufferedWriter.class);

    private final String key;
    private final Class implementation;

    WriterImplementation(final String key, final Class implementation) {
        this.key = key;
        this.implementation = implementation;
    }

    /**
     * Get specific writer by given key. If key not found it returns null.
     *
     * @param key key to get writer
     * @return desired class of writer implementation or null
     */
    public static Class getClassByKey(final String key) {
        if (key == null) {
            Logger.getLogger(WriterImplementation.class.getName()).log(Level.WARNING, "Key for getClassByKey was null. Could not retrieve desired implementation.");
            return null;
        }
        final WriterImplementation desiredImplementation = Arrays.stream(WriterImplementation.values()).filter(impl -> impl.key.equals(key)).findFirst().orElse(null);
        if (desiredImplementation == null) {
            Logger.getLogger(WriterImplementation.class.getName()).log(Level.FINER, String.format("Could not find requested key %s in enum WriterImplementation", key));
            return null;
        }
        return desiredImplementation.getImplementation();
    }

    /**
     * Checks if the given key is a valid option for existing implementations.
     *
     * @param key key to check against
     * @return true on valid key, false on issue
     */
    public static boolean isKeyExisting(final String key) {
        return WriterImplementation.getClassByKey(key) != null;
    }

    public Class getImplementation() {
        return this.implementation;
    }
}

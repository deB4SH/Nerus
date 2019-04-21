package de.b4sh.nerus.lib.writer;

import java.io.File;

/**
 * NullWriter is a writer implementation that does nothing.
 * This implementation should provide a base line how fast a system can pass through without any real writing operation.
 */
final class NullWriter extends AbstractBaseWriter {

    /**
     * Public constructor with the next abstractWriter to chain to.
     *
     * @param next next writer to pass information to
     */
    NullWriter(final AbstractBaseWriter next) {
        super(next);
    }

    @Override
    public void writeByteArray(final File destination, final byte[] array) {
        //no real operation happens here
        if (this.getNext() != null) {
            this.getNext().writeByteArray(destination, array);
        }
    }
}

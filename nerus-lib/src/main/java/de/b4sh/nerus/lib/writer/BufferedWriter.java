package de.b4sh.nerus.lib.writer;

import java.io.File;

final class BufferedWriter extends AbstractBaseWriter {

    /**
     * @param next
     */
    public BufferedWriter(final AbstractBaseWriter next) {
        super(next);
    }

    @Override
    public void writeByteArray(final File destination, final byte[] array) {

        //pass data to the next writer if existing
        if (this.getNext() != null) {
            this.getNext().writeByteArray(destination, array);
        }
    }
}

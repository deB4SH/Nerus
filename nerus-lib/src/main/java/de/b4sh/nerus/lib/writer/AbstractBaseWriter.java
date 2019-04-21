package de.b4sh.nerus.lib.writer;

abstract class AbstractBaseWriter implements IWriter {

    final AbstractBaseWriter next;

    /**
     * @param next
     */
    public AbstractBaseWriter(final AbstractBaseWriter next) {
        this.next = next;
    }

    public AbstractBaseWriter getNext() {
        return this.next;
    }


}

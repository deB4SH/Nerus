package de.b4sh.nerus.lib.writer;

import org.junit.Assert;
import org.junit.Test;

public class WriterImplementationTest {

    @Test
    public void getImplementation() {
        final Class impl = WriterImplementation.NULLWRITER.getImplementation();
        Assert.assertNotNull(impl);
    }

    @Test
    public void getClassByKeyKnownKey() {
        final Class impl = WriterImplementation.getClassByKey("null");
        Assert.assertNotNull(impl);
    }

    @Test
    public void getClassByKeyUnknownKey() {
        final Class impl = WriterImplementation.getClassByKey("unknown");
        Assert.assertNull(impl);
    }

    @Test
    public void getClassByKeyNullParameter() {
        final Class impl = WriterImplementation.getClassByKey(null);
        Assert.assertNull(impl);
    }
}
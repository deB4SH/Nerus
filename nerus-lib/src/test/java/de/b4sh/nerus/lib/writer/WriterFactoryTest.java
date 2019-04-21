package de.b4sh.nerus.lib.writer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WriterFactoryTest {
    static final String[] param = new String[2];

    @BeforeClass
    public static void setUpEnvironment() {
        WriterFactoryTest.param[0] = "buffered";
        WriterFactoryTest.param[1] = "null";
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructWriterChain() {
        final IWriter writer = WriterFactory.constructWriterChain(WriterFactoryTest.param);
        Assert.assertNotNull(writer);

    }
}
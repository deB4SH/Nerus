package de.b4sh.nerus.lib.writer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WriterFactoryTest {
    static final String[] param = new String[2];

    @BeforeClass
    public static void setUpEnvironment() {
        WriterFactoryTest.param[0] = "buffered";
        WriterFactoryTest.param[1] = "null";
    }

    @Test
    public void constructWriterChain() {
        final IWriter writer = WriterFactory.constructWriterChain(WriterFactoryTest.param);
        Assert.assertNotNull(writer);
        Assert.assertEquals(writer.getClass(), BufferedWriter.class);
        Assert.assertEquals(((AbstractBaseWriter) writer).getNext().getClass(), NullWriter.class);
    }

    @Test
    public void constructWriterChainWithIssueKey() {
        final String[] issueList = new String[3];
        issueList[0] = "buffered";
        issueList[1] = "buffered";
        issueList[2] = "foo";
        final IWriter writer = WriterFactory.constructWriterChain(issueList);
        Assert.assertNull(writer);
    }

    @Test
    public void constructWriterChainWithIssueKeyNullParameter() {
        final String[] issueList = new String[3];
        issueList[0] = "buffered";
        issueList[1] = "buffered";
        issueList[2] = null;
        final IWriter writer = WriterFactory.constructWriterChain(issueList);
        Assert.assertNull(writer);
    }

    @Test
    public void constructWriterChainNullPass() {
        final IWriter writer = WriterFactory.constructWriterChain(null);
        Assert.assertNull(writer);
    }
}
package de.b4sh.nerus.lib.writer;

import de.b4sh.nerus.lib.generator.RandomByteArrayGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

public class NullWriterTest {

    private static RandomByteArrayGenerator randomByteArrayGenerator;
    private NullWriter unit;

    @BeforeClass
    public static void createTestClass() {
        NullWriterTest.randomByteArrayGenerator = new RandomByteArrayGenerator();
    }

    @Before
    public void setUp() throws Exception {
        this.unit = new NullWriter();
    }

    @After
    public void tearDown() throws Exception {
        this.unit = null;
    }

    @Test
    public void writeByteArray() {
        this.unit.writeByteArray(new File("target/writer/Nullwriter.file"), NullWriterTest.randomByteArrayGenerator.generateArray(100));
    }
}
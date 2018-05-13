package de.b4sh.nerus.lib.generator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecureRandomByteArrayGeneratorTest {

    private IByteArrayGenerator generator;

    @Before
    public void setUp() throws Exception {
        this.generator = new SecureRandomByteArrayGenerator();
    }

    @After
    public void tearDown() throws Exception {
        this.generator = null;
    }

    @Test
    public void testGenerateArray() {
        Assert.assertNotNull(this.generator);
        final byte[] result = this.generator.generateArray(1024);
        Assert.assertNotNull(result);
        Assert.assertEquals(1024, result.length);
    }

    @Test
    public void testGenerateArrayShorthand() {
        Assert.assertNotNull(this.generator);
        final byte[] result = this.generator.generateArray();
        Assert.assertNotNull(result);
        Assert.assertEquals(1024, result.length);
    }

    @Test
    public void testGenerateArrayWithZerroSize() {
        Assert.assertNotNull(this.generator);
        final byte[] result = this.generator.generateArray(0);
        Assert.assertNull(result);
    }
}
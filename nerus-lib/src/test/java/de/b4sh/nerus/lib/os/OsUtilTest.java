package de.b4sh.nerus.lib.os;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a semi accurate test and needs to be done on multiple environments.
 */
public class OsUtilTest {

    private OsUtil osUtil;

    @Before
    public void setUp() {
        this.osUtil = new OsUtil();
    }

    @After
    public void tearDown() {
        this.osUtil = null;
    }

    @Test
    public void isWindows() {
        if (this.osUtil.isWindows()) {
            Assert.assertEquals(true, this.osUtil.isWindows());
            Assert.assertEquals(false, this.osUtil.isUnix());
        }
    }

    @Test
    public void isUnix() {
        if (this.osUtil.isUnix()) {
            Assert.assertEquals(false, this.osUtil.isWindows());
            Assert.assertEquals(true, this.osUtil.isUnix());
        }
    }
}
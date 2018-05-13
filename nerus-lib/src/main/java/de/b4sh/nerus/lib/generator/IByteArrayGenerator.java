package de.b4sh.nerus.lib.generator;

public interface IByteArrayGenerator {

    /**
     * Generates a byte array with given length.
     *
     * @param legnth length to generate
     * @return an instanced byte array
     */
    byte[] generateArray(int legnth);

    /**
     * Shorthand function to generate a byte array with a predefined length of 1024.
     *
     * @return an instanced byte array with a length of 1024
     */
    byte[] generateArray();

}

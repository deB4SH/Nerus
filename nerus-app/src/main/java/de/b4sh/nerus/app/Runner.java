package de.b4sh.nerus.app;

public final class Runner {

    public static boolean keepAlive;

    public static void main(final String[] args) {
        final Nerus nerus = new Nerus();
        while (Runner.keepAlive) {
            //Nop
        }
    }

}

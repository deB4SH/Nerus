package de.b4sh.nerus.app.ws;

public final class SocketEndpoint {

    private final WSocket server;


    public SocketEndpoint(final int servicePort) {
        this.server = new WSocket(servicePort);
    }
}

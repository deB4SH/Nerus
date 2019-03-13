package de.b4sh.nerus.app;

import de.b4sh.nerus.app.ws.SocketEndpoint;

public final class Nerus {

    private final SocketEndpoint socketEndpoint;

    public Nerus() {
        this.socketEndpoint = new SocketEndpoint(8081);
    }

}

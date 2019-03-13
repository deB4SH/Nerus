package de.b4sh.nerus.app.ws;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * WSocket extends the WebSocketServer class from the provided lib Java-Websocket.
 */
public final class WSocket extends WebSocketServer {

    private final static Logger log = Logger.getLogger(WSocket.class.getName());

    WSocket(final int servicePort) {
        super(new InetSocketAddress(servicePort));
    }

    @Override
    public void onOpen(final WebSocket webSocket, final ClientHandshake clientHandshake) {
        WSocket.log.log(Level.INFO, String.format("New Socket opened from %s. ", webSocket.getLocalSocketAddress()
                .getAddress()));
    }

    @Override
    public void onClose(final WebSocket webSocket, final int i, final String s, final boolean b) {
        WSocket.log.log(Level.INFO, String.format("Socket closed from connection %s", webSocket.getLocalSocketAddress
                ().getAddress()));
    }

    @Override
    public void onMessage(final WebSocket webSocket, final String s) {

    }

    @Override
    public void onError(final WebSocket webSocket, final Exception e) {

    }

    @Override
    public void onStart() {

    }
}

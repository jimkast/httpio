package org.jimkast;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Nio2SocketServer implements Runnable {
    private final AsynchronousServerSocketChannel socket;

    public Nio2SocketServer(int port) throws IOException {
        this(AsynchronousServerSocketChannel.open(), port);
    }

    public Nio2SocketServer(AsynchronousServerSocketChannel socket, int port) throws IOException {
        this.socket = socket;
        socket.bind(new InetSocketAddress(port));
    }

    public Nio2SocketServer(AsynchronousServerSocketChannel socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        socket.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel ch, Void att) {
                // Accept the next connection
                socket.accept(null, this);

                // Greet the client
//                    ch.write(ByteBuffer.wrap("Hello, I am Echo Server 2020, let's have an engaging conversation!\n".getBytes()));

                // Allocate a byte buffer (4K) to read from the client
                ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
                try {
                    // Read the first line
                    int bytesRead = ch.read(byteBuffer).get();

                    boolean running = true;
                    while (bytesRead != -1 && running) {
                        System.out.println("bytes read: " + bytesRead);

                        // Make sure that we have data to read
                        if (byteBuffer.position() > 2) {
                            // Make the buffer ready to read
                            byteBuffer.flip();

                            // Convert the buffer into a line
                            byte[] lineBytes = new byte[bytesRead];
                            byteBuffer.get(lineBytes, 0, bytesRead);
                            String line = new String(lineBytes);

                            // Debug
                            System.out.println("Message: " + line);

                            // Echo back to the caller
                            byte[] bytes = line.getBytes();
                            ch.write(ByteBuffer.wrap(("HTTP/1.1 200 OK\r\n\r\nContent-Length:3" + bytes.length + "\r\n\r\naaa").getBytes()));

                            // Make the buffer ready to write
                            byteBuffer.clear();

                            // Read the next line
                            bytesRead = ch.read(byteBuffer).get(20, TimeUnit.SECONDS);
                        } else {
                            // An empty line signifies the end of the conversation in our protocol
                            running = false;
                        }
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    // The user exceeded the 20 second timeout, so close the connection
                    ch.write(ByteBuffer.wrap("Good Bye\n".getBytes()));
                    System.out.println("Connection timed out, closing connection");
                }

                System.out.println("End of conversation");
                try {
                    // Close the connection if we need to
                    if (ch.isOpen()) {
                        ch.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void att) {
                ///...
            }
        });
    }
}
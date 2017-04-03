package com.daocheng.master.book;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;


public class BookMasterServer {
    private static final Logger logger = LoggerFactory.getLogger(BookMasterServer.class.getName());

    private Server server;

    private void start() throws IOException {

    /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new BookServiceImpl())
                .build()
                .start();


        logger.info("Server started, listening on " + port);

        ConsulClient client = new ConsulClient("localhost");

        NewService newService = new NewService();
        newService.setId("book_master_1");
        newService.setTags(Collections.singletonList("static"));
        newService.setName("book_master");
        newService.setPort(port);

        NewService.Check serviceCheck = new NewService.Check();
        serviceCheck.setScript("ping");
        serviceCheck.setInterval("10s");
        newService.setCheck(serviceCheck);

        client.agentServiceRegister(newService);

        logger.info("book_master services been registered");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                BookMasterServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }



    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final BookMasterServer server = new BookMasterServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {

        @Override
        public void getBook(GetBookRequest req, StreamObserver<Book> responseObserver) {
            Book book = Book.newBuilder().setName("GBL_CNY_CN").build();
            responseObserver.onNext(book);
            responseObserver.onCompleted();
        }
    }
}

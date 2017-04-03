package com.daocheng.master.client;

import com.daocheng.master.book.Book;
import com.daocheng.master.book.BookMasterServer;
import com.daocheng.master.book.BookServiceGrpc;
import com.daocheng.master.book.GetBookRequest;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;


/**
 * Created by Lenovo on 2017/3/30.
 */
public class ClientMasterServer {
    private static final Logger logger = LoggerFactory.getLogger(ClientMasterServer.class.getName());

    private Server server;

    private void start() throws IOException {
    /* The port on which the server should run */
        int port = 50052;
        server = ServerBuilder.forPort(port)
                .addService(new ClientMasterServer.ClientServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);

        ConsulClient client = new ConsulClient("localhost");

        NewService newService = new NewService();
        newService.setId("client_master_1");
        newService.setTags(Collections.singletonList("static"));
        newService.setName("client_master");
        newService.setPort(port);

        NewService.Check serviceCheck = new NewService.Check();
        serviceCheck.setScript("ping");
        serviceCheck.setInterval("10s");
        newService.setCheck(serviceCheck);

        client.agentServiceRegister(newService);

        logger.info("client_master services been registered");

        // Client of Book Master

        ManagedChannel channel;
        BookServiceGrpc.BookServiceBlockingStub blockingStub;

        //TODO: to replace this with Consul services lookup.
        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext(true);

        channel = channelBuilder.build();
        blockingStub = BookServiceGrpc.newBlockingStub(channel);

        GetBookRequest request = GetBookRequest.newBuilder().setName("GBL_CNY_CN").build();
        Book response;
        try {
            response = blockingStub.getBook(request);
        } catch (StatusRuntimeException e) {
            logger.error(e.getMessage());
            return;
        }
        logger.info("Response: " + response.getName());
        

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                ClientMasterServer.this.stop();
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
        final ClientMasterServer server = new ClientMasterServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class ClientServiceImpl extends ClientServiceGrpc.ClientServiceImplBase {

        @Override
        public void getClient(GetClientRequest req, StreamObserver<Client> responseObserver) {
            Client client = Client.newBuilder().setName("GBL_CNY_CN").build();
            responseObserver.onNext(client);
            responseObserver.onCompleted();
        }
    }
}

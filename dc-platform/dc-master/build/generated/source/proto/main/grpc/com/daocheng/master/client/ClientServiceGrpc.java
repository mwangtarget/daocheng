package com.daocheng.master.client;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: ClientMaster.proto")
public final class ClientServiceGrpc {

  private ClientServiceGrpc() {}

  public static final String SERVICE_NAME = "ClientService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.client.GetClientRequest,
      com.daocheng.master.client.Client> METHOD_GET_CLIENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "ClientService", "GetClient"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.client.GetClientRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.client.Client.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.client.CreateClientRequest,
      com.daocheng.master.client.Client> METHOD_CREATE_CLIENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "ClientService", "CreateClient"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.client.CreateClientRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.client.Client.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientServiceStub newStub(io.grpc.Channel channel) {
    return new ClientServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ClientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public void getClient(com.daocheng.master.client.GetClientRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.client.Client> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CLIENT, responseObserver);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *            //TODO: check the syntax !
     *            post: "/v1/entities/{parent=desks/&#42;}/books"
     *            body: "book"
     *        };
     * </pre>
     */
    public void createClient(com.daocheng.master.client.CreateClientRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.client.Client> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_CLIENT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_CLIENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.client.GetClientRequest,
                com.daocheng.master.client.Client>(
                  this, METHODID_GET_CLIENT)))
          .addMethod(
            METHOD_CREATE_CLIENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.client.CreateClientRequest,
                com.daocheng.master.client.Client>(
                  this, METHODID_CREATE_CLIENT)))
          .build();
    }
  }

  /**
   */
  public static final class ClientServiceStub extends io.grpc.stub.AbstractStub<ClientServiceStub> {
    private ClientServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public void getClient(com.daocheng.master.client.GetClientRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.client.Client> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CLIENT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *            //TODO: check the syntax !
     *            post: "/v1/entities/{parent=desks/&#42;}/books"
     *            body: "book"
     *        };
     * </pre>
     */
    public void createClient(com.daocheng.master.client.CreateClientRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.client.Client> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_CLIENT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientServiceBlockingStub> {
    private ClientServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public com.daocheng.master.client.Client getClient(com.daocheng.master.client.GetClientRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CLIENT, getCallOptions(), request);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *            //TODO: check the syntax !
     *            post: "/v1/entities/{parent=desks/&#42;}/books"
     *            body: "book"
     *        };
     * </pre>
     */
    public com.daocheng.master.client.Client createClient(com.daocheng.master.client.CreateClientRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_CLIENT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientServiceFutureStub extends io.grpc.stub.AbstractStub<ClientServiceFutureStub> {
    private ClientServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.client.Client> getClient(
        com.daocheng.master.client.GetClientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CLIENT, getCallOptions()), request);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *            //TODO: check the syntax !
     *            post: "/v1/entities/{parent=desks/&#42;}/books"
     *            body: "book"
     *        };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.client.Client> createClient(
        com.daocheng.master.client.CreateClientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_CLIENT, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CLIENT = 0;
  private static final int METHODID_CREATE_CLIENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CLIENT:
          serviceImpl.getClient((com.daocheng.master.client.GetClientRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.client.Client>) responseObserver);
          break;
        case METHODID_CREATE_CLIENT:
          serviceImpl.createClient((com.daocheng.master.client.CreateClientRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.client.Client>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ClientServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.daocheng.master.client.ClientMaster.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ClientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientServiceDescriptorSupplier())
              .addMethod(METHOD_GET_CLIENT)
              .addMethod(METHOD_CREATE_CLIENT)
              .build();
        }
      }
    }
    return result;
  }
}

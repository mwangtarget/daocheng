package com.daocheng.master.book;

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
    comments = "Source: BookMaster.proto")
public final class DeskServiceGrpc {

  private DeskServiceGrpc() {}

  public static final String SERVICE_NAME = "DeskService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.book.GetDeskRequest,
      com.daocheng.master.book.Desk> METHOD_GET_DESK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "DeskService", "GetDesk"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.GetDeskRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.Desk.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.book.CreateDeskRequest,
      com.daocheng.master.book.Desk> METHOD_CREATE_DESK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "DeskService", "CreateDesk"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.CreateDeskRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.Desk.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeskServiceStub newStub(io.grpc.Channel channel) {
    return new DeskServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeskServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeskServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static DeskServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeskServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DeskServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *        option (google.api.http) = {
     *             get: "/v1/{name=entities/&#42;&#47;desks/&#42;}"
     *        };
     * </pre>
     */
    public void getDesk(com.daocheng.master.book.GetDeskRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Desk> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DESK, responseObserver);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/{parent=entities/&#42;}/desks"
     *            body: "desk"
     *        };
     * </pre>
     */
    public void createDesk(com.daocheng.master.book.CreateDeskRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Desk> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_DESK, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_DESK,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.book.GetDeskRequest,
                com.daocheng.master.book.Desk>(
                  this, METHODID_GET_DESK)))
          .addMethod(
            METHOD_CREATE_DESK,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.book.CreateDeskRequest,
                com.daocheng.master.book.Desk>(
                  this, METHODID_CREATE_DESK)))
          .build();
    }
  }

  /**
   */
  public static final class DeskServiceStub extends io.grpc.stub.AbstractStub<DeskServiceStub> {
    private DeskServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeskServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeskServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeskServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *             get: "/v1/{name=entities/&#42;&#47;desks/&#42;}"
     *        };
     * </pre>
     */
    public void getDesk(com.daocheng.master.book.GetDeskRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Desk> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DESK, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/{parent=entities/&#42;}/desks"
     *            body: "desk"
     *        };
     * </pre>
     */
    public void createDesk(com.daocheng.master.book.CreateDeskRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Desk> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_DESK, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeskServiceBlockingStub extends io.grpc.stub.AbstractStub<DeskServiceBlockingStub> {
    private DeskServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeskServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeskServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeskServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *             get: "/v1/{name=entities/&#42;&#47;desks/&#42;}"
     *        };
     * </pre>
     */
    public com.daocheng.master.book.Desk getDesk(com.daocheng.master.book.GetDeskRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DESK, getCallOptions(), request);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/{parent=entities/&#42;}/desks"
     *            body: "desk"
     *        };
     * </pre>
     */
    public com.daocheng.master.book.Desk createDesk(com.daocheng.master.book.CreateDeskRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_DESK, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeskServiceFutureStub extends io.grpc.stub.AbstractStub<DeskServiceFutureStub> {
    private DeskServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeskServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeskServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeskServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *             get: "/v1/{name=entities/&#42;&#47;desks/&#42;}"
     *        };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.book.Desk> getDesk(
        com.daocheng.master.book.GetDeskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DESK, getCallOptions()), request);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/{parent=entities/&#42;}/desks"
     *            body: "desk"
     *        };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.book.Desk> createDesk(
        com.daocheng.master.book.CreateDeskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_DESK, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DESK = 0;
  private static final int METHODID_CREATE_DESK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeskServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeskServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DESK:
          serviceImpl.getDesk((com.daocheng.master.book.GetDeskRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.book.Desk>) responseObserver);
          break;
        case METHODID_CREATE_DESK:
          serviceImpl.createDesk((com.daocheng.master.book.CreateDeskRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.book.Desk>) responseObserver);
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

  private static final class DeskServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.daocheng.master.book.BookMaster.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DeskServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeskServiceDescriptorSupplier())
              .addMethod(METHOD_GET_DESK)
              .addMethod(METHOD_CREATE_DESK)
              .build();
        }
      }
    }
    return result;
  }
}

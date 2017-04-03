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
public final class EntityServiceGrpc {

  private EntityServiceGrpc() {}

  public static final String SERVICE_NAME = "EntityService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.book.GetEntityRequest,
      com.daocheng.master.book.Entity> METHOD_GET_ENTITY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "EntityService", "GetEntity"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.GetEntityRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.Entity.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.book.CreateEntityRequest,
      com.daocheng.master.book.Entity> METHOD_CREATE_ENTITY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "EntityService", "CreateEntity"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.CreateEntityRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.Entity.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EntityServiceStub newStub(io.grpc.Channel channel) {
    return new EntityServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EntityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EntityServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static EntityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EntityServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EntityServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *        option (google.api.http) = {
     *              get: "/v1/{name=entities/&#42;}"
     *        };
     * </pre>
     */
    public void getEntity(com.daocheng.master.book.GetEntityRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Entity> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ENTITY, responseObserver);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/entities"
     *            body: "entity"
     *        };
     * </pre>
     */
    public void createEntity(com.daocheng.master.book.CreateEntityRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Entity> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_ENTITY, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ENTITY,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.book.GetEntityRequest,
                com.daocheng.master.book.Entity>(
                  this, METHODID_GET_ENTITY)))
          .addMethod(
            METHOD_CREATE_ENTITY,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.book.CreateEntityRequest,
                com.daocheng.master.book.Entity>(
                  this, METHODID_CREATE_ENTITY)))
          .build();
    }
  }

  /**
   */
  public static final class EntityServiceStub extends io.grpc.stub.AbstractStub<EntityServiceStub> {
    private EntityServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntityServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntityServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *              get: "/v1/{name=entities/&#42;}"
     *        };
     * </pre>
     */
    public void getEntity(com.daocheng.master.book.GetEntityRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Entity> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ENTITY, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/entities"
     *            body: "entity"
     *        };
     * </pre>
     */
    public void createEntity(com.daocheng.master.book.CreateEntityRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Entity> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_ENTITY, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EntityServiceBlockingStub extends io.grpc.stub.AbstractStub<EntityServiceBlockingStub> {
    private EntityServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntityServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntityServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *              get: "/v1/{name=entities/&#42;}"
     *        };
     * </pre>
     */
    public com.daocheng.master.book.Entity getEntity(com.daocheng.master.book.GetEntityRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ENTITY, getCallOptions(), request);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/entities"
     *            body: "entity"
     *        };
     * </pre>
     */
    public com.daocheng.master.book.Entity createEntity(com.daocheng.master.book.CreateEntityRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_ENTITY, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EntityServiceFutureStub extends io.grpc.stub.AbstractStub<EntityServiceFutureStub> {
    private EntityServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EntityServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EntityServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EntityServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *              get: "/v1/{name=entities/&#42;}"
     *        };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.book.Entity> getEntity(
        com.daocheng.master.book.GetEntityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ENTITY, getCallOptions()), request);
    }

    /**
     * <pre>
     *        option (google.api.http) = {
     *            post: "/v1/entities"
     *            body: "entity"
     *        };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.book.Entity> createEntity(
        com.daocheng.master.book.CreateEntityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_ENTITY, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ENTITY = 0;
  private static final int METHODID_CREATE_ENTITY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EntityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EntityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ENTITY:
          serviceImpl.getEntity((com.daocheng.master.book.GetEntityRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.book.Entity>) responseObserver);
          break;
        case METHODID_CREATE_ENTITY:
          serviceImpl.createEntity((com.daocheng.master.book.CreateEntityRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.book.Entity>) responseObserver);
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

  private static final class EntityServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.daocheng.master.book.BookMaster.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EntityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EntityServiceDescriptorSupplier())
              .addMethod(METHOD_GET_ENTITY)
              .addMethod(METHOD_CREATE_ENTITY)
              .build();
        }
      }
    }
    return result;
  }
}

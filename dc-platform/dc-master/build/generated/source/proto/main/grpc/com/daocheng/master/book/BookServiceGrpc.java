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
public final class BookServiceGrpc {

  private BookServiceGrpc() {}

  public static final String SERVICE_NAME = "BookService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.book.GetBookRequest,
      com.daocheng.master.book.Book> METHOD_GET_BOOK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "BookService", "GetBook"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.GetBookRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.Book.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.daocheng.master.book.CreateBookRequest,
      com.daocheng.master.book.Book> METHOD_CREATE_BOOK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "BookService", "CreateBook"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.CreateBookRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.daocheng.master.book.Book.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookServiceStub newStub(io.grpc.Channel channel) {
    return new BookServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static BookServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BookServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public void getBook(com.daocheng.master.book.GetBookRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Book> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BOOK, responseObserver);
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
    public void createBook(com.daocheng.master.book.CreateBookRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Book> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_BOOK, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_BOOK,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.book.GetBookRequest,
                com.daocheng.master.book.Book>(
                  this, METHODID_GET_BOOK)))
          .addMethod(
            METHOD_CREATE_BOOK,
            asyncUnaryCall(
              new MethodHandlers<
                com.daocheng.master.book.CreateBookRequest,
                com.daocheng.master.book.Book>(
                  this, METHODID_CREATE_BOOK)))
          .build();
    }
  }

  /**
   */
  public static final class BookServiceStub extends io.grpc.stub.AbstractStub<BookServiceStub> {
    private BookServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public void getBook(com.daocheng.master.book.GetBookRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Book> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BOOK, getCallOptions()), request, responseObserver);
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
    public void createBook(com.daocheng.master.book.CreateBookRequest request,
        io.grpc.stub.StreamObserver<com.daocheng.master.book.Book> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_BOOK, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookServiceBlockingStub extends io.grpc.stub.AbstractStub<BookServiceBlockingStub> {
    private BookServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public com.daocheng.master.book.Book getBook(com.daocheng.master.book.GetBookRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BOOK, getCallOptions(), request);
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
    public com.daocheng.master.book.Book createBook(com.daocheng.master.book.CreateBookRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_BOOK, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookServiceFutureStub extends io.grpc.stub.AbstractStub<BookServiceFutureStub> {
    private BookServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *         option (google.api.http) = {
     *               get: "/v1/{name=entities/&#42;&#47;desks/&#42;&#47;books/}"
     *        };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.book.Book> getBook(
        com.daocheng.master.book.GetBookRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BOOK, getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.daocheng.master.book.Book> createBook(
        com.daocheng.master.book.CreateBookRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_BOOK, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BOOK = 0;
  private static final int METHODID_CREATE_BOOK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BOOK:
          serviceImpl.getBook((com.daocheng.master.book.GetBookRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.book.Book>) responseObserver);
          break;
        case METHODID_CREATE_BOOK:
          serviceImpl.createBook((com.daocheng.master.book.CreateBookRequest) request,
              (io.grpc.stub.StreamObserver<com.daocheng.master.book.Book>) responseObserver);
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

  private static final class BookServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.daocheng.master.book.BookMaster.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookServiceDescriptorSupplier())
              .addMethod(METHOD_GET_BOOK)
              .addMethod(METHOD_CREATE_BOOK)
              .build();
        }
      }
    }
    return result;
  }
}

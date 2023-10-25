package transaqConnector;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: connect.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConnectServiceGrpc {

  private ConnectServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "transaqConnector.ConnectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<transaqConnector.Connect.DataRequest,
      transaqConnector.Connect.DataResponse> getFetchResponseDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchResponseData",
      requestType = transaqConnector.Connect.DataRequest.class,
      responseType = transaqConnector.Connect.DataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<transaqConnector.Connect.DataRequest,
      transaqConnector.Connect.DataResponse> getFetchResponseDataMethod() {
    io.grpc.MethodDescriptor<transaqConnector.Connect.DataRequest, transaqConnector.Connect.DataResponse> getFetchResponseDataMethod;
    if ((getFetchResponseDataMethod = ConnectServiceGrpc.getFetchResponseDataMethod) == null) {
      synchronized (ConnectServiceGrpc.class) {
        if ((getFetchResponseDataMethod = ConnectServiceGrpc.getFetchResponseDataMethod) == null) {
          ConnectServiceGrpc.getFetchResponseDataMethod = getFetchResponseDataMethod =
              io.grpc.MethodDescriptor.<transaqConnector.Connect.DataRequest, transaqConnector.Connect.DataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchResponseData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  transaqConnector.Connect.DataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  transaqConnector.Connect.DataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectServiceMethodDescriptorSupplier("FetchResponseData"))
              .build();
        }
      }
    }
    return getFetchResponseDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<transaqConnector.Connect.SendCommandRequest,
      transaqConnector.Connect.SendCommandResponse> getSendCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendCommand",
      requestType = transaqConnector.Connect.SendCommandRequest.class,
      responseType = transaqConnector.Connect.SendCommandResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<transaqConnector.Connect.SendCommandRequest,
      transaqConnector.Connect.SendCommandResponse> getSendCommandMethod() {
    io.grpc.MethodDescriptor<transaqConnector.Connect.SendCommandRequest, transaqConnector.Connect.SendCommandResponse> getSendCommandMethod;
    if ((getSendCommandMethod = ConnectServiceGrpc.getSendCommandMethod) == null) {
      synchronized (ConnectServiceGrpc.class) {
        if ((getSendCommandMethod = ConnectServiceGrpc.getSendCommandMethod) == null) {
          ConnectServiceGrpc.getSendCommandMethod = getSendCommandMethod =
              io.grpc.MethodDescriptor.<transaqConnector.Connect.SendCommandRequest, transaqConnector.Connect.SendCommandResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  transaqConnector.Connect.SendCommandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  transaqConnector.Connect.SendCommandResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectServiceMethodDescriptorSupplier("SendCommand"))
              .build();
        }
      }
    }
    return getSendCommandMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConnectServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectServiceStub>() {
        @java.lang.Override
        public ConnectServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectServiceStub(channel, callOptions);
        }
      };
    return ConnectServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectServiceBlockingStub>() {
        @java.lang.Override
        public ConnectServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectServiceBlockingStub(channel, callOptions);
        }
      };
    return ConnectServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConnectServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectServiceFutureStub>() {
        @java.lang.Override
        public ConnectServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectServiceFutureStub(channel, callOptions);
        }
      };
    return ConnectServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void fetchResponseData(transaqConnector.Connect.DataRequest request,
        io.grpc.stub.StreamObserver<transaqConnector.Connect.DataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchResponseDataMethod(), responseObserver);
    }

    /**
     */
    default void sendCommand(transaqConnector.Connect.SendCommandRequest request,
        io.grpc.stub.StreamObserver<transaqConnector.Connect.SendCommandResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendCommandMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConnectService.
   */
  public static abstract class ConnectServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ConnectServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConnectService.
   */
  public static final class ConnectServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConnectServiceStub> {
    private ConnectServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchResponseData(transaqConnector.Connect.DataRequest request,
        io.grpc.stub.StreamObserver<transaqConnector.Connect.DataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFetchResponseDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendCommand(transaqConnector.Connect.SendCommandRequest request,
        io.grpc.stub.StreamObserver<transaqConnector.Connect.SendCommandResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendCommandMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConnectService.
   */
  public static final class ConnectServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConnectServiceBlockingStub> {
    private ConnectServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<transaqConnector.Connect.DataResponse> fetchResponseData(
        transaqConnector.Connect.DataRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFetchResponseDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public transaqConnector.Connect.SendCommandResponse sendCommand(transaqConnector.Connect.SendCommandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendCommandMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ConnectService.
   */
  public static final class ConnectServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConnectServiceFutureStub> {
    private ConnectServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<transaqConnector.Connect.SendCommandResponse> sendCommand(
        transaqConnector.Connect.SendCommandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendCommandMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_RESPONSE_DATA = 0;
  private static final int METHODID_SEND_COMMAND = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_RESPONSE_DATA:
          serviceImpl.fetchResponseData((transaqConnector.Connect.DataRequest) request,
              (io.grpc.stub.StreamObserver<transaqConnector.Connect.DataResponse>) responseObserver);
          break;
        case METHODID_SEND_COMMAND:
          serviceImpl.sendCommand((transaqConnector.Connect.SendCommandRequest) request,
              (io.grpc.stub.StreamObserver<transaqConnector.Connect.SendCommandResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFetchResponseDataMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              transaqConnector.Connect.DataRequest,
              transaqConnector.Connect.DataResponse>(
                service, METHODID_FETCH_RESPONSE_DATA)))
        .addMethod(
          getSendCommandMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              transaqConnector.Connect.SendCommandRequest,
              transaqConnector.Connect.SendCommandResponse>(
                service, METHODID_SEND_COMMAND)))
        .build();
  }

  private static abstract class ConnectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return transaqConnector.Connect.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConnectService");
    }
  }

  private static final class ConnectServiceFileDescriptorSupplier
      extends ConnectServiceBaseDescriptorSupplier {
    ConnectServiceFileDescriptorSupplier() {}
  }

  private static final class ConnectServiceMethodDescriptorSupplier
      extends ConnectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConnectServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConnectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectServiceFileDescriptorSupplier())
              .addMethod(getFetchResponseDataMethod())
              .addMethod(getSendCommandMethod())
              .build();
        }
      }
    }
    return result;
  }
}

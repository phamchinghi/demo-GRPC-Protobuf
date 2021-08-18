package Server;

import com.nghi.grpc.HelloRequest;
import com.nghi.grpc.HelloResponse;
import com.nghi.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
       //Khởi tạo 1 lời chào lấy name từ request
        String greeting = new StringBuilder()
               .append("Hello, ")
               .append(request.getFirstName())
               .append(" ")
               .append(request.getLastName())
               .toString();
        //tạo 1 response đưa ra lời chào
        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

package Server;

import com.nghi.grpc.HelloRequest;
import com.nghi.grpc.HelloResponse;
import com.nghi.grpc.HelloServiceGrpc;
import com.nghi.grpc.HelloServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;

public class GrpcClient {
    public static void main(String[] args)throws IOException, InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8000).usePlaintext().build();

        //gọi function hello và dùng stub để tương tác vs server
        // RPC sẽ đợi response từ server và sẽ trả về một response hoặc một exception vì dùng blocking stub
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(managedChannel);

        // nhận HelloResponse object trả về từ server.
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Pham")
                .setLastName("Chi Nghi")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        managedChannel.shutdown();
    }
}

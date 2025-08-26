package com.example.client;

import com.example.server.UserRequest;
import com.example.server.UserResponse;
import com.example.server.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
@Service
public class UserClient {

    @GrpcClient("server")

    private UserServiceGrpc.UserServiceBlockingStub blockingStub;

    public UserResponse sayUser(Integer id) {
        UserRequest request = UserRequest.newBuilder().setUserId(id).build();
        UserResponse response = blockingStub.getUser(request);
        return response;
    }
}
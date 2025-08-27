package com.atlas.client;

import com.atlas.server.UserRequest;
import com.atlas.server.UserResponse;
import com.atlas.server.UserServiceGrpc;
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
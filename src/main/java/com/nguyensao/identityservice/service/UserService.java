package com.nguyensao.identityservice.service;

import java.util.List;

import com.nguyensao.identityservice.dto.request.UserCreateRequest;
import com.nguyensao.identityservice.dto.request.UserUpdateRequest;
import com.nguyensao.identityservice.dto.response.UserResponse;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse updateUser(String userId, UserUpdateRequest request);

    void deleteUser(String userId);

    List<UserResponse> getUsers();

    UserResponse getUser(String userId);

    // GetTheoToKen
    UserResponse getUserByToken();

}

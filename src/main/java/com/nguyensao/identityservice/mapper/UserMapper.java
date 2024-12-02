package com.nguyensao.identityservice.mapper;

import com.nguyensao.identityservice.dto.request.UserCreateRequest;
import com.nguyensao.identityservice.dto.request.UserUpdateRequest;
import com.nguyensao.identityservice.dto.response.UserResponse;
import com.nguyensao.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Post
    User toUser(UserCreateRequest request);

    // Get
    // @Mapping(source = "firstName", target = "lastName") //lấy giá trị từ fistName
    // sang lastName
    UserResponse toUserResponse(User user);

    // Update
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}

package com.nguyensao.identityservice.mapper;

import org.mapstruct.Mapper;

import com.nguyensao.identityservice.dto.request.PermissionRequest;
import com.nguyensao.identityservice.dto.response.PermissionResponse;
import com.nguyensao.identityservice.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}

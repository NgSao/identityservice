package com.nguyensao.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nguyensao.identityservice.dto.request.RoleRequest;
import com.nguyensao.identityservice.dto.response.RoleResponse;
import com.nguyensao.identityservice.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}

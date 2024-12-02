package com.nguyensao.identityservice.service;

import java.util.List;

import com.nguyensao.identityservice.dto.request.RoleRequest;
import com.nguyensao.identityservice.dto.response.RoleResponse;

public interface RoleService {
    RoleResponse create(RoleRequest request);

    List<RoleResponse> getAll();

    void delete(String role);
}

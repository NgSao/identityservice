package com.nguyensao.identityservice.service;

import java.util.List;

import com.nguyensao.identityservice.dto.request.PermissionRequest;
import com.nguyensao.identityservice.dto.response.PermissionResponse;

public interface PermissionService {
    PermissionResponse create(PermissionRequest request);

    List<PermissionResponse> getAll();

    void delete(String permission);
}

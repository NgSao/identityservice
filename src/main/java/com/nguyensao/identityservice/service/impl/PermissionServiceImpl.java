package com.nguyensao.identityservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyensao.identityservice.dto.request.PermissionRequest;
import com.nguyensao.identityservice.dto.response.PermissionResponse;
import com.nguyensao.identityservice.entity.Permission;
import com.nguyensao.identityservice.mapper.PermissionMapper;
import com.nguyensao.identityservice.repository.PermissionRepository;
import com.nguyensao.identityservice.service.PermissionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }

}

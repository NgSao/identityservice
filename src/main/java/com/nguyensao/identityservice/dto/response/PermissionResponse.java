package com.nguyensao.identityservice.dto.response;

import lombok.*;

import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor // không tham số
@AllArgsConstructor // chứa tất cả tham số
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionResponse {
    String name;
    String description;
}

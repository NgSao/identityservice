package com.nguyensao.identityservice.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor // không tham số
@AllArgsConstructor // chứa tất cả tham số
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL) // nếu 1 trường có gt null k trả về json vd message;
public class ApiResponse<T> {
    // là một lớp generic, nghĩa là có thể nhận một kiểu dữ liệu bất kỳ được chỉ
    // định bằng T.
    @Builder.Default
    int code = 1000; // mã trạng thái 200,400,4001
    String message;// thông điệp thành công, thất bại
    T result;// kết quả phản hoài

}

package com.nguyensao.identityservice.configuration;

import java.text.ParseException;
import java.util.Objects;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import com.nguyensao.identityservice.dto.request.IntrospectRequest;
import com.nguyensao.identityservice.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
// khai báo là 1 thẻ Bean
public class CustomJwtDecoder implements JwtDecoder {

    @Value("${jwt.signer-key}")
    String signerKey;

    @Autowired
    AuthenticationService authenticationService;

    private NimbusJwtDecoder nimbusJwtDecoder = null;

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            // Gọi dịch vụ introspect để kiểm tra tính hợp lệ của token
            var response = authenticationService.introspect(IntrospectRequest.builder().token(token).build());
            if (!response.isValid()) {
                throw new JwtException("Invalid token");
            }
        } catch (JOSEException | ParseException e) {
            throw new JwtException(e.getMessage());
        }

        // Nếu nimbusJwtDecoder chưa được tiêm, khởi tạo nó
        if (Objects.isNull(nimbusJwtDecoder)) {
            // thực hiện decoder token biết hợp lệ hay không
            SecretKeySpec secretKeySpec = new SecretKeySpec(signerKey.getBytes(), "HS512");
            nimbusJwtDecoder = NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
        }
        // Sử dụng nimbusJwtDecoder để giải mã token và trả về kết quả
        return nimbusJwtDecoder.decode(token);
    }
}

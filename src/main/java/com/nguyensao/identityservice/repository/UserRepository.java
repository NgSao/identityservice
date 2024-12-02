package com.nguyensao.identityservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyensao.identityservice.entity.User;

@Repository // rõ ràng đánh dấu 1 component, sử lý ngoai lệ, k dùng vẫn hd
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}

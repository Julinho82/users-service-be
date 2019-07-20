package com.dh.fullstack.users.service.model.repositories;

import com.dh.fullstack.users.service.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

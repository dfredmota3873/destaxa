package com.destaxa.repository;

import com.destaxa.model.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, UUID> {
}

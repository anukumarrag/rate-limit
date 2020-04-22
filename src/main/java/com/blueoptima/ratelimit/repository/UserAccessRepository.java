package com.blueoptima.ratelimit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blueoptima.ratelimit.model.UserAccessEntity;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccessEntity, Long> {

	@Query(value = "select user from user_access_log user where user_id = :userId and url = :url and access_time < now() + 1", nativeQuery = true)
	public List<UserAccessEntity> report(@Param("userId") String userId, @Param("url") String url);
}

package com.miu.edu.batch_processing.repository;

import com.miu.edu.batch_processing.entity.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserClassRepository extends JpaRepository<UserClass,Integer> {

    @Query("select u from UserClass  u where u.user= ?1")
    public Optional<UserClass> findUserByUserName(String username);

}

package com.javadev.webnewsMVC.repository;

import com.javadev.webnewsMVC.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    Optional<User> findByGmail(String gmail);
    Boolean existsByGmail(String gmail);
    Boolean existsByUserName(String userName);

}

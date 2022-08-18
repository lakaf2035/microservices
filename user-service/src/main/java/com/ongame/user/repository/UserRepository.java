package com.ongame.user.repository;


import com.ongame.user.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Userr, Long> {

    Userr findByUserId(Long userId);
}

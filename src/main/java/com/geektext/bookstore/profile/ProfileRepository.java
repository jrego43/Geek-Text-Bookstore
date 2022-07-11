package com.geektext.bookstore.profile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
    // SELECT * FROM profile WHERE username = ?
    @Query(value = "SELECT * FROM profile WHERE username = :username LIMIT 1", nativeQuery = true)
    Optional<Profile> findProfileByUsername(String username);
}

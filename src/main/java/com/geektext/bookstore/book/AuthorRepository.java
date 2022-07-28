package com.geektext.bookstore.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    //@Query(value = "SELECT * FROM profile WHERE username = :username LIMIT 1", nativeQuery = true)
    //Optional<Profile> findProfileByUsername(String username);
}

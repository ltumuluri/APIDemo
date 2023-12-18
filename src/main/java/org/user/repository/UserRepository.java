package org.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.user.beans.Userabc;

import java.util.List;

public interface UserRepository extends JpaRepository<Userabc, Integer> {

    List<Userabc> findAllByFirstName(String firstName);

    @Query(value = "delete from userabc where email like ?1", nativeQuery = true)
    List<Userabc> deleteByEmail(String email);
}


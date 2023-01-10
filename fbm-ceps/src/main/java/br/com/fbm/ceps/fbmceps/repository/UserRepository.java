package br.com.fbm.ceps.fbmceps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fbm.ceps.fbmceps.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u FROM User WHERE u.userName=:userName")
    UserModel findByUsername(@Param("userName") String userName);

}

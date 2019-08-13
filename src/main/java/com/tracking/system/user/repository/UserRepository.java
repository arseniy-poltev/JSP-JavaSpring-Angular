package com.tracking.system.user.repository;

import com.tracking.system.user.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String>{
    User findByLoginName(@Param("loginName") String loginName);
    User findById(@Param("id") long id);
    List<User> findByCompanyIdAndType(@Param("companyId") int companyId,@Param("type") String type);
    List<User> findByType(@Param("type") String type);

}

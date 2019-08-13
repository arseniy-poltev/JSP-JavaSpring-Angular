package com.tracking.system.user.service;

import com.tracking.system.user.service.model.User;

import java.util.List;

public interface UserService {

    User findByUserLoginName(String loginName);
    User save(User user);
    User update(User user);
    User findById(long id);
    List<User> findByCompanyAndType(int companyId,String type);
    List<User> findByType(String type);

}

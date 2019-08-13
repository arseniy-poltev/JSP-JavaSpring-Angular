package com.tracking.system.user.service;

import com.tracking.system.company.employee.service.EmployeeServiceImpl;
import com.tracking.system.company.employee.service.model.Employee;
import com.tracking.system.company.service.CompanyServiceImpl;
import com.tracking.system.company.service.model.Company;
import com.tracking.system.user.repository.UserRepository;
import com.tracking.system.user.service.model.User;
import com.tracking.system.utils.GlobalConstant.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    private static final Logger LOG = LoggerFactory
            .getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private CompanyServiceImpl companyService;

    @Override
    public User findByUserLoginName(String loginName) {
        User user = userRepository.findByLoginName(loginName);
        modifyModel(user);
        return user;
    }

    @Override
    public User save(User user){
        User newUser = userRepository.save(user);
        if(user.getType().equals(UserType.CLIENT.getValue())){

        }else if(user.getType().equals(UserType.EMPLOYEE.getValue())){
            Employee employee = new Employee();
            employee.setUserId((int)newUser.getId());
            employee.setUserInfo(newUser);
            employee.setCompanyId(newUser.getCompanyId());
            employeeService.save(employee);
        }
        return newUser;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        User user = userRepository.findById(id);
        modifyModel(user);
        return user;
    }

    @Override
    public List<User> findByCompanyAndType(int companyId,String type) {
        List<User> userList = userRepository.findByCompanyIdAndType(companyId,type);
        modifyList(userList);
        return userList;
    }

    @Override
    public List<User> findByType(String type) {
        List<User> userList = userRepository.findByType(type);
        modifyList(userList);
        return userList;
    }

    private void modifyModel(User user){
        if(user == null){
            return;
        }
        int companyId = user.getCompanyId();
        if(companyId == 0){
            return;
        }
        Company company = companyService.findById((long)companyId);
        if(company == null){
            return;
        }
        user.setCompanyName(company.getInternalName());
    }
    private void modifyList(List<User> users) {
        int i;
        for (i = 0; i < users.size(); i++) {
            User user = users.get(i);
            modifyModel(user);
        }
    }
}

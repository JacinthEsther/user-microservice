package com.techie.userservice.service;


import com.techie.userservice.VO.Department;
import com.techie.userservice.VO.ResponseTemplateVO;
import com.techie.userservice.entity.User;
import com.techie.userservice.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepo userRepo;
    private final RestTemplate restTemplate;

    public User save(User user) {
        log.info("Inside saveUser of userService");
       return userRepo.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepo.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/"
                        + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}

package com.ongame.user.service;


import com.ongame.user.VO.Department;
import com.ongame.user.VO.ResponseTemplateVO;
import com.ongame.user.entity.Userr;
import com.ongame.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public  Userr saveUser(Userr user) {
        log.info("Inside saveUser method of UserService ");
        return userRepository.save(user);
    }

    public Userr findUserById(Long userId) {

        log.info("Inside findUserById method of UserService");
        return userRepository.findByUserId(userId);

    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo= new ResponseTemplateVO();
        Userr user = userRepository.findByUserId(userId);


        Department department =
                restTemplate.getForObject( "http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}

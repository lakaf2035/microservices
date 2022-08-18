package com.ongame.user.VO;


import com.ongame.user.entity.Userr;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;


@Data
@RequestMapping
@NoArgsConstructor
public class ResponseTemplateVO {
    private Userr user;
    private Department department;
}

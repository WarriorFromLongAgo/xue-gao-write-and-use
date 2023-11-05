package com.xuegao.springsecuritydemo1.domain.po;
 
import lombok.*;

/**
 * @author LiaoBaohong 2021/7/13
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
 
    private Integer id;
    private String username;
    private String password;
}
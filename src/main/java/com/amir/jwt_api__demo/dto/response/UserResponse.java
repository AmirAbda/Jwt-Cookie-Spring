package com.amir.jwt_api__demo.dto.response;

import java.util.Set;

import com.amir.jwt_api__demo.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class  UserResponse {

    private Long id ;

    private String username;
    
    private Set<UserRole> roles;
    
}

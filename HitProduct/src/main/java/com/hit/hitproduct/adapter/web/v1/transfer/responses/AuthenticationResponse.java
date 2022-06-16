package com.hit.hitproduct.adapter.web.v1.transfer.responses;

import com.hit.hitproduct.domains.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
//    private Long userId;
    private String username;

    private List<Role> roleList;
}
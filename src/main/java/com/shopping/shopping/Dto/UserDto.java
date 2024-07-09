package com.shopping.shopping.Dto;

import com.shopping.shopping.enums.Role;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {
    private String username;
    private String password;
    private Role role;
}

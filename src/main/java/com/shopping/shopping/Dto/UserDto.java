package com.shopping.shopping.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {
    private String userName;
    private String passWord;
    private String role;
}

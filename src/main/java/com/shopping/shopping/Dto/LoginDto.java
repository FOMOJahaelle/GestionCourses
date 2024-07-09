package com.shopping.shopping.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LoginDto {
    private String username;
    private String password;
}

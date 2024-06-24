package com.shopping.shopping.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TacheRequest {

    private String nameTache;
    private String description;
    private Boolean statut;
    private  Long Course_id;
}

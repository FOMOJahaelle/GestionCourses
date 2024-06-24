package com.shopping.shopping.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TacheResponse {
    private String nameTache;
    private String description;
    private Boolean statut;
    private  Long course_id;
}

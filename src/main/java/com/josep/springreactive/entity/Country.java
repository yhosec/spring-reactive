package com.josep.springreactive.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("country")
public class Country {
    @Id
    private Integer id;
    private String code;
    private String name;
    private String status;
}

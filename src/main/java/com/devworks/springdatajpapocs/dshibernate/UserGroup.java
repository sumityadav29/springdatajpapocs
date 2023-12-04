package com.devworks.springdatajpapocs.dshibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserGroup {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private List<Long> userIds;
}

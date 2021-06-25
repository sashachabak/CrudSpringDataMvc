package com.spring.crudspringdatamvc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission {
    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write"),
    DEVELOPERS_UPDATE("developers:update"),
    DEVELOPERS_DELETE("developers:delete");



    private final String permission;

}

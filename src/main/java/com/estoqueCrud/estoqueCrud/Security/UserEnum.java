package com.estoqueCrud.estoqueCrud.Security;

public enum UserEnum {


    User("User"),
    Admin("Admin");

    private String name;

    private UserEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.example.designpattern.designpattern;

import com.example.designpattern.domain.entity.User;

public class UserBuilder {

    private String name;

    private String password;

    private String telephone;

    private String gender;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public UserBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public User build() {
        return new User(this.name, this.password, this.telephone, this.gender);
    }
}

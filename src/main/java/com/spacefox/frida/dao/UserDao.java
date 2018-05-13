package com.spacefox.frida.dao;


import com.spacefox.frida.domain.User;
import com.spacefox.frida.layout.UserService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDao implements UserService {

    private List<User> users;
    private PropertiesConfiguration props;
    private int userAmount;

    public UserDao() throws ConfigurationException {
        props = new PropertiesConfiguration("vata.properties");;
        userAmount = props.getInt("users.amount");
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for(int i=1; i<userAmount+1; i++){
            User user = new User();
            user.setId(i);
            user.setName(props.getString(i + ".user.name"));
            users.add(user);
        }
        return users;
    }

    @Override
    public User getByName(String name) {
        User res = getAll().stream().filter(u -> u.getName().equals(name)).collect(Collectors.toList()).get(0);
        return res;
    }
}

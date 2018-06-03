package com.spacefox.frida.propdb;


import com.spacefox.frida.domain.User;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDao {

    private List<User> users;
    private PropertiesConfiguration props;
    private int userAmount;

    public UserDao() throws ConfigurationException {
        props = new PropertiesConfiguration("dummyData.properties");;
        userAmount = props.getInt("users.amount");
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for(long i=1; i<userAmount+1; i++){
            User user = new User();
            user.setPublicId(i);
            user.setName(props.getString(i + ".user.name"));
            users.add(user);
        }
        return users;
    }

    public User getByName(String name) {
        User res = getAll().stream().filter(u -> u.getName().equals(name)).collect(Collectors.toList()).get(0);
        return res;
    }
}

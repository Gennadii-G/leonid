package com.spacefox.frida.utils;

import com.spacefox.frida.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class SecUtil {

    @Autowired
    private UserService userService;

    public int accessLevel(){
//        int lvl;
//        User us = userService.currentUser();
//        lvl=(us==null||!us.isActive())?0:us.getRoles().stream().mapToInt(Roles::getAccessLvl).max().getAsInt();
//        return lvl;

//        String usr = SecurityContextHolder.getContext().getAuthentication().getName();
//        return (usr == null || usr.equals("anonymousUser")) ? 0 : 1;
        return 1;
    }
}

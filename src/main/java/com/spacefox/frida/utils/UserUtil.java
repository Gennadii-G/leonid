package com.spacefox.frida.utils;

import com.spacefox.frida.domain.catalogs.Roles;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtil {

    public static String currentUser(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private static boolean isGuest(){
        boolean res;
        res = SecurityContextHolder.getContext()
                .getAuthentication().getName()
                .equals("anonymousUser");
        return res;
    }
}

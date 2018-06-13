package com.spacefox.frida.utils;

import org.springframework.security.core.context.SecurityContextHolder;

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

package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.utils.R;

public class UserService {

    public UserService(){
    }

    public User getUser(){
        User user = new User();
        user.setNickName(R.TESTDATA.get("MyNickName"));
        user.setEmail(R.TESTDATA.get("myEmail"));
        user.setPassword(R.TESTDATA.get("myPassword"));
        return user;
    }
}

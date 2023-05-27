package com.hblg.forum.Service;

import com.hblg.forum.Entity.User;
import com.hblg.forum.until.Result;
import java.util.*;


public interface USerService {

    public User Login(String username,String password);

    public User findUserByID(long id);

    public boolean Register(String username,String password);
}

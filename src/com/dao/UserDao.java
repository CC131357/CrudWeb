package com.dao;

import com.entity.User;

import java.util.List;

public interface UserDao {
    public boolean login(String name,String pwd);
    public boolean register(User user);
    public List<User> getUserAll();
    public boolean delete(int id);
    public boolean update(int id,String name,String pwd,String sex,String home,String info);
}

package services;

import dataaccess.RoleDB;
import models.*;
import dataaccess.UserDB;
import java.util.List;

public class UserService {

    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void insert(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception {
        User user = new User(email, activity, first_name, last_name, password);
        RoleDB roledb = new RoleDB();
        int r = roledb.getAll().indexOf(role);
        Role rol = roledb.getAll().get(r);
        user.setRole(rol);
        UserDB userdb = new UserDB();
        userdb.insert(user);
    }
    
    public void update(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setRole(role);
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}

package com.user.services;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    //fake User List
    List<User> list = List.of(
      new User(1344L, "krishna", "1234567890"),
      new User(1345L, "raj", "1234568760"),
      new User(1346L, "krish", "1233547890"),
      new User(1347L, "kri", "1234543590"),
      new User(1348L, "krina", "1234563490")
    );
    @Override
    public User getUser(long id) {
        return list.stream()
                .filter(user -> Long.valueOf(user.getUserId()).equals(id))
                .findAny()
                .orElse(null);
    }
}

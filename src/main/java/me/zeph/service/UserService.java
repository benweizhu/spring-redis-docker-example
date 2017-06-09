package me.zeph.service;

import me.zeph.converter.BytesToUserConverter;
import me.zeph.converter.UserToBytesConverter;
import me.zeph.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserToBytesConverter userToBytesConverter;

    @Autowired
    private BytesToUserConverter bytesToUserConverter;

    public void saveUser(User user) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("user", user.getPhoneNumber(), userToBytesConverter.convert(user));
    }

    public User findUserByPhoneNumber(String phoneNumber) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        return bytesToUserConverter.convert((byte[]) hashOperations.get("user", phoneNumber));
    }

}

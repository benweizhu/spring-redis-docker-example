package me.zeph.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.zeph.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
@WritingConverter
public class UserToBytesConverter implements Converter<User, byte[]> {

    private final Jackson2JsonRedisSerializer<User> serializer;

    public UserToBytesConverter() {
        serializer = new Jackson2JsonRedisSerializer<>(User.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public byte[] convert(User value) {
        return serializer.serialize(value);
    }
}

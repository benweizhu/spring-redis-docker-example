package me.zeph.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.zeph.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class BytesToUserConverter implements Converter<byte[], User> {

    private final Jackson2JsonRedisSerializer<User> serializer;

    public BytesToUserConverter() {
        serializer = new Jackson2JsonRedisSerializer<>(User.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public User convert(byte[] value) {
        return serializer.deserialize(value);
    }
}

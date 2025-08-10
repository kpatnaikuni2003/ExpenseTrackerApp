package com.security.authservice.serializer;



import com.security.authservice.eventProducer.UserInfoEvent;
import com.security.authservice.model.UserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoEvent>
{
//    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> map, boolean b) {
    }

    @Override
    public byte[] serialize(String arg0, UserInfoEvent arg1) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }


//    @Override
//    public byte[] serialize(String topic, UserInfoEvent data) {
//        if (data == null) {
//            return null;
//        }
//        try {
//            return objectMapper.writeValueAsBytes(data);
//        } catch (Exception e) {
//            throw new SerializationException("Error serializing UserInfoEvent", e);
//        }
//    }

    @Override public void close() {
    }
}

package com.hiepdoan.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.Module;
import com.hiepdoan.demo.boudary.serializer.CollectionTypeJsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.ArrayList;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper jsonObjectMapper() {
        ArrayList<Module> modules = new ArrayList<>();

        //CollectionType Serialization
        SimpleModule collectionTypeSerializerModule = new SimpleModule();
        collectionTypeSerializerModule.setSerializers(new CollectionTypeJsonSerializer());
        modules.add(collectionTypeSerializerModule);

        return Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) //ISODate
                .modules(modules)
                .build();
    }
}

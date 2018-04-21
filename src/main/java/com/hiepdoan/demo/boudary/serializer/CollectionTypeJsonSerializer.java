package com.hiepdoan.demo.boudary.serializer;


import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.hiepdoan.demo.model.LanguageString;

import java.util.ArrayList;
import java.util.List;

//custom serializer for CollectionType
public class CollectionTypeJsonSerializer extends SimpleSerializers {

    @Override
    public JsonSerializer<?> findCollectionSerializer(SerializationConfig config,
                                                      CollectionType type,
                                                      BeanDescription beanDesc,
                                                      TypeSerializer elementTypeSerializer,
                                                      JsonSerializer<Object> elementValueSerializer) {
        //if the collection is of type LanguageString, then use custom collection serializer
        if (isLanguageStringListType(type)) {
            return new LanguageStringListSerializer();
        }

        return findSerializer(config, type, beanDesc);
    }


    private boolean isLanguageStringListType(CollectionType type) {
        CollectionType languageStringArrayListType = TypeFactory.defaultInstance()
                .constructCollectionType(ArrayList.class, LanguageString.class);

        CollectionType languageStringListType = TypeFactory.defaultInstance()
                .constructCollectionType(List.class, LanguageString.class);

        return (type.equals(languageStringListType) || type.equals(languageStringArrayListType));
    }
}
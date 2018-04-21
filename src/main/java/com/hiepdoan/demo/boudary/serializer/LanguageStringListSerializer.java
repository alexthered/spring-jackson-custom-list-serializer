package com.hiepdoan.demo.boudary.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hiepdoan.demo.model.LanguageString;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LanguageStringListSerializer extends JsonSerializer<List<LanguageString>> {

    @Override
    public void serialize(List<LanguageString> value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {

        HashMap<String, String> map = new HashMap<>();
        for (LanguageString languageString: value) {
            map.put(languageString.getLocale().getLanguage(), languageString.getValue());
        }
        gen.writeObject(map);

    }
}

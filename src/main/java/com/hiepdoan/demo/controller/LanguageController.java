package com.hiepdoan.demo.controller;

import com.hiepdoan.demo.model.LanguageString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/languages")
public class LanguageController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LanguageString>> getLanguageString() {

        return new ResponseEntity<>(generateDummyLanguageString(), HttpStatus.OK);
    }

    private List<LanguageString> generateDummyLanguageString() {
        List<LanguageString> languageStringList = new ArrayList<>();

        languageStringList.add(
                LanguageString.builder()
                        .locale(Locale.ENGLISH)
                        .value("hello")
                        .build()
        );

        languageStringList.add(
                LanguageString.builder()
                        .locale(Locale.FRENCH)
                        .value("bonjour")
                        .build()
        );

        languageStringList.add(
                LanguageString.builder()
                        .locale(Locale.GERMAN)
                        .value("hallo")
                        .build()
        );
        return languageStringList;
    }
}

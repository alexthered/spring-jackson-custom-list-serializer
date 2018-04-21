package com.hiepdoan.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.Locale;

@Data
@Builder
public class LanguageString {

    Locale locale;
    String value;
}

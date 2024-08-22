package com.dongne.its.base.apiPayload.code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneralTimestamp {
    public static String getTimestamp(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }
}

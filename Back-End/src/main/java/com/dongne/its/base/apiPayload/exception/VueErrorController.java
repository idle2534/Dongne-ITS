package com.dongne.its.base.apiPayload.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @GetMapping(ERROR_PATH)
    public String redirectRoot(){
        return "index.html";
    }

    public static String getErrorPath() {
        return ERROR_PATH;
    }
}

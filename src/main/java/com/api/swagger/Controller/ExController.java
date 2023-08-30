package com.api.swagger.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/ex")
@CrossOrigin(origins = "http://localhost:8080/")
public class ExController {

    @GetMapping(value = "/ex", name = "예시")
    public HashMap<String, Object> ex() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("의히","으으");
        resMap.put("의히1","으으");
        resMap.put("의히2","으으");
        resMap.put("의히3","으으");
        resMap.put("의히4","으으");
        return resMap;
    }

}

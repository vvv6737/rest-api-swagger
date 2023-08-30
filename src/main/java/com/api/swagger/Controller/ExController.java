package com.api.swagger.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ex")
@CrossOrigin(origins = "http://localhost:8080/")
public class ExController {

    @GetMapping(value = "/ex", name = "예시")
    public List<HashMap<String, Object>> ex() {
        List<HashMap<String, Object>> resList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            HashMap<String, Object> resMap = new HashMap<>();
            resMap.put("idx", (i + 1));
            resMap.put("title","제목" + (i + 1));
            resMap.put("author","작성자" + (i + 1));
            resMap.put("created_at","작성일시" + (i + 1));
            resList.add(resMap);
        }
        return resList;
    }

}

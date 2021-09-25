package com.liba.taskManager.restController;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String test1() {
        return "asdaf";
    }
}
package com.growin.marvel.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@Api(value = "GrowinMarvelController")
@RestController
@RequestMapping("/api/v1")
public class GrowinMarvelController {

    @ApiOperation(value = "Test operation", response = String.class)
    @GetMapping("/test")
    public String test(){   return "I'm running mate!";   }
}

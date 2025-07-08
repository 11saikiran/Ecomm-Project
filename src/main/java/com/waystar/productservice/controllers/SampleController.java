package com.waystar.productservice.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/sayHello/{name}")
    public String sampleMethod(@PathVariable String name) {
        return "Hello World "+name;
    }
    @GetMapping("/sayHello2")
    public String sampleMethod2() {
        return "Hello World2";
    }

}

package top.anglesang.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.anglesang.springbootdemo.Annotation.MyAnnotation;

@RestController
public class HelloController {

    @MyAnnotation
    @RequestMapping("/add1")
    public String addData1(String deviceId) {
        return "add1";
    }

    @RequestMapping("/add2")
    public String addData2(String deviceId) {
        return "add2";
    }

    @RequestMapping("/add3")
    public String addData3(String deviceId) {
        return "add3";
    }

}

package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int number, @PathVariable int number2){
        return number + number2;
    }

    @RequestMapping(path = "/subtract/{number}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int number, @PathVariable int number2){
        return number2 - number;
    }

    @RequestMapping(path = "/multiply/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int number, @PathVariable int number2){
        return number * number2;
    }

    @RequestMapping(path = "/divide/{number}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int number, @PathVariable int number2){
        return number / number2;
    }


}

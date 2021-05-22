package com.spring.math.operations.controller.controller;

import com.spring.math.operations.controller.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class OperationsController {
    //@Autowired
    MathService myMathService;
    public OperationsController(){
        myMathService = new MathService();
    }

    @GetMapping("/math2")
    public double find(){
        return 5;
    }
    @GetMapping("/math2/calculate")
    public String performOperation(@RequestParam String operations, @RequestParam int x, @RequestParam int y) throws ArithmeticException
    {
        int result = 0;
        char operationChar = ' ';
        switch(operations.toLowerCase()) {
            case "add":
                operationChar = '+';
                result = myMathService.add(x,y);
                break;
            case "substract":
                operationChar = '-';
                result = myMathService.substract(x,y);
                break;
            case "multiply":
                operationChar = '*';
                result = myMathService.multiply(x,y);
                break;
            case "divide":
                operationChar = '/';
                result = myMathService.divide(x,y);
                break;

                default:

                break;


        }
        StringBuilder myBuilder = new StringBuilder();
        myBuilder.append(x);
        myBuilder.append(" ");
        myBuilder.append(operationChar);
        myBuilder.append(" ");
        myBuilder.append(y);
        myBuilder.append(" ");
        myBuilder.append("=");
        myBuilder.append(" ");
        myBuilder.append(result);
        return myBuilder.toString();
    }

    @PostMapping("/math2/sum")
    public String sum( @RequestParam MultiValueMap<String,String> n){
       // List<String> newList  = n.get("n");

        return myMathService.sum(n);
    }

    @RequestMapping(value ="/math/volume/{length}/{width}/{height}")
    public String rectangleVolume(@PathVariable Integer length, @PathVariable Integer width, @PathVariable Integer height )
    {
        Integer volume = ( length * width * height );
        StringBuilder str = new StringBuilder();
        str.append("The volume of a ");
        str.append(length);
        str.append("x");
        str.append(width);
        str.append("x");
        str.append(height);
        str.append(" rectangle is ");
        str.append(volume);
        return str.toString();
    }
}

package com.spring.math.operations.controller.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MathService {
    public int add(int x, int y) {

        return x+y;
    }

    public int substract(int x, int y) {
        return x-y;
    }

    public int multiply(int x, int y) {
        return x*y;
    }

    public int divide(int x, int y) throws ArithmeticException{
        return x/y;
    }

    public String sum( MultiValueMap<String,String> n){
        // List<String> newList  = n.get("n");
        List<Integer> myList = n.get("n").stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        //String.join(" + ", myList.toString());
        int total = myList.stream()
                .mapToInt(Integer::intValue)
                .sum();
        String theSumStr = myList.stream().map( i ->  i.toString()).collect(Collectors.joining(" + "));


        StringBuilder myBuilder = new StringBuilder(theSumStr);
        myBuilder.append(" = ");
        myBuilder.append(total);
        return myBuilder.toString();
    }
}

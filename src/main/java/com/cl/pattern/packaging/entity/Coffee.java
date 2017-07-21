package com.cl.pattern.packaging.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cl on 2017/7/12.
 */
public class Coffee extends CaffeineBeverage {

    void brew() {
        System.out.println("dripping coffee through filter");
    }

    void addcondiments() {
        System.out.println("adding sugar and milk");
    }

    boolean customerWantsCondiments(){
        String answer = getInput();

        if (answer.toLowerCase().startsWith("y")){
            return true;
        }else {
            return false;
        }
    }


    String getInput() {

        String answer = null;
        System.out.println("would you like milk and sugar with you coffee(y/n)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("io error try to read you answer");
        }
        if(answer == null){
            return  "no";
        }
        return answer;
    }

}

package com.example.crowdfunding.security;

interface X{

	public boolean azff(int a, int b);
	
}

public class App{
	
    
    public static void main(String[] args) {
        X obj = (int a,int b)->{
        	return a > b;
        };
        
 System.out.println(obj.azff(10,85));

    }
}
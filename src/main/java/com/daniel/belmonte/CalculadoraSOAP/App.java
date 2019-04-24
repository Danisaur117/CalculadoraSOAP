package com.daniel.belmonte.CalculadoraSOAP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.daniel.belmonte.ws.Calculator;
import com.daniel.belmonte.ws.CalculatorSoap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String leido = "";
        int op1 = 0, op2 = 0, result = 0;
        
        try {
        	do {
        		System.out.println("Introduce el operando 1 (valor entero): ");
        		leido = reader.readLine();
        	}
        	while(!leido.matches("^[-]?[0-9]*$"));
        	
        	op1 = Integer.valueOf(leido);
        	
        	do {
        		System.out.println("Introduce el operando 2 (valor entero): ");
        		leido = reader.readLine();
        	}
        	while(!leido.matches("^[-]?[0-9]*$"));
        	
        	op2 = Integer.valueOf(leido);
        	
        	do {
        		System.out.println("¿Qué operación deseas realizar? (Introduce el operador) ");
        		System.out.println("-> Suma\t(+)");
        		System.out.println("-> Resta\t(-)");
        		System.out.println("-> Multiplicación\t(*)");
        		System.out.println("-> División\t(/)");
        		leido = reader.readLine();
        	}
        	while(!leido.matches("^[+\\-*\\/]$"));
        }
        catch(Exception ex) {
        	System.out.println(ex);
        }
        
        switch(leido.charAt(0)) {
        	case '+':{
        		result = calculatorSoap.add(op1, op2);
        		System.out.println("El resultado de sumar " + op1 + " y " + op2 + " es " + result);
        		break;
        	}
        	case '-':{
        		result = calculatorSoap.subtract(op1, op2);
        		System.out.println("El resultado de restar " + op2 + " a " + op1 + " es " + result);
        		break;
        	}
        	case '*':{
        		result = calculatorSoap.multiply(op1, op2);
        		System.out.println("El resultado de multiplicar " + op1 + " por " + op2 + " es " +
        						   result);
        		break;
        	}
        	case '/':{
        		result = calculatorSoap.divide(op1, op2);
        		System.out.println("El resultado de la división entera entre " + op1 + " y " + op2 +
        						   " es " + result);
        		break;
        	}
        	default:{
        		System.out.println("ERROR: Operación no soportada");
        		break;
        	}
        }
    }
}

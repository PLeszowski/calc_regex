package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

	public static void main(String[] args) {

		double x = 0, y = 0;
		String operator = "";
		String nextLine;
		String[] splitLine;
		Scanner scFile = null;

		//Scanner sc = new Scanner(System.in);
		Calculator calc = new Calculator();

		File file = new File("c:/temp/calc_file.txt");


		try {
			scFile = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		while (scFile.hasNext()) {

			//nextLine = scFile.next();
			//splitLine = nextLine.split(";");

			nextLine = scFile.next();
			//System.out.println(nextLine);
			String pattern = "(\\d+\\.?\\d*);(\\D);(\\d+\\.?\\d*)";

			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(nextLine);

			try {
				m.find();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

//            if(m.find()){
//                System.out.println("group 0 = " + m.group(0));
//                System.out.println("group 1 = " + m.group(1));
//                System.out.println("group 2 = " + m.group(2));
//                System.out.println("group 3 = " + m.group(3));
//                //System.out.println("group 4 = " + m.group(4));
//                //System.out.println("group 5 = " + m.group(5));
//            } else{
//                System.out.println("NO MATCH");
//                break;
//            }

			try {
				x = Double.parseDouble(m.group(1));
				y = Double.parseDouble(m.group(3));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			try {
				operator = m.group(2);
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
//            System.out.println("x = " + x);
//            System.out.println("operator = " + operator);
//          System.out.println("y = " + y);
//            try {
//                x = sc.nextDouble();
//            } catch (InputMismatchException e) {
//                done = true;
//                e.printStackTrace();
//                break;
//            }
//
//            try {
//                operator = sc.next();
//            } catch (InputMismatchException e) {
//                done = true;
//                e.printStackTrace();
//                break;
//            }
//
//
//            try {
//                y = sc.nextDouble();
//            } catch (InputMismatchException e) {
//                done = true;
//                e.printStackTrace();
//                break;
//            }
			try {
				System.out.println("Calculation result: " + calc.eval(x, y, operator));
			} catch (DivisionByZeroException e) {
				e.printStackTrace();
			}

		}

		scFile.close();
	}
}
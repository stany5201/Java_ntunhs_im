package hw;

import java.util.Scanner;

public class hw2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fever;
		String cough;
		String Lazy;
	    String highbool;
		String dry;
        String sweats;
		
		Scanner sc = new Scanner (System.in);
		System.out.println("歡迎使用醫療診斷系統。請依序回答問題");
		System.out.println("==========================");
		System.out.println("請問你最近是否發燒?:");
		fever =sc.next();
		
		if(fever.toLowerCase().equals("y")){
			System.out.println("請問你最近是否咳嗽?:");
			cough =sc.next();
			
			if(cough.toLowerCase().equals("y")){
				System.out.println("請問你最近是否疲倦?:");
				Lazy =sc.next();
				  if(Lazy.toLowerCase().equals("y")) {
					System.out.println("先生/小姐你可能得感冒!!");
				}
				else {
					System.out.println("先生/小姐你可能得其他系統!!");
				}
			}else{
			System.out.println("請問你最近是否高血壓?:");
			highbool = sc.next();
			
			if(highbool.toLowerCase().equals("y")) {
				System.out.println("請問你最近是否口乾?");
				dry = sc.next();
				
				if(dry.toLowerCase().equals("y")) {
					System.out.println("先生/小姐你可能得肝病!!");
				} else {
					System.out.println("其他系統");
				}
			}else {
				System.out.print("請問你最近是否盜汗?:");
				sweats = sc.next();
				
			if(sweats.toLowerCase().equals("y")) {
				System.out.print("先生/小姐你可能得肺病!!");
			}else {
				System.out.println("先生/小姐你可能得其他系統");
			}
			}
			}
		}else {
			System.out.print("你很正常");
		}}}
		

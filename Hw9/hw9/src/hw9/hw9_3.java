package hw9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hw9_3 {
public static void main(String[] args) {
// TODO Auto-generated method stub
   int sum=0;
   String line;
   boolean isLoop=true;
// 創建一個HashMap來存儲學生名字和對應的成績
   Map<String, Integer> grades = new HashMap<>();
   while(isLoop) {
	   line= input("請輸入指令選擇下列功能 0.新增 1.查詢 2.修改 3.刪除 4.顯示所有 99.結束:");
	   if(line.equals("99"))isLoop=false;
	   else {
		   String name;
		   int grade;
		   switch(line) {
		 case "0":
		   name=input("請輸入學生姓名:");
		   grade=Integer.parseInt(input("請輸入學生成績:"));
		   grades.putIfAbsent(name, grade);
		   break;
		 case "1":
			 name=input("請輸入學生姓名:");
			 System.out.println("學生姓名:"+ name+" 成績"+grades.get(name));
		   
			 break;
		 case "2":
			 name=input("請輸入學生姓名:");
			 grade=Integer.parseInt(input("請輸入學生成績:"));
			 grades.put(name, grade);
			 System.out.println("學生姓名:"+ name+" 修改後成績"+grades.get(name));
			 break;
		  case "3":
			  name=input("請輸入學生姓名:");
			  grades.remove(name);
			  System.out.println("學生姓名:"+name+"已刪除");
			  break;
		  case "4":
			  System.out.println("學生成績列表:");
			  for(Map.Entry<String, Integer>entry:grades.entrySet()) {
				  System.out.println(entry.getKey()+":"+entry.getValue());
			  }
			  break;
		   }
	   }
   }
  }
   
      static String input(String prompt) {
    	  System.out.print(prompt);
    	  Scanner scanner = new Scanner(System.in);
    	  String line = scanner.nextLine();
    	  return line;
      }
}

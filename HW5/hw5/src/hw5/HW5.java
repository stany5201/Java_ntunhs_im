package hw5;

import java.util.Scanner;

public class HW5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isInLoop= true;
		Scanner sc = new Scanner(System.in);
		int command=0;
		
		StoreValueCard card1 = new StoreValueCard("NTUNHS001",1000,0);
		while(isInLoop) {
			int value=0;
			System.out.print("請輸入以下指令:1.儲值 2.扣款 3.兌換紅利 4.查看明細 0.離開系統:");
			command=sc.nextInt();
			switch(command) {
			case 0:
			System.out.println("離開系統");
			isInLoop=false;
			break;
			case 1:
				System.out.println("請輸入儲值金額:");
				value=sc.nextInt();
				card1.addValue(value);
				card1.printDetails();
				break;
			case 2:
				System.out.println("請輸入扣除金額:");
				value=sc.nextInt();
				card1.charge(value);
				card1.printDetails();
				break;
			case 3:
				System.out.println("請輸入兌換紅利:");
				value=sc.nextInt();
				card1.exchageBonus(value);
				card1.printDetails();
				break;
			case 4:
				card1.printDetails();
				break;
			default:
			System.out.println("請確認是否輸入錯誤指令:");
			break;
			}
		}
	}
}

class StoreValueCard{
	String cardId;
	int balance;
	int bonus;
	int totalCardNum;
	
	
	StoreValueCard(String cardId, int balance, int bonus){
		this.cardId = cardId;
		this.balance = balance;
		this.bonus = bonus;
		totalCardNum++;
	}
		
		void addValue(int money) {
			if(money>0) {
				this.balance+= money;
				if(money>=1000) {
					this.bonus++;
				}
			}
			else {
				System.out.println("請輸入金額不能為負值");
			}
		}
		void charge(int money) {
			if(money>0) {
				if(money<this.balance) {
					this.balance-=money;
				}
				else {
					System.out.println("餘額不足請儲值!");
				}
			}
			else {
				System.out.println("請確認扣款金額不能為負值");
			}
		}
		
		void exchageBonus(int bonus) {
			if(bonus>0) {
				if(bonus <this.bonus) {
					this.bonus-=bonus;
				}
				else {
					System.out.println("紅利不足無喇兌換!");
				}
			}
			else {
				System.out.println("請確認兌換紅利不能為負載");			
			}
		}
		void printDetails() {
				System.out.printf("(%s, %d, %d)%n",	this.cardId, this.balance, this.bonus);
			
	}

}

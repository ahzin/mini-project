package mini.project.handler.nomember;

import java.util.Scanner;

/**
 * 
 * @author 이다현
 * 비회원 메인을 담당하는 클래스입니다.
 *
 */
public class NoMemberMain {

	private static Scanner scan ;
		
	static { //정적생성자
		scan = new Scanner(System.in);
	}
	
	
	/**
	 * 비회원 메인화면을 출력하고 선택을 통해 주문화면으로 이동하는 메소드입니다.
	 */
	public void nomemberMain() {
		
		NoMemberOrder nomemberOrder = new NoMemberOrder();
		
		
		boolean loop = true;
		
		while(loop) {
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\r\n\n\n\t\t[ 안녕하세yo, 비회원님 :) ]\n\n");
		System.out.println("\t  ============로그인 하세요============\n\n");
		
		System.out.println("\n\t\t\t1. 주문하기\n");
		System.out.println("\t     (0을 입력하시면 뒤로 이동합니다.)\n\n");
		System.out.print("\n\t\t  이동할 화면 입력: ");
		String selNum = scan.nextLine();
		
		
		if(selNum.equals("0")) {
			//Main Class의 초기화면으로 이동
			loop = false;
			
		} else if (selNum.equals("1")) {
			//주문하기로 이동
			nomemberOrder.nomemberOrder();
			
		} else {
			System.out.println("\n\t\t올바르지 않은 접근입니다.");
					
		}//loop
		
	}//main
	
	
	
	}	
}//class

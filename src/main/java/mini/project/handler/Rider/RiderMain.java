package mini.project.handler.Rider;

import java.util.Scanner;

public class RiderMain {

  /**
   *
   * 라이더 메인 화면을 출력하고 선택지를 입력받는 메소드입니다.
   *
   */
  public void ridermainmain() {

    RiderLogin rl = new RiderLogin();
    RiderRegister rr = new RiderRegister();


    Scanner scan = new Scanner(System.in);

    boolean loop = true;
    while (loop) {
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\r\n\n\n\t\t안녕하세요! 멋진 라이더님!\n\n");
      System.out.println("\t\t\t1. 로그인\n\n");
      System.out.println("\t\t\t2. 라이더 신청하기\n\n");
      System.out.println("\n\n\t   (뒤로가기를 원하시면 0을 입력해주세yo)");
      System.out.print("\n\t\t  이동할 화면 입력(숫자) : ");
      String selNum = scan.nextLine();

      if (selNum.equals("1")) { // 라이더 로그인
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        rl.riderloginmain();
      } else if (selNum.equals("2")) { // 라이더 신청하기
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        rr.riderregistermain();
      }
      else if (selNum.equals("0")) { // 처음으로
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        loop = false;
      } else {
        System.out.println("올바른 입력 해주세요");
      }
    } // loop
  }
}
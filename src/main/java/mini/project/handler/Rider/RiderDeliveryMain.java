package mini.project.handler.Rider;

import java.util.Scanner;

/**
 * 라이더 업무를 선택하는 메인화면을 담당하는 클래스입니다.
 */
public class RiderDeliveryMain {

  /**
   * Scanner를 통해 입력받은 데이터를 저장하는 변수입니다.
   */
  public static Scanner scan = new Scanner(System.in);

  /**
   * 라이더 업무를 선택하는 메인화면을 출력하고 선택지를 입력받는 메소드입니다.
   */
  public void riderdelviverymain() {

    RiderDeliveryMain rdm = new RiderDeliveryMain();
    RiderDeliveryWait rdw = new RiderDeliveryWait();

    boolean loop = true;
    while (loop) {

      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\r\n\n\n\t\t환영합니다. 오늘도 열심히 달려주세요>.<\n\n\n");

      System.out.println("\t\t\t1. 진행 중인 배달\n\n");
      System.out.println("\n\n\t   (뒤로가기를 원하시면 0을 입력해주세yo)");


      System.out.print("\n\t\t  이동할 화면 입력(숫자) : ");
      String selNum = scan.nextLine();

      if (selNum.equals("1")) { // 진행 중 화면으로 이동
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        rdw.riderdeliverywaitmain();
      } else if (selNum.equals("0")) { // 전 단계로 이동
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        loop = false;
      } else {
        System.out.println("잘못입력하셧습니다.");
      }
    }

  }


}

package mini.project.handler.Rider;

import java.util.Scanner;

import mini.project.Main.Dummies;
import mini.project.Main.RiderData;

public class RiderLogin { // 라이더 로그인 클래스

  /**
   * 라이더 데이터를 저장하는 ArrayList 입니다.
   */
  public static RiderData ss = new RiderData();

  /**
   * Scanner를 통해 입력받은 데이터를 저장하는 변수입니다.
   */
  public static Scanner scan = new Scanner(System.in);

  private static String userID;

  public static String getUserID() {
    return userID;
  }

  public static void setUserID(String userID) {
    RiderLogin.userID = userID;
  }

  /**
   * 라이더 로그인 화면을 출력하고 아이디와 비밀번호를 입력받는 메소드입니다.
   */
  public void riderloginmain() {



    riderlogin();

  }

  private static void riderlogin() {

    RiderDeliveryMain rdm = new RiderDeliveryMain();

    boolean loop = true;
    while (loop) {
      System.out.println("\n\n\n\n\n\n\n\n\n");
      System.out.println("\r\n\n\n\t\t== 라이더 로그인 ==\n\n");

      System.out.println("\n\n\t   (뒤로가기를 원하시면 0을 입력해주세yo)\n");

      System.out.print("\t1. ID : ");
      String riderID = scan.nextLine();
      setUserID(riderID);
      System.out.println();

      if (riderID.equals("0")) {
        loop = false;
      } else {
        System.out.println("\n\n\t   (뒤로가기를 원하시면 0을 입력해주세yo)\n");

        System.out.print("\t2. 비밀번호 : ");
        String riderPW = scan.nextLine();
        System.out.println();

        boolean result = false;

        for (int i = 0; i < Dummies.rider.size(); i++) {
          if (Dummies.rider.get(i).getRiderID().equals(riderID)
              && Dummies.rider.get(i).getRiderPW().equals(riderPW)) {
            result = true;
            break;

          }
        }//for
        if (result) {
          rdm.riderdelviverymain();
        } else if (riderPW.equals("0")) {
          loop = false;
        } else {
          System.out.println("\tID와 비밀번호가 올바르지 않습니다. 다시 입력해주세요.\n");
        }

      }//else

    }//while
  }
}
package mini.project.handler.Store;

import java.util.ArrayList;
import java.util.Scanner;
import mini.project.Main.App;
import mini.project.Main.Dummies;

/**
 * 점포 - 3.배달 조회

 */
public class StoreDelivery {
  private ArrayList<String> orderNum = new ArrayList<String>(); // 주문번호
  private ArrayList<String> orderName = new ArrayList<String>(); // 주문자명
  private ArrayList<String> orderPhone = new ArrayList<String>(); // 주문자 전화번호
  private ArrayList<String> orderAddress = new ArrayList<String>(); // 주문자 주소
  private ArrayList<String> orderMenu = new ArrayList<String>(); // 주문상품
  private ArrayList<String> orderPrice = new ArrayList<String>(); // 결제금액
  private ArrayList<String> orderResult = new ArrayList<String>(); // 배달 결과
  private ArrayList<String> list = new ArrayList<String>(); // 조회리스트 목록

  /**
   * 배달 조회 메인메소드
   */
  public void main() {
    StoreMain storemain = new StoreMain();
    Scanner scan = new Scanner(System.in);
    int orderNum = 1;
    boolean loop = true;
    while (loop) {
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\n\n\n\n\t\t== 배달 조회 ==\n");
      System.out.println("주문번호\t주문자명\t전화번호\t배달 결과\n");
      System.out.println("=================================================================");
      for (int i = 0; i < Dummies.order.size(); i++) {
        if (Dummies.order.get(i).getWhatmean().equals(storemain.getStoreID()) &&
            Dummies.order.get(i).getAccept().equals("수락")) {
          String memberID = Dummies.order.get(i).getMemberID();
          String memberName = namecheck(memberID);
          String memberPhone = phonecheck(memberID);
          String memberAddress = findaddress(memberID);
          String menu = findfood(memberID);
          String price = findprice(memberID);
          String slist = String.format("  OR%03d\t\t%s\t\t%s\t%s\n"
              , orderNum
              , memberName
              , memberPhone
              , Dummies.order.get(i).getComplete());

          System.out.println(slist);
          this.orderNum.add("OR" + orderNum);
          this.orderName.add(memberName);
          this.orderPhone.add(memberPhone);
          this.orderResult.add(Dummies.order.get(i).getComplete());
          this.orderMenu.add(menu);
          this.orderPrice.add(price);
          this.orderAddress.add(memberAddress);
          this.list.add(slist);
          orderNum++;
        }
      }

      System.out.print("\t\t\t1.상세보기\n\n");
      System.out.println("\n\t(뒤로가기를 원하면 0번을 입력해주세yo)\n");
      System.out.print("\t\t입력 : ");
      String num = scan.nextLine();
      System.out.println();

      if (num.equals("0")) {
        loop = false;
      } else if(num.equals("1")) {
        System.out.print("\t\t[주문번호로 검색]\n\n");
        findordernumber();
        App.pause();
        loop = false;
      } else {
        System.out.println("다시 입력하세요");
      }

    } // loop

  }// main


  /**
   * 주문번호로 검색하여 조회해주는 메소드
   */
  public void findordernumber() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\n\t\t주문번호 : ");
    String num_order = scan.nextLine();
    System.out.println("\n");

    for (int i = 0; i < this.list.size(); i++) {
      if (this.list.get(i).contains(num_order)) {
        System.out.println("\n\n\n");
        System.out.printf("\t\t주문번호 : %s\n\n", this.orderNum.get(i));
        System.out.printf("\t\t주문자명 : %s\n\n", this.orderName.get(i));
        System.out.printf("\t\t전화번호 : %s\n\n", this.orderPhone.get(i));
        System.out.printf("\t\t주소 : %s\n\n", this.orderAddress.get(i));
        System.out.printf("\t\t주문상품 : %s\n\n", this.orderMenu.get(i));
        System.out.printf("\t\t결제금액 : %,d원\n\n", Integer.parseInt(this.orderPrice.get(i)));
        System.out.printf("\t\t배달 결과 : %s\n\n", this.orderResult.get(i));

      }
    }

  }

}
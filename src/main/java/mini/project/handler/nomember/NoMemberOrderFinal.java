package mini.project.handler.nomember;

import java.util.Scanner;
import mini.project.Main.Dummies;
import mini.project.Main.OrderData;

/**
 *비회원 주문의 최종 확인을 담당하는 클래스입니다.
 */
public class NoMemberOrderFinal {

  private static Scanner scan;


  static {
    scan = new Scanner(System.in);
  }


  /**
   * 비회원의 최종 주문 내역을 출력하는 메소드입니다.
   */
  public void lastCheck() {

    System.out.println("\t주문 내역을 확인하시려면 엔터를 입력해주세요!");
    scan.nextLine();

    System.out.println("\n\n\t▼ ▼ ▼ ▼ ▼고객님, 주문이 완료되었습니다▼ ▼ ▼ ▼ ▼\n\n");
    NoMemberOrder nomemOrder = new NoMemberOrder();
    System.out.println("\n\t이름   : "+nomemOrder.getNoMemberName());
    System.out.println("\n\t배달지 : "+nomemOrder.getNoMemberAddressCity()+" "
        +nomemOrder.getNoMemberAddressGu()+" "
        +nomemOrder.getNoMemberAddressDong()+"\n\n");




    OrderData temp = new OrderData();

    temp.setAccept("대기");
    temp.setComplete("미완");
    temp.setMemberID("TC"+Dummies.temporaryMember);
    Dummies.temporaryMember++;
    temp.setMenu(nomemOrder.getFinalMenu());

    String totalCost=nomemOrder.getFinalPrice() * nomemOrder.getFinalMenuCount() + "";

    temp.setMenuprice(totalCost);
    temp.setRiderID("null");
    temp.setWhatmean(nomemOrder.getStoreID());

    Dummies.order.add(temp);


    System.out.println("\t   [주문한 메뉴]    [수량]  [결제 금액]\n");
    System.out.println("\t  "+nomemOrder.getFinalMenu()+nomemOrder.getFinalMenuCount()+"\t"+temp.getMenuprice()+"원");

    System.out.println("\n\n\t현재 상태: "+temp.getAccept());
    System.out.println("\n\t배달 시간: 30분\n\n");
    System.out.println("\t고객님의 비회원 번호는 "+temp.getMemberID()+"입니다.");


    System.out.println("\n-------------------------------------------------------");

    System.out.println("\n\n\t▲ ▲ ▲ ▲ ▲ 0을 입력하시면 이전으로 이동합니다.▲ ▲ ▲ ▲ ▲\n\n");
    scan.nextLine();

  }
}

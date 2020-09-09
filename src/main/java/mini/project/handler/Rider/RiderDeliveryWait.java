package mini.project.handler.Rider;

import java.util.Scanner;

import mini.project.Main.Dummies;

/**
 *현재 라이더의 진행중인 배달 정보를 담당하는 클래스입니다.
 */
public class RiderDeliveryWait {

  /**
   * Scanner를 통해 입력받은 데이터를 저장하는 변수입니다.
   */
  public static Scanner scan = new Scanner(System.in);

  /**
   * 현재 진행중인 배달 정보를 출력하고 배달 완료 시 배달 정보를 배달 완료 목록으로 이동시키는 메소드입니다.
   */
  public void riderdeliverywaitmain() {

    RiderLogin rl = new RiderLogin();
    RiderDeliveryMain rdm = new RiderDeliveryMain();

    boolean loop = true;
    while (loop) {

      boolean ck = false;
      int num = 0;
      String memberid = "";
      String storeid = "";
      for (int i = 0; i < Dummies.order.size(); i++) {
        if (Dummies.order.get(i).getComplete().equals("미완")
            && Dummies.order.get(i).getRiderID().equals(rl.getUserID())) {
          memberid = Dummies.order.get(i).getMemberID();
          storeid = Dummies.order.get(i).getWhatmean();
          num = i;
          ck = true;
        }
      }

      String NoMemberName = "";
      String NoMemberCity = "";
      String NoMemberGu = "";
      String NoMemberDong = "";
      String NoMemberPhone = "";

      if (memberid.contains("TC")) {
        for (int i = 0; i < Dummies.nomember.size(); i++) {
          if(Dummies.nomember.get(i).getNomemberID().equals(memberid)) {
            NoMemberName = Dummies.nomember.get(i).getNomemberName();
            NoMemberCity = Dummies.nomember.get(i).getNomemberSi();
            NoMemberGu = Dummies.nomember.get(i).getNomemberDong();
            NoMemberDong = Dummies.nomember.get(i).getNomemberDong();
            NoMemberPhone = Dummies.nomember.get(i).getNomemberPhone();
          }
        }
      }


  String storeName = "";
  String storeCity = "";
  String storeGu = "";
  String storeDong = "";
  String storePhone = "";
  for (int i = 0; i < Dummies.store.size(); i++) {
    if (Dummies.store.get(i).getStoreID().equals(storeid)) {
      storeName = Dummies.store.get(i).getStoreName();
      storeCity = Dummies.store.get(i).getStoreAddressCity();
      storeGu = Dummies.store.get(i).getStoreAddressGu();
      storeDong = Dummies.store.get(i).getStoreAddressDong();
      storePhone = Dummies.store.get(i).getStorePhone();
    }
  }

  if (ck) {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\t\t[진행중인 주문]\n");
    System.out.println("\t[고객]");
    System.out.printf("\t이름 : %s\n", NoMemberName);
    System.out.printf("\t주소 : %s %s %s\n", NoMemberCity, NoMemberGu, NoMemberDong);
    System.out.printf("\t전화번호 : %s\n\n", NoMemberPhone);

    System.out.println("\t[점포]");
    System.out.printf("\t점포 이름 : %s\n", storeName);
    System.out.printf("\t주소 : %s %s %s\n", storeCity, storeGu, storeDong);
    System.out.printf("\t전화번호 : %s\n\n", storePhone);

    System.out.println("\t배달 소요 시간 : 30분\n");

    System.out.println("\t\t원하시는 항목을 선택해주세요.");
    System.out.println("\t1. 배달 완료");
  } else {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\n\n\t    현재 주문이 없습니다.");
  }
  }
} // loop
}
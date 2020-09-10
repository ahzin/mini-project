package mini.project.handler.Store;

import java.util.Scanner;
import mini.project.Main.Dummies;
import mini.project.Main.StoreData;

public class StoreMain {

  private static String storeID;
  private static String storeName;

  /**
   * 점포 메인 클래스
   */
  public void storeMain() {

    mainpage();

  }// main

  /**
   * 점포 - 메인페이지
   */
  private void mainpage() {

    boolean loop = true;
    while (loop) {
      StoreOrder storeorder = new StoreOrder();
      StoreDelivery storedelivery = new StoreDelivery();

      Scanner scan = new Scanner(System.in);
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\n\n\t\t== 점포 메인화면 ==");
      System.out.println("\n\t(뒤로가기를 원하면 0번을 입력해주세yo)\n");
      System.out.print("\t\t1.고객 주문 조회\n\n\t\t2.배달 조회\n\n");
      System.out.print("\t\t이동할 화면 입력(숫자) : ");
      String num_main = scan.nextLine();
      System.out.println();
      if (num_main.equals("1")) {
        storeorder.main();
      } else if (num_main.equals("2")) {
        storedelivery.main();
      } else if (num_main.equals("0")) {
        loop = false;
      }
    } // loop
  }

  /**
   * 점포등록 메소드
   */
  private void regist() {
    Scanner scan = new Scanner(System.in);
    StoreData sto = new StoreData();
    String storeID = "";
    //      System.out.println(Dummies.nostore.size()); //입력하기 전 배열의 크기

    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\n\n\t\t== 점포 정보 입력 ==\n\n");
    System.out.print("\t\t카테고리 선택\n\t[1.한식 2.중식 3.양식 4.치킨 5.피자]\n\n");
    System.out.print("\t\t입력 : ");
    String category = scan.nextLine();
    System.out.println();
    System.out.print("\t\t비밀번호 : ");
    String StorePW = scan.nextLine();
    System.out.println();
    System.out.print("\t\t상호명 [ex) 교촌치킨 양천구점] : ");
    String StoreName = scan.nextLine();
    System.out.println();
    System.out.print("\t\t전화번호 : ");
    String StorePhone = scan.nextLine();
    System.out.println();
    System.out.print("\t\t주소[시] : ");
    String StoreAddressCity = scan.nextLine();
    System.out.println();
    System.out.print("\t\t주소[구] : ");
    String StoreAddressGu = scan.nextLine();
    System.out.println();
    System.out.print("\t\t주소[동] : ");
    String StoreAddressDong = scan.nextLine();
    System.out.println();

    //가게 상호 번호 부여
    if (category.equals("1") || category.equals("한식")) {
      sto.setStoreID("Sa" + Dummies.storeKORnumber);
      storeID = "Sa" + Dummies.storeKORnumber;
      Dummies.storeKORnumber++;
    } else if (category.equals("2") || category.equals("중식")) {
      sto.setStoreID("Sb" + Dummies.storeCHINAnumber);
      storeID = "Sb" + Dummies.storeCHINAnumber;
      Dummies.storeCHINAnumber++;
    } else if (category.equals("3") || category.equals("일식")) {
      sto.setStoreID("Sc" + Dummies.storeJAPANnumber);
      storeID = "Sc" + Dummies.storeJAPANnumber;
      Dummies.storeJAPANnumber++;
    } else if (category.equals("4") || category.equals("치킨")) {
      sto.setStoreID("Sd" + Dummies.storeCHICKENnumber);
      storeID = "Sd" + Dummies.storeCHICKENnumber;
      Dummies.storeCHICKENnumber++;
    } else if (category.equals("5") || category.equals("피자")) {
      sto.setStoreID("Se" + Dummies.storePIZZAnumber);
      storeID = "Se" + Dummies.storePIZZAnumber;
      Dummies.storePIZZAnumber++;
    }

    sto.setStorePW(StorePW);
    sto.setStoreName(StoreName);
    sto.setStorePhone(StorePhone);
    sto.setStoreAddressCity(StoreAddressCity);
    sto.setStoreAddressGu(StoreAddressGu);
    sto.setStoreAddressDong(StoreAddressDong);

    Dummies.store.add(sto);
  }

  public String getStoreID() {
    return storeID;
  }

  public void setStoreID(String storeID) {
    this.storeID = storeID;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

}
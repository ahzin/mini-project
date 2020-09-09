package mini.project.handler.Store;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import mini.project.Main.Dummies;

/**
 * 점포 - 2.고객 주문 조회 클래스
 *
 * @author sist47
 *
 */
public class StoreOrder {

  private ArrayList<String> orderNum = new ArrayList<String>(); // 주문번호
  private ArrayList<String> orderName = new ArrayList<String>(); // 주문자명
  private ArrayList<String> orderPhone = new ArrayList<String>(); // 주문자 전화번호
  private ArrayList<String> orderAddress = new ArrayList<String>(); // 주문자 주소
  private ArrayList<String> orderMenu = new ArrayList<String>(); // 주문상품
  private ArrayList<String> orderPrice = new ArrayList<String>(); // 결제금액
  private ArrayList<String> orderResult = new ArrayList<String>(); // 배달 결과
  private ArrayList<String> orderID = new ArrayList<String>(); // 주문자 ID
  private ArrayList<String> list = new ArrayList<String>(); // 조회리스트 목록
  private String num_accept = "null";

  /**
   * 주문 조회, 수락 메인메소드
   */
  public void main() {
    StoreMain storemain = new StoreMain();
    Scanner scan = new Scanner(System.in);
    int orderNum = 1;
    boolean loop = true;
    while (loop) {
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\n\n\n\n\t\t== 고객 주문 조회 ==\n");
      System.out.print("\t\t1.현재 주문목록 \n\n\t\t2.주문 대기 목록\n\n");
      System.out.println("\t(뒤로가기를 원하면 0번을 입력해주세yo)\n");
      System.out.print("\t\t입력 : ");
      String num_order = scan.nextLine();
      System.out.println("\n");

      if (num_order.equals("1")) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\t\t== 현재 주문목록 ==\n");
        System.out.println("주문번호\t주문자명\t주소\t\t전화번호\n");
        if (this.num_accept.equals("1")) {
          orderNum = 1;
          String name = "";
          for (int i = 0; i < Dummies.order.size(); i++) {
            //                      for(int j =0; j<this.list.size(); j++) {
            //                          if(this.list.get(j).equals(anObject)) {
            //                              name = 주문수락한회원이름;
            //                          }
            //                      }
            if (Dummies.order.get(i).getWhatmean().equals(storemain.getStoreID())
                && Dummies.order.get(i).getAccept().equals("수락")
                && Dummies.order.get(i).getComplete().equals("미완")) {
              //&& Dummies.order.get(i).getMemberID().equals(anObject)
              String memberID = Dummies.order.get(i).getMemberID();
              String memberName = namecheck(memberID);
              String memberPhone = phonecheck(memberID);
              String memberAddress = findaddress(memberID);
              //                          String menu = findfood(memberID);
              //                          String price = findprice(memberID);
              String ordernum = "";
              for(int j=0; j<this.orderNum.size(); j++) {

                if(this.list.get(j).contains(memberName)) {
                  ordernum = this.orderNum.get(j);
                }

              }

              String slist = String.format("  %s\t\t%s\t%s\t%s\n", ordernum, memberName,
                  memberAddress, memberPhone);
              System.out.println(slist);
              break;
            }

          }
          System.out.println("\t(뒤로가기를 원하면 엔터를 입력해주세yo)\n");
          System.out.print("\t\t1.상세보기\n\n");
          System.out.print("\t\t입력 : ");
          String num = scan.nextLine();
          System.out.println("\n");


          if (num.equals("0")) {
            loop = false;
          } else if (num.equals("1")) {
            System.out.print("\t[어떤 항목으로 검색하시겠습니까?]\n\n\t\t1.주문번호\n\n\t\t2.주문자명\n\n\t\t3.전화번호\n\n");
            System.out.print("\t\t입력 : ");
            String num_search = scan.nextLine();
            System.out.println("\n");


            if (num_search.equals("1")) {
              findordernumber(false);
              Main.pause();
            } else if (num_search.equals("2")) {
              findname(false);
              Main.pause();
            } else if (num_search.equals("3")) {
              findphone(false);
              Main.pause();
            }
          }
        }
      } else if (num_order.equals("2")) {
        orderNum = 1;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\t\t== 대기중인 주문목록 ==\n");
        System.out.println("주문번호\t주문자명\t주소\t\t전화번호");
        System.out.println("=============================================================");
        for (int i = 0; i < Dummies.order.size(); i++) {
          if (Dummies.order.get(i).getWhatmean().equals(storemain.getStoreID())
              && Dummies.order.get(i).getAccept().equals("대기")) {
            String memberID = Dummies.order.get(i).getMemberID();
            String memberName = namecheck(memberID);
            String memberPhone = phonecheck(memberID);
            String memberAddress = findaddress(memberID);
            String menu = findfood(memberID);
            String price = findprice(memberID);
            String slist = String.format("  OR%d\t\t%s\t%s\t%s\n", orderNum, memberName, memberAddress,
                memberPhone);

            System.out.println(slist);

            this.orderNum.add("OR" + orderNum);
            this.orderName.add(memberName);
            this.orderPhone.add(memberPhone);
            this.orderResult.add(Dummies.order.get(i).getComplete());
            this.orderMenu.add(menu);
            this.orderPrice.add(price);
            this.orderAddress.add(memberAddress);
            this.orderID.add(memberID);
            this.list.add(slist);

            orderNum++;
          }
        }
        System.out.println("\t(뒤로가기를 원하면 엔터를 입력해주세yo)\n");
        System.out.print("\t\t1.상세보기\n\n");
        System.out.print("\t\t입력 : ");
        String num = scan.nextLine();
        System.out.println("\n");
        if (num.equals("0")) {
          loop = false;
        } else if (num.equals("1")) {
          System.out.print("\t\t[어떤 항목으로 검색하시겠습니까?]\n\n\t\t1.주문번호\n\n\t\t2.주문자명\n\n\t\t3.전화번호\n\n");
          System.out.print("\t\t입력 : ");
          String num_search = scan.nextLine();
          System.out.println("\n");

          if (num_search.equals("1")) {
            findordernumber(true);
            Main.pause();
          } else if (num_search.equals("2")) {
            findname(true);
            Main.pause();
          } else if (num_search.equals("3")) {
            findphone(true);
            Main.pause();
          }
        }
      } else if (num_order.equals("0")) {
        loop = false;
      }
    } // loop
  }// main

  /**
   * 주문 수락 메소드
   *
   * @param id
   */
  public void accept(String id) {
    Random rnd = new Random();
    int r = rnd.nextInt(2) + 2001;
    Scanner scan = new Scanner(System.in);
    StoreMain storemain = new StoreMain();
    System.out.print("\n\n\t\t[주문을 수락하시겠습니까?]\n\n\t\t1.예 \n\n\t\t2.아니오\n\n");
    System.out.print("\t\t입력 : ");
    this.num_accept = scan.nextLine();
    System.out.println();

    if (this.num_accept.equals("1")) {
      for (int i = 0; i < Dummies.order.size(); i++) {
        if (Dummies.order.get(i).getWhatmean().equals(storemain.getStoreID())
            && Dummies.order.get(i).getAccept().equals("대기")
            && Dummies.order.get(i).getMemberID().equals(id)) {
          Dummies.order.get(i).setAccept("수락");
          Dummies.order.get(i).setRiderID("R" + r);
          break;
        }
      }
    } else if (this.num_accept.equals("2")) {
      System.out.println("\t이전 화면으로 이동합니다.\n");
    }

  }

  /**
   * 주문자 전화번호로 검색하여 조회해주는 메소드
   * @param b
   */
  public void findphone(boolean b) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\t\t전화번호 : ");
    String num_phone = scan.nextLine();
    System.out.println("\n");
    String id = "";
    for (int i = 0; i < this.list.size(); i++) {
      if (this.list.get(i).contains(num_phone)) {
        System.out.printf("\t\t주문번호 : %s\n\n", this.orderNum.get(i));
        System.out.printf("\t\t주문자명 : %s\n\n", this.orderName.get(i));
        System.out.printf("\t\t전화번호 : %s\n\n", this.orderPhone.get(i));
        System.out.printf("\t\t주소 : %s\n\n", this.orderAddress.get(i));
        System.out.printf("\t\t주문상품 : %s\n\n", this.orderMenu.get(i));
        System.out.printf("\t\t결제금액 : %,d원\n\n", Integer.parseInt(this.orderPrice.get(i)));
        System.out.printf("\t\t배달 결과 : %s\n\n", this.orderResult.get(i));
        id = this.orderID.get(i);
        break;

      }
    }
    if(b==true) {
      accept(id);
    }
  }

  /**
   * 주문자명으로 검색하여 조회해주는 메소드
   * @param b
   */
  public void findname(boolean b) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\t\t주문자명 : ");
    String num_name = scan.nextLine();
    System.out.println("\n");
    String id = "";

    for (int i = 0; i < this.list.size(); i++) {
      if (this.list.get(i).contains(num_name)) {
        System.out.printf("\t\t주문번호 : %s\n\n", this.orderNum.get(i));
        System.out.printf("\t\t주문자명 : %s\n\n", this.orderName.get(i));
        System.out.printf("\t\t전화번호 : %s\n\n", this.orderPhone.get(i));
        System.out.printf("\t\t주소 : %s\n\n", this.orderAddress.get(i));
        System.out.printf("\t\t주문상품 : %s\n\n", this.orderMenu.get(i));
        System.out.printf("\t\t결제금액 : %,d원\n\n", Integer.parseInt(this.orderPrice.get(i)));
        System.out.printf("\t\t배달 결과 : %s\n\n", this.orderResult.get(i));
        id = this.orderID.get(i);
        break;

      }
    }
    if(b==true) {
      accept(id);
    }
  }

  /**
   * 주문번호로 검색하여 조회해주는 메소드
   * @param b
   */
  public void findordernumber(boolean b) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\t\t주문번호 : ");
    String num_order = scan.nextLine();
    System.out.println("\n");
    String id = "";
    for (int i = 0; i < this.list.size(); i++) {
      if (this.list.get(i).contains(num_order)) {
        System.out.printf("\t\t주문번호 : %s\n\n", this.orderNum.get(i));
        System.out.printf("\t\t주문자명 : %s\n\n", this.orderName.get(i));
        System.out.printf("\t\t전화번호 : %s\n\n", this.orderPhone.get(i));
        System.out.printf("\t\t주소 : %s\n\n", this.orderAddress.get(i));
        System.out.printf("\t\t주문상품 : %s\n\n", this.orderMenu.get(i));
        System.out.printf("\t\t결제금액 : %,d원\n\n", Integer.parseInt(this.orderPrice.get(i)));
        System.out.printf("\t\t배달 결과 : %s\n\n", this.orderResult.get(i));
        id = this.orderID.get(i);
        break;
      }
    }
    if(b==true) {
      accept(id);
    }

  }

  /**
   * 회원 번호로 주문한 상품가격 찾는 메소드
   */
  public String findprice(String memberID) {
    String price = "";
    for (int i = 0; i < Dummies.order.size(); i++) {
      if (Dummies.order.get(i).getMemberID().equals(memberID)) {
        price = Dummies.order.get(i).getMenuprice();
      }
    }
    return price;
  }

  /**
   * 회원 번호로 주문한 상품 찾는 메소드
   */
  public String findfood(String memberID) {
    String menu = "";
    for (int i = 0; i < Dummies.order.size(); i++) {
      if (Dummies.order.get(i).getMemberID().equals(memberID)) {
        menu = Dummies.order.get(i).getMenu();
      }
    }
    return menu;
  }

  /**
   * 회원, 비회원 주소 찾는 메소드
   *
   * @param memberID
   * @return
   */
  public String findaddress(String memberID) {
    String memberaddress = "";
    for (int i = 0; i < Dummies.member.size(); i++) {
      if (Dummies.member.get(i).getMemberID().equals(memberID)) {
        memberaddress = Dummies.member.get(i).getMemberAddressCity() + " "
            + Dummies.member.get(i).getMemberAddressGu() + " "
            + Dummies.member.get(i).getMemberAddressDong();
      }
    }

    for (int i = 0; i < Dummies.nomember.size(); i++) {
      if (Dummies.nomember.get(i).getNomemberID().equals(memberID)) {
        memberaddress = Dummies.nomember.get(i).getNomemberSi() + " " + Dummies.nomember.get(i).getNomemberGu()
            + " " + Dummies.nomember.get(i).getNomemberDong();
      }
    }
    return memberaddress;
  }

  /**
   * 회원, 비회원 이름 찾는 메소드
   *
   * @param memberID
   * @return
   */
  public String namecheck(String memberID) {
    //

    //      MemberData member = new MemberData();
    String membername = "";
    for (int i = 0; i < Dummies.member.size(); i++) {
      if (Dummies.member.get(i).getMemberID().equals(memberID)) {
        membername = Dummies.member.get(i).getMemberName();
      }
    }

    for (int i = 0; i < Dummies.nomember.size(); i++) {
      if (Dummies.nomember.get(i).getNomemberID().equals(memberID)) {
        membername = Dummies.nomember.get(i).getNomemberName();
      }
    }
    return membername;

    //
  }

  /**
   * 회원, 비회원 전화번호 찾는 메소드
   *
   * @param memberID
   * @return
   */
  public String phonecheck(String memberID) {
    //      MemberData member = new MemberData();
    String memberphone = "";
    for (int i = 0; i < Dummies.member.size(); i++) {
      if (Dummies.member.get(i).getMemberID().equals(memberID)) {
        memberphone = Dummies.member.get(i).getMemberPhone();
      }
    }

    for (int i = 0; i < Dummies.nomember.size(); i++) {
      if (Dummies.nomember.get(i).getNomemberID().equals(memberID)) {
        memberphone = Dummies.nomember.get(i).getNomemberPhone();
      }
    }
    return memberphone;
  }

}
package mini.project.handler.Store;
import java.util.Scanner;
import mini.project.Main.App;
import mini.project.Main.Dummies;
import mini.project.Main.MenuData;
import mini.project.Main.MenuPriceData;

/**
 * 점포 - 1.점포 정보 수정화면
 */
public class StoreInfoAlter {

  /**
   * 메뉴 조회, 추가, 삭제 메인메소드
   */
  public void main() {
    boolean loop = true;
    while (loop) {
      Scanner scan = new Scanner(System.in);
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\n\n\t\t== 점포 정보 수정 ==");
      System.out.println("\n\t(뒤로가기를 원하면 0번을 입력해주세yo)\n");
      System.out.print("\t\t1.메뉴 조회 \n\n\t\t2.메뉴 추가 \n\n\t\t3.메뉴 삭제\n\n");
      System.out.print("\t\t이동할 화면 입력(숫자) : ");


      String num_alter = scan.nextLine();

      if(num_alter.equals("1")) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        search();
      }else if(num_alter.equals("2")) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        addmenu();
      } else if (num_alter.equals("3")) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        deletemenu();
      } else if (num_alter.equals("0")) {
        loop = false;
      } else {
        System.out.println("\t잘못 입력하셨습니다. 다시 입력해 주세요.");
      }
    }//loop
  }// main

  /**
   * 메뉴 조회 메소드
   */
  private void search() {
    MenuData menu = new MenuData();
    MenuPriceData menuprice = new MenuPriceData();
    StoreMain storemain = new StoreMain();
    Scanner scan = new Scanner(System.in);
    boolean loop = true;
    int num = 0;

    while(loop) {
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\n\n\t\t== 등록된 메뉴 ==\n");
      System.out.println("\t\t<메뉴>\t<가격>\n");
      for(int i=0; i<Dummies.menu.size(); i++) {
        if(Dummies.menu.get(i).getStoreID().equals(storemain.getStoreID())) {
          num = i;
          for(int j=1; j<4; j++) {
            if(j==1) {
              if(!Dummies.menu.get(i).getMenu1().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu1(), Dummies.menuprice.get(i).getPrice1() );
              }
            } else if(j==2) {
              if(!Dummies.menu.get(i).getMenu2().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu2(), Dummies.menuprice.get(i).getPrice2() );
              }
            } else if(j==3) {
              if(!Dummies.menu.get(i).getMenu3().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu3(), Dummies.menuprice.get(i).getPrice3() );
              }
            }
          }
          break;
        }
      }//for

      System.out.println("\t(뒤로가기를 원하면 엔터를 입력해주세yo)\n");
      scan.nextLine();
      loop = false;
    }//loop

  }



  /**
   * 메뉴 추가 메소드
   */
  private static void addmenu() {
    MenuData menu = new MenuData();
    MenuPriceData menuprice = new MenuPriceData();
    StoreMain storemain = new StoreMain();
    Scanner scan = new Scanner(System.in);
    boolean loop = true;

    while (loop) {
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\n\n\t\t== 등록된 메뉴 ==\n");
      System.out.println("\t\t<메뉴>\t\t<가격>\n");
      for(int i=0; i<Dummies.menu.size(); i++) {
        if(Dummies.menu.get(i).getStoreID().equals(storemain.getStoreID())) {
          for(int j=1; j<4; j++) {
            if(j==1) {
              if(!Dummies.menu.get(i).getMenu1().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu1(), Dummies.menuprice.get(i).getPrice1() );
              }
            } else if(j==2) {
              if(!Dummies.menu.get(i).getMenu2().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu2(), Dummies.menuprice.get(i).getPrice2() );
              }
            } else if(j==3) {
              if(!Dummies.menu.get(i).getMenu3().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu3(), Dummies.menuprice.get(i).getPrice3() );
              }
            }
          }
          break;
        }
      }//for
      int error = 0;
      for (int i = 1; i < 4; i++) {
        if(i==1) {
          System.out.println("\t(뒤로가기를 원하면 0번을 입력해주세yo)\n");
        }
        System.out.printf("\n\n\t\t== 메뉴%d 추가 ==\n\n", i);
        System.out.printf("\t메뉴%d : ", i);
        String menuName = scan.nextLine();
        if(i==1) {
          if(menuName.equals("0")) {
            loop = false;
            break;
          }
        }
        System.out.println();
        System.out.print("\t가격(원) : ");
        String menuPrice = scan.nextLine();
        System.out.println();

        if(menuName.equals("") || menuPrice.equals("")) {
          System.out.println("\t\t잘못된 값을 입력하셨습니다.\n\n\t\t이전 단계로 이동합니다.\n");
          App.pause();
          break;
        }
        if (i == 1) {
          menu.setMenu1(menuName);
          menuprice.setPrice1(Integer.parseInt(menuPrice));
        } else if (i == 2) {
          menu.setMenu2(menuName);
          menuprice.setPrice2(Integer.parseInt(menuPrice));
        } else if (i == 3) {
          menu.setMenu3(menuName);
          menuprice.setPrice3(Integer.parseInt(menuPrice));
          System.out.println("\t\t메뉴가 추가되었습니다.\n");
          App.pause();
        }


      } // for
      menu.setStoreID(storemain.getStoreID());
      menuprice.setStoreID(storemain.getStoreID());
      Dummies.menu.add(menu);
      Dummies.menuprice.add(menuprice);

      loop = false;
    } // loop

  }


  /**
   * 메뉴 삭제 메소드
   */
  private static void deletemenu() {
    StoreMain storemain = new StoreMain();
    Scanner scan = new Scanner(System.in);
    int num=-1;
    boolean loop = true;

    while (loop) {

      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      System.out.println("\n\n\t\t== 메뉴 삭제 ==\n");
      System.out.println("\t\t<메뉴>\t\t<가격>\n");
      for(int i=0; i<Dummies.menu.size(); i++) {
        if(Dummies.menu.get(i).getStoreID().equals(storemain.getStoreID())) {
          num = i;
          for(int j=1; j<4; j++) {
            if(j==1) {
              if(!Dummies.menu.get(i).getMenu1().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu1(), Dummies.menuprice.get(i).getPrice1() );
              }
            } else if(j==2) {
              if(!Dummies.menu.get(i).getMenu2().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu2(), Dummies.menuprice.get(i).getPrice2() );
              }
            } else if(j==3) {
              if(!Dummies.menu.get(i).getMenu3().equals("")) {
                System.out.printf("\t메뉴%d\t%s : %,d원\n\n", j, Dummies.menu.get(i).getMenu3(), Dummies.menuprice.get(i).getPrice3() );
              }
            }
          }
          break;
        }
      }//for
      System.out.print("\n\n\t\t[어떤 메뉴를 삭제하시겠습니까?]\n\n");
      System.out.println("\t(뒤로가기를 원하면 0번을 입력해주세yo)\n");
      System.out.print("\t\t삭제할 메뉴 : ");
      String delmenu = scan.nextLine();

      if(delmenu.equals("0")) {
        loop = false;
        break;
      }
      if(delmenu.equals("1")) {
        Dummies.menu.get(num).setMenu1("");;
        Dummies.menuprice.get(num).setPrice1(0);
        System.out.println("\n\t\t삭제가 완료되었습니다.");
        App.pause();
        loop = false;
      } else if(delmenu.equals("2")) {
        Dummies.menu.get(num).setMenu2("");;
        Dummies.menuprice.get(num).setPrice2(0);
        System.out.println("\n\t\t삭제가 완료되었습니다.");
        App.pause();
        loop = false;
      } else if(delmenu.equals("3")) {
        Dummies.menu.get(num).setMenu3("");;
        Dummies.menuprice.get(num).setPrice3(0);
        System.out.println("\n\t\t삭제가 완료되었습니다.");
        App.pause();
        loop = false;
      } else {
        System.out.println("\n\n\t\t잘못 입력하셨습니다. \n\n\t\t다시 입력해주세요.\n");
      }


    } // loop
  }
}
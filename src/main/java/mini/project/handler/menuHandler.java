package mini.project.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import mini.project.domain.Menu;
import mini.project.util.Prompt;

public class menuHandler {
  ArrayList<Menu> menuList = new ArrayList<>();
  orderHandler orderHandler;

  public menuHandler(ArrayList<Menu> list, orderHandler orderHandler) {
    this.menuList = list;
    this.orderHandler = orderHandler;
  }

  public void add() {
    System.out.println("[메뉴 주문]");
    System.out.println("현재 저희 업체는 코로나로 인해,");
    System.out.println("야식만 배달 가능합니다.");
    System.out.println();
    System.out.println("**************메뉴**************");
    System.out.println("*******1. 피자 (10,000원)*******");
    System.out.println("*******2. 치킨 (10,000원)*******");
    System.out.println("*******3. 보쌈 (10,000원)*******");
    System.out.println("*******4. 족발 (10,000원)*******");
    System.out.println("*******5. 곱창 (10,000원)*******");
    System.out.println("********************************");


    Menu menu = new Menu();
    menu.setFood(Prompt.inputString("메뉴 선택: "));
    menu.setNum(Prompt.inputInt("수량: "));
    menu.setOrderedDate(new Date(System.currentTimeMillis())); //주문일시


    while (true) {
      String food = Prompt.inputString("주문하시겠습니까?(취소: 빈 문자열) ");

      if (food.length() == 0) {
        System.out.println("메뉴 주문을 취소합니다.");
        return;
      } else{
        menu.setFood(food);
        break;
      }

      System.out.println("존재하는 메뉴가 아닙니다.");
    }

    StringBuilder food = new StringBuilder();
    while (true) {
      String num = Prompt.inputString("수량?(완료: 빈 문자열) ");

      if (num.length() == 0) {
        break;
      } else if (num != null) {
        if (num.length() > 0) {
          food.append(menu);
        } else {
          System.out.println("1개 이상 주문해주세요.");
        }
      }

      menu.setFood(food.toString());

      menuList.add(menu);
    }

    public void list() {
      System.out.println("[주문 리스트]");

      Iterator<Menu> iterator = menuList.iterator();

      while (iterator.hasNext()) {
        Menu Menu = iterator.next();
        System.out.printf("%d, %s, %d, %s\n",
            Menu.getNo(),
            Menu.getFood(),
            Menu.getNum(),
            Menu.getOrderedDate()
            );
      }
    }

    public void detail() {
      System.out.println("[주문 상세보기]");
      int num = Prompt.inputInt("번호? ");
      Menu Menu = findBynum(num);

      if (Menu == null) {
        System.out.println("해당 번호의 프로젝트가 없습니다.");
        return;
      }

      System.out.printf("주문메뉴: %s\n", Menu.getFood());
      System.out.printf("수량: %d\n", Menu.getNum());
      System.out.printf("주문일시: %s\n", Menu.getOrderedDate());
    }

    public void update() {
      System.out.println("[주문 변경]");
      int no = Prompt.inputInt("주문번호? ");
      Menu menu = findBynum(no);

      if (menu == null) {
        System.out.println("해당 번호의 주문이 없습니다.");
        return;
      }

      String food = Prompt.inputString(
          String.format("메뉴명(%s)? ", menu.getFood()));
      int num = Prompt.inputInt(
          String.format("수량(%s)? ", menu.getNum()));
      Date orderedDate = Prompt.inputDate(
          String.format("주문일(%s)? ", menu.getOrderedDate()));

      String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
      if (!response.equalsIgnoreCase("y")) {
        System.out.println("주문 변경을 취소하였습니다.");
        return;
      }

      menu.setFood(food);
      menu.setNum(num);

      System.out.println("주문을 변경하였습니다.");
    }

    public void delete() {
      System.out.println("[주문 삭제]");
      int no = Prompt.inputInt("주문 번호? ");
      int index = indexOf(no);

      if (index == -1) {
        System.out.println("해당 번호의 주문이 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
      if (!response.equalsIgnoreCase("y")) {
        System.out.println("주문 전체 삭제를 취소하였습니다.");
        return;
      }

      menuList.remove(index);
      System.out.println("주문을 전체 삭제하였습니다.");
    }

    private Menu findBynum(int no) {
      for (int i = 0; i < menuList.size(); i++) {
        Menu Menu = menuList.get(i);
        if (Menu.getNum() == no) {
          return Menu;
        }
      }
      return null;
    }

    private int indexOf(int no) {
      for (int i = 0; i < menuList.size(); i++) {
        Menu Menu = menuList.get(i);
        if (Menu.getNum() == no) {
          return i;
        }
      }
      return -1;
    }
  }

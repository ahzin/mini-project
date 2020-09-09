package mini.project.handler;

import java.sql.Date;
import java.util.ArrayList;
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
      } else if (menuHandler.findByName(food) != null) {
        menu.setOwner(food);
        break;
      }

      System.out.println("존재하는 메뉴가 아닙니다.");
    }

    StringBuilder food = new StringBuilder();
    while (true) {
      String num = Prompt.inputString("수량?(완료: 빈 문자열) ");

      if (num.length() == 0) {
        break;
      } else if (menuHandler.findByName(num) != null) {
        if (menu.length() > 0) {
          food.append(menu);
        } else {
          System.out.println("1개 이상 주문해주세요.");
        }
      }
      menu.setFood(food.toString());

      menuList.add(menu);
    }

    public void list() {
      System.out.println("[프로젝트 목록]");

      Iterator<Menu> iterator = menuList.iterator();

      while (iterator.hasNext()) {
        Menu Menu = iterator.next();
        System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
            Menu.getnum(),
            Menu.getTitle(),
            Menu.getStartDate(),
            Menu.getEndDate(),
            Menu.getOwner(),
            Menu.getMembers());
      }
    }

    public void detail() {
      System.out.println("[프로젝트 상세보기]");
      int num = Prompt.inputInt("번호? ");
      Menu Menu = findBynum(num);

      if (Menu == null) {
        System.out.println("해당 번호의 프로젝트가 없습니다.");
        return;
      }

      System.out.printf("프로젝트명: %s\n", Menu.getTitle());
      System.out.printf("내용: %s\n", Menu.getContent());
      System.out.printf("기간: %s ~ %s\n", Menu.getStartDate(), Menu.getEndDate());
      System.out.printf("만든이: %s\n", Menu.getOwner());
      System.out.printf("팀원: %s\n", Menu.getMembers());
    }

    public void update() {
      System.out.println("[프로젝트 변경]");
      int num = Prompt.inputInt("번호? ");
      Menu Menu = findBynum(num);

      if (Menu == null) {
        System.out.println("해당 번호의 프로젝트가 없습니다.");
        return;
      }

      String title = Prompt.inputString(
          String.format("프로젝트명(%s)? ", Menu.getTitle()));
      String content = Prompt.inputString(
          String.format("내용(%s)? ", Menu.getContent()));
      Date startDate = Prompt.inputDate(
          String.format("시작일(%s)? ", Menu.getStartDate()));
      Date endDate = Prompt.inputDate(
          String.format("종료일(%s)? ", Menu.getEndDate()));

      String owner = null;
      while (true) {
        String name = Prompt.inputString(
            String.format("만든이(%s)?(취소: 빈 문자열) ", Menu.getOwner()));
        if (name.length() == 0) {
          System.out.println("프로젝트 등록을 취소합니다.");
          return;
        } else if (memberHandler.findByName(name) != null) {
          owner = name;
          break;
        }
        System.out.println("등록된 회원이 아닙니다.");
      }

      StringBuilder members = new StringBuilder();
      while (true) {
        String name = Prompt.inputString(
            String.format("팀원(%s)?(완료: 빈 문자열) ", Menu.getMembers()));
        if (name.length() == 0) {
          break;
        } else if (memberHandler.findByName(name) != null) {
          if (members.length() > 0) {
            members.append(",");
          }
          members.append(name);
        } else {
          System.out.println("등록된 회원이 아닙니다.");
        }
      }

      String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
      if (!response.equalsIgnumreCase("y")) {
        System.out.println("프로젝트 변경을 취소하였습니다.");
        return;
      }

      Menu.setTitle(title);
      Menu.setContent(content);
      Menu.setStartDate(startDate);
      Menu.setEndDate(endDate);
      Menu.setOwner(owner);
      Menu.setMembers(members.toString());

      System.out.println("프로젝트를 변경하였습니다.");
    }

    public void delete() {
      System.out.println("[프로젝트 삭제]");
      int num = Prompt.inputInt("번호? ");
      int index = indexOf(num);

      if (index == -1) {
        System.out.println("해당 번호의 프로젝트가 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
      if (!response.equalsIgnumreCase("y")) {
        System.out.println("프로젝트 삭제를 취소하였습니다.");
        return;
      }

      menuList.remove(index);
      System.out.println("프로젝트를 삭제하였습니다.");
    }

    private Menu findBynum(int num) {
      for (int i = 0; i < menuList.size(); i++) {
        Menu Menu = menuList.get(i);
        if (Menu.getnum() == num) {
          return Menu;
        }
      }
      return null;
    }

    private int indexOf(int num) {
      for (int i = 0; i < menuList.size(); i++) {
        Menu Menu = menuList.get(i);
        if (Menu.getnum() == num) {
          return i;
        }
      }
      return -1;
    }
  }

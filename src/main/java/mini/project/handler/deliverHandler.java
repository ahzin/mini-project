package mini.project.handler;

import java.util.ArrayList;
import mini.project.domain.Deliver;
import mini.project.util.Prompt;

public class deliverHandler {

  ArrayList<Deliver> deliverList = new ArrayList<>();

  public void add() {
    System.out.println("[배달 정보]");

    Deliver deliver = new Deliver();
    deliver.setNo(Prompt.inputInt("주문번호? "));
    deliver.setName(Prompt.inputString("라이더 이름? "));
    deliver.setTel(Prompt.inputString("라이더 번호? "));

    deliverList.add(deliver);
  }

  public void list() {
    System.out.println("[배달 목록]");

    for (int i = 0; i < deliverList.size(); i++) {
      Deliver deliver = deliverList.get(i);
      System.out.printf("주문 번호:%d, "
          + "담당라이더:%s, "
          + "라이더번호:%s, "
          + "주문시간:%s, "
          + "가게주소:%s, "
          + "배달주소:%s\n",
          deliver.getNo(),
          deliver.getName(),
          deliver.getTel()

          //추가 해야할 것 !!
          //주문시간
          //가게주소
          //배달주소
          );
    }
  }

  public Deliver findByName(String name) {
    for (int i = 0; i < deliverList.size(); i++) {
      Deliver deliver = deliverList.get(i);
      if (deliver.getName().equals(name)) {
        return deliver;
      }
    }
    return null;
  }

  public void delete() {
    System.out.println("[배달 삭제]");
    int no = Prompt.inputInt("주문번호? ");
    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 주문이 없습니다.");
      return;
    }

    String response = Prompt.inputString("배달을 완료하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("배달완료를 취소하였습니다.");
      return;
    }

    deliverList.remove(index);
    System.out.println("배달을 완료하였습니다.");
  }

  @SuppressWarnings("unused")
  private Deliver findByNo(int no) {
    for (int i = 0; i < deliverList.size(); i++) {
      Deliver deliver = deliverList.get(i);
      if (deliver.getNo() == no) {
        return deliver;
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < deliverList.size(); i++) {
      Deliver deliver = deliverList.get(i);
      if (deliver.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


package mini.project.handler;


import java.sql.Date;
import java.util.ArrayList;

import mini.project.domain.order;
import mini.project.util.Prompt;


public class orderHandler {

	  ArrayList<order> orderList = new ArrayList<>();

	  public void add() {
	    System.out.println("[주문]");

	    order order = new order();
	    
	    order.setNo(Prompt.inputInt("번호? "));
	    order.setId(Prompt.inputString("ID? "));
	    order.setName(Prompt.inputString("이름? "));
	    order.setAddress(Prompt.inputString("주소? "));
	    order.setHp(Prompt.inputString("전화번호? "));
	    
	    // #주문시간?
	    order.setOrderedDate(new Date(System.currentTimeMillis()));
	    
	    order.setViewCount(0);

	    orderList.add(order);

	    System.out.println("주문 완료");
	  }

	  public void list() {
	    System.out.println("[주문 목록]");

	    for (int i = 0; i < orderList.size(); i++) {
	      order order = orderList.get(i);
	      System.out.printf("%d, %s, %s, %s, %s, %s, %d\n",
	          order.getNo(),
	          order.getId(),
	          order.getName(),
	          order.getAddress(),
	          order.getHp(),
	          order.getOrderedDate(),
	          order.getViewCount());
	    }
	  }

	  public void detail() {
	    System.out.println("[주문 상세보기]");
	    int no = Prompt.inputInt("번호? ");
	    order order = findByNo(no);

	    if (order == null) {
	      System.out.println("해당 번호의 주문이 없습니다.");
	      return;
	    }

	    order.setViewCount(order.getViewCount() + 1);

	    System.out.printf("ID: %s\n", order.getId());
	    System.out.printf("이름: %s\n", order.getName());
	    System.out.printf("주소: %s\n", order.getAddress());
	    System.out.printf("전화번호: %s\n", order.getHp());
	    System.out.printf("주문일: %s\n", order.getOrderedDate());
	    System.out.printf("조회수: %d\n", order.getViewCount());
	  }
	  // # 주문변경?
	  public void update() {
	    System.out.println("[주문 변경]");
	    int no = Prompt.inputInt("번호? ");
	    order order = findByNo(no);

	    if (order == null) {
	      System.out.println("해당 번호의 게시글이 없습니다.");
	      return;
	    }
	    
	    String name = Prompt.inputString(
		    String.format("주소(%s)? ", order.getName()));
	    String address = Prompt.inputString(
	        String.format("주소(%s)? ", order.getAddress()));
	    String hp = Prompt.inputString(
	        String.format("전화번호(%s)? ", order.getHp()));
	   

	    String response = Prompt.inputString("정말 변경하시겠습니까?(Y/N) ");
	    if (!response.equalsIgnoreCase("y")) {
	      System.out.println("변경을 취소하였습니다.");
	      return;
	    }

	    order.setName(name);
	    order.setAddress(address);
	    order.setHp(hp);
	    
	    System.out.println("게시글을 변경하였습니다.");
	  }

	  public void delete() {
	    System.out.println("[주문 취소]");
	    int no = Prompt.inputInt("번호? ");
	    int index = indexOf(no);

	    if (index == -1) {
	      System.out.println("해당 번호의 주문이 없습니다.");
	      return;
	    }

	    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
	    if (!response.equalsIgnoreCase("y")) {
	      System.out.println("주문을 취소하였습니다.");
	      return;
	    }

	    orderList.remove(index);
	    System.out.println("게시글을 삭제하였습니다.");
	  }

	  private order findByNo(int no) {
	    for (int i = 0; i < orderList.size(); i++) {
	      order order = orderList.get(i);
	      if (order.getNo() == no) {
	        return order;
	      }
	    }
	    return null;
	  }

	  private int indexOf(int no) {
	    for (int i = 0; i < orderList.size(); i++) {
	      order order = orderList.get(i);
	      if (order.getNo() == no) {
	        return i;
	      }
	    }
	    return -1;
	  }
}


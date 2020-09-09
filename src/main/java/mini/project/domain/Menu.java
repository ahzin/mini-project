package mini.project.domain;

import java.sql.Date;

public class Menu {
  //메뉴 정보
  private int no; //주문번호
  private int menu;  // 메뉴
  //private int pay; //가격
  private int option; //수량
  private Date orderedDate; //주문일자
  private int viewCount;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getOption() {
    return option;
  }
  public void setOption(int option) {
    this.option = option;
  }
  public int getMenu() {
    return menu;
  }
  public void setMenu(int menu) {
    this.menu = menu;
  }

  public Date getOrderedDate() {
    return orderedDate;
  }
  public void setOrderedDate(Date orderedDate) {
    this.orderedDate = orderedDate;
  }

  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

}
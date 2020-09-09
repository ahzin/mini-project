package mini.project.domain;

import java.sql.Date;

public class Menu {
  //메뉴 정보
  private int no; //주문번호
  private String food;  // 메뉴
  private int num; //수량
  private Date orderedDate; //주문일자
  private int viewCount;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public String getFood() {
    return food;
  }
  public void setFood(String food) {
    this.food = food;
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
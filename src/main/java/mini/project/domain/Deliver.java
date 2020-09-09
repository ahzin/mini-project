package mini.project.domain;

public class Deliver {
  private int no; //주문번호
  //라이더 정보
  private String name;  // 라이더 이름
  private String tel; // 라이더 전화번호
  private int viewCount;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }

  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }


}
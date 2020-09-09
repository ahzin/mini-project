package mini.project.Main;

public class OrderData {
  private String accept;
  private String complete;
  private String memberID;
  private String whatmean;
  private String menu;
  private String menuprice;
  private String riderID;

  /**가게의 해당주문 수락상태를 불러오는 메소드*/
  public String getAccept() {
    return accept;
  }
  /**가게의 해당주문 수락상태를 설정하는 메소드*/
  public void setAccept(String accept) {
    this.accept = accept;
  }
  /**라이더의 해당주문 수락상태를 불러오는 메소드*/
  public String getComplete() {
    return complete;
  }
  /**라이더의 해당주문 수락상태를 설정하는 메소드*/
  public void setComplete(String complete) {
    this.complete = complete;
  }
  /**해당주문을 한 회원ID를 불러오는 메소드*/
  public String getMemberID() {
    return memberID;
  }
  /**해당주문을 한 회원ID를 설정하는 메소드*/
  public void setMemberID(String memberID) {
    this.memberID = memberID;
  }
  /**해당주문을 한 가게ID를 불러오는 메소드*/
  public String getWhatmean() {
    return whatmean;
  }
  /**해당주문을 한 가게ID를 설정하는 메소드*/
  public void setWhatmean(String whatmean) {
    this.whatmean = whatmean;
  }
  /**해당주문의 메뉴를 불러오는 메소드*/
  public String getMenu() {
    return menu;
  }
  /**해당주문의 메뉴를 설정하는 메소드*/
  public void setMenu(String menu) {
    this.menu = menu;
  }
  /**해당주문의 가격을 불러오는 메소드*/
  public String getMenuprice() {
    return menuprice;
  }
  /**해당주문의 가격을 설정하는 메소드*/
  public void setMenuprice(String menuprice) {
    this.menuprice = menuprice;
  }
  /**해당주문을 맡은 라이더ID를 불러오는 메소드*/
  public String getRiderID() {
    return riderID;
  }
  /**해당주문을 맡은 라이더ID를 설정하는 메소드*/
  public void setRiderID(String riderID) {
    this.riderID = riderID;
  }


  @Override
  /**주문을 출력하는 확인용 메소드*/
  public String toString() {
    return "OrderData [accept=" + accept + ", complete=" + complete + ", memberID=" + memberID + ", whatmean="
        + whatmean + ", menu=" + menu + ", menuprice=" + menuprice + ", riderID=" + riderID + "]";
  }
}

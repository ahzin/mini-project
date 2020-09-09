package mini.project.Main;

public class MenuData {
  private  String storeID;
  private  String menu1;
  private String menu2;
  private String menu3;

  /**메뉴 가게아이디를 불러오는 메소드*/
  public String getStoreID() {
    return storeID;
  }

  /**메뉴 가게아이디를 설정하는 메소드*/
  public void setStoreID(String storeID) {
    this.storeID = storeID;
  }
  /**해당 메뉴1을 불러오는 메소드*/
  public String getMenu1() {
    return menu1;
  }
  /**해당 메뉴1을 설정하는 메소드*/
  public void setMenu1(String menu1) {
    this.menu1 = menu1;
  }
  /**해당 메뉴1을 불러오는 메소드*/
  public String getMenu2() {
    return menu2;
  }
  /**해당 메뉴1을 설정하는 메소드*/
  public void setMenu2(String menu2) {
    this.menu2 = menu2;
  }
  /**해당 메뉴1을 불러오는 메소드*/
  public String getMenu3() {
    return menu3;
  }
  /**해당 메뉴1을 설정하는 메소드*/
  public void setMenu3(String menu3) {
    this.menu3 = menu3;
  }
  @Override
  /**메뉴 정보를 모두출력하는 확인용 메소드*/
  public String toString() {
    return "MenuData [storeID=" + storeID + ", menu1=" + menu1 + ", menu2=" + menu2 + ", menu3=" + menu3 + "]";
  }

}

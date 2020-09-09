package mini.project.Main;

public class MenuPriceData {
  private String storeID;

  private int price1;
  private int price2;
  private int price3;

  /**메뉴가격 해당 가게아이디를 불러오는 메소드*/
  public String getStoreID() {
    return storeID;
  }
  /**메뉴가격 해당 가게아이디를 설정하는 메소드*/
  public void setStoreID(String storeID) {
    this.storeID = storeID;
  }
  /**해당 메뉴가격1을 불러오는 메소드*/
  public int getPrice1() {
    return price1;
  }
  /**해당 메뉴가격1을 설정하는 메소드*/
  public void setPrice1(int price1) {
    this.price1 = price1;
  }
  /**해당 메뉴가격1을 불러오는 메소드*/
  public int getPrice2() {
    return price2;
  }
  /**해당 메뉴가격1을 불러오는 메소드*/
  public void setPrice2(int price2) {
    this.price2 = price2;
  }
  /**해당 메뉴가격1을 불러오는 메소드*/
  public int getPrice3() {
    return price3;
  }
  /**해당 메뉴가격1을 불러오는 메소드*/
  public void setPrice3(int price3) {
    this.price3 = price3;
  }

  @Override
  /**메뉴가격 클래스의 모든 변수를 출력하는 확인용 메소드*/
  public String toString() {
    return "MenuPriceData [storeID=" + storeID + ", price1=" + price1 + ", price2=" + price2 + ", price3=" + price3
        + "]";
  }
}

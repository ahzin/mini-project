package mini.project.Main;

public class StoreData {
  private  String storeID;
  private  String storePW;
  private  String storeName;
  private  String storePhone;
  private  String storeAddressCity;
  private  String storeAddressGu;
  private  String storeAddressDong;
  private  String storeOrderCount;

  /**해당 가게ID를 불러오는 메소드*/
  public String getStoreID() {
    return storeID;
  }
  /**해당 가게ID를 설정하는 메소드*/
  public void setStoreID(String storeID) {
    this.storeID = storeID;
  }
  /**해당 가게PW를 불러오는 메소드*/
  public String getStorePW() {
    return storePW;
  }
  /**해당 가게PW를 설정하는 메소드*/
  public void setStorePW(String storePW) {
    this.storePW = storePW;
  }
  /**해당 가게이름을 불러오는 메소드*/
  public String getStoreName() {
    return storeName;
  }
  /**해당 가게이름을 설정하는 메소드*/
  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }
  /**해당 가게번호를 불러오는 메소드*/
  public String getStorePhone() {
    return storePhone;
  }
  /**해당 가게번호를 설정하는 메소드*/
  public void setStorePhone(String storePhone) {
    this.storePhone = storePhone;
  }
  /**해당 가게 주소 시를 불러오는 메소드*/
  public String getStoreAddressCity() {
    return storeAddressCity;
  }
  /**해당 가게 주소 시를 설정하는 메소드*/
  public void setStoreAddressCity(String storeAddressCity) {
    this.storeAddressCity = storeAddressCity;
  }
  /**해당 가게 주소 구를 불러오는 메소드*/
  public String getStoreAddressGu() {
    return storeAddressGu;
  }
  /**해당 가게 주소 구를 설정하는 메소드*/
  public void setStoreAddressGu(String storeAddressGu) {
    this.storeAddressGu = storeAddressGu;
  }
  /**해당 가게 나머지 주소를 불러오는 메소드*/
  public String getStoreAddressDong() {
    return storeAddressDong;
  }
  /**해당 가게 나머지 주소를 설정하는 메소드*/
  public void setStoreAddressDong(String storeAddressDong) {
    this.storeAddressDong = storeAddressDong;
  }
  /**해당 가게 누적 주문수를 불러오는 메소드*/
  public String getStoreOrderCount() {
    return storeOrderCount;
  }
  /**해당 가게 누적 주문수를 설정하는 메소드*/
  public void setStoreOrderCount(String storeOrderCount) {
    this.storeOrderCount = storeOrderCount;
  }
  @Override
  public String toString() {
    return "StoreData [storeID=" + storeID + ", storePW=" + storePW + ", storeName=" + storeName + ", storePhone="
        + storePhone + ", storeAddressCity=" + storeAddressCity + ", storeAddressGu=" + storeAddressGu
        + ", storeAddressDong=" + storeAddressDong + ", storeOrderCount=" + storeOrderCount + "]";
  }

}

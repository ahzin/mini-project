package mini.project.handler.nomember;

// 주문시 선택된 점포의 데이터의 저장을 담당하는 클래스입니다.

public class SelectedStore {

  //멤버변수
  private  String seleStoreId="";
  private  String seleStoreName="";
  private  String seleStoreLocation="";
  private  String seleStoreOrderCount="";



  public String getSeleStoreId() {
    return seleStoreId;
  }
  public void setSeleStoreId(String seleStoreId) {
    this.seleStoreId = seleStoreId;
  }
  public String getSeleStoreName() {
    return seleStoreName;
  }
  public void setSeleStoreName(String seleStoreName) {
    this.seleStoreName = seleStoreName;
  }
  public String getSeleStoreLocation() {
    return seleStoreLocation;
  }
  public void setSeleStoreLocation(String seleStoreLocation) {
    this.seleStoreLocation = seleStoreLocation;
  }
  public String getSeleStoreOrderCount() {
    return seleStoreOrderCount;
  }
  public void setSeleStoreOrderCount(String seleStoreOrderCount) {
    this.seleStoreOrderCount = seleStoreOrderCount;
  }


  @Override
  public String toString() {
    return  "\t\t"+seleStoreId + "  " + seleStoreName  + "  \t" + seleStoreOrderCount +"\n" ;
  }





}

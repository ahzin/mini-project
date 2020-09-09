package mini.project.Main;

public class RiderData {
  private  String riderID;
  private  String riderPW;
  private  String riderName;
  private  String riderPhone;
  private  String riderAddressCity;
  private  String riderAddressGu;
  private  String riderStatus;

  /**라이더의 ID를 불러오는 메소드입니다*/
  public String getRiderID() {
    return riderID;
  }
  /**라이더의 ID를 설정하는 메소드입니다*/
  public void setRiderID(String riderID) {
    this.riderID = riderID;
  }
  /**라이더의 PW를 불러오는 메소드입니다*/
  public String getRiderPW() {
    return riderPW;
  }
  /**라이더의 PW를 설정하는 메소드입니다*/
  public void setRiderPW(String riderPW) {
    this.riderPW = riderPW;
  }
  /**라이더의 이름을 불러오는 메소드입니다*/
  public String getRiderName() {
    return riderName;
  }
  /**라이더의 이름을 설정하는 메소드입니다*/
  public void setRiderName(String riderName) {
    this.riderName = riderName;
  }
  /**라이더의 전화번호를 불러오는 메소드입니다*/
  public String getRiderPhone() {
    return riderPhone;
  }
  /**라이더의 전화번호를 설정하는 메소드입니다*/
  public void setRiderPhone(String riderPhone) {
    this.riderPhone = riderPhone;
  }
  /**라이더의 담당 주소 시를 불러오는 메소드입니다*/
  public String getRiderAddressCity() {
    return riderAddressCity;
  }
  /**라이더의 담당 주소 시를 설정하는 메소드입니다*/
  public void setRiderAddressCity(String riderAddressCity) {
    this.riderAddressCity = riderAddressCity;
  }
  /**라이더의 담당 주소 구를 불러오는 메소드입니다*/
  public String getRiderAddressGu() {
    return riderAddressGu;
  }
  /**라이더의 담당 주소 구를 설정하는 메소드입니다*/
  public void setRiderAddressGu(String riderAddressGu) {
    this.riderAddressGu = riderAddressGu;
  }
  /**라이더의 배달상태를 불러오는 메소드*/
  public String getRiderStatus() {
    return riderStatus;
  }
  /**라이더의 배달상태를 설정하는 메소드*/
  public void setRiderStatus(String riderStatus) {
    this.riderStatus = riderStatus;
  }
  @Override
  /**라이더 클래스의 정보를 출력하는 확인용 메소드*/
  public String toString() {
    return "RiderData [riderID=" + riderID + ", riderPW=" + riderPW + ", riderName=" + riderName + ", riderPhone="
        + riderPhone + ", riderAddressCity=" + riderAddressCity + ", riderAddressGu=" + riderAddressGu
        + ", riderStatus=" + riderStatus + "]";
  }

}

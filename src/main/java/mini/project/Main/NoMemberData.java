package mini.project.Main;

public class NoMemberData {
  private String nomemberID;
  private String nomemberName;
  private String nomemberPhone;
  private String nomemberSi;
  private String nomemberGu;
  private String nomemberDong;
  /**비회원 임시아이디를 불러오는 메소드*/
  public String getNomemberID() {
    return nomemberID;
  }
  /**비회원 임시아이디를 설정하는 메소드*/
  public void setNomemberID(String nomemberID) {
    this.nomemberID = nomemberID;
  }
  /**비회원 이름을 불러오는 메소드*/
  public String getNomemberName() {
    return nomemberName;
  }
  /**비회원 이름을 설정하는 메소드*/
  public void setNomemberName(String nomemberName) {
    this.nomemberName = nomemberName;
  }
  /**비회원 전화번호를 불러오는 메소드*/
  public String getNomemberPhone() {
    return nomemberPhone;
  }
  /**비회원 전화번호를 설정하는 메소드*/
  public void setNomemberPhone(String nomemberPhone) {
    this.nomemberPhone = nomemberPhone;
  }
  /**비회원 주소 시를 불러오는 메소드*/
  public String getNomemberSi() {
    return nomemberSi;
  }
  /**비회원 주소 시를 설정하는 메소드*/
  public void setNomemberSi(String nomemberSi) {
    this.nomemberSi = nomemberSi;
  }
  /**비회원 주소 구를 불러오는 메소드*/
  public String getNomemberGu() {
    return nomemberGu;
  }
  /**비회원 주소 구를 설정하는 메소드*/
  public void setNomemberGu(String nomemberGu) {
    this.nomemberGu = nomemberGu;
  }
  /**비회원 나머지 주소를 불러오는 메소드*/
  public String getNomemberDong() {
    return nomemberDong;
  }
  /**비회원 나머지 주소를 설정하는 메소드*/
  public void setNomemberDong(String nomemberDong) {
    this.nomemberDong = nomemberDong;
  }
  @Override
  /**비회원 정보 확인용 메소드*/
  public String toString() {
    return "NoMemberData [nomemberID=" + nomemberID + ", nomemberName=" + nomemberName + ", nomemberPhone="
        + nomemberPhone + ", nomemberSi=" + nomemberSi + ", nomemberGu=" + nomemberGu + ", nomemberDong="
        + nomemberDong + "]";
  }
}

package mini.project.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Dummies {
  /**외부저장소에있는 가게Data들을 저장하는 ArrayList*/
  public static ArrayList<StoreData> store = new ArrayList<StoreData>();
  /**외부저장소에있는 라이더Data들을 저장하는 ArrayList*/
  public static ArrayList<RiderData> rider = new ArrayList<RiderData>();
  /**외부저장소에있는 메뉴Data들을 저장하는 ArrayList*/
  public static ArrayList<MenuData> menu = new ArrayList<MenuData>();
  /**외부저장소에있는 메뉴가격Data들을 저장하는 ArrayList*/
  public static ArrayList<MenuPriceData> menuprice = new ArrayList<MenuPriceData>();
  /**외부저장소에있는 주문Data들을 저장하는 ArrayList*/
  public static ArrayList<OrderData> order = new ArrayList<OrderData>();
  /**외부저장소에있는 리뷰Data들을 저장하는 ArrayList*/
  public static ArrayList<NoMemberData> nomember = new ArrayList<NoMemberData>();

  /**라이더번호를 누적하는 static int (ex. R2001)*/
  public static int ridernumber ;
  /**한식가게번호를 누적하는 static int (ex. Sa132)*/
  public static int storeKORnumber ;
  /**중식가게번호를 누적하는 static int (ex. Sb132)*/
  public static int storeCHINAnumber ;
  /**일식가게번호를 누적하는 static int (ex. Sc132)*/
  public static int storeJAPANnumber ;
  /**치킨가게번호를 누적하는 static int (ex. Sd132)*/
  public static int storeCHICKENnumber ;
  /**피자가게번호를 누적하는 static int (ex. Se132)*/
  public static int storePIZZAnumber ;
  /**비회원번호를 누적하는 static int (ex. TC132)*/
  public static int temporaryMember;


  /**외부 저장소의 내용들을 불러와 변수에 저장시키는 메소드*/
  public void dummy() {

    try {
      /*외부저장소에 있는 회원Data들의 위치*/
      String path = "dat\\member.dat";
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String line = null;


      /*외부저장소에 있는 점포Data들의 위치*/
      String path2 = "dat\\store.dat";
      BufferedReader reader2 = new BufferedReader(new FileReader(path2));
      line = null;

      while ((line = reader2.readLine()) != null) {
        StoreData ss = new StoreData();
        String[] temp = line.split("\\|");
        ss.setStoreID(temp[0]);
        ss.setStorePW(temp[1]);
        ss.setStoreName(temp[2]);
        ss.setStorePhone(temp[3]);
        ss.setStoreAddressCity(temp[4]);
        ss.setStoreAddressGu(temp[5]);
        ss.setStoreAddressDong(temp[6]);
        ss.setStoreOrderCount(temp[7]);
        store.add(ss);
      }
      reader.close();

      /*외부저장소에 있는 라이더Data들의 위치*/
      String path3 = "dat\\rider.dat";
      BufferedReader reader3 = new BufferedReader(new FileReader(path3));
      line = null;

      while ((line = reader3.readLine()) != null) {
        RiderData rr = new RiderData();
        String[] temp = line.split("\\|");
        rr.setRiderID(temp[0]);
        rr.setRiderPW(temp[1]);
        rr.setRiderName(temp[2]);
        rr.setRiderPhone(temp[3]);
        rr.setRiderAddressCity(temp[4]);
        rr.setRiderAddressGu(temp[5]);
        rr.setRiderStatus(temp[6]);

        rider.add(rr);
      }
      reader.close();

      /*외부저장소에 있는 메뉴Data들의 위치*/
      String path4 = "dat\\menu.dat";
      BufferedReader reader4 = new BufferedReader(new FileReader(path4));
      line = null;

      while ((line = reader4.readLine()) != null) {
        MenuData me = new MenuData();
        String[] temp = line.split("\\|");
        me.setStoreID(temp[0]);

        me.setMenu1(temp[1]);
        me.setMenu2(temp[2]);
        me.setMenu3(temp[3]);

        menu.add(me);
      }
      reader.close();

      /*외부저장소에 있는 메뉴가격Data들의 위치*/
      String path5 = "dat\\menuprice.dat";
      BufferedReader reader5 = new BufferedReader(new FileReader(path5));
      line = null;

      while ((line = reader5.readLine()) != null) {
        MenuPriceData mp = new MenuPriceData();
        String[] temp = line.split("\\|");
        mp.setStoreID(temp[0]);

        mp.setPrice1(Integer.parseInt(temp[1]));
        mp.setPrice2(Integer.parseInt(temp[2]));
        mp.setPrice3(Integer.parseInt(temp[3]));

        menuprice.add(mp);
      }
      reader.close();


      /*외부저장소에 있는 주문Data들의 위치*/
      String path6 = "dat\\order.dat";
      BufferedReader reader6 = new BufferedReader(new FileReader(path6));
      line = null;

      while ((line = reader6.readLine()) != null) {
        OrderData ord = new OrderData();
        String[] temp = line.split("\\|");
        ord.setAccept(temp[0]);
        ord.setComplete(temp[1]);
        ord.setMemberID(temp[2]);
        ord.setWhatmean(temp[3]);
        ord.setMenu(temp[4]);
        ord.setMenuprice(temp[5]);
        ord.setRiderID(temp[6]);

        order.add(ord);
      }
      reader.close();

      /*외부저장소에 있는 비회원Data들의 위치*/
      String path8 = "dat\\nomember.dat";
      BufferedReader reader8 = new BufferedReader(new FileReader(path8));
      line = null;

      while ((line = reader8.readLine()) != null) {
        NoMemberData nomem = new NoMemberData();
        String[] temp = line.split("\\|");
        nomem.setNomemberID(temp[0]);
        nomem.setNomemberName(temp[1]);
        nomem.setNomemberPhone(temp[2]);
        nomem.setNomemberSi(temp[3]);
        nomem.setNomemberGu(temp[4]);
        nomem.setNomemberDong(temp[5]);

        nomember.add(nomem);
      }
      reader.close();



      /*외부저장소에 있는 라이더ID번호 Data의 위치*/
      String path11 = "dat\\ridernumber.dat";
      BufferedReader reader11 = new BufferedReader(new FileReader(path11));
      line = null;

      while ((line = reader11.readLine()) != null) {
        //              String[] temp = line.split("\\|");
        ridernumber = Integer.parseInt(line);

      }
      reader.close();



      /*외부저장소에 있는 가게ID번호 Data의 위치*/
      String path12 = "dat\\storenumber.dat";
      BufferedReader reader12 = new BufferedReader(new FileReader(path12));
      line = null;

      while ((line = reader12.readLine()) != null) {
        String[] temp = line.split("\\|");
        storeKORnumber = Integer.parseInt(temp[0]);
        storeCHINAnumber = Integer.parseInt(temp[1]);
        storeJAPANnumber = Integer.parseInt(temp[2]);
        storeCHICKENnumber = Integer.parseInt(temp[3]);
        storePIZZAnumber = Integer.parseInt(temp[4]);

      }
      reader.close();



      /*외부저장소에 있는 비회원번호 Data의 위치*/
      String path13 = "dat\\temporarynumber.dat";
      BufferedReader reader13 = new BufferedReader(new FileReader(path13));
      line = null;

      while ((line = reader13.readLine()) != null) {
        String[] temp = line.split("\\|");
        temporaryMember = Integer.parseInt(temp[0]);

      }
      reader.close();

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }// dummyMember

}// class

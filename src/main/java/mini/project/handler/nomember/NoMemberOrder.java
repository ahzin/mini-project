package mini.project.handler.nomember;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import main.Dummies;
import main.MenuData;
import main.MenuPriceData;

/**
 * 
 * @author 이다현 
 *비회원 주문을 담당하는 클래스입니다.
 */
public class NoMemberOrder {
	
	private static String noMemberName;
	private static String noMemberPhone;
	private static String noMemberAddressCity;
	private static String noMemberAddressGu;
	private static String noMemberAddressDong;
	private static Scanner scan;
	private static String storeID;

	private static String finalMenu;
	private static int finalPrice;
	private static int finalMenuCount;
	
	private String str1 = "";
	private String str2 = "";
	private String str3 = "";
	

	ArrayList<SelectedStore> list = new ArrayList<SelectedStore>();
	ArrayList<MenuOrder> menulist = new ArrayList<MenuOrder>();
	
	
	static {
		scan = new Scanner(System.in);
	}

	
	/**
	 * 비회원의 정보를 입력하고 같은 주소데이터를 지니는 점포에게 주문하는 메소드입니다.
	 */
	public void nomemberOrder() {


		// 비회원 주문 시, 정보입력하는 메소드
		inputNoMemberInfo();

		
		// 같은 주소지에 위치한 음식점들 불러오기
		storeCateSel();
		
		
	} 
	
	//주문하기2-메뉴선택
	private void menuSelect() {
		
			boolean loop = true;
			
			while(loop) {
				
			
			System.out.println("\n\t      (0을 입력하시면 뒤로 이동합니다.)\n\n");
			System.out.print("\t\t주문하실 메뉴의 번호를 입력해주세yo! ");
			System.out.print("\n\t\t◎ 메뉴 입력: ");
			String selNum3 = scan.nextLine();
			
			
			if(selNum3.equals("0")) {
				loop = false;
			
			}else {
				
				if(selNum3.equals("1")) {
					int index=str1.lastIndexOf(" "); 
					String temp = str1.substring(0, index);
					setFinalMenu(temp);
					
				System.out.print("\t\t주문하실 메뉴의 수량을 입력해주세yo! ");
				System.out.print("\n\t\t◎ 수량 입력: "); //고객이 원하는 수량을 입력함
				String selNum4 = scan.nextLine();
				setFinalMenuCount(selNum4);
				
				MenuOrder mlist = new MenuOrder();
				mlist.setMenuName(temp); //입력한 번호(메뉴명 출력)
				mlist.setMenuPrice(selNum4);//수량
						
				String temp2 = str1.substring(index+1); //입력한 번호의 가격	
				setFinalPrice(temp2);
				mlist.setTotalPrice(Integer.parseInt(temp2)*Integer.parseInt(selNum4));
			
				menulist.add(mlist);
				
				
				} else if(selNum3.equals("2")) {
					int index=str2.lastIndexOf(" "); 
					String temp = str2.substring(0, index);
					setFinalMenu(temp);
	
					System.out.print("\n\n\t\t주문하실 메뉴의 수량을 입력해주세yo! ");
					System.out.print("\n\t\t◎ 수량 입력: "); //고객이 원하는 수량을 입력함
					String selNum4 = scan.nextLine();
					setFinalMenuCount(selNum4);						
					
					MenuOrder mlist = new MenuOrder();
					mlist.setMenuName(temp); //입력한 번호
					mlist.setMenuPrice(selNum4);//수량
					
					String temp2 = str2.substring(index+1); //입력한 번호의 가격	
					setFinalPrice(temp2);
					mlist.setTotalPrice(Integer.parseInt(temp2)*Integer.parseInt(selNum4));
	
					menulist.add(mlist);
				
					
				}else if (selNum3.equals("3")) {
					
					int index=str3.lastIndexOf(" "); 
					String temp = str3.substring(0, index);
					setFinalMenu(temp);
					
					System.out.print("\n\n\t\t주문하실 메뉴의 수량을 입력해주세yo! ");
					System.out.print("\n\t\t◎ 수량 입력: "); //고객이 원하는 수량을 입력함
					String selNum4 = scan.nextLine();
					setFinalMenuCount(selNum4);
												
					MenuOrder mlist = new MenuOrder();
					mlist.setMenuName(temp); //입력한 번호
					mlist.setMenuPrice(selNum4);//수량
							
					String temp2 = str3.substring(index+1); //입력한 번호의 가격	
					setFinalPrice(temp2);
					mlist.setTotalPrice(Integer.parseInt(temp2)*Integer.parseInt(selNum4));
										
					menulist.add(mlist);
					
				} else {
					System.out.println("\n\n\t\t\t다시 입력해주세요 :) ");
					
				}
				
				
				System.out.print("\n\n\n\t\t   결제로 이동하시겠습니까? (Y/N)\n");
				System.out.println("\n\t\t추가주문을 원하실 경우 N을 입력해주세yo  ");
				System.out.println("\t\t(0을 입력하시면 뒤로 이동합니다.)\n");
				System.out.print("\t      \t\t입력 : ");
				
				String yesNo = scan.nextLine();
				System.out.println("\n\n");
				
				if(yesNo.equals("Y")) {
					
					//결제페이지로 이동
					orderPurchase();				
					
					
				} else if (yesNo.equals("N")) {
					//기능없음!!
					//추가 메뉴선택
	//				menuSelect();
				}
			}//0이아닐때의범위
			
		}//while	
	}

	//결제하기
	private void orderPurchase() {
		
		boolean loop = true;
		while(loop) {
			
			
			NoMemberOrderFinal orderFinal = new NoMemberOrderFinal();
			System.out.println("\n\n\n\t\t==========[ 결제 페이지 입니다 ]==========\n\n");
			System.out.println("\t     [주문한 메뉴]    [수량]  [결제 금액]");
			System.out.println("\t"+menulist.get(0));
	
			System.out.println("\t------------------------------");
			System.out.println("\n\t총 주문 금액 : "+menulist.get(0).getTotalPrice()+"\n\n");
			System.out.println("\t------------------------------");
			
			System.out.println("\t\t결제하시겠습니까? (Y/N)");//N은 0역할을합니다
			System.out.println("\t     (0을 입력하시면 뒤로 이동합니다.)\n\n");
			System.out.print("\t\t     입력 : ");
			
			String orderFinish = scan.nextLine();
			
			if(orderFinish.equals("Y")) {
				
				
				if((menulist.get(0).getTotalPrice() > 15000)) {
					
					System.out.println("\n\n\n\n\t\t 결제가 완료되었습니다 !  :)\n\n\n\n");
					System.out.println("");
					//주문 완료 후 
					orderFinal.lastCheck();
					loop = false;			
				} else {
				
					System.out.println("\n\n\t\t최소 결제금액 이상 주문해주세yo!");
					System.out.println("\t\t최소 결제금액은 15,000원 입니다.");
					menulist.clear(); //주문금액 미달 시 다시 list를 사용하기 위해 비움
					
				}
				
			
			} else if (orderFinish.equals("N")){
				System.out.println("\n\n\n\t\t     결제를 취소합니다.\n\n\n");
				loop = false;
			}
			
		}
	}//메소드

	
	
	//주문하기1-가게선택
	private  void storeSearch() {
		
		boolean loop = true;
		while(loop) {

			System.out.print("\n\n\t  주문하실 점포의 번호를 입력해주세yo :) \n\n");
			System.out.println("\t     (0을 입력하시면 뒤로 이동합니다.)\n");
			System.out.print("\t\t\t입력 : ");
			
			storeID = scan.nextLine();
			boolean check = false;
			setStoreID(storeID);
			String storeName = "";
				
			if(storeID.equals("0")) {
				loop = false;
			}else {
		
				for (int i = 0; i < Dummies.store.size() ; i++) {
												
					if (storeID.equals(Dummies.store.get(i).getStoreID())) {						
						storeName = Dummies.store.get(i).getStoreName();	
						for (MenuData m : Dummies.menu) {
							if(m.getStoreID().equals(storeID)) {			
								str1 = m.getMenu1();
								str2 = m.getMenu2();
								str3 = m.getMenu3();				
								check = true;
							}
						}
						for (MenuPriceData p : Dummies.menuprice) {
							if(p.getStoreID().equals(storeID)) {		
							str1 = str1 +"\t\t "+ p.getPrice1();
							str2 = str2 +"\t\t "+ p.getPrice1();
							str3 = str3 +"\t\t "+ p.getPrice1();
							}
						}
					}//if
				}//for
					
				if(check){
						
					System.out.println("\n\n\n  ========[ 안녕하세yo! "+storeName+"입니다. ]========\n");
					System.out.println("\t최소 주문금액: 15,000원");
					System.out.println("\n\t\t[ MENU ]\t\t[ PRICE ]\t\t\n");		
					
					System.out.println("\t\t1. "+str1+"\n");
					System.out.println("\t\t2. "+str2+"\n");
					System.out.println("\t\t3. "+str3+"\n");
	
					if(storeID.equals("Se401")) {
						//피자헛 강남구점
						System.out.println("\t\t4. 고구마피자\t\t23,000");
						System.out.println("\n\t\t5. 불고기피자\t\t24,000");
						System.out.println("\n\t\t6. 치즈피자\t\t16,000");
						System.out.println("\n\t\t7. 갈릭버터쉬림프피자\t26,000");
						System.out.println("\n\t\t8. 더블치즈스테이크피자\t22,500");
					} 
					if(storeID.equals("Sb401")) {
						//용문각 강남구점
						System.out.println("\t\t4. 양장피 \t\t23,000");
						System.out.println("\n\t\t5. 깐풍기 \t\t24,000");
						System.out.println("\n\t\t6. 탕수육 小\t\t16,000");
						System.out.println("\n\t\t7. 탕수육 中\t\t22,500");
						System.out.println("\n\t\t8. 탕수육 大\t\t26,000");
					}
					menuSelect();
				}else {
					System.out.println("\n\t\t잘못된 입력입니다.");
				}			
			}//else 0이아닐

		}//while
	}//메소드

	
	
	
	private  void orderSearch() {
		boolean loop = true;
		while(loop) {
			System.out.println("\n\n\n\t  ===============옵션 선택===============\n");
			System.out.println("\t\t   1. 바로 주문하기\n\n\t\t 2. 누적 주문 순으로 보기\n\t\t ");
			System.out.println("\t     (0을 입력하시면 뒤로 이동합니다.)\n");
			System.out.print("\t\t\t입력 : ");
			String selNum = scan.nextLine();
			
			 if (selNum.equals("1")) {
				
				 System.out.println(" ");
				 for(int i=0; i<list.size(); i++) {									
//						list.get(i);								
//						System.out.println(list.get(i));			
						System.out.println("\t\t"+list.get(i).getSeleStoreId()+"\t"
										+list.get(i).getSeleStoreName()+"\n");			
					}
			 
				 			 
				 //바로주문하기
				 storeSearch();
				 
			 } else if (selNum.equals("2")) {
				// 2. 누적 주문 순으로 보기
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				System.out.println("\n\n\n\t\t  2. 누적 주문 순으로 보기\n\n");
					
				for(int i=0; i<list.size(); i++) {			
						
					list.get(i);		
						
					Collections.sort(list, new Comparator<SelectedStore>() {
							
						public int compare(SelectedStore o1, SelectedStore o2) {	
							return Integer.parseInt(o2.getSeleStoreOrderCount())
									-Integer.parseInt(o1.getSeleStoreOrderCount());				
						}				
					});	
					
					System.out.println(list.get(i));
						
				}
				
				//누적 조회 이후의 주문

				storeSearch();
		
				
			
			} else if (selNum.equals("0")) {
				loop = false;
			} else {
				System.out.println("\n\n\t\t다시 입력해주세yo!");
				System.out.println("계속하시려면 엔터키를 입력해주세요");
				scan.nextLine();
			}
			 
		}//while
	}//메소드



	

	//집 주변 배달집 탐색 결과에 대해 출력해줌
	//storeCateSel() : 카테고리 별 검색
	private  void storeCateSel() {
		boolean loop = true;
		
		while(loop) {	
			System.out.printf("\r\n\n\n\t  나의 주소 : %s %s %s\n", noMemberAddressCity, noMemberAddressGu,
					noMemberAddressDong);
	
			System.out.println("\n\n\n\t\t집 주변 배달집 탐색 결과입니다.\n\n\n");
			System.out.println("          1.한식    2.중식    3.일식    4.치킨    5.피자  ");
			System.out.println("\n\t     (0을 입력하시면 뒤로 이동합니다.)\n\n");
			System.out.print("\t\t\t선택 : ");
			String selNum = scan.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

			
			
		
			if (selNum.equals("1")) {
				for (int i = 0; i < Dummies.store.size(); i++) {
					if (noMemberAddressCity.equals(Dummies.store.get(i).getStoreAddressCity())
							&& noMemberAddressGu.equals(Dummies.store.get(i).getStoreAddressGu())) {
						if (Dummies.store.get(i).getStoreID().contains("Sa")) {					
							System.out.println("\t\t   " + Dummies.store.get(i).getStoreID() + "  "
									+ Dummies.store.get(i).getStoreName()+"\n");				
							
							//클래스-인스턴스에 저장						
							SelectedStore selstore1 = new SelectedStore();						
							selstore1.setSeleStoreId(Dummies.store.get(i).getStoreID());
							selstore1.setSeleStoreName(Dummies.store.get(i).getStoreName());
							selstore1.setSeleStoreLocation(Dummies.store.get(i).getStoreAddressGu());
							selstore1.setSeleStoreOrderCount(Dummies.store.get(i).getStoreOrderCount());					
							list.add(selstore1);						
						}
					}				
				} // for			
				orderSearch();
				
			} else if (selNum.equals("2")) {
				for (int i = 0; i < Dummies.store.size(); i++) {
					if (noMemberAddressCity.equals(Dummies.store.get(i).getStoreAddressCity())
							&& noMemberAddressGu.equals(Dummies.store.get(i).getStoreAddressGu())) {
						if (Dummies.store.get(i).getStoreID().contains("Sb")) {
							System.out.println("\t\t   " + Dummies.store.get(i).getStoreID() + "  "
									+ Dummies.store.get(i).getStoreName()+"\n");
							
							//클래스-인스턴스에 저장
							SelectedStore selstore2 = new SelectedStore();	
							selstore2.setSeleStoreId(Dummies.store.get(i).getStoreID());
							selstore2.setSeleStoreName(Dummies.store.get(i).getStoreName());
							selstore2.setSeleStoreLocation(Dummies.store.get(i).getStoreAddressGu());
							selstore2.setSeleStoreOrderCount(Dummies.store.get(i).getStoreOrderCount());
							
							list.add(selstore2);
							
						}
	
					}
					
				} // for
				orderSearch();
	
			} else if (selNum.equals("3")) {
	
				for (int i = 0; i < Dummies.store.size(); i++) {
					if (noMemberAddressCity.equals(Dummies.store.get(i).getStoreAddressCity())
							&& noMemberAddressGu.equals(Dummies.store.get(i).getStoreAddressGu())) {
	
						if (Dummies.store.get(i).getStoreID().contains("Sc")) {
							
							System.out.println("\t\t   " + Dummies.store.get(i).getStoreID() + "  "
									+ Dummies.store.get(i).getStoreName()+"\n");
							
							//클래스-인스턴스에 저장
							
							SelectedStore selstore3 = new SelectedStore();
							
							selstore3.setSeleStoreId(Dummies.store.get(i).getStoreID());
							selstore3.setSeleStoreName(Dummies.store.get(i).getStoreName());
							selstore3.setSeleStoreLocation(Dummies.store.get(i).getStoreAddressGu());
							selstore3.setSeleStoreOrderCount(Dummies.store.get(i).getStoreOrderCount());
							
							list.add(selstore3);
		
						}
	
					}
					
				} // for
				orderSearch();
				
			} else if (selNum.equals("4")) {
	
				for (int i = 0; i < Dummies.store.size(); i++) {
					if (noMemberAddressCity.equals(Dummies.store.get(i).getStoreAddressCity())
							&& noMemberAddressGu.equals(Dummies.store.get(i).getStoreAddressGu())) {
	
						if (Dummies.store.get(i).getStoreID().contains("Sd")) {
							
							System.out.println("\t\t   " + Dummies.store.get(i).getStoreID() + "  "
									+ Dummies.store.get(i).getStoreName()+"\n");
							
							//클래스-인스턴스에 저장
							
							SelectedStore selstore4 = new SelectedStore();
							
							selstore4.setSeleStoreId(Dummies.store.get(i).getStoreID());
							selstore4.setSeleStoreName(Dummies.store.get(i).getStoreName());
							selstore4.setSeleStoreLocation(Dummies.store.get(i).getStoreAddressGu());
							selstore4.setSeleStoreOrderCount(Dummies.store.get(i).getStoreOrderCount());
							
							list.add(selstore4);
						
						}
	
					}
					
				} // for
				orderSearch();
				
			} else if (selNum.equals("5")) {
	
				for (int i = 0; i < Dummies.store.size(); i++) {
					if (noMemberAddressCity.equals(Dummies.store.get(i).getStoreAddressCity())
							&& noMemberAddressGu.equals(Dummies.store.get(i).getStoreAddressGu())) {
						
						if (Dummies.store.get(i).getStoreID().contains("Se")) {
							
							System.out.println("\t\t   " + Dummies.store.get(i).getStoreID() + "  "
									+ Dummies.store.get(i).getStoreName()+"\n");
							
							//클래스-인스턴스에 저장
							
							SelectedStore selstore5 = new SelectedStore();
							
							selstore5.setSeleStoreId(Dummies.store.get(i).getStoreID());
							selstore5.setSeleStoreName(Dummies.store.get(i).getStoreName());
							selstore5.setSeleStoreLocation(Dummies.store.get(i).getStoreAddressGu());
							selstore5.setSeleStoreOrderCount(Dummies.store.get(i).getStoreOrderCount());
							
							list.add(selstore5);
						}
						
	
					}
					
				} // for
				
				orderSearch();
			}else if(selNum.equals("0")){
				loop = false;
				
			}else {
				System.out.println("\n\n\t\t   다시 선택해주세yo !\n\n");
				System.out.println("\t  계속하시려면 엔터키를 입력해주세요");
				scan.nextLine();
			}
		}//while
	}

	/**
	 * 비회원 고객의 기본정보를 입력하는 메소드입니다.
	 */
	public void inputNoMemberInfo() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\r\n\n\n\t\t기본 정보를 입력해주세yo.\n\n");
		System.out.println();

		System.out.print("\n\t\t  고객 이름: ");
		noMemberName = scan.nextLine();

		System.out.print("\n\t\t  핸드폰 번호: ");
		noMemberPhone = scan.nextLine();

		System.out.print("\n\t\t  배송지(시): ");
		noMemberAddressCity = scan.nextLine();

		// 광역시: 서울시, 부산시, 대구시, 인천시, 광주시, 대전시, 울산시
		if (!(noMemberAddressCity.equals("서울시") || noMemberAddressCity.equals("부산시") ||
				noMemberAddressCity.equals("대구시") || noMemberAddressCity.equals("인천시") ||
				noMemberAddressCity.equals("광주시") || noMemberAddressCity.equals("대전시") ||
				noMemberAddressCity.equals("울산시"))) {
			System.out.println("\n\t\t정확하지 않은 입력입니다. 다시 입력해주세요");
			System.out.print("\n\t\t  배송지(시): ");
			noMemberAddressCity = scan.nextLine();		
		}

		// 구: 노원구, 송파구, 중랑구, 강서구, 동대문구, 중구, 구로구, 강북구,
		// 서대문구, 강동구, 금천구, 종로구, 용산구, 영등포구, 도봉구, 양천구
		// 관악구, 성북구, 광진구, 마포구, 강남구, 은평구, 서초구
		System.out.print("\n\t\t  배송지(구): ");
		noMemberAddressGu = scan.nextLine();

		if (!(noMemberAddressGu.equals("노원구") || noMemberAddressGu.equals("중랑구") ||
				noMemberAddressGu.equals("송파구") || noMemberAddressGu.equals("강서구") ||
				noMemberAddressGu.equals("동대문구") || noMemberAddressGu.equals("중구") ||
				noMemberAddressGu.equals("구로구") || noMemberAddressGu.equals("강북구") ||
				noMemberAddressGu.equals("서대문구") || noMemberAddressGu.equals("강동구")||
				noMemberAddressGu.equals("금천구") || noMemberAddressGu.equals("종로구")||
				noMemberAddressGu.equals("용산구") || noMemberAddressGu.equals("영등포구")||
				noMemberAddressGu.equals("도봉구") || noMemberAddressGu.equals("양천구")||
				noMemberAddressGu.equals("관악구") || noMemberAddressGu.equals("성북구")||
				noMemberAddressGu.equals("광진구") || noMemberAddressGu.equals("마포구")||
				noMemberAddressGu.equals("강남구") || noMemberAddressGu.equals("은평구")||
				noMemberAddressGu.equals("서초구"))) {
			
			System.out.println("정확하지 않은 입력입니다. 다시 입력해주세요");
			System.out.print("\n\t배송지(구): ");
			noMemberAddressGu = scan.nextLine();
		
		}

		System.out.print("\n\t\t  배송지(나머지 주소): ");
		noMemberAddressDong = scan.nextLine();

		
		
		setNoMemberName(noMemberName);
		setNoMemberPhone(noMemberPhone);
		setNoMemberAddressCity(noMemberAddressCity);
		setNoMemberAddressGu(noMemberAddressGu);
		setNoMemberAddressDong(noMemberAddressDong);
		
		System.out.println("\t  계속하시려면 엔터키를 입력해주세요");
		scan.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	
	}

	public String getNoMemberName() {
		return noMemberName;
	}

	public void setNoMemberName(String noMemberName) {
		NoMemberOrder.noMemberName = noMemberName;
	}

	public String getNoMemberPhone() {
		return noMemberPhone;
	}

	public void setNoMemberPhone(String noMemberPhone) {
		NoMemberOrder.noMemberPhone = noMemberPhone;
	}

	public String getNoMemberAddressCity() {
		return noMemberAddressCity;
	}

	public void setNoMemberAddressCity(String noMemberAddressCity) {
		NoMemberOrder.noMemberAddressCity = noMemberAddressCity;
	}

	public String getNoMemberAddressGu() {
		return noMemberAddressGu;
	}

	public void setNoMemberAddressGu(String noMemberAddressGu) {
		NoMemberOrder.noMemberAddressGu = noMemberAddressGu;
	}

	public String getNoMemberAddressDong() {
		return noMemberAddressDong;
	}

	public void setNoMemberAddressDong(String noMemberAddressDong) {
		NoMemberOrder.noMemberAddressDong = noMemberAddressDong;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		NoMemberOrder.storeID = storeID;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public String getStr3() {
		return str3;
	}

	public void setStr3(String str3) {
		this.str3 = str3;
	}

	public String getFinalMenu() {
		return finalMenu;
	}

	public void setFinalMenu(String finalMenu) {
		NoMemberOrder.finalMenu = finalMenu;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(String finalPrice) {
		NoMemberOrder.finalPrice = Integer.parseInt(finalPrice);
	}

	public int getFinalMenuCount() {
		return finalMenuCount;
	}

	public void setFinalMenuCount(String finalMenuCount) {
		NoMemberOrder.finalMenuCount = Integer.parseInt(finalMenuCount);
	}
	
	
	
	
	
}

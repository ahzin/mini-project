package mini.project.handler.nomember;

// 주문시 메뉴의 데이터를 저장담당 클래스
public class MenuOrder {

	private String menuName="";
	private String menuPrice="";
	private int totalPrice=0;
	
	

	
	@Override
	public String toString() {
		return "\t" + menuName  + menuPrice + "\t" + totalPrice;
	}


	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}

package mini.project.domain;

import java.sql.Date;
//
public class order {
	
	 private int no;
	 private String id;
	 private String name;
	 private String address;
	 private String hp;
	 private Date orderedDate;
	 private int viewCount;



	public int getNo() {
		return no;
	}
	public void setNo(int no) {
	    this.no = no;
	  }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	 

}

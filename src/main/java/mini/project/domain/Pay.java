package mini.project.domain;

import java.sql.Date;

public class Pay {

   private int no;
   private int num;
   private int method;
   private Date deliveredDate;
   private int viewCount;
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   
   public Date getDeliveredDate() {
      return deliveredDate;
   }
   public void setDeliveredDate(Date deliveredDate) {
      this.deliveredDate = deliveredDate;
   }
   
   public int getViewCount() {
      return viewCount;
   }
   public void setViewCount(int viewCount) {
      this.viewCount = viewCount;
   }
   public int getMethod() {
      return method;
   }
   public void setMethod(int method) {
      this.method = method;
   }
   
   
}
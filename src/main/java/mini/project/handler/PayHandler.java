package mini.project.handler;

import java.sql.Date;
import java.util.ArrayList;

import mini.project.domain.Menu;
import mini.project.domain.Pay;
import mini.project.util.Prompt;

public class PayHandler {

   ArrayList<Pay> payList = new ArrayList<>();
   MenuHandler menuHandler;
   
   public PayHandler(MenuHandler menuHandler) {
      this.menuHandler = menuHandler;
   }

    public void add() {
          System.out.println("[ 결제 ]");
      
          Pay pay = new Pay();
          
          pay.setNo(Prompt.inputInt("결제 번호: "));
          pay.setNum(Prompt.inputInt("수량: "));
          pay.setMethod(Prompt.inputInt("결제수단?\n0: 카드\n 1: 현금\n> "));
          pay.setDeliveredDate(new Date(System.currentTimeMillis())); // 결제시간

          payList.add(pay);
        }
    
    public void list() {
          System.out.println("[회원 목록]");

          for (int i = 0; i < payList.size(); i++) {
            Pay pay = payList.get(i);
            System.out.printf("%d, %d, %s\n",
                pay.getNo(),
                pay.getNum(),
                pay.getDeliveredDate());
          }
        }
    
    public void detail() {
          System.out.println("[회원 상세보기]");
          int no = Prompt.inputInt("번호? ");
          Pay pay = findByNo(no);

          if (pay == null) {
            System.out.println("해당 번호의 회원이 없습니다.");
            return;
          }

          System.out.printf("수량: %s\n", pay.getNum());
          System.out.printf("금액: %s\n", pay.getNum() * 10000 + 3000 ); // 수량 * 금액  + 배달료
          System.out.printf("배달예상시각: %s\n", pay.getDeliveredDate());
        }
    
    private Pay findByNo(int no) {
          for (int i = 0; i < payList.size(); i++) {
            Pay pay = payList.get(i);
            if (pay.getNo() == no) {
              return pay;
            }
          }
          return null;
        }




}
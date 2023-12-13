package vendingmachine;

import View.InputView;

import java.util.List;

public class VendingMachine {
    private static String SPLITER1= ";";
    private static String SPLITER2=",";
    private int [] cntArray;
    private List<Product> products; //상품들의 수

    VendingMachine(String ProductInfo){
      String [] Products= ProductInfo.split(SPLITER1);
      try{
          for(String product:Products){
              String [] productInfo=product.split(SPLITER2);
              if(productInfo.length !=3){
                  throw new IllegalArgumentException("[ERROR] 잘못된 물건 정보를 입력하셨습니다.");
              }
              Product p= new Product(productInfo[0], productInfo[1], productInfo[2]);
              products.add(p);
          }
      }catch(IllegalArgumentException e) {
          products.clear();
          System.out.println(e.getMessage());
          InputView.inputProductInfo();
      }
    };



}

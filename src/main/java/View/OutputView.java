package View;

public class OutputView {

    private static String vendingMachineMoneyMessage="자판기가 보유한 동전";

    public static void printMachineMoney(int [] cntArray){
        System.out.println(vendingMachineMoneyMessage);
        System.out.println("500원 - "+cntArray[0]+"개");
        System.out.println("100원 - "+cntArray[1]+"개");
        System.out.println("50원 - "+cntArray[2]+"개");
        System.out.println("10원 - "+cntArray[3]+"개");

    }


}

package Qwin;

import java.util.*;

public class Stocks {

    List<String> names = Arrays.asList( );


    List<String> namesa = new ArrayList<>();


    public int ne(int[] prices) {

        int maxProfit = 0;
        int minPrice = prices[0];
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        for (int price : prices) {
            int profit = price - minPrice;
             if (profit > maxProfit) {
                maxProfit = profit;
            } else if (price < minPrice){
                minPrice = price;
            }
        }
        return maxProfit;
    }
        public static void main(String[] args) {



            int[] all = {7,1,5,3,6,4};
            Stocks jbm = new Stocks();

            System.out.println(jbm.ne(all));

            int first = 0;
            int second = 1;
            int sum ;
            System.out.print("Fibonnacci Series: ");
            for (int i = 0;i < 8 ;i++){
                System.out.print(first + ", ");
                sum = first + second;
                first = second;
                second = sum;
            }

    }
}
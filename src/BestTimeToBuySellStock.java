public class BestTimeToBuySellStock {

    public static int bruteForce(int[] price){

        int maxProfit=0;

        for(int i = 0; i< price.length; i++){
            for(int j = i+1; j< price.length; j++){
                int cost = price[j]- price[i];
                maxProfit=Math.max(maxProfit,cost);
            }
        }
        return maxProfit;
    }

    public static int solve(int[] price){

        int mini= price[0];
        int maxProfit =0;

        for(int i = 1; i< price.length; i++){
            int cost= price[i]-mini;
            maxProfit =Math.max(maxProfit,cost);
            mini=Math.min(mini, price[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] price={7,1,5,3,6,4};
        int ans=solve(price);
        System.out.println(ans);
    }

}

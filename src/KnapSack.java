import java.util.Arrays;

public class KnapSack
{
    //Recursive Approach
    public static int recursiveKanpsack(int[]weight,int[] value,int totalWeight,int index)
    {
        if(index==0||totalWeight==0)
        {
            return 0;
        }
        if(weight[index-1]>totalWeight)
        {
            return recursiveKanpsack(weight, value, totalWeight, index-1);
        }else
            return Math.max(value[index-1]+recursiveKanpsack(weight, value, totalWeight-weight[index-1], index-1),
                    recursiveKanpsack(weight, value, totalWeight, index-1));
    }


    //Memoization Approach 
    public static int knapsack(int[] weight,int value[],int totalWeight,int n,int[][] arr)
    {
        if(n==0||totalWeight==0)
        {
            return 0;
        }
        if(arr[n][totalWeight]!=-1)
        {
            return arr[n][totalWeight];
        }
        if(weight[n-1]>totalWeight)
        {
            arr[n][totalWeight]= knapsack(weight, value, totalWeight, n-1,arr);
            return arr[n][totalWeight];
        }else
            arr[n][totalWeight]= Math.max(value[n-1]+knapsack(weight, value, totalWeight-weight[n-1], n-1,arr),
                    knapsack(weight, value, totalWeight, n-1,arr));
        return arr[n][totalWeight];
    }
    //Top Down DP Approach
    public static int topDownDp(int[] weight,int value[],int totalWeight,int size)
    {
        int dp[][]=new int[size+1][totalWeight+1];

        for(int i=0;i<=size;i++)
        {
            for(int j=0;j<=totalWeight;j++)
            {
                if(i==0||j==0)
                {
                    dp[i][j]=0;
                }else if(weight[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }else
                    dp[i][j]=Math.max(value[i-1]+dp[i][j-weight[i-1]], dp[i][j-1]);
            }
        }
        return dp[size][totalWeight];
    }



    public static void main(String [] args)
    {

        int[] value={60,100,120};
        int[] weight={10,20,30};
        int totalWeight=50;
        int [][]arr=new int[value.length+1][totalWeight+1];
        for(int i=0;i<arr.length;i++)
        {

            for(int j=0;j<arr[i].length;j++)
            {
                arr[i][j]=-1;
            }

        }
        System.out.println(topDownDp(weight,value,totalWeight,value.length));
    }
}
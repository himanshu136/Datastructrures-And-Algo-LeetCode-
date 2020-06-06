public class SubsetSum {

    private static boolean recursiveSubsetSum(int[] set,int index,int sum)
    {
        if(sum==0)
        {
            return true;
        }
        if(index==0 && sum!=0)
        {
            return false;
        }
        if (set[index - 1] > sum)
            return recursiveSubsetSum(set, index - 1, sum);

        return recursiveSubsetSum(set, index-1,sum)||recursiveSubsetSum(set, index-1,sum-set[index-1]);

    }

    private static boolean memoizationSubsetSum(int[] set,int index,int sum,int [][]dp)
    {
        if(sum==0)
        {
            return true;
        }
        if(dp[index][sum]!=-1)
        {
            return dp[index][sum]==1?true:false;
        }
        if(index==0 && sum!=0)
        {
            dp[index][sum]=0;
            return false;
        }
        if (set[index - 1] > sum)
            if(recursiveSubsetSum(set, index - 1, sum))
            {
                dp[index][sum]=1;
                return true;
            }else
            {
                dp[index][sum]=0;
                return false;

            }
        boolean a=recursiveSubsetSum(set, index-1,sum);
        boolean b=recursiveSubsetSum(set, index-1,sum-set[index-1]);

        if(a||b)
        {
            dp[index][sum]=1;
        }else{
            dp[index][sum]=0;
        }
        return a||b;

    }

    public static void main(String[] args) {
        int[] set={3,4,5,2};
        int sum=9;
        int dp[][]=new int[set.length+1][sum+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        System.out.println(memoizationSubsetSum(set,set.length,sum,dp));
    }
}

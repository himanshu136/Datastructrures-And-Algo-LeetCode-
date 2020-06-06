public class NumberOfDiceRollsWithTargetSum {
    //LeetCode 1155
    static double  MOD=1e9+7;
    public static int recursiveTargetSum(int face,int sum,int d)
    {
        if(sum==0 && d==0)
        {
            return 1;
        }
        if(d==0 || sum<0)
        {
            return 0;
        }
        int count=0;

        for (int i = 0; i <=face; i++) {
           count= (int) (count+recursiveTargetSum(face, sum-i,d-1) %MOD);
        }
        return count;
    }

    public static int topDown(int face,int sum,int d)
    {
        int dp[][]=new int[d+1][sum+1];
        for (int i = 0; i <=d; i++) {
            for (int j = 0; j <=sum; j++) {
                if(i==0&&j==0)
                {
                    dp[i][j]=1;
                }
                 else if(i==0||j==0) {
                    dp[i][j]=0;
                }
            }

        }
        int count=0;
        for (int i = 1; i <=d; i++) {
            for(int j=1;j<=sum;j++)
            {
                for (int k = 0; k <j&&k<face ; k++) {
                    count=count+dp[i-1][j-k];
                }
            }
        }
        return  count;
    }

    public static void main(String[] args) {
        int d=2;
        int sum=7;
        int face=6;
        System.out.println(recursiveTargetSum(face,sum,d));
        System.out.println(topDown(face,sum,d));
    }
}

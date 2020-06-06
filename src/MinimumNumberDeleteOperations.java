public class MinimumNumberDeleteOperations {
    public static int recursive(String a,String b,int i,int j)
    {
            if(i==0&&j==0)
            {
                return 0;
            }
           if(i==0)
           {
               return j;
           }
           if(j==0)
           {
               return i;
           }
           if(a.charAt(i-1)==b.charAt(j-1))
           {
               return recursive(a,b,i-1,j-1);
           }
           return 1+Math.min(recursive(a,b,i-1,j),recursive(a,b,i,j-1));
    }
    public static int topDown(String a,String b)
    {
        int dp[][]=new int[a.length()+1][b.length()+1];
        for (int i = 0; i <=a.length(); i++) {
            for (int j = 0; j<=b.length() ; j++) {
             if(i==0)
             {
                 dp[i][j]=j;
             }else if(j==0)
             {
                 dp[i][j]=i;
             }else if(a.charAt(i-1)==b.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1];
             }else {
                 dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
             }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        String a="sea";
        String b="ea";
        System.out.println("Recursice "+recursive(a,b,a.length(),b.length()));
        System.out.println("TopDown "+topDown(a,b));

    }
}

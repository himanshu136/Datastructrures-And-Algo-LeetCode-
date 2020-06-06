public class EditDistance {
    public static int recursiveEditDistance(String a,String b,int i,int j)
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
            return recursiveEditDistance(a,b,i-1,j-1);
        }
        return 1+Math.min(recursiveEditDistance(a,b,i-1,j-1),
                Math.min(recursiveEditDistance(a,b,i-1,j),recursiveEditDistance(a,b,i,j-1)));

    }

    public static int topDownEditDistance(String a ,String b)
    {
        int dp[][]=new int[a.length()+1][b.length()+1];
        for (int i = 0; i <a.length(); i++) {
            for (int j = 0; j <b.length() ; j++) {
                if(i==0)
                {
                    dp[i][j]=j;
                }else if(j==0)
                {
                    dp[i][j]=i;
                }else if (a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }else
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[a.length()-1][b.length()-1];
    }

    public static void main(String[] args) {
        String a="geek";
        String b="gesek";
        System.out.println(recursiveEditDistance(a,b,a.length(),b.length()));
        System.out.println(topDownEditDistance(a,b));

    }
}

public class LongestCommonSubstring {

    public static int recursiveLongestCommonSubstring(String a,String b,int m,int n,int result)
    {
        if(m==0||n==0)
        {
            return result;
        }
        if(a.charAt(m-1)==b.charAt(n-1))
        {
             result=recursiveLongestCommonSubstring(a,b,m-1,n-1,result+1);
        }
            int temp=Math.max(recursiveLongestCommonSubstring(a,b,m-1,n,0),
                    recursiveLongestCommonSubstring(a,b,m,n-1,0));
            return Math.max(temp,result);
        }

    public static int topDown(String a,String b)
    {
        int dp[][]=new int[a.length()+1][a.length()+1];
        int result=0;
        for(int i=0;i<=a.length();i++)
        {
            for (int j = 0; j <=b.length() ; j++) {
                if(i==0||j==0)
                {
                    dp[i][j]=0;
                }else if(a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                    result=Math.max(result,dp[i][j]);
                }else {
                    dp[i][j]=0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
    String a="bbbab";
    String c="bb";
    StringBuilder b=new StringBuilder(a);
    System.out.println(recursiveLongestCommonSubstring(a,c,a.length(),c.length(),0));
        System.out.println("Top Down "+topDown(a,c));
    }
}

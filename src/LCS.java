import java.time.LocalDateTime;

public class LCS {

    private static int recursive(char[] a ,char[] b,int i,int j)
    {
        if(i<=0||j<=0)
        {
            return 0;
        }
        if(a[i-1]==b[j-1])
        {
            return 1+recursive(a, b, i-1, j-1);
        }else
        {
            return Math.max(recursive(a, b, i, j-1),recursive(a, b, i-1, j));
        }
    }

    private static int memoization(char[]a,char[]b,int i,int j,int [][]array)
    {
        if(i<=0||j<=0)
        {
            return 0;
        }
        if(array[i][j]!=-1)
        {
            return array[i][j];
        }
        if(a[i-1]==b[j-1])
        {
            array[i][j]=1+memoization(a, b, i-1, j-1, array);
            return array[i][j];
        }else
        {
            array[i][j]=Math.max(memoization(a, b, i, j-1, array), 
            memoization(a, b, i-1, j, array));
            return array[i][j];
        }
    }
    private static int topDown(char[]a,char[]b,int i,int j)
    {
        int [][]dp=new int[i+1][j+1];
        for(int m=0;m<dp.length;m++)
        {
            for(int n=0;n<dp[0].length;n++)
            {
                if(m==0||n==0)
                {
                    dp[m][n]=0;
                }else if(a[m-1]==b[n-1])
                {
                    dp[m][n]=1+dp[m-1][n-1];
                }else
                dp[m][n]=Math.max(dp[m][n-1],dp[m-1][n]);
            }
        }
        printLCS(dp,a,b);
        return dp[i][j];
    }
       private static void printLCS(int[][] dp,char[]a,char[]b)
        {

            String s="";
            int i=a.length;
            int j=b.length;
            while(i>0&&j>0)
            {
                
            }
        }
        

    public static void main(String[] args) {

        String a="ABCDGH";
        String b="AEDFHR";

        char[] X=a.toCharArray(); 
        char[] Y=b.toCharArray(); 
        int[][] array= new int[X.length+1][Y.length+1];
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                array[i][j]=-1;
            }
        }
        System.out.println("Recursive "+recursive(X, Y, X.length,Y.length));
        System.out.println("Memoization"+memoization(X, Y, X.length,Y.length,array));
        System.out.println("Top Down "+topDown(X, Y, X.length, Y.length));
        
    }
    
}
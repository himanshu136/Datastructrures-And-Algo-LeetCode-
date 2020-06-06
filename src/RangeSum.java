public class RangeSum {
public static int[] arr={-2, 0, 3, -5, 2, -1};
public static int dp[];
static {
    dp=new int[arr.length];
    dp[0]=arr[0];
    for (int i = 1; i <arr.length ; i++) {
        dp[i]=dp[i-1]+arr[i];
    }
}

public static int checkRange(int i,int j)
{
    if(i==0)return dp[j];
    return dp[j]-dp[i-1];
}

    public static void main(String[] args) {
        System.out.println(checkRange(0,3));
    }
}

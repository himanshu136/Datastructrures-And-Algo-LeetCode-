public class isSubsequence {
    public static boolean checkRecursive(String a ,String b,int m,int n)
    {
        if(m==0)
        {
            return  true;
        }
        if(n==0)
        {
            return false;
        }
        if(a.charAt(m-1)==b.charAt(n-1))
        {
            return checkRecursive(a,b,m-1,n-1);
        }
        return checkRecursive(a,b,m,n-1);
    }
    public static boolean checkIterative(String s, String t)
    {
        int j=0;
        for (int i = 0; i <t.length() && j< s.length(); i++) {
                if(s.charAt(j)==t.charAt(i))
                    j++;

        }
        return (j==s.length());
    }
    public static void main(String[] args) {
        String s="abc";
        String t="axybdca";
        System.out.print(checkIterative(s,t));
    }
}

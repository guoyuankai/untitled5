import java.util.Scanner;

public class Magic_coin {
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String ans = "";
            ans=magic_coin(n,ans);
            System.out.println(ans);
        }
    }
    public static String magic_coin(int n,String ans) {
        if (n == 0) {
            return ans;
        } else if (n % 2 == 0) {
            return magic_coin((n - 2) / 2, ans = '2' + ans);
        } else {
            return magic_coin((n - 1) / 2, ans = '1' + ans);
        }
    }
}

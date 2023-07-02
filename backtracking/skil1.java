import java.util.Scanner;

public class skil1 {

    public static void main(String[] args) {
        
        int ans = mp(10197  , 17207);
        System.out.println(ans);
    }
    public static int mp(int a, int b){
        int sum = 1;
        for(int i = 1; i<= a; i++){
            sum *= i;
        }
        sum = sum % b;
        return sum;
    }

    
}

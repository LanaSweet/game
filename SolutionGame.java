package game;
import java.util.*;

//Some changes made directly from Github to practice pull from Github into local repository

//Adding another changes to try the tracking from the local

public class SolutionGame {
    
    public static boolean check(int leap, int[] game, int i){
        if (i>=game.length){
            return true;
        }
        if (i<0 || game[i]==1) return false;
        game[i]=1;
        return (check(leap, game, i+1) ||
                check(leap, game, i-1) ||
                check(leap, game, i+ leap));
    }

    public static boolean canWin(int leap, int[] game) {
        boolean res=true;
        int j = 0;
        int k = 0;
        int n = game.length;

        if (game[j]==0 && n ==1){
            return true;
        }
        while (j<n ) { 
            if (j+leap>=n){
                return true;
            }
            if (j+1<n) {
                if (game[j+1]==0) {
                    j = j+1;
                    
                } else 
                    if (game[j+leap]==0) {
                        j=j+leap;
                    } else if (j>2 && game[j-1]==0){j=j--;} else return false;
               
            } else return true;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

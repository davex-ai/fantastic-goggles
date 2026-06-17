package Qwin;

public class Solve {
    //Given an integer n, return the number of odd numbers that are strictly less than n.
    public int checkOdd(int n){
        int i = 0 ;
        if (n == 0){
            return n;
        }else {
            for (i = n; i > 0; i--){
                if (i % 2 != 0){
                    System.out.print(i + ", ");
                }
            }
        }
        return i;
    }

    //Given an integer n, return the number of odd numbers that are strictly less than n.
    public int checkPrime(int n){
        if(n == 0 || n == 1) {
            return 0;
        }
        for (int i = n; i >= n; i--) {
            if (i % 2 != 0){
                return i ;
            }
        }
        return 1;
    }
    public String checkParenthesis(String str){
        if (str == null){
            return "Invalid Input";
        }
        char c = str.charAt(0);
        if (c == '{' && str.charAt(str.length() - 1) == '}'){
            return "complete {}";
        }else if ( c == '[' && str.charAt(str.length() - 1) == ']'){
            return "complete []";
        }else if (c == '(' && str.charAt(str.length() - 1) == ')'){
            return "complete ()";
        }
        return "Input has incomplete parenthesis";
    }


    public static void main(String[] args) {
        Solve solve = new Solve();
        System.out.println(solve.checkOdd(10));
        System.out.println(solve.checkPrime(7));
        System.out.println(solve.checkParenthesis("{[]}"));


    }
}

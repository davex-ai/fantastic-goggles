package Gpt;

import java.util.Scanner;

public class bj {
    public static void main(String[] args) {

        bj bj = new bj();
        bj.pe("anna");

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a word");
//        String input = sc.nextLine();
//        String word = input.toLowerCase();
//
//        try {
//            StringBuilder rev = new StringBuilder();
//            for (int i = word.length() - 1; i >= 0; i-- )
//                rev.append(word.charAt(i));
//            System.out.println(rev);
//
//            if (rev.toString().equals(word)){
//                System.out.println("Dave' practice more java");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


//
//        int result = 0;
//        List<List<Integer>> source = List.of(
//                List.of(1, 2, 3, 4, 6),
//                List.of(22, 23, 24, 25),
//                List.of(32, 33)
//        );
//        cont: for(List<Integer> l: source){
//            for (int i: l){
//                if(i > 7){
//                    result = i;
//                    continue cont;
//                }
//            }
//        }
//        System.out.println("result=" + result);
//
        }
        String palindrome(String input){
            String rev = "";
        for (int i = input.length() - 1; i >= 0; i--)
            rev += input.charAt(i);

        if ( rev.equals(input)){
            System.out.println("So help me ");
        }


        return rev ;
    }
    StringBuilder pe (String word){
        StringBuilder rev = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--)
            rev.append(word.charAt(i));

        if ( rev.equals(word)){
            System.out.println("So help me ");
        }
        return rev;
    }

    }



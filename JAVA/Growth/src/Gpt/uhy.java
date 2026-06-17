package Gpt;

import java.util.HashMap;
import java.util.List;

public class uhy {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        System.out.println((b1 & b2) + " " + (b1 && b2));
        int t = 0;
        System.out.println(t++);
        int q = 10;
        q %= 6;
        System.out.println(q);
        System.out.println("A".repeat(3).lastIndexOf("A"));

        for (int i = 20, j = -1; i < 23 && j < 0; ++i, ++j) {
            System.out.println(i + " " + j + " ");

            int x = 10;
            try {
                if (x++ > 10) {
                    throw new RuntimeException("The x value is out of the range: " + x);
                }
                System.out.println("The x value is within the range: " + x);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());

            }
            int result = 0;
            List<List<Integer>> source = List.of(
                    List.of(1, 2, 3, 4, 6),
                    List.of(22, 23, 24, 25),
                    List.of(32, 33)
            );
            cont:
            for (List<Integer> l : source) {
                for (int n : l) {
                    if (n > 7) {
                        result = n;
                        continue cont;
                    }
                }
            }
            System.out.println("result=" + result);
            char x1 = '\u0032';
            System.out.println(x1);
            int e = 34;
            System.out.println(e - 2);

            int $r = 3;
            int s = 5;
            System.out.println($r * s - 3);
            System.out.println($r * (s - 3));

            for (int l = getInitialValue(), h = x == -2 ? x + 2 : 0, k = 0;
                 h < 3 || j < 3; ++l, j = l) {
                System.out.println(l + " " + j);
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }


    private static int getInitialValue() {
//        uhy n = new uhy();
//        n.twoSum({5,8,9,7},7);
        return 0;
    }

}




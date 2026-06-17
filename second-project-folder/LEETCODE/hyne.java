package dave.blockchain;

import java.util.*;

public class hyne {

    //    1️⃣ Valid Anagram when i first attempting this i didn't even know what an anagram was but we pulled through
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> firstword = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (firstword.containsKey(s.charAt(i))) {
                firstword.put(s.charAt(i), firstword.get(s.charAt(i)) + 1);
            } else {
                firstword.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (firstword.containsKey(t.charAt(i))) {
                firstword.put(t.charAt(i), firstword.get(t.charAt(i)) - 1);
                if (firstword.get(t.charAt(i)) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // 2️⃣ First Unique Character in a String i think this was also easy
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> firstword = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (firstword.containsKey(letter)) {
                firstword.put(letter, firstword.get(letter) + 1);
            } else {
                firstword.put(letter, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (firstword.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 3️⃣ Contains Duplicate piece of cake. only question that i solved easily without help
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }

    //4️⃣ Valid Palindrome i used so may ds for this one stack, string builder etc
    public boolean isPalindrome(String s) {
        int a = 0;
        int b = s.length() - 1;
        while (a < b) {
            if (!Character.isLetterOrDigit(s.charAt(a))) {
                a++;
            } else if (!Character.isLetterOrDigit(s.charAt(b))) {
                b--;
            } else {
                if (Character.toLowerCase(s.charAt(a)) != Character.toLowerCase(s.charAt(b))) {
                    return false;
                }
                a++;
                b--;
            }

        }
        return true;
    }

    //    5️⃣ Merge Sorted Array i think this was straight forward but my mental model delayed
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m - 1;
        int b = n - 1;
        int c = m + n - 1;

        while (b >= 0) {
            if (a >= 0 && nums1[a] > nums2[b]) {
                nums1[c] = nums1[a];
                a--;
            } else {
                nums1[c] = nums2[b];
                b--;
            }
            c--;
        }
        return nums1;
    }

    //6️⃣ Valid Parentheses this was easy in my head but on code ?? i almost gave up
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c) == '{' || s.charAt(c) == '[' || s.charAt(c) == '(') {
                stack.add(s.charAt(c));
            }
            if (stack.empty()) return false;
            if (s.charAt(c) == '}' && stack.pop() != '{') {
                return false;
            } else if (s.charAt(c) == ']' && stack.pop() != '[') {
                return false;
            } else if (s.charAt(c) == ')' && stack.pop() != '(') {
                return false;
            }
        }
        return stack.empty();
    }

    //    7️⃣ Backspace String Compare this was the trickiest
    public boolean backspaceCompare(String s, String t) {
        int b = s.length() - 1;
        Stack<Character> sCharacters = new Stack<>();
        int a = t.length() - 1;
        Stack<Character> tCharacters = new Stack<>();
        while (b >= 0) {
            if (s.charAt(b) == '#') {
                if (!sCharacters.isEmpty()) {
                    sCharacters.pop();
                }
            } else {
                sCharacters.push(s.charAt(b));
            }
            b--;
        }

        while (a >= 0) {
            if (t.charAt(a) == '#') {
                if (!tCharacters.isEmpty()) {
                    tCharacters.pop();
                }
            } else {
                tCharacters.push(t.charAt(a));
            }
            a--;
        }

        if (sCharacters.equals(tCharacters)) return true;

        return false;
    }

    //        8️⃣ Best Time to Buy and Sell Stock read a blog on medium where jp morgan gave the author this question so happy i solved it (although there are harder questions with the same name so i might be wrong)
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (prices[i] - min > max) {
                    max = prices[i] - min;
                }
            }
        }
        return max;
    }

    //    9️⃣ Maximum Subarray (Kadane’s)
    public int maxSubArray(int[] nums) {//cant believe you made me do a medium tagged problem smh😭😭
        int sum = nums[0];
        int max = nums[0];
        for (int n = 1; n < nums.length; n++) {
            if (nums[n] + max > nums[n]) {
                max += nums[n];
            } else {
                max = nums[n];
            }
            if (max > sum) {
                sum = max;
            }
        }
        return sum;
    }

    //🔟 Two Sum (yes, now) this one shook me surprisingly cuz i solved it a million times
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            } else {
                map.put(nums[i], i);

            }
        }
        return new int[]{0, 0};
    }

    public int[] sortByBits(int[] arr) {
        Integer[] integer = new Integer[arr.length];
    for (int i = 0; i < arr.length; i++){
        integer[i] = arr[i];
    }

    Arrays.sort(integer,(a, b) -> {
        int bitA = Integer.bitCount(a);
        int bitB = Integer.bitCount(b);

        if (bitA == bitB){
            return a - b;
        }
        return bitA - bitB;
    });

    for (int i = 0; i < arr.length; i++){
        arr[i] = integer[i];
    }
    return arr;
    }

//    public int sumRootToLeaf(TreeNode root) {
//        return dfs(root, 0);
//    }
//
//    private int dfs(TreeNode root, int current) {
//        if (root == null) return  0;
//        current = current * 2 + root.value;
//
//        if (root.left == null && root.right == null) return current;
//        return dfs(root.left, current) + dfs(root.right, current);
//    }

    public int numSteps(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        int counter = 0;
        int b = s.length() - 1;
        while (!builder.toString().equals("1")) {
            if (builder.charAt(b) == '0') {
                builder.deleteCharAt(b);
            } else {
                int c = b;
                while (c >= 0 && builder.charAt(c) == '1') {
                    builder.setCharAt(c, '0');
                    c--;
                }
                if (c < 0) {
                    builder.insert(0, '1');
                } else {
                    builder.setCharAt(c,'1');
                }
            }
            counter++;
            b =builder.length() -1;
        }
        return counter;

    }

    public int minOperations(String s, int k) {
        int counter = 0;
        int c = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(s);

        for (int a = 0; a < builder.length(); a++) {
            if (builder.charAt(a) != '1') {
                if (a + k > builder.length()) return -1;

                for (c = a; c < k + a; c++) {
                    if (builder.charAt(c) == '0'){
                        builder.setCharAt(c, '1');
                    }else {
                        builder.setCharAt(c, '0');
                    }
                }
                counter++;
            }
        }
        return counter;
    }



    public static void main(String[] args) {
        hyne jk = new hyne();
//        int[] ints3 = {1,1,1,3,3,4,3,2,4,2};
        int[] ints2 = {7, 1, 5, 3, 6, 4};
        int[] ints1 = {2, 5, 6};
        int[] ints = {2, 7, 11, 15};

//        System.out.println(jk.firstUniqChar("loveleetcode"));
//        System.out.println(Arrays.toString(jk.getConcatenation(ul)));
//        System.out.println(jk.containsDuplicate(ul));
//        System.out.println(jk.maxProfit(uls));
//        System.out.println(jk.numSteps("1101"));
        System.out.println(jk.minOperations("0101", 3));
//        System.out.println(Arrays.toString(jk.twoSum(ints, 9)));
//        System.out.println(jk.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(Arrays.toString(jk.merge(uls, 3, lu, 3)));
    }

}

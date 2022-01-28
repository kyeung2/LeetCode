package io.nimbus.leetcode.top100interview.medium;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }
        return say(countAndSay(n - 1));
    }

    private String say(String count) {

        StringBuilder say = new StringBuilder();
        int numberCount = 0;
        int currentNumber = -1;
        for (char c : count.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (number == currentNumber) {
                numberCount++;
            } else {
                // record the last set of same numbers if not first number
                if (currentNumber != -1) {
                    say.append(numberCount);
                    say.append(currentNumber);
                }
                currentNumber = number;
                numberCount = 1;
            }
        }

        // handle last swap
        say.append(numberCount);
        say.append(currentNumber);

        return say.toString();
    }

}

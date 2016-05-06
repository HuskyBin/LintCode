/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Have you met this question in a real interview? Yes
Example
Given [1,2,3] which represents 123, return [1,2,4].

Given [9,9,9] which represents 999, return [1,0,0,0].
*/
   public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int index = digits.length - 1;
        int carry = 1;
        while (index >= 0) {
            int sum = 0;
            sum = digits[index] + 1;
            carry = sum / 10;
            digits[index] = sum % 10;
            if (carry == 0) break;
            index--;
        }
        if (carry == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}

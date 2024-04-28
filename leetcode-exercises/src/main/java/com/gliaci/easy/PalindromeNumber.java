package com.gliaci.easy;

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return (reversed == x) || (x == (reversed / 10));
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int number = 123656321;
        System.out.printf("Number %d is%sPalindrome\n", number, palindromeNumber.isPalindrome(number) ? " " : " not ");
        number = 123653321;
        System.out.printf("Number %d is%sPalindrome\n", number, palindromeNumber.isPalindrome(number) ? " " : " not ");
    }

}


package com.gliaci.easy;

import java.util.Map;

public class RomanToInteger {

    enum RomanNumeralPatterns {

        M(1000),
        D(500),
        CM(900),
        CD(400),
        C(100),
        L(50),
        XC(90),
        XL(40),
        X(10),
        V(5),
        IX(9),
        IV(4),
        III(3),
        II(2),
        I(1);

        private final int number;

        RomanNumeralPatterns(int number) {

            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }


    public int romanToInt(String s) {
        for (RomanNumeralPatterns romanNumeralPattern : RomanNumeralPatterns.values()) {
            if (s.startsWith(romanNumeralPattern.name())) {
                return romanNumeralPattern.getNumber() + romanToInt(s.substring(romanNumeralPattern.name().length()));
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.printf("Integer value of [%s] Roman Numeral is [%d]%n", "III", romanToInteger.romanToInt("III"));
        System.out.printf("Integer value of [%s] Roman Numeral is [%d]%n", "CMXCIX", romanToInteger.romanToInt("CMXCIX"));
        System.out.printf("Integer value of [%s] Roman Numeral is [%d]%n", "MMMDCCXXIV", romanToInteger.romanToInt("MMMDCCXXIV"));
    }

}

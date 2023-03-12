package recursion;

public class Recursion_1 {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(bunnyEars(2));
        System.out.println(fibonacci(2));
        System.out.println(countHi("hihih"));
        System.out.println(sumDigits(126));
        System.out.println(count7(717));
        System.out.println(powerN(3, 3));
        System.out.println(parenBit("xyz(abc)123"));
        System.out.println(allStar("Hello"));
        System.out.println(pairStar("xxyy"));
    }

    /* 1. Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result
    recursively (without loops).*/
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    /* 2. We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of
    ears across all the bunnies recursively (without loops or multiplication).*/
    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) return 0;
        return 2 + bunnyEars(bunnies - 1);
    }

    /* 3. The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The
    first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the
    previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive
    fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.*/
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /* 4. Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.*/
    public static int countHi(String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0, 2).equals("hi")) return 1 + countHi(str.substring(1));
        else return countHi(str.substring(1));
    }

    /* 5. Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10
    yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).*/
    public static int sumDigits(int n) {
        if (n < 10) return n;
        return (n % 10) + sumDigits(n / 10);
    }

    /* 6. Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2.
    (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the
    rightmost digit (126 / 10 is 12).*/
    public static int count7(int n) {
        if (n < 1) return 0;
        if (n % 10 == 7) return 1 + count7(n / 10);
        else return count7(n / 10);
    }

    /* 7. Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power,
    so powerN(3, 2) is 9 (3 squared).*/
    public static int powerN(int base, int n) {
        if (n == 0) return 1;
        return base * powerN(base, n - 1);
    }

    /* 8. Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of
    the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".*/
    public static String parenBit(String str) {
        if (str.equals("")) return str;
        if (str.charAt(0) == '(') {
            if (str.charAt(str.length() - 1) == ')')
                return str;
            else
                return parenBit(str.substring(0, str.length() - 1));
        } else
            return parenBit(str.substring(1));
    }

    /* 9. Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".*/
    public static String allStar(String str) {
        if (str.equals("") || str.length() == 1) return str;
        return str.charAt(0) + "*" + allStar(str.substring(1));
    }

    /* 10. Given a string, compute recursively a new string where identical chars that are adjacent in the original
    string are separated from each other by a "*".*/
    public static String pairStar(String str) {
        if (str.equals("") || str.length() == 1) return str;
        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        else
            return str.charAt(0) + pairStar(str.substring(1));
    }
}

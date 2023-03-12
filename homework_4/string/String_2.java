package string;

public class String_2 {
    public static void main(String[] args) {
        System.out.println(endOther("AbC", "HiaBc"));
        System.out.println(mixString("Hi", "There"));
        System.out.println(oneTwo("tcagdo"));
        System.out.println(bobThere("b12b1b"));
        System.out.println(catDog("catcat"));
    }

    /* 1. Given two strings, return true if either of the strings appears at the very end of the other string,
    ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
    Note: str.toLowerCase() returns the lowercase version of a string.*/
    public static boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() < b.length()) {
            String temp = b.substring(b.length() - a.length(), b.length());
            return temp.compareTo(a) == 0 ? true : false;
        } else {
            String temp = a.substring(a.length() - b.length(), a.length());
            return temp.compareTo(b) == 0 ? true : false;
        }
    }

    /* 2. Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the
    second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.*/
    public static String mixString(String a, String b) {
        int max = Math.max(a.length(), b.length());
        String word = "";
        for (int i = 0; i < max; i++) {
            if (i <= a.length() - 1)
                word += a.substring(i, i + 1);
            if (i <= b.length() - 1)
                word += b.substring(i, i + 1);
        }
        return word;
    }

    /* 3. Given a string, compute a new string by moving the first char to come after the next two chars, so "abc"
     yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any
     group of fewer than 3 chars at the end.*/
    public static String oneTwo(String str) {
        String result = "";
        for (int i = 0; i < str.length() - 2; i += 3) {
            result += str.substring(i + 1, i + 3) + str.charAt(i);
        }
        return result;
    }

    /* 4. Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.*/
    public static boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b')
                return true;
        }
        return false;
    }

    /* 5. Return true if the string "cat" and "dog" appear the same number of times in the given string.*/
    public static boolean catDog(String str) {
        int cat = 0;
        int dog = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            String temp = str.substring(i, i + 3);
            if (temp.compareTo("cat") == 0)
                cat++;
            if (temp.compareTo("dog") == 0)
                dog++;
        }
        return cat == dog ? true : false;
    }
}

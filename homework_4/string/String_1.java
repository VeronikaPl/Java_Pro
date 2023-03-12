package string;

public class String_1 {
    public static void main(String[] args) {
        System.out.println(makeOutWord("<<>>", "Hello"));
        System.out.println(withoutEnd("Java"));
        System.out.println(comboString("a", "bb"));
        System.out.println(lastTwo("coding"));
        System.out.println(conCat("abc", "cat"));
        System.out.println(makeTags("i", "Yay"));
        System.out.println(deFront("away"));
        System.out.println(frontAgain("edited"));
        System.out.println(twoChar("java", 3));
        System.out.println(left2("Hello"));
    }

    /* 1. Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
    middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting at index i
    and going up to but not including index j.*/
    public static String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }

    /* 2. Given a string, return a version without the first and last char, so "Hello" yields "ell". The string
    length will be at least 2.*/
    public static String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);
    }

    /* 3. Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string on the
    outside and the longer string on the inside. The strings will not be the same length, but they may be empty
    (length 0).*/
    public static String comboString(String a, String b) {
        String shortString, longString;
        if (a.length() <= b.length()) {
            shortString = a;
            longString = b;
        } else {
            shortString = b;
            longString = a;
        }
        return shortString + longString + shortString;
    }

    /* 4. Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so
    "coding" yields "codign".*/
    public static String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        } else
            return str.substring(0, str.length() - 2) + str.charAt(str.length() - 1) + str.charAt(str.length() - 2);
    }

    /* 5. Given two strings, append them together (known as "concatenation") and return the result. However, if the
    concatenation creates a double-char, then omit one of the chars, so "abc" and "cat" yields "abcat".*/
    public static String conCat(String a, String b) {
        if (a.length() == 0 || b.length() == 0)
            return a + b;
        if ((a.substring(a.length() - 1, a.length())).equals(b.substring(0, 1)))
            return a + b.substring(1, b.length());
        else
            return a + b;
    }

    /* 6. The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example, the
    "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the HTML string
    with tags around the word, e.g. "<i>Yay</i>".*/
    public static String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }

    /* 7. Given a string, return a version without the first 2 chars. Except keep the first char if it is 'a' and keep
    the second char if it is 'b'. The string may be any length. Harder than it looks.*/
    public static String deFront(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == 'a')
                temp += 'a';
            else if (i == 1 && str.charAt(i) == 'b')
                temp += 'b';
            else if (i > 1)
                temp += str.charAt(i);
        }
        return temp;
    }

    /* 8. Given a string, return true if the first 2 chars in the string also appear at the end of the string,
    such as with "edited".*/
    public static boolean frontAgain(String str) {
        if (str.length() < 2)
            return false;
        else if (str.substring(0, 2).equals(str.substring(str.length() - 2, str.length())))
            return true;
        else
            return false;
    }

    /* 9. Given a string and an index, return a string length 2 starting at the given index. If the index is too
    big or too small to define a string length 2, use the first 2 chars. The string length will be at least 2.*/
    public static String twoChar(String str, int index) {
        if (str.length() <= index + 1 || index < 0)
            return str.substring(0, 2);
        else
            return str.substring(index, index + 2);
    }

    /* 10. Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. The
    string length will be at least 2.*/
    public static String left2(String str) {
        return str.substring(2, str.length()) + str.substring(0, 2);
    }
}

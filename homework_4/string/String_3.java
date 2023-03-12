package string;

public class String_3 {
    public static void main(String[] args) {
        System.out.println(countYZ("day fyyyz"));
        System.out.println(mirrorEnds("abXYZba"));
    }

    /* 1. Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in
    "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word
    if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char
    is an alphabetic letter.)*/
    public static int countYZ(String str) {
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'y' || str.charAt(i) == 'z') {
                if (i < str.length() - 1 && !Character.isLetter(str.charAt(i + 1)))
                    count++;
                else if (i == str.length() - 1)
                    count++;
            }
        }
        return count;
    }

    /* 2. Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string.
    In other words, zero or more characters at the very begining of the given string, and at the very end of the string
    in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".*/
    public static String mirrorEnds(String string) {
        String final_ = "";
        String temp1 = "";
        String temp2 = "";

        for (int i = 0; i < string.length(); i++) {
            temp1 += string.substring(i, i + 1);
            temp2 = "";
            for (int j = temp1.length() - 1; j >= 0; j--) {
                temp2 += temp1.substring(j, j + 1);
                if (temp2.equals(string.substring(string.length() - i - 1, string.length())))
                    final_ = temp1;
            }
        }
        return final_;
    }
}

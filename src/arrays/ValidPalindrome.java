package arrays;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome vp = new ValidPalindrome();
        boolean isPalindrome = vp.isPalindrome(s);
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    public boolean isPalindrome(String s) {
//        s = s.replace(":", "");
//        s = s.replace("'", "");
//        s = s.replace(",", "");
//        s = s.toLowerCase();
//        s = s.replace(" ", "");
//        int left = 0;
//        int right = s.length() - 1;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;


        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
            left++;
            right--;
        }
        return true;
    }
}

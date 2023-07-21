public class Main {

    static boolean isPalindrome(String str){ // kavak --
       int startIndex = 0;
       int endIndex = str.length()-1;

       while(startIndex <= endIndex) {
           if(!(str.charAt(startIndex) == str.charAt(endIndex))) {
               return false;
           }
           startIndex++;
           endIndex--;
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("adana"));
    }
}
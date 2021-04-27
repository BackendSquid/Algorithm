class Solution {
    public boolean isPalindrome(String s) {
        String trimedString = s.replaceAll("[^a-zA-Z0-9]", "");
        String lower = trimedString.toLowerCase();
        char[] lowerCharArray = lower.toCharArray();
        
        int len = lowerCharArray.length;
        for (int i = 0; i < len / 2; i++) {
            if (lowerCharArray[i] != lowerCharArray[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}

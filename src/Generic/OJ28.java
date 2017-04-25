public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        int i=0;
        int j=needle.length();
        while(true){
            if(haystack.substring(i, j).compareTo(needle) == 0) return i;
            else{
                i++;
                j++;
            }
            if(j>haystack.length()) return -1;
        }
    }
}
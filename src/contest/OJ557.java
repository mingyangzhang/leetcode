package contest;

/**
 * Created by mingyazh on 4/8/2017.
 */
public class OJ557{
    public String reverseWords(String s) {
        int fromIndex = 0;
        StringBuffer ans = new StringBuffer();
        while(s.indexOf(' ', fromIndex)!=-1){
            int index = s.indexOf(' ', fromIndex);
            for(int i=index-1; i>=fromIndex; i--)
                ans.append(s.charAt(i));
            ans.append(' ');
            fromIndex = index+1;
        }
        for(int i=s.length()-1; i>=fromIndex; i--)
            ans.append(s.charAt(i));
        return ans.toString();
    }

    public static void main(String[] args){
        OJ557 sol = new OJ557();
        String s = "ad das ";
        System.out.print(sol.reverseWords(s));
    }
}

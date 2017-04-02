package Generic;

/**
 * Created by mingyazh on 3/21/2017.
 */
public class OJ4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0) return n%2 == 0?(float)(nums2[n/2-1]+nums2[n/2])/2:nums2[(n-1)/2];
        if(n==0) return m%2 == 0?(float)(nums1[m/2-1]+nums1[m/2])/2:nums1[(m-1)/2];
        if((m+n)%2 == 1) return findKthElement(nums1, nums2, (m+n-1)/2);

        return (float)(findKthElement(nums1, nums2, (m+n)/2-1)+findKthElement(nums1, nums2, (m+n)/2))/2;
    }

    private Integer findKthElement(int[] nums1, int[] nums2, int k){
        int index = nums1.length>k?k:nums1.length-1;
        Integer val = binarysearch(nums1, 0, index, k, nums2);
        if(val!=null) return val;
        index = nums2.length>k?k:nums2.length-1;
        return binarysearch(nums2, 0, index, k, nums1);
    }

    private Integer binarysearch(int[] array1, int i, int j, int  k, int[] array2){
        if(i>j) return null;
        if(i==j){
            if(compare(array1, array2, i, k)==0) return array1[i];
            return null;
        }
        int m = (i+j)/2;
        int cmp = compare(array1, array2, m, k);
        if(cmp<0) return binarysearch(array1, m+1, j, k, array2);
        else if(cmp>0) return binarysearch(array1, i, m, k, array2);
        else return array1[m];
    }

    private int compare(int[] array1, int[] array2, int index, int k){
        int val = array1[index];
        if(array2.length < k-index) return -1;
        else if(array2.length-1 < k-index && array2[array2.length-1]>val) return -1;
        else if(array2.length-1 < k-index && array2[array2.length-1]<=val) return 0;
        else if(k-index-1 < 0 && array2[0]<val) return 1;
        else if(k-index-1 < 0 && array2[0]>=val) return 0;
        else if(array2[k-index-1] > val) return -1;
        else if(array2[k-index] < val) return 1;
//        else if(k-index-1 >= 0 && val < array2[k-index-1]) return -1;
        else return 0;
    }

    public static void main(String[] args){
        OJ4 sol = new OJ4();
        int[] nums1 = {1};
        int[] nums2 = {2};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}

package Classic;


/**
 * Created by mingyazh on 2017/6/14.
 */
public class QuickSort {
    private Comparable[] list;

    private void swap(int i, int j){
        Comparable temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private void sort(int left, int right){
        if(left>=right) return;
        Comparable mid = list[right];
        int l = left;
        int r = right-1;
        while(l<r){
            while(l<r && list[l].compareTo(mid)<0)
                l++;
            while(l<r && list[r].compareTo(mid)>0)
                r--;
            swap(l, r);
        }
        if(list[l].compareTo(mid)>0)
            swap(l, right);
        else
            l++;
        sort(left, l-1);
        sort(l, right);
    }

    public void sort(Comparable[] list){
        this.list = list;
        sort(0, list.length-1);
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        Integer[] list = new Integer[]{1,3,2,5,6,1,7,4,5,6};
        qs.sort(list);
        for(int n:list)
            System.out.print(n);
    }
}

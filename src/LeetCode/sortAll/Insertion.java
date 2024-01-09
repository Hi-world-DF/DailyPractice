package LeetCode.sortAll;

public class Insertion {
    public static void sort(int[] a){
        int n = a.length;
        for(int i = 1;i < n;i++){
            for(int j = 0;j<i;j++){
                if(less(a[i],a[j])){
                    swap(a,i,j);
                }
            }
        }
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private static boolean less(int a, int b) {
        if(a > b){
            return false;
        }else {
            return true;
        }
    }

    private static void show(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] a = {1,23,12,8,9,21,4,0,16,3,5,18};
        sort(a);
        show(a);
    }
}

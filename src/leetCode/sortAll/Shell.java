package src.leetCode.sortAll;
/**
 * 希尔排序
 * */
public class Shell {
    public static void sort(int[] a){
        int n = a.length;
        int h =1;
        while (h < n/3){
            h = 3*h +1;
        }
        while (h >= 1){
            for(int i = h;i < n;i++){
                for(int j = i;j >= h && less(a[j],a[j-h]);j-=h){
                    exchange(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    /**
     * 交换
     * */
    private static void exchange(int[] a, int j, int i) {
        if(a[j] < a[i]){
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }

    /**
     * 比较
     * */
    private static boolean less(int a, int b) {
        if(a < b){
            return true;
        }
        return false;
    }

    private static void isSorted(int[] a){
        for(int i = 0;i < a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] a = {2,3,1,7,12,32,6,2,5};
        Shell.sort(a);
        Shell.isSorted(a);
    }
}

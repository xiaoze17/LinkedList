package com.xiaoze17;
/*
    递归：
    1。有终止结果
    2.把原问题转换成更小的问题
 */
public class Sum {
    //一个递归函数就搞定了，但是挂怪的，为什么要指定第二个参数
    public int sum(int[] arr, int l){
        if (l == arr.length) {
            return 0;
        }
        int sum = arr[l]+sum(arr,l+1);
        return sum;
    }

    //这个是两个递归函数搞定的，这个函数入口不需要第二个参数
    //是不是可以体现OO的封装，
    public int sum2(int[] arr) {
        return sum2(arr,0);
    }
    private int sum2(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l]+sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 9};
        int[] arr2 = new int[10000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        System.out.println((new Sum()).sum(arr2,0));
        System.out.println((new Sum()).sum2(arr2));
    }
}

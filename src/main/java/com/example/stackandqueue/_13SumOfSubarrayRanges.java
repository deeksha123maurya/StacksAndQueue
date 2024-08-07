package com.example.stackandqueue;
import java.util.*;
public class _13SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    // max
    public long sumSubarrayMaxs(int[] arr) {

        int n = arr.length;
        int[] NGL = findNGL(arr);
        int[] NGR = findNGR(arr);

        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            int l = i - NGL[i];
            int r = NGR[i] - i;
            long totalSum = ((long)arr[i] * l * r);
            sum = (sum + totalSum);
        }
        return sum;
    }
    private int[] findNGL(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = arr.length -1; i >= 0; i--){

            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }else{
                ans[i] = arr.length;
            }
            st.push(i);
        }
        return ans;
    }
    private int[] findNGR(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }else{
                ans[i] = -1;
            }
            st.push(i);
        }
        return ans;
    }

    // mins
    public long sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] NSL = findNSL(arr);
        int[] NSR = findNSR(arr);

        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            int l = i - NSL[i];
            int r = NSR[i] - i;
            long totalSum = ((long)arr[i] * l * r);
            sum = (sum + totalSum);
        }
        return sum;
    }
    private int[] findNSL(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = arr.length -1; i >= 0; i--){

            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }else{
                ans[i] = arr.length;
            }
            st.push(i);
        }
        return ans;
    }
    private int[] findNSR(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }else{
                ans[i] = -1;
            }
            st.push(i);
        }
        return ans;
    }
}

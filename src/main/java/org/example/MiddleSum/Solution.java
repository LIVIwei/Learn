package org.example.MiddleSum;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author: LIVI
 * @Time: 2022/11/02  15:11
 * @Description: 计算中位数
 */
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if((m+n)==1) {
            return m==1?nums1[0]:nums2[0];
        }
        int left=0;
        int right=m;
        if(m>n){
            right=n;
            int[] temp=nums1;//注意这种写法
            nums1=nums2;
            nums2=temp;
        }
        int total=(m+n+1)/2;
        while(left<right) {
            int i=left+(right-left)/2;
            int j=total-i;
            if(nums1[i]>nums2[j-1]) {
                right=i;
            }
            else {
                left=i+1;
            }
        }
        int i=left;
        int j=total-i;
        int nums1LValue=i-1>=0?nums1[i-1]:Integer.MIN_VALUE;
        int nums2LValue=j-1>=0?nums2[j-1]:Integer.MIN_VALUE;
        int nums1RValue=i>=nums1.length?Integer.MAX_VALUE:nums1[i];
        int nums2Rvalue=j>=nums2.length?Integer.MAX_VALUE:nums2[j];
        return (m+n)%2==0?(double)(Math.min(nums1RValue, nums2Rvalue)+Math.max(nums1LValue, nums2LValue))/2:Math.max(nums1LValue, nums2LValue);
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {8,10,12,14};
        findMedianSortedArrays(nums1,nums2);
    }
}
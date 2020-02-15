package com.zb.study.select;

import java.util.Arrays;

/**
 * 二分查找
 */
public class TowSelectDemo {

    public static void main(String[] args) {
        TowSelectDemo towSelectDemo = new TowSelectDemo();
        System.out.println(towSelectDemo.bsearch01(new int[]{1, 2, 4, 5, 6, 7}, 6, 2));
        System.out.println(towSelectDemo.bsearch02(new int[]{1, 2, 4, 5, 6, 7}, 6, 4));
        System.out.println(towSelectDemo.firstBsearch(new int[]{1, 2, 2, 5, 6, 7}, 6, 2));
        System.out.println(towSelectDemo.firstBigBsearch(new int[]{1, 2, 4, 6, 6, 7}, 6, 5));
        System.out.println(towSelectDemo.lastBsearch(new int[]{1, 2, 4, 5, 8, 8}, 6, 8));
        System.out.println(towSelectDemo.lastSmallBsearch(new int[]{1, 2, 3, 3, 6, 7}, 6, 3));
    }

    /**
     * @param arr 数组有序
     * @param n   数组实际有效大小
     * @param val 目标值
     */
    public int bsearch01(int[] arr, int n, int val) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式
     *
     * @return
     */
    public int bsearch02(int[] arr, int n, int val) {
        return bsearchInternally(arr, 0, n - 1, val);
    }

    private int bsearchInternally(int[] arr, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] < val) {
            return bsearchInternally(arr, mid + 1, high, val);
        } else {
            return bsearchInternally(arr, low, mid - 1, val);
        }
    }

    /**
     * 第一个给定值
     *
     * @param arr
     * @param n
     * @param val
     * @return
     */
    public int firstBsearch(int[] arr, int n, int val) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > val) {
                high = mid - 1;
            } else if (arr[mid] < val) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid] < val) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    public int firstBigBsearch(int[] arr, int n, int val) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < val) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < val) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 最后一个给定值
     *
     * @param arr
     * @param n
     * @param val
     * @return
     */
    public int lastBsearch(int[] arr, int n, int val) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < val) {
                low = mid + 1;
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] > val) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public int lastSmallBsearch(int[] arr, int n, int val) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > val) {
                high = mid - 1;
            }else {
                if (mid == n - 1 || arr[mid + 1] > val) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }


}

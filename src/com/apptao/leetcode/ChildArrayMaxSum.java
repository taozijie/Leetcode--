package com.apptao.leetcode;

/**
 * Created by a on 2018-01-02.
 *
 * 求出数组连续最大和，，子数组最大
 *
 * 如 []
 *
 */
public class ChildArrayMaxSum {

    public static void main(String[] args) {

        int [] arr = new int[]{
                1, -2, 3, 10, -4, 7, 2, -5
        };

        new ChildArrayMaxSum().MaxSum(arr);

    }


    /**
     * 解决方案，最大和，累加和大于0
     * @param array
     */
    private void MaxSum(int array[])

    {

        int len = array.length;

        if(null == array || len <=0){
            return;
        }

        int curSum = 0, maxSum = 0;
        int index_start = 0, index_end = 0;     // 初始化子数组最大和下标
        int i;
        for(i=0; i<len; i++){
            curSum += array[i];     // 累加

            if(curSum < 0){          // 当前和小于0，重置为0
                curSum = 0;
                index_start = i+1;      // 调整子数组最大和的开始下标
            }

            if(curSum > maxSum){     // 当前和大于最大和，则重置最大和
                maxSum = curSum;
                index_end = i;          // 调整子数组最大和的结束下标
            }
        }

        if(maxSum == 0){            // 最大和依然为0，说明数组中所有元素都为负值
            maxSum = array[0];
            index_start = index_end = 0;                // 初始化子数组最大和下标
            for(i=1; i<len; i++){
                if(array[i] > maxSum){
                    maxSum = array[i];
                    index_start = index_end = i;        // 调整子数组最大和下标
                }
            }
        }

        // 输出最大和的子数组及其开始、结束下标
        System.out.printf("index_start: %d\nindex_end: %d\n", index_start, index_end);
        for(i=index_start; i<=index_end; i++){
            System.out.printf("%d\t", array[i]);
        }

        System.out.printf("\n\nmaxSum: %d", maxSum);
    }

    /**
     * 方案二，
     * @param A
     * @return
     */
    int MaxSubsequenceSum2(int A[])
    {
        int N = A.length;
        int ThisSum=0,MaxSum=0,i,j,k;
        for(i=0;i<N;i++)
        {
            ThisSum=0;
            for(j=i;j<N;j++)
            {
                ThisSum+=A[j];
                if(ThisSum>MaxSum)
                    MaxSum=ThisSum;
            }
        }
        return MaxSum;
    }





}

class Solution {
    public int maxSatisfied(int[] cstm, int[] grpy, int min) {
        int n = cstm.length;
        int i = 0;
        int j = 0;
        int maxSumIdx = i;
        int maxSum = 0;
        int sum = 0;
        while(j<min){
            if(grpy[j]==1) sum+=cstm[j];
            j++;
        }
       j--;
        while(j<n){
            if(sum>=maxSum){
                maxSumIdx = i;
                maxSum = sum;
            }
            j++;
            if(j<n&&grpy[j]==1){
                sum+=cstm[j];
            }
            if(grpy[i]==1){
                sum = sum-cstm[i];
            }
            i++;
            
            
        }
       i = maxSumIdx;
       while(i<maxSumIdx+min){
        grpy[i] = 0;
        i++;
       }
       sum = 0;
       for(int k = 0; k<n ; k++){
        if(grpy[k]==0) sum+=cstm[k];
       }
        return sum;
    }
}
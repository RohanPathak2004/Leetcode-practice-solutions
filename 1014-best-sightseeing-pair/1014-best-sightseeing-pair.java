class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = values[0];
        int maxIdx = 0; 
        int n = values.length;
        for(int i = 1 ; i<n ;i++){
            int currScore = values[maxIdx]+values[i]+(maxIdx-i);
            
            maxScore = Math.max(currScore,maxScore);
            if(values[i]+i>=values[maxIdx]+maxIdx){
                maxIdx = i;
            }
        }
        return maxScore;
    }
}
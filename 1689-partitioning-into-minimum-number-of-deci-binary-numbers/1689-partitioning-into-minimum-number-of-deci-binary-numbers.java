class Solution {
    public int minPartitions(String n) {
        int maxNum = 0;
        for(int i = 0 ; i<n.length() ; i++){
            char ch = n.charAt(i);
            maxNum = Math.max(maxNum,Integer.parseInt(ch+""));
        }
        return maxNum;
    }
}
class Solution {
    public int minPartitions(String n) {
        int maxNum = 0;
        for(int i = 0 ; i<n.length() ; i++){
            int num = n.charAt(i)-48;
            if(num>=maxNum) maxNum = num;
        }
        return maxNum;
    }
}
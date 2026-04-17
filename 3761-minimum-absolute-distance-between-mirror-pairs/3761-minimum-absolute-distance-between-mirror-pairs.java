class Solution {
    public int revNum(int n){
        int r = 0;
        int p =1;
        while(n>0){
            int rem = n%10;
            r = r*10+rem;
            n = n/10;
        }
        return r;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n ; i++){
            if(map.containsKey(nums[i])){
                min = Math.min(min,i-map.get(nums[i]));
                map.put(nums[i],i);
                map.put(revNum(nums[i]),i);
            }else{
                int rev = revNum(nums[i]);
                map.put(rev,i);
            }
        }
        // System.out.println(revNum(123));
        return min==Integer.MAX_VALUE?-1:min;

    }
}
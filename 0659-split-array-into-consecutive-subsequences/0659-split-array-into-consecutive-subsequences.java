class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> avlMap = new HashMap<>();
        HashMap<Integer,Integer> vacMap = new HashMap<>();
        for(int ele:nums){
            avlMap.compute(ele,(k,v)->v==null?1:v+1);
        }
        for(int ele: nums){
            int num = ele;
            if(avlMap.get(num)==0) continue;
             if(vacMap.containsKey(num)){
                vacMap.put(num,vacMap.get(num)-1);
                avlMap.put(num,avlMap.get(num)-1);
                if(vacMap.get(num)==0) vacMap.remove(num);
                vacMap.compute(num+1,(k,v)->v==null?1:v+1);
            }
            else if(avlMap.containsKey(num)&&avlMap.containsKey(num+1)&&avlMap.containsKey(num+2)&&avlMap.get(num)>0&&avlMap.get(num+1)>0&&avlMap.get(num+2)>0){
                avlMap.put(num,avlMap.get(num)-1);
                avlMap.put(num+1,avlMap.get(num+1)-1);
                avlMap.put(num+2,avlMap.get(num+2)-1);
                
                vacMap.compute(num+3,(k,v)->v==null?1:v+1);

            }else return false;
            
            
        }
        
        return true;
    }
}
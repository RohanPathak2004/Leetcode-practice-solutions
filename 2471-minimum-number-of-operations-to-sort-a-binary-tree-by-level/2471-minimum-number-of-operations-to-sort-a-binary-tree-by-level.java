
class Solution {
    public int countTotalSwap(List<Integer> list){
        if(list.size()==1) return 0;
        int n = list.size();
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n ; i++) map.put(list.get(i),i);
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        for(int i = 0; i<n ; i++){
            if(!sortedList.get(i).equals(list.get(i))){
                int pos = map.get(sortedList.get(i));
                int a = list.get(i);
                int b = list.get(pos);
                map.put(a,pos);
                map.put(b,i);
                list.set(i,b);
                list.set(pos,a);
                count++;

            }
        }

        

        return count;

    }
    public int minimumOperations(TreeNode root) {
        int totalSwaps = 0;
        List<List<Integer>> nodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size()!=0){
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            for(int i = 0; i<len ; i++){
                TreeNode front = q.remove();
                list.add(front.val);
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            nodes.add(list);
        }for(List list:nodes){
            totalSwaps += countTotalSwap(list);
        }
        return totalSwaps;
    }
}
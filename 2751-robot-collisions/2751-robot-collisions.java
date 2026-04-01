class Solution {
    public class Robot{
        public int pos;
        public int health;
        public char dir;
        public Robot(int pos, int health, char dir){
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] points, int[] healths, String directions) {
        int n = points.length;
        Robot[] rob = new Robot[n];
        Stack<Robot> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<n ;i++){
            Robot r = new Robot(points[i],healths[i],directions.charAt(i));
            rob[i] = r;
        }

        Arrays.sort(rob,(a,b)->a.pos-b.pos);
        // for(Robot r: rob) System.out.println(r.pos);

        for(int i = 0; i<n ;i++){
            Robot r = rob[i];

            if(st.size()>0&&st.peek().dir=='R'&&r.dir=='L'){
                
                while(st.size()>0&&st.peek().health<r.health&&st.peek().dir=='R'&&r.dir=='L'){
                    st.pop();
                    int h  = r.health;
                    r.health =h-1; 
                }
                if(st.size()>0&&st.peek().health==r.health&&st.peek().dir=='R'&&r.dir=='L'){
                     st.pop();
                     continue;
                }
                if(st.size()>0&&st.peek().dir=='R'&&r.dir=='L'&&st.peek().health>r.health){
                    int h = st.peek().health;
                    Robot top = st.pop();
                    top.health = h-1;
                    st.push(top);
                }else st.push(r);
            }else{
                st.push(r);
            }
        }
        if(st.size()==0) return list;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(st.size()!=0){
            Robot r = st.pop();
            map.put(r.pos,r.health);
        }
        for(int ele:points){
            if(map.containsKey(ele)) list.add(map.get(ele));
        }
        return list;
    }
}
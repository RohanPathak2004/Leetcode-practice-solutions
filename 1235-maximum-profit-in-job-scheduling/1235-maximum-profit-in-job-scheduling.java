class Solution {
    public class Job {
        int s;
        int e;
        int p;

        public Job(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }

    public int lowerBound(int l, int h, int tar, Job[] arr) {
        
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid].s < tar)
                l = mid + 1;
            else {
                h = mid;
            }
        }

        return l;
    }

    public int rec(int i, int n, int maxPoint, Job[] arr, HashMap<Integer,Integer> dp) {
        if (i >= n)
            return 0;
        if(dp.containsKey(i)) return dp.get(i);
            
        int skip = rec(i + 1, n, maxPoint, arr, dp);
        int pick = arr[i].p;
        // if(arr[i].e>maxPoint) return pick;
        int nextIdx = lowerBound(i, n, arr[i].e, arr);
        // System.out.println(nextIdx);
        // if (nextIdx >= n)
        //     return arr[i].p;
        pick += rec(nextIdx,n,maxPoint,arr,dp);
        int ans =  Math.max(pick,skip);
        dp.put(i,ans);
        return ans;
    }

    public int jobScheduling(int[] s, int[] e, int[] p) {
        int n = s.length;
        Job[] arr = new Job[n];
        int maxPoint = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(s[i], e[i], p[i]);
            maxPoint = Math.max(maxPoint,s[i]);
        }
        Arrays.sort(arr, (a, b) -> a.s - b.s);
        // for(Job j: arr) System.out.println(j.s+" "+j.e+" "+j.p+" ");
        HashMap<Integer,Integer> dp = new HashMap<>();
        int ans = -1;
        
            ans = Math.max(ans, rec(0, n, maxPoint, arr, dp));
        
        return ans;
    }
}
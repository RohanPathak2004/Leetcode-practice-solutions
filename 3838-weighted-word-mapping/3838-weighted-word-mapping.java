class Solution {
    public int calculateWeight(String s,int[] arr){
        int w = 0;
        for(int i = 0; i<s.length() ; i++){
            w+=arr[(int)s.charAt(i)-97];
        }
        return w;
    }
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        int n = words.length;
        char chrs[] = new char[26];
        chrs[25] = 'a';
        
        for(int i = 24 ; i>=0 ; i--){
            chrs[i] = (char)((int)chrs[i+1]+1);
            
        }
        char[] ch = new char[n];

        for(int i = 0; i<n ; i++){
            int wordWeight = (calculateWeight(words[i],weights))%26;
            ch[i] = chrs[wordWeight];
            ans+=ch[i];
        }
        
        return ans;
    }
}
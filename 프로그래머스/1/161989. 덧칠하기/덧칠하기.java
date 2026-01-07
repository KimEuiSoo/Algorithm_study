class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paint = 0;
        for(int s : section){
            if(paint<=s){
                paint=s+m;
                answer++;                
            }
        }
        return answer;
    }
}
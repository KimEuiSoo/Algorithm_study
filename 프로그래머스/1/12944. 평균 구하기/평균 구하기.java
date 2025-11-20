class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum=0;
        for(int data : arr){
            sum+=data;
        }
        answer = (double)sum/arr.length;
        return answer;
    }
}
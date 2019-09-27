class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array<IntArray>(arr1.size,{IntArray(arr2[0].size,{i->0})})
        var row1:Int = 0
        var row2:Int = 0
        var col1:Int = 0
        var col2:Int = 0
        var idx1:Int = 0
        var idx2:Int = 0
        var sum:Int = 0

        while(row1 < arr1.size){
            while(col2 < arr2[0].size){
                sum = 0
                col1 = 0
                row2 = 0
                while(col1 < arr1[row1].size){
                    sum += arr1[row1][col1] * arr2[row2][col2]
                    col1++
                    row2++
                }
                col2++
                answer[idx1][idx2] = sum
                idx2++
            }
            row1++
            idx2 = 0
            idx1++
            col2 = 0
        }

        return answer
    }
}
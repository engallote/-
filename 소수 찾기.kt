import java.io.BufferedInputStream
import java.lang.StringBuilder
import java.util.*
import javax.print.attribute.IntegerSyntax

class Solution {
    var check: Array<Boolean> = Array<Boolean>(8, { false })
    var hs: HashSet<Int> = HashSet<Int>()
    fun main(args: Array<String>) = with(Scanner(BufferedInputStream(System.`in`))) {
        var numbers: String = "17"
        println(solution(numbers))
    }

    fun solution(numbers: String): Int {
        var answer = 0
        val max: Int = 10000000
        var chk: Array<Boolean> = Array<Boolean>(10000000, { i -> false })
        chk[0] = true
        chk[1] = true

        for (i in 0..max - 1) {
            if (chk[i]) continue
            for (j in i + i..max - 1 step i) {
                chk[j] = true
            }
        }
        var ch: CharArray = numbers.toCharArray()
        find(ch, "")

        var x: Int = 0
        for (i in hs) {
            x = i
            if (!chk[x]) answer++
        }
        return answer
    }

    fun find(ch: CharArray, path: String) {
        if (path.length > 0) hs.add(Integer.parseInt(path))

        for (i in 0..ch.size - 1) {
            if (!check[i]) {
                check[i] = true
                find(ch, path + "" + ch[i])
                check[i] = false
            }
        }
    }
}
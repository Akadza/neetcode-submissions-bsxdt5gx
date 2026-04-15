class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (word in strs) {
            val count = IntArray(26)
            for (c in word) count[c - 'a']++
            val key = count.joinToString(separator = "#")
            map.getOrPut(key) { mutableListOf() }.add(word)
        }
        return map.values.toList()
    }
}

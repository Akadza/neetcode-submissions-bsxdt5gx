class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

class WordDictionary {
    private val root = TrieNode() 

    fun addWord(word: String) {
        var current = root
        for (char in word) {
            current = current.children.getOrPut(char) { TrieNode() }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        return dfs(word, 0, root)
    }
    
    private fun dfs(word: String, i: Int, node: TrieNode): Boolean {
        if (word.length == i) return node.isEndOfWord

        val char = word[i]

        if (char == '.') {
            for (child in node.children.values) {
                if (dfs(word, i + 1, child)) return true
            }
            return false
        } else {
            val nextNode = node.children[char] ?: return false
            return dfs(word, i + 1, nextNode)
        }
    }
}

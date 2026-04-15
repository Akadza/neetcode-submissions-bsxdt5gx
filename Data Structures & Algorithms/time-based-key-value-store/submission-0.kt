class TimeMap {

    private val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val list = map.getOrPut(key) { mutableListOf() }
        list.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val list = map[key] ?: return ""
        
        var left = 0
        var right = list.size - 1
        var result = ""

        while (left <= right) {
            val idx = left + (right - left) / 2
            val (ts, value) = list[idx]

            if (ts <= timestamp) {
                result = value
                left = idx + 1
            } else right = idx - 1
        }
        return result
    }
}

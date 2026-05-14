class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = HashMap<Int, MutableList<Int>>()
        for (i in 0 until numCourses) {
            preMap[i] = mutableListOf()
        }
        for (prereq in prerequisites) {
            val (crs, pre) = prereq
            preMap[crs]!!.add(pre)
        }

        val visiting = HashSet<Int>()

        fun dfs(crs: Int): Boolean {
            if (crs in visiting) {
                return false
            }
            if (preMap[crs]!!.isEmpty()) {
                return true
            }

            visiting.add(crs)
            for (pre in preMap[crs]!!) {
                if (!dfs(pre)) {
                    return false
                }
            }
            visiting.remove(crs)
            preMap[crs] = mutableListOf()
            return true
        }
        for (c in 0 until numCourses) {
            if (!dfs(c)) {
                return false
            }
        }
        return true
    }
}

class Twitter {
    private var timeStamp = 0
    private val follows = mutableMapOf<Int, MutableSet<Int>>()
    private val tweets = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()


    fun postTweet(userId: Int, tweetId: Int) {
        tweets.getOrPut(userId) { mutableListOf() }.add(tweetId to timeStamp)
        timeStamp++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> b.third - a.third }

        val people = (follows[userId] ?: mutableSetOf()).toMutableSet()
        people.add(userId)

        for (id in people) {
            val userTweets = tweets[id]
            if (!userTweets.isNullOrEmpty()) {
                val lastIdx = userTweets.size - 1
                val lastTweet = userTweets[lastIdx]
                pq.add(Triple(id, lastIdx, lastTweet.second))
            }
        }

        val result = mutableListOf<Int>()

        while (pq.isNotEmpty() && result.size < 10) {
            val (authorId, tweetIdx, _) = pq.poll()

            result.add(tweets[authorId]!![tweetIdx].first)

            if (tweetIdx > 0) {
                val nextIdx = tweetIdx - 1
                val nextTweet = tweets[authorId]!![nextIdx]
                pq.add(Triple(authorId, nextIdx, nextTweet.second))
            }
        }

        return result
        
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (followerId != followeeId) {
            follows.getOrPut(followerId) { mutableSetOf() }.add(followeeId)
        }
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        follows[followerId]?.remove(followeeId)
    }
}

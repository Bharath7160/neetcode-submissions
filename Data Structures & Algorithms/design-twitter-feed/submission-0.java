class Twitter {
    private static class Tweet {
        int id;
        long time;
        Tweet next; // This user's previous tweet

        Tweet(int id, long time, Tweet next) {
            this.id = id;
            this.time = time;
            this.next = next;
        }
    }

    private long time = 0;
    private Map<Integer, Tweet> latestTweet = new HashMap<>();
    private Map<Integer, Set<Integer>> follows = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        Tweet previous = latestTweet.get(userId);
        latestTweet.put(userId, new Tweet(tweetId, time++, previous));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        // Most recent tweet has priority.
        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>((a, b) -> Long.compare(b.time, a.time));

        // Include the user's own tweets.
        if (latestTweet.containsKey(userId)) {
            maxHeap.offer(latestTweet.get(userId));
        }

        // Include the latest tweet from each followed user.
        for (int followeeId : follows.getOrDefault(userId, Collections.emptySet())) {
            if (followeeId != userId && latestTweet.containsKey(followeeId)) {
                maxHeap.offer(latestTweet.get(followeeId));
            }
        }

        while (!maxHeap.isEmpty() && feed.size() < 10) {
            Tweet newest = maxHeap.poll();
            feed.add(newest.id);

            // Make that user's next older tweet available.
            if (newest.next != null) {
                maxHeap.offer(newest.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, id -> new HashSet<>())
               .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
package heap.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Problem: 355. Design Twitter
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsdesign-twitter
 */
class Twitter {

    class Tweet {
        public int userId;
        public int tweetId;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    private HashMap<Integer, HashSet<Integer>> following;
    private ArrayList<Tweet> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        int i = tweets.size() - 1;
        while (i >= 0 && feed.size() < 10) {
            Tweet tweet = tweets.get(i);
            if (tweet.userId == userId || following.getOrDefault(userId, new HashSet<>()).contains(tweet.userId))
                feed.add(tweet.tweetId);
            i--;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> hs = following.getOrDefault(followerId, new HashSet<>());
        hs.add(followeeId);
        following.put(followerId, hs);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> hs = following.getOrDefault(followerId, new HashSet<>());
        hs.remove(followeeId);
        following.put(followerId, hs);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
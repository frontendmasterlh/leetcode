package array.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-twitter/
 * */
public class Twitter {

    public class Tweet {
        int tweetId;
        int timeStamp;
        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
    int timeStamp;
    private Map<Integer, List<Tweet>> timelines;
    private Map<Integer, Set<Integer>> followMap;

    /** Initialize your data structure here. */
    public Twitter() {
        timelines = new HashMap<>();
        followMap = new HashMap<>();
        timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
            timelines.put(userId, new ArrayList<>());
        }
        timelines.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> feed = new ArrayList<>();
        if (!followMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        List<Tweet> timeline = timelines.get(userId);
        if (timeline != null) {
            for (int i = timeline.size() - 1; i >= Math.max(0, timeline.size() - 10); i--) {
                feed.add(timeline.get(i));
            }
        }
        Set<Integer> followees = followMap.get(userId);
        if (followees != null) {
            for (Integer followee : followees) {
                timeline = timelines.get(followee);
                if (timeline != null) {
                    for (int i = timeline.size() - 1; i >= Math.max(0, timeline.size() - 10); i--) {
                        feed.add(timeline.get(i));
                    }
                }
            }
        }
        Collections.sort(feed, new Comparator<Tweet>(){
            public int compare(Tweet o1, Tweet o2) {
                return o2.timeStamp - o1.timeStamp;
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            list.add(feed.get(i).tweetId);
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
            timelines.put(followerId, new ArrayList<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> follow = followMap.get(followerId);
        if (follow == null) {
            return;
        }
        follow.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 1);
//        twitter.getNewsFeed(1);
        twitter.follow(1, 5);
//        twitter.getNewsFeed(2);
        List<Integer> res1 = twitter.getNewsFeed(1);
        for (Integer r : res1) {
            System.out.println(r);
        }
//        twitter.unfollow(2, 1);
////        twitter.postTweet(2, 6);
//        List<Integer> res = twitter.getNewsFeed(1);
//        for (Integer r : res) {
//            System.out.println(r);
//        }
    }
}

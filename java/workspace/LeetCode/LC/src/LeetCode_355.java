/**
 * Created by Dachi on 16/7/28.
 */

import java.util.*;

class Tweet {
    public int userId;
    public int tweetId;
    public int timestamp;

    public Tweet(int uId, int tId, int time){
        this.userId = uId;
        this.tweetId = tId;
        this.timestamp = time;
    }
}

class Twitter {

    HashMap users;
    HashMap tweets;
    HashMap follows;
    int timestamp;

    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new HashMap();
        this.tweets = new HashMap();
        this.follows = new HashMap();
        this.timestamp = 0;
    }

    public void registerUser(int userId){
        users.put(userId,1);
        tweets.put(userId,new ArrayList<Tweet>());
        List<Integer> followees = new ArrayList<Integer>();
        followees.add(userId);
        follows.put(userId,followees);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {

        //If a user does not exist
        if(users.get(userId) == null){
            registerUser(userId);
        }

        //Create a new tweet
        Tweet t = new Tweet(userId,tweetId,this.timestamp);
        this.timestamp++;

        //Add the user-tweet record in the hashmap
        List<Tweet> userTweets = (ArrayList) tweets.get(userId);
        userTweets.add(t);
        tweets.put(userId, userTweets);

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        if(users.get(userId) == null){
            registerUser(userId);
        }

        List<Integer> result = new ArrayList<Integer>();

        PriorityQueue<Tweet> pq = new PriorityQueue(10, new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2){
                return t2.timestamp - t1.timestamp;
            }
        });

        List<Integer> followees = (ArrayList) follows.get(userId);

        for(int i = 0; i < followees.size(); i++){
            //Fetch the tweets of every followee this user has
            List<Tweet> ts = (ArrayList) tweets.get(followees.get(i));

            //Loop thru all the tweets
            for(int j = 0; j < ts.size(); j++){
                pq.offer(ts.get(j));
            }
        }

        int count = 10;

        while(pq.size() > 0 && count-- > 0){
            Tweet t = pq.poll();
            result.add(t.tweetId);
        }

        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        //Invalid operations
        if(followerId < 0 || followeeId < 0 || followerId == followeeId){
            return ;
        }

        //If follower does not exist
        if(users.get(followerId) == null){
            registerUser(followerId);

        }

        //If followee does not exist
        if(users.get(followeeId) == null ){
            registerUser(followeeId);
        }

        //Put follower-follwee into hashmap, do not add duplicate
        List<Integer> followees = (ArrayList) follows.get(followerId);
        if(followees.indexOf(followeeId) < 0){
            followees.add(followeeId);
            follows.put(followerId,followees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        //Invalid operations
        if(followerId < 0 || followeeId < 0 || followerId == followeeId){
            return ;
        }

        if(users.get(followerId) == null || users.get(followeeId) == null){
            return ;
        }

        //Unfollow
        List<Integer> followees = (ArrayList) follows.get(followerId);
        if(followees.indexOf(followeeId) > 0){
            followees.remove((Integer) followeeId);
            follows.put(followerId,followees);
        }
    }
}

public class LeetCode_355 {
    public static void main(String[] args){

    }
}

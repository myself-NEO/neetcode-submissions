class Twitter {

    Set<Integer> users;
    Map<Integer, Set<Integer>> followees;
    List<Pair<Integer, Integer>> tweets;
    public Twitter() {
        users = new HashSet<>();
        followees = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        users.add(userId);
        tweets.add(new Pair<>(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        for(int i=tweets.size()-1; i>=0; i--) {
            int u = tweets.get(i).getKey();
            if(feed.size()==10) return feed;
            if((null!=followees.get(userId) && followees.get(userId).contains(u)) || u == userId) {
                feed.add(tweets.get(i).getValue());
            }
        }
        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> f = followees.get(followerId);
        f.remove(followeeId);
        followees.put(followerId, f);
    }
}

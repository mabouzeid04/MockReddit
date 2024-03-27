/*
 * Mahmoud Abouzeid
 * 
 * This file contains all the instance variables 
 * for the users and the methods used to manipulate users.
 */

import java.util.ArrayList;

/**
 * This class stores users and is responsible for 
 * using methods to manipulate the users.
 */
public class User {
    private int karma;
    private String username;
    private ArrayList<Post> posts;
    private ArrayList<Post> upvoted;
    private ArrayList<Post> downvoted;

    /**
     * This constructor intializes the user.
     * 
     * @param username username of the user.
     */

     public User(String username){
        this.username = username;
        karma = 0;
        posts = new ArrayList<Post>();
        upvoted = new ArrayList<Post>();
        downvoted = new ArrayList<Post>();
    }
    /**
     * This method adds a post to the users array of posts.
     * 
     * @param post the post that will be added to the user.
     */
    public void addPost(Post post){
        if (post == null){
            return;
        }
        else {
            posts.add(post);
            updateKarma();
        }
    }

    /**
     * This method updates the users karma.
     */
    public void updateKarma(){
        karma = 0;
        for (int i = 0; i < posts.size(); i++){
            karma += (posts.get(i).getUpvoteCount()
                - posts.get(i).getDownvoteCount());
        }
    }

    /**
     * This getter method returns the karma of the user.
     * 
     * @return returns the karma of user.
     */
    public int getKarma(){
        return karma;
    }

    /**
     * This method allows a user to upvote a post.
     * 
     * @param post the post that is upvoted
     */
    public void upvote(Post post){
        if (post == null){
            return;
        }
        boolean upvotedByUser = false;
        boolean downvotedByUser = false;
        for (int i = 0; i < upvoted.size(); i++){
            if (post == upvoted.get(i)){
                upvotedByUser = true;
            }
        }
        // returns if user is author or they already upvoted.
        if ((post.getAuthor() == this) || (upvotedByUser)) {
            return;
        }

        for (int i = 0; i < downvoted.size(); i++){
            if (post == downvoted.get(i)){
                downvotedByUser = true;
            }
        }
        
        // removes downvote if applicable.
        if (downvotedByUser){
            post.updateDownvoteCount(false);
            downvoted.remove(post);
        }
        // updates upvotes on the post and adds it to the upvoted array
        upvoted.add(post);
        post.updateUpvoteCount(true);
        post.getAuthor().updateKarma();
    }

    /**
     * This method allows a user to downvote a post.
     * 
     * @param post the post that is downvoted.
     */
    public void downvote(Post post){
        if (post == null){
            return;
        }
        boolean upvotedByUser = false;
        boolean downvotedByUser = false;

        for (int i = 0; i < downvoted.size(); i++){
            if (post == downvoted.get(i)){
                downvotedByUser = true;
            }
        }
        if ((post.getAuthor() == this) || (downvotedByUser)) {
            return;
        }
        // finds out if post was upvoted by user already.
        for (int i = 0; i < upvoted.size(); i++){
            if (post == upvoted.get(i)){
                upvotedByUser = true;
            }
        }

        // removes upvote if applicable.
        if (upvotedByUser){
            post.updateUpvoteCount(false);
            upvoted.remove(post);
        }

        // updates downvotes on the post and adds it to the downvoted array
        downvoted.add(post);
        post.updateDownvoteCount(true);
        post.getAuthor().updateKarma();
    }

    /**
     * This method finds and returns the users top post.
     * 
     * @return returns the users top post.
     */
    public Post getTopPost(){ 
        if ((posts == null) || (posts.size() == 0)){
            return null;
        }

        int maxVotes = Integer.MIN_VALUE;
        Post topPost = posts.get(0);
        for (int i = 0; i < posts.size(); i++){
            if (posts.get(i).getTitle() != null) { // ensures theres a title. 
                if (posts.get(i).getUpvoteCount()
                    - posts.get(i).getDownvoteCount() > maxVotes){
                    maxVotes = posts.get(i).getUpvoteCount()
                        - posts.get(i).getDownvoteCount();
                    topPost = posts.get(i);
                }
            }       
        }
        return topPost;
    }

    



}

/*
 * Mahmoud Abouzeid
 * This file contains all the instance variables 
 * for the posts and the methods used to manipulate posts.
 */

import java.util.ArrayList;

/**
 * This class stores posts and is responsible for 
 * manipulating the posts and displaying their values.
 */
public class Post {
    private String title;
    private String content;
    private Post replyTo;
    private User author;
    private int upvoteCount;
    private int downvoteCount;

    /** 
     * This constructor initializes the posts
     * 
     * @param title the title of the post
     * @param content content of the post
     * @param author author of the post
     */
    public Post(String title, String content, User author){
        this.title = title;
        this.content = content;
        replyTo = null;
        this.author = author;
        upvoteCount = 1;
        downvoteCount = 0;
    }

    /**
     * This constructor intializes the reply to a post.
     * 
     * @param content content of the reply
     * @param replyTo which post the reply is replying to
     * @param author author of the reply
     */
    public Post(String content, Post replyTo, User author){
        title = null; 
        this.content = content;
        this.replyTo = replyTo;
        this.author = author;
        upvoteCount = 1;
        downvoteCount = 0;
    }

    /**
     * This getter method returns the title of the post.
     * 
     * @return returns the title of the post.
     */
    public String getTitle(){ 
        return title;
    }

    /**
     * this getter method returns the post that
     * this comment is replying to.
     * 
     * @return returns the post that this is replying to.
     */
    public Post getReplyTo(){ 
        return replyTo;
    }

    /**
     * This getter method gets the author of the post.
     * 
     * @return returns the author of the post.
     */
    public User getAuthor(){
        return author;
    }

    /**
     * This getter method gets the upvotes of the post.
     * 
     * @return returns the upvote count of the post
     */
    public int getUpvoteCount(){
        return upvoteCount;
    }
    
    /**
     * This getter method gets the downvotes of the post.
     * 
     * @return returns the downvote count of the post
     */
    public int getDownvoteCount(){
        return downvoteCount;
    }

    /**
     * This method updates the upvote count of a post.
     * 
     * @param isIncrement whether the upvote count should
     *  be incremented or decremented.
     */
    public void updateUpvoteCount(boolean isIncrement){
        if (isIncrement){
            upvoteCount++;
        }
        else {
            upvoteCount--;
        }
    }

    /**
     * This method updates the downvote count of a post.
     * 
     * @param isIncrement whether the downvote count should
     *  be incremented or decremented.
     */
    public void updateDownvoteCount(boolean isIncrement){
        if (isIncrement){
            downvoteCount++;
        }
        else {
            downvoteCount--;
        }
    }

    /**
     * This getter method returns the thread of the post.
     * 
     * @return returns the thread of posts before this one.
     */
    public ArrayList<Post> getThread(){
        ArrayList<Post> thread = new ArrayList<Post>();
        boolean comment = false;
        if (this.getTitle() == null) {
            comment = true;
        }

        Post currentPost = this; // this actually refers to the current post

        while (comment) {
            thread.add(0, currentPost);
            currentPost = currentPost.getReplyTo();
            if (currentPost.getTitle() != null){
                comment = false;
            }
        }
        
        thread.add(0, currentPost);
        
        return thread;
    }

    /**
     * This method puts the post in string format.
     * @return returns a string of the post.
     */
    public String toString(){
        if (title == null){
            return "[" + upvoteCount + "|" + downvoteCount + "]" +
                "\t" + content;
        }
        else {
            return "[" + upvoteCount + "|" + downvoteCount +
                "]" + "\t" + title + "\n" + "\t" + content;
        }
    } 
}
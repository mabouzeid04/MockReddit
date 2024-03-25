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
}

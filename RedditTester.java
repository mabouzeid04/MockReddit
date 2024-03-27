/*
 * Mahmoud Abouzeid
 * Email: mabouzeid@ucsd.edu
 * 
 * This file tests the files User.java and Post.java.
 */

/**
 * This class tests the methods in post.java and user.java.
 */
public class RedditTester {
    public static void main(String[] args) {
        
        // go through every method in the two classes and try every different input. 
        User rama = new User("rama");
        User zibda = new User("zibda");
        User eric = new User("eric");
        Post p1 = new Post("Post1", "OrigPost", rama);
        Post p2 = new Post("Post2", "OrigPost2", rama);
        Post c1 = new Post("Comment1", p1, rama);
        Post c2 = new Post("comment2", c1, rama);
        Post c3 = new Post("comment3", c2, zibda);
        
        System.out.println(rama);
        System.out.println(zibda);

        //upvoting and downvoting.
        zibda.upvote(c1);
        rama.upvote(c1); 
        rama.upvote(c2); 
        zibda.downvote(c1);
        zibda.upvote(p2);
        zibda.upvote(c2);
        zibda.upvote(c2);
        zibda.downvote(p2);
        eric.upvote(c2);

        System.out.println(c2);
        
        // testing getter methods
        System.out.println("c2 author is " + c2.getAuthor());
        System.out.println("c2 title is " + c2.getTitle());
        System.out.println("c2 is replying to " + c2.getReplyTo());
        System.out.println("c1 upvote count is " + c1.getUpvoteCount());
        System.out.println("c1 downvote count is " +c1.getDownvoteCount());
        System.out.println("c1 is " +c1);
        System.out.println("c1 is replying to" + c1.getReplyTo());

        //karma is only updated if the add posts to user comes after the up/downvoting
        rama.addPost(p1);
        rama.addPost(p2);
        rama.addPost(c1);
        rama.addPost(c2);
        zibda.addPost(c3);

        System.out.println(p1.getThread());
        System.out.println(c3.getThread());

        System.out.println(rama);
        System.out.println(zibda);
        
        // testing top post and top comment
        System.out.println("rama top post is " + rama.getTopPost());
        System.out.println("rama top comment is " + rama.getTopComment());
        
        System.out.println(rama.getPosts());
        System.out.println(zibda.getPosts());
        
        
    }
    
}

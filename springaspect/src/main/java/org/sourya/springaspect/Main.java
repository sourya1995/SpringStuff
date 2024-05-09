package org.sourya.springaspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(CommentService.class);
        
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Sourya");
        service.publishComment(comment);
    }
}

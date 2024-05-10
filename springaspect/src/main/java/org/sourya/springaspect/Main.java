package org.sourya.springaspect;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
	private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main( String[] args )
    {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(CommentService.class);
        
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Sourya");
        String value = service.publishComment(comment);
        logger.info(value);
    }
}

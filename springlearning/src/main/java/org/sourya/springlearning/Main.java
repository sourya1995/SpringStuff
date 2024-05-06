package org.sourya.springlearning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Parrot p = new Parrot();
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}

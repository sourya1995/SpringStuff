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
		/* Parrot p = new Parrot(); */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean("parrot2", Parrot.class);
        System.out.println(p.getName());
        
        String s = context.getBean(String.class);
        System.out.println(s);
        
        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}

package org.sourya.springlearning;

import java.util.function.Supplier;

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
        Parrot x = new Parrot();
        x.setName("CR7");
        Supplier<Parrot> parrotSupplier = () -> x;
        context.registerBean("parrot1", Parrot.class, parrotSupplier);
        Parrot p = context.getBean(Parrot.class);
		/* p.setName("Ravi"); */
        System.out.println(p.getName());
        
        String s = context.getBean(String.class);
        System.out.println(s);
        
        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}

package org.jboss.arquillian.examples.jbembedded;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.impl.base.ServiceExtensionLoader;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class HelloEJBITCase {
    @EJB
    private HelloEJB helloEJB;

    @Deployment
    public static JavaArchive createTestArchive() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "helloEJB.jar")
                .addClasses(HelloEJB.class);
        return jar;
    }

    @Test
    public void testHelloEJB() {
        String result = helloEJB.sayHelloEJB("Michael");
        System.out.println(result);
        assertEquals("Hello Fred", result);
    }

    @Test
    public void testHelloEJB2() {
        String result = helloEJB.sayHelloEJB("Michael");
        System.out.println(result);
        assertEquals("Hello Michael", result);
    }
}

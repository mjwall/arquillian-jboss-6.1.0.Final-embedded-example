package org.jboss.arquillian.examples.jbembedded;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@RunWith(Arquillian.class)
public class HelloEJBITTest {
    @EJB
    private HelloEJB helloEJB;

    @Deployment
    public static JavaArchive createTestArchive() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "helloEJB.jar")
                .addClasses(HelloEJB.class);
        System.out.println("HERE MIKE");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Test
    public void testHelloEJB() {
        String result = helloEJB.sayHelloEJB("Michael");
        assertEquals("Hello Michael", result);
        //assertEquals("Hello David", result);
    }
}

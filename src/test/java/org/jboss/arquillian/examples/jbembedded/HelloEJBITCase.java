package org.jboss.arquillian.examples.jbembedded;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Arquillian.class)
public class HelloEJBITCase {
    @EJB
    private HelloEJBBean helloEJB; //instantiated with arquillian

    private String expectedGreeting = null;

    @Before
    public void setup() {
        // test without injection
        expectedGreeting = new PhrasesBean().getGreeting();
    }


    @Deployment
    public static JavaArchive createTestArchive() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "helloEJB.jar")
                .addClasses(HelloEJBBean.class)
                .addClass(LocalPhrases.class)
                .addClass(PhrasesBean.class);
        return jar;
    }

    @Test
    public void testPojoStillWorks() {
        String name = "Fred";
        assertEquals("Hello " + name, helloEJB.sayHelloPOJO(name));
    }

    @Test
    public void testAFailureDoesNotStopLaterTests() {
        fail("Hopefully later test will still run");
    }

    @Test
    public void testEJBResourceInjection() {
        String name = "Mike";
        assertEquals(expectedGreeting + name, helloEJB.sayHelloEJB(name));
    }
}

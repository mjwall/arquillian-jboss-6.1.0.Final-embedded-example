package org.jboss.arquillian.examples.jbembedded;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class HelloEJBTest  {
    @Test
    public void testPOJO() {
        HelloEJBBean pojo = new HelloEJBBean();
        assertEquals("Hello Mike", pojo.sayHelloPOJO("Mike"));
    }

    @Test
    public void testEJB() {
        // This one is not run through JBoss, so the EJB hasn't been injected and you will get a NPE
        // calling resource.getGreeting
        HelloEJBBean ejb = new HelloEJBBean();
        try {
            assertEquals("Hello George", ejb.sayHelloEJB("George"));
            fail();
        } catch (NullPointerException npe) {
            assertNull(npe.getMessage());
        }
    }

    @Test
    public void testEJBWithHelper() {
        HelloEJBBean bean = HelloEJBBean.getTestableInstance(new PhrasesBean());
        String expectedGreeting = new PhrasesBean().getGreeting();
        String name = "Johnny";
        assertEquals(expectedGreeting + name, bean.sayHelloEJB(name));
    }
}
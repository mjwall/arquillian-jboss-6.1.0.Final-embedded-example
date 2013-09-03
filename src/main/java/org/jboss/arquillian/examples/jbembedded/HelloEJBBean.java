package org.jboss.arquillian.examples.jbembedded;

import org.jboss.annotation.ejb.LocalBinding;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
public class HelloEJBBean {

    @EJB
    private LocalPhrases phrases;

    // helper method for testing
    protected static HelloEJBBean getTestableInstance(LocalPhrases phrases) {
        HelloEJBBean bean = new HelloEJBBean();
        bean.phrases = phrases;
        return bean;
    }

	public String sayHelloEJB(String name) {

		return phrases.getGreeting() + name;
	}

    public String sayHelloPOJO(String name) {
        return "Hello " + name;
    }
}

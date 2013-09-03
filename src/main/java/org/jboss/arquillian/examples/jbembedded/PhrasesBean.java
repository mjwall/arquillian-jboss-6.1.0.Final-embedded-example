package org.jboss.arquillian.examples.jbembedded;

import org.jboss.annotation.ejb.LocalBinding;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local(LocalPhrases.class)
@Stateless
public class PhrasesBean implements LocalPhrases{
    public String getGreeting() {
        return "YOLO ";
    }

}

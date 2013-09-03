# JBoss 6.1.0.Final Embedded Example

It appears that Arquillian is not being used with JBoss 6 by very many people.  I searched around for a concise, working
example, but everything I found was 1-2 years old and nothing was for JBoss 6.1.0.Final.  I am stuck on that JBoss for
little while longer.  This project is an attempt to provide that simple working example.  I started with the
ejb31-jbembedded example at https://github.com/arquillian/arquillian-examples/tree/master/ejb31-jbembedded.

Arquillian enables you to test your business logic in a remote or embedded container. Alternatively, it can deploy an archive to the container so the test can interact as a remote client.

All about arquillian: http://jboss.org/arquillian

## Getting started

1. Clone this project at https://github.com/mjwall/arquillian-jboss-6.1.0.Final-embedded-example
2. There is no need to create a settings.xml like is needed for most JBoss projects, but in case you are curious the
instructions are at http://community.jboss.org/wiki/MavenGettingStarted.
3. To run unit test, use the usual `mvn test`.
4. Integration tests are run using the failsafe-plugin, and are run using `mvn integration-test` or `mvn verify`.

## Notes about design

My intention here is show how to test a simple EJB with another EJB injected into it.  The class under test is the
HelloEJBBean.  Injected into that is the PhraseBean which has a getGreeting method that is used in the
sayHelloEJB method

I attempted to recreate what I have done in the past to test EJBs without Arquillian in the HelloEJBTest.  It is a simple
JUnit testcase that uses a protected static method on the HelloEJBBean class to 'inject' the PhrasesBean.

The HelloEJBITCase is used by Arquillian and deployed to an embedded JBoss for testing.  Arquillian doesn't appear to get
eployment information from the container, so injected resources are by naming convention.  A good reference for this
naming convention is https://docs.jboss.org/author/display/ARQ/Dependency+injection.  I am unsure the EJB's
mappedName would work correctly, but it looks there is a ticket that has been completed at
https://issues.jboss.org/browse/ARQ-167.

Normal unit tests where the class ends in *Test.java will be run during maven's test phase.  Integration tests will not
be run.

Using the maven-failsafe-plugin, only tests ending in *IT*.java, *IT.java and *ITCase.java will be run during the
integration-test phase.  During this phase, JBoss will be downloaded and unzip it in the target directory.
Arquillian then starts JBoss and deploys an archive.  Failsafe will not stop the build for a failing test,
so all your tests will get a chance to run.  For more on failsafe,
see http://maven.apache.org/surefire/maven-failsafe-plugin/index.html.  Note, the integration-phase also runs the test
phase, so unit tests will be run first

NOTE: the xmlsec jar appears to be corrupted in the nexus repo.  I got
a "invalid CEN header (bad signature)" error, so I downloaded a binary from
http://archive.apache.org/dist/santuario/java-library/xml-security-bin-1_4_3.zip,
unzipped it and put the lib/xmlsec-1.4.3.jar into my maven repo at the
correct location.

NOTE2: running `mvn integration-test` will download
jboss-as-distribution, which is huge and takes a while.  Be patient

## System requirements

This project will built with Java 1.6.0_45 and Maven 3.0.5.

## Links/Credits

Along the way, I bookmarked the following pages.  I didn't associate what nugget of info I found where, but they were
 all useful.  Sorry.

- [https://community.jboss.org/thread/170302?start=0&tstart=0]
- [https://github.com/arquillian/arquillian-showcase]
- [http://arquillian.org/modules/arquillian-jbossas-embedded-6-container-adapter/]
- [http://blog.inbetweenthoughts.com/2010/07/running-tests-in-maven-using-arquillian.html]
- [http://milestonenext.blogspot.de/2012/12/ejb3-integration-test-with-arquillian.html]
- [http://www.javacodegeeks.com/2012/06/java-ee-6-testing-part-ii-introduction.html]
- [http://www.samaxes.com/2012/05/javaee-testing-introduction-arquillian-shrinkwrap/]
- [http://arquillian.org/guides/getting_started/#add_a_container_adapter]
- [http://arquillian.org/guides/getting_started_rinse_and_repeat/]
- [https://community.jboss.org/thread/172264]
- [https://docs.jboss.org/author/display/ARQ/Containers]
- [https://docs.jboss.org/author/display/ARQ/Test+run+modes]

## TODO
Figure out how to debug a test in JBoss.  http://stackoverflow.com/questions/14522734/debugging-with-arquillian-in-intellij-managed-container
may help.

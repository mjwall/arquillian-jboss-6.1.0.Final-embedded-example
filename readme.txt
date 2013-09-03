JBoss 6.1.0.Final Embedded Example

It appears that Arquillian with JBoss 6 is not being used by very many people.  I search around for a concise, working
example, but everything I found was 1-2 years old and nothing was for JBoss 6.1.0.Final, which is what I am
stuck using.  This project is an attempt to provide that simple working example.  I started with the
ejb31-jbembedded example at https://github.com/arquillian/arquillian-examples/tree/master/ejb31-jbembedded.

Arquillian enables you to test your business logic in a remote or embedded container. Alternatively, it can deploy an archive to the container so the test can interact as a remote client.
 
All about arquillian: http://jboss.org/arquillian
 
Getting started
================
1) Clone this project at Download sources.
2) Configure JBoss Maven repositories in settings.xml (http://community.jboss.org/wiki/MavenGettingStarted).
3) Run: mvn test.
 
 Tests will be executed within container. Container will be started by Arquillian, automatically.
 
 System requirements
 ===================
 All you need to run this project is Java 5.0 (Java SDK 1.5) or greater and
 Maven 2.0.10 or greater. This application is setup to be run on a Java EE 6
 certified application server.



Along the way, I bookmarked the following pages.  I didn't associate what nugget of info I found where, sorry.

https://community.jboss.org/thread/170302?start=0&tstart=0

https://github.com/arquillian/arquillian-showcase

http://arquillian.org/modules/arquillian-jbossas-embedded-6-container-adapter/

http://blog.inbetweenthoughts.com/2010/07/running-tests-in-maven-using-arquillian.html

http://milestonenext.blogspot.de/2012/12/ejb3-integration-test-with-arquillian.html

http://www.javacodegeeks.com/2012/06/java-ee-6-testing-part-ii-introduction.html

http://www.samaxes.com/2012/05/javaee-testing-introduction-arquillian-shrinkwrap/

http://arquillian.org/guides/getting_started/#add_a_container_adapter

http://arquillian.org/guides/getting_started_rinse_and_repeat/

https://community.jboss.org/thread/172264

https://docs.jboss.org/author/display/ARQ/Containers

https://docs.jboss.org/author/display/ARQ/Test+run+modes
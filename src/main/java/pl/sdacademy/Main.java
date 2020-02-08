package pl.sdacademy;

import org.apache.catalina.startup.Tomcat;
import pl.sdacademy.tomcat.EmbeddedTomcatFactory;

public class Main {
    public static void main(String[] args) throws Exception {

        Tomcat tomcat = EmbeddedTomcatFactory.create(8080);
        tomcat.start();
        tomcat.getServer().await();

    }
}

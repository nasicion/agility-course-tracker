package com.nasicion.agility_course_tracker;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * Created by guillermo.nasi on 23/05/2017.
 */
@SpringBootApplication()
public class AgilityCourseTracker {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgilityCourseTracker.class);

    public static void main(String[] args) {
        SpringApplication.run(AgilityCourseTracker.class, args);

        LOGGER.debug("amount of args: " + args.length);
        Arrays.stream(args).forEach(arg -> LOGGER.debug("arg: " + arg));

        Boolean openBrowser = args.length > 0 ? Boolean.valueOf(args[0]) : false;

        LOGGER.debug("Open Browser: " + openBrowser);
        if (openBrowser)
            openBrowser();
    }

    /**
     * Starts a web browser in the host machine
     */
    private static void openBrowser() {
        String url = "http://localhost:8080/";

        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try{

            if (os.indexOf( "win" ) >= 0) {

                // this doesn't support showing urls in the form of "page.html#nameLink"
                rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);

            } else if (os.indexOf( "mac" ) >= 0) {

                rt.exec( "open " + url);

            } else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {

                // Do a best guess on unix until we get a platform independent way
                // Build a list of browsers to try, in this order.
                String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror",
                        "netscape","opera","links","lynx"};

                // Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
                StringBuffer cmd = new StringBuffer();
                for (int i=0; i<browsers.length; i++)
                    cmd.append( (i==0  ? "" : " || " ) + browsers[i] +" \"" + url + "\" ");

                rt.exec(new String[] { "sh", "-c", cmd.toString() });

            } else {
                return;
            }
        }catch (Exception e){
            return;
        }
        return;
    }
}

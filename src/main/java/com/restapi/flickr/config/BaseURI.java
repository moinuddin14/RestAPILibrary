package com.restapi.flickr.config;

/**
 * Created by s0v0023 on 11/2/16.
 */
public class BaseURI {

    /**
     * User/ Client/ Customer has to update the QA, Prod and/ or Stagging i.e., the Base Uri to run the tests on.
     */
    public final static String QA="https://qa-api.flickr.com/services/rest";
    public final static String PROD="https://api.flickr.com/services/rest";
    public final static String STAGGING="https://stagging-api.flickr.com/services/rest";

    /**
     * This method returns the Base URI, based on the environment that the user wants to run on.
     */
    public static String getBaseURI(){
        /**
         * User passes the environment from the
         *  1. command line (ex: mvn test -Denv="QA" will run the tests on QA environment)
         *  2. hardcoded in pom.xml file
         *  <build>
                <plugins>
                    <plugin>
                            <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                         <version>2.19.1</version>
                         <configuration>
                            <suiteXmlFiles>
                                <suiteXmlFile>testng.xml</suiteXmlFile>
                            </suiteXmlFiles>
                            <systemPropertyVariables>
                         <env>prod</env>
                         </systemPropertyVariables>
                         </configuration>
                    </plugin>
                </plugins>
            </build>
         */
        String environment = System.getProperty("env").toUpperCase();
        String baseURI=null;
        if(environment.equalsIgnoreCase("QA")){
            baseURI=QA;
        }else if(environment.equalsIgnoreCase("PROD")){
            baseURI=PROD;
        }else if(environment.equalsIgnoreCase("STAGGING"))
            baseURI=STAGGING;
        return baseURI;
    }
}
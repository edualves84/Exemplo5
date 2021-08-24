package web;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        features = { "src/test/resources/features"},
        glue     =  {"web"},
        plugin   =  {"pretty",
                     "html:target/extentsreport",
                     "json:target/extentsreport.json",}

)

public class Runner {

}

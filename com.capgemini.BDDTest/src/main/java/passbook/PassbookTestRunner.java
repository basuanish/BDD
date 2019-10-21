package passbook;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="C:\\Users\\anibasu\\eclipse-workspace\\com.capgemini.BDDTest\\src\\main\\java\\passbook\\Passbook.feature"
,glue = "passbook")

public class PassbookTestRunner {

}

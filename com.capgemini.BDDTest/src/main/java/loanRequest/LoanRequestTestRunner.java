package loanRequest;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="C:\\Users\\anibasu\\eclipse-workspace\\com.capgemini.BDDTest\\src\\main\\java\\loanRequest\\LoanRequest.feature"
,glue = "loanRequest")

public class LoanRequestTestRunner {

}

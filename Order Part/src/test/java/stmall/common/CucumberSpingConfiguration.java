package stmall.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stmall.OrderPartApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrderPartApplication.class })
public class CucumberSpingConfiguration {}

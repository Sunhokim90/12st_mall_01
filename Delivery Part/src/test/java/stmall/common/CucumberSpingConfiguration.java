package stmall.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stmall.DeliveryPartApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryPartApplication.class })
public class CucumberSpingConfiguration {}

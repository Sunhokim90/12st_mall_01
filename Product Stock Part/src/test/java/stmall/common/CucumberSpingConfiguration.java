package stmall.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stmall.ProductStockPartApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { ProductStockPartApplication.class })
public class CucumberSpingConfiguration {}

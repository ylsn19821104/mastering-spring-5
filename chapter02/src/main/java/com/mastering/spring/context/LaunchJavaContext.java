package com.mastering.spring.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mastering.spring.beans.User;
import com.mastering.spring.business.BusinessService;

@Configuration
@ComponentScan(basePackages = {"com.mastering.spring"})
class SpringContext {
}

public class LaunchJavaContext {

    private static final User DUMMY_USER = new User("dummy");

    public static Logger logger = LoggerFactory.getLogger(LaunchJavaContext.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringContext.class);

        BusinessService service = context.getBean(BusinessService.class);
        logger.debug(service.calculateSum(DUMMY_USER) + "");
    }
}

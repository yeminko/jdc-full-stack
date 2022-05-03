package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanFactoryPostProcessors {

    private static final String CONFIG = "classpath:/post-processors.xml";

    @Test
    void test() {
        
        try(var context = new GenericXmlApplicationContext(CONFIG)) {

        }
    }
}

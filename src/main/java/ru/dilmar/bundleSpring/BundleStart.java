package ru.dilmar.bundleSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ru.dilmar.spring.bundleSpring")
public class BundleStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BundleStart.class);
        BundleBean bundleBean=(BundleBean) ctx.getBean("bundleBean");
        bundleBean.print();
    }
}

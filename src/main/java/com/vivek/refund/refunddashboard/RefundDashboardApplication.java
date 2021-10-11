package com.policybazaar.refund.refunddashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages ={"com.policybazaar.refund","com.policybazaar.refund.refunddashboard"})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
@EnableAspectJAutoProxy
public class RefundDashboardApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RefundDashboardApplication.class, args);
	}

}

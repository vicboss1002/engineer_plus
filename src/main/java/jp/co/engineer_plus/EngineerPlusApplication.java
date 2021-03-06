package jp.co.engineer_plus;


import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import jp.co.engineer_plus.servlet.filter.LoginFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * エントリポイントとなるクラス<br />
 * Spring bootアプリケーションで最初に呼び出されるmainメソッドを持つ
 */
@SpringBootApplication
public class EngineerPlusApplication {
//	private static Log logger = LogFactory.getLog(EngineerPlusApplication.class);
//	@Bean
//	protected ServletContextListener listener() {
//		return new ServletContextListener() {
//
//			@Override
//			public void contextInitialized(ServletContextEvent sce) {
//				logger.info("ServletContext initialized");
//			}
//
//			@Override
//			public void contextDestroyed(ServletContextEvent sce) {
//				logger.info("ServletContext destroyed");
//			}
//
//		};
//	}
    public static void main(String[] args) {
        SpringApplication.run(EngineerPlusApplication.class, args);
    }
	/**
	 * 文字エンコーディングのフィルターを返す
	 * @return フィルター
	 */
	@Bean
	public Filter characterEncodingFilter() {
		  CharacterEncodingFilter filter = new CharacterEncodingFilter();
		  filter.setEncoding("UTF-8");
		  filter.setForceEncoding(true);
		  return filter;
	}
	@Bean
	public FilterRegistrationBean filterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setDispatcherTypes(DispatcherType.REQUEST);
	    registration.addUrlPatterns("/business_plan");
	    registration.setFilter(new LoginFilter());
	    return registration;
	}
}

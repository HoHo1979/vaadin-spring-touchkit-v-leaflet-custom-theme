package org.vaadin.tkspring;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.server.VaadinServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public VaadinServlet vaadinServlet() {
        return new SpringAwareTouchKitServlet();
    }
    
    @Bean
    public NavigationManager navigationManager() {
    	return new NavigationManager();
    }

    // Stuff needed for widgetset CDN, not needed if using std widgetset.
    // Run priming build (mvn install) if (generated) resource is missing.
//    @Bean
//    public in.virit.WidgetSet viritinCdnInitializer() {
//        return new in.virit.WidgetSet();
//    }

}

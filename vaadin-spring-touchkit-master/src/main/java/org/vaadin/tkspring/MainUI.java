package org.vaadin.tkspring;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.tkspring.view.LoginView;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.TabBarView;

@Theme("mytheme")
@SpringUI
// If not using cdn.virit.in, uncomment following annotation and vaadin plugin
// from pom.xml
@Widgetset("AppWidgetset")
//@Widgetset("com.vaadin.touchkitsampler.gwt.TouchKitSamplerWidgetSet")
public class MainUI extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5405474605437828645L;

	NavigationManager navigationManager;

	LoginView loginView;
	
	@Autowired
	public MainUI(LoginView loginView,NavigationManager navigationManager) {
		this.loginView=loginView;
		this.navigationManager=navigationManager;
	}
	
    @Override
    protected void init(VaadinRequest request) {

//    	TabBarView tabBarView = new TabBarView();
//    	Tab tab=tabBarView.addTab(loginView,"Login");
//    	tab.setIcon(FontAwesome.PLUS_CIRCLE);
    	
        //NavigationManager navigationManager = new NavigationManager();
//        NavigationView view = new NavigationView("Hello TouchKit!");
//        final Switch aSwitch = new Switch("Yes no");
//
//        view.setContent(new MVerticalLayout(
//                new RichText(
//                        "Vaadin *TouchKit* with Vaadin *Spring* with Spring *Boot*."),
//                aSwitch,
//                new Button("Holaa!", e -> Notification.show("You touched it!"))
//        ));

    	 
        navigationManager.navigateTo(loginView);

        setContent(
              //tabBarView
        		navigationManager
        );
    }
}

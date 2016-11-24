package org.vaadin.tkspring.view;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.tkspring.datebase.MockUsers;
import org.vaadin.tkspring.datebase.Staff;

import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.NumberField;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;

@SpringComponent
@UIScope
public class LoginView extends NavigationView {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6582251608000551315L;

	
	EmailField username;
	NumberField password;

	@Autowired
	MockUsers userService;
	@Autowired
	NavigationManager navigationManager;
	@Autowired
	StaffCheckInView staffCheckInView;
	
	
	@PostConstruct
	public void init() {
		username = new EmailField("User Name");
		username.setValue("jamesho@gmail.com");
		username.setIcon(VaadinIcons.USER);
		username.addStyleName("username");
		password = new NumberField("Password");
		password.setValue("1025");
		password.setIcon(VaadinIcons.PASSWORD);
		Button loginButton = new Button("Login");
		loginButton.addClickListener(this::login);
		VerticalComponentGroup v1 = new VerticalComponentGroup();
		v1.addComponent(username);
		v1.addComponent(password);
		v1.addComponent(loginButton);
		setContent(v1);
	}
	
	
	public void login(Button.ClickEvent event) {
		String usernameString=username.getValue();
		String passwordString=password.getValue();
		Staff staff = new Staff();
		staff.setUsername(usernameString);
		staff.setPassword(passwordString);
		
		if(userService.findMatchUser(staff)) {
			Optional<Staff> staffOptional=userService.findUserByUserName(usernameString);
			if(staffOptional.isPresent()) {
				staff=staffOptional.get();
				navigationManager.navigateTo(staffCheckInView);
			}
		}
		
		
		
	}

}

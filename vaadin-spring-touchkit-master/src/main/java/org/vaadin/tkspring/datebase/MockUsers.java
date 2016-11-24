package org.vaadin.tkspring.datebase;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Scope;

import com.vaadin.spring.annotation.SpringComponent;


@SpringComponent
@Scope("singleton")
public class MockUsers {

	Set<Staff> staffs = new LinkedHashSet<Staff>(); 
	
	public MockUsers() {
		Staff staff = new Staff("1111@gmail.com","1111","James","Ho");
		Staff staff1 = new Staff("1112@gmail.com","1112","Jessica","Lin");
		Staff staff2 = new Staff("1113@gmail.com","1113","Danny","Ho");
		Staff staff3 = new Staff("1114@gmail.com","1114","Jerry","Lee");
		staffs.add(staff);
		staffs.add(staff1);
		staffs.add(staff2);
		staffs.add(staff3);
	}

	public Set<Staff> getStaffs() {
		return staffs;
	}
	
	public boolean findMatchUser(Staff staff) {
		
		return staffs.stream().filter(x->x.equals(staff))
			.findAny().isPresent();
	}

	public Optional<Staff> findUserByUserName(String username) {
		
		Optional<Staff> staffOptional;
		staffOptional=staffs.stream().filter(x->x.getUsername().equals(username))
					.findAny();
		
		return staffOptional;
	}

}

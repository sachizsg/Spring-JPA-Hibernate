package springjpahibernate.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springjpahibernate.model.Users;
import springjpahibernate.model.UsersContact;
import springjpahibernate.model.UsersLog;
import springjpahibernate.repository.UsersContactRepository;

@RestController
@RequestMapping("/rest/userscontact")
public class UsersContactResource {
	
	@Autowired
	UsersContactRepository userContractRepository;
	
	@GetMapping("/all")
	public List<UsersContact> getUserContact(){
		return userContractRepository.findAll();
		
	}
	
	@GetMapping("/update/{name}")
	public List<UsersContact> update(@PathVariable("name") String name) {
		UsersContact userContact = new UsersContact();
		Users users = new Users();
		
		UsersLog usersLog = new UsersLog();
		usersLog.setLog("Hi Youtube");
		
		UsersLog usersLog2 = new UsersLog();
		usersLog2.setLog("Hi Viewers");
		
		users.setTeamName("Development").setSalary(1000).setName(name).setUsersLogs(Arrays.asList(usersLog, usersLog2));;
		
		userContact.setPhoneNo(1111111).setUsers(users);
		
		userContractRepository.save(userContact);
		return userContractRepository.findAll();
		
	}

}

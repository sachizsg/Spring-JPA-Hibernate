package springjpahibernate.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springjpahibernate.model.Users;
import springjpahibernate.repository.UserRepository;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {
	
	@Autowired
	UserRepository userRepository;
	/**
	 * fetch all the data
	 * @return
	 */
	@GetMapping("/all")
	public List<Users> getAll(){
		return userRepository.findAll();
		
	}
	/**
	 * If it's a value return list
	 * @param name
	 * @return
	 */
	@GetMapping("/{name}")
	public List<Users> getUser(@PathVariable("name") final String name){
		return userRepository.findByName(name);
		
	}
	
	/**
	 * Retrieve data according to the id
	 * @param id
	 * @return data from user id
	 */
	@GetMapping("/id/{id}")
	public Users getUserById(@PathVariable Integer id) {
		return userRepository.findUsersById(id);
	}
	
	/**
	 * Update id and name
	 * @param id
	 * @param name
	 * @return
	 */
	@GetMapping("/update/{id}/{name}")
	public Users update(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		
		Users users = getUserById(id);
		users.setName(name);
		
		return userRepository.save(users);
		
	}

}

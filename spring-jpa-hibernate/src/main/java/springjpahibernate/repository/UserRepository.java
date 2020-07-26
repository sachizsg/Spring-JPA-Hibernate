package springjpahibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springjpahibernate.model.Users;

/**
 * Use to retrive data from databases using model
 * Model,PrimaryKey | Users, Integer
 */
public interface UserRepository extends JpaRepository<Users,Integer> {
	
	List<Users> findByName(String name);
	
	Users findUsersById(Integer id);
	
	
}

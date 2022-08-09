package com.miu.edu.batch_processing;

import com.miu.edu.batch_processing.entity.RoleType;
import com.miu.edu.batch_processing.entity.UserClass;
import com.miu.edu.batch_processing.repository.UserClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BatchProcessingDemoApplication implements CommandLineRunner {
	@Autowired
	private UserClassRepository userClassRepository;

	public static void main(String[] args) {
		SpringApplication.run(BatchProcessingDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
 load();
	}


	public void load(){
		Set<RoleType> set1= new HashSet<>();
		set1.add(RoleType.ADMIN);
		Set<RoleType> set2= new HashSet<>();
		set2.add(RoleType.ADMIN);
		Set<RoleType> set3= new HashSet<>();
		set3.add(RoleType.USER);
		List<UserClass> userClassList= Arrays.asList(new UserClass("Priya","Giri",set1),
				new UserClass("Prabhat","Gyawali",set2),
				new UserClass("Tirtha","Khanal",set3));

		for(int i=0;i<userClassList.size();i++){
          userClassRepository.save(userClassList.get(i));
		}
	}
}

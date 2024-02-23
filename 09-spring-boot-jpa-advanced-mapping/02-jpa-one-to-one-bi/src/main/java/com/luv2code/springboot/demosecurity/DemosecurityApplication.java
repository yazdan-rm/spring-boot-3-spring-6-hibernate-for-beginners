package com.luv2code.springboot.demosecurity;

import com.luv2code.springboot.demosecurity.dao.AppDAO;
import com.luv2code.springboot.demosecurity.entity.Instructor;
import com.luv2code.springboot.demosecurity.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemosecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemosecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{

//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		Long theId = 6L;
		System.out.println("Deleting instructor detail id: " +theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		Long theId = 2L;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instance detail
		System.out.println("TempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!");


	}

	private void deleteInstructor(AppDAO appDAO) {
		Long theId = 1L;

		System.out.println("Deleting instructor id : " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		System.out.println("Finding instructor id: 2");
		Instructor tempInstructor = appDAO.findInstructorById(2L);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only:" + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// create the Instructor
		Instructor tempInstructor =
				new Instructor("Yazdan", "RafieeManesh", "yrafieemanesh@gmail.com");

		// create the instructorDetail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"youtube",
						"Programming"
				);

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// NOTE: this will ALSO save the details object
		// because of CascadeTyp.All
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}


}

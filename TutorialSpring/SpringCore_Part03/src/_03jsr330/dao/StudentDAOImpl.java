package _03jsr330.dao;



import javax.inject.Named;

import _03jsr330.model.Student;

@Named
public class StudentDAOImpl implements StudentDAO {

	@Override
	public void insertStudent(Student student) {
		System.out.println("StudentDAOImpl#InsertStudent");
		
	}

	
}

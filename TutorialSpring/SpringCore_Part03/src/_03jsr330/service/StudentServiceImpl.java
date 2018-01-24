package _03jsr330.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import _03jsr330.dao.StudentDAO;
import _03jsr330.model.Student;

@Named(value="sService")
@Singleton
//Spring Beanleri varsayılan olarak Singleton'dur
public class StudentServiceImpl implements StudentService {
	
	//@Autowired yerine kullanabiliriz.
	@Inject
	private StudentDAO studentDAO;
	
	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("StudentServiceImpl#insertStudent");
		studentDAO.insertStudent(student);
	}

}

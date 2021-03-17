package labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentTest {
	@Test
	@Order(5) 
    public void testConstructor() {
		
		Student s = new Student("Robert Navarro");
		
		assertEquals(6, s.getId());
		assertEquals(0.0, s.getGPA());
		assertEquals(false, s.isHonorsStudent());
		assertEquals("Robert Navarro", s.getName());
    }

	@Test
	@Order(1) 
    public void testName() {

		Student s = new Student("Robert Navarro");
		assertEquals(1, s.getId());
		s.setName("Emily");
		assertEquals("Emily", s.getName());
    }
	
	@Test
	@Order(2) 
    public void testId() {
		Student s2 = new Student("Robert Navarro");
		assertEquals(2, s2.getId());
		Student s3 = new Student("Emily Navarro");
		assertEquals(3, s3.getId());
    }
	
	@Test
	@Order(4)
    public void testGPA() {
		Student s4 = new Student("Lee");
		assertEquals(0.0, s4.getGPA());
		s4.setGPA(4.0);
		assertEquals(4.0, s4.getGPA());
    }
	
	@Test
	@Order(3)
    public void testHonors() {
		Student s5 = new Student("Robert Navarro");
		assertEquals(false, s5.isHonorsStudent());
		s5.setGPA(4.0);
		assertEquals(true, s5.isHonorsStudent());
    }
}

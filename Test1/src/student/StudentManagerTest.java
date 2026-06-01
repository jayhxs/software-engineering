package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class StudentManagerTest {
	
	static StudentManager manager;

	@BeforeAll
	static void setUp() {
		manager = new StudentManager();
	}

	@Test
	@Order(1)
	void testAddStudent() {
		manager.addStudent("짱구");
		assertTrue(manager.hasStudent("짱구"));
	}

	@Test
	@Order(2)
	void testRemoveStudent() {
		manager.removeStudent("짱구");
		assertFalse(manager.hasStudent("짱구"));
	}

	@Test
	@Order(3)
	void testAddDuplicateStudent() {
		manager.addStudent("철수");
		assertThrows(IllegalArgumentException.class, () -> {
			manager.addStudent("철수");
		});
	}

	@Test
	@Order(4)
	void testRemoveNonExistingStudent() {
		assertThrows(IllegalArgumentException.class, () -> {
			manager.removeStudent("영희");
		});
	}

}
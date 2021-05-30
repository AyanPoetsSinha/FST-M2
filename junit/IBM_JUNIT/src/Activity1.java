import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Activity1 {

	// Test Fixture
	static ArrayList<String> list;

	//Arraylist invokation
	
	
	@BeforeEach
	
	void setUp() throws Exception{
		//Arraylist invokation
		list= new ArrayList<String> ();
	// Add values to the list
	list.add("alpha"); // at index 0
	list.add("beta"); // at index 1
	
	
	//checking the insert operation
	
	
	
	}
	@Test
	
	public void insertTest() {
		//Assertion for size
		assertEquals(2,list.size(),"Wrong Size");
		//Add new elements
		list.add(2,"charlie");
		//Assertion again for size
		assertEquals(3,list.size(),"Wrong Size");
		
        // Assert individual elements
		
        assertEquals("alpha", list.get(0), "Wrong element");	
        assertEquals("beta", list.get(1), "Wrong element");	
        assertEquals("charlie", list.get(2), "Wrong element");
		
	}
	
	@Test
	
	//Test Method to test the replace op
    public void replaceTest() {
		
        // Replace new element
	
        list.set(1, "charlie");
	
 
	
        // Assert size of list
	
        assertEquals(2, list.size(), "Wrong size");
	
        // Assert individual elements
	
        assertEquals("alpha", list.get(0), "Wrong element");
	
        assertEquals("charlie", list.get(1), "Wrong element");
	
    }
	
	}



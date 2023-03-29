package practice;

import org.testng.annotations.Test;

public class TestNgPrioritytest {
	@Test(priority = 3)
 public void create()
 {
	 System.out.println("create");
 }
	@Test(priority = 2)
 public void delete()
 {
	 System.out.println("delete");
 }
	@Test(invocationCount = 0)
 public void update()
 {
	 System.out.println("update");
 }
}

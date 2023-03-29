package practice;

import org.testng.annotations.Test;

public class TestNg_invocationtest {
	@Test(priority = 0,invocationCount = 1)
	public void create()
	{
		System.out.println("create");
}
	@Test(dependsOnMethods = "create")
	public void delete()
	{
		System.out.println("delete");
	}
	@Test(priority = 1)
		public void update()
		{
			System.out.println("update");//
		}}

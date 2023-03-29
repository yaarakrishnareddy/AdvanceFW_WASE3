package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependsModule {
@Test()
public void create()
{
	System.out.println("create");
	Assert.fail();
	
}
@Test(dependsOnMethods = "create")
public void delete()
{
	System.out.println("delete");
}
@Test()
public void update()
{
	System.out.println("update");
}
}

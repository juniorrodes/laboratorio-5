import controllers.LostCallsController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class LostCallsControllerTest { 

    LostCallsController lostCalls = new LostCallsController();

@Before
public void before() throws Exception {
    lostCalls.registerLostCall("40028922");
} 

@After
public void after() throws Exception {
    lostCalls.getLostCalls().clear();
} 

/** 
* 
* Method: registerLostCall(String number) 
* 
*/ 
@Test
public void testRegisterLostCall() throws Exception {
    String call = "0800642822";
    lostCalls.registerLostCall(call);
    Assert.assertEquals(call,lostCalls.getLostCalls().get(1));
}

/** 
* 
* Method: deleteCalls() 
* 
*/ 
@Test
public void testDeleteCalls() throws Exception {
    Assert.assertEquals(false,lostCalls.getLostCalls().isEmpty());
    lostCalls.deleteCalls();
    Assert.assertEquals(true,lostCalls.getLostCalls().isEmpty());
} 


} 

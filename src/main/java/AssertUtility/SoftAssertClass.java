package AssertUtility;

import org.testng.asserts.SoftAssert;
//used for Non-mandatory fields
public class SoftAssertClass{
    
    SoftAssert soft = new SoftAssert();
    
    public void softAssertusingboolean(String actvalue, String expvalue) {
        boolean value = actvalue.contains(expvalue);
        soft.assertTrue(value);
        soft.assertAll(); 
    }

    public void assertALL() {
        soft.assertAll(); 
    }
}

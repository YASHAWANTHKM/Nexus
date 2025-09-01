package AssertUtility;

import org.testng.Assert;

public class HardAssertClass {
	
	// Used for Mandatory Fields
	    
	    public void hardAssertforboolean(String expvalue, String actvalue) {
	        boolean value = expvalue.contains(actvalue);
	        Assert.assertTrue(value);
	    }
	}

	


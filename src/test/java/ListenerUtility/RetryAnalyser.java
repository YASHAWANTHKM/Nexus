package ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser {

	
	public class RetryAnalyserImple implements IRetryAnalyzer {
	int count=0;
	int limitcount=3;
		@Override
		public boolean retry(ITestResult result) {
			// TODO Auto-generated method stub
			if(count<limitcount)
			{
				count++;
				return true;
			}
			return false;
		}

	}
	}


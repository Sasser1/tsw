package testovi;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.logging.Logger;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AutoGumaTests.class,ParameterizedTests.class);
		Logger logger = Logger.getLogger(TestRunner.class.toString());
		
		for (Failure f : result.getFailures()) {
			logger.warning(f.toString());
		}
		
		logger.info("Vreme rada " + result.getRunTime());
		logger.info("Broj testova " + result.getRunCount());
		logger.info("Broj pada " + result.getFailureCount());
		logger.info("Broj dinamickih pada " + result.getAssumptionFailureCount());
		logger.info("Broj ignorisanih " + result.getIgnoreCount());
		logger.info("Broj uspesnih " + (result.getRunCount() - result.getFailureCount() - result.getIgnoreCount()));
		
		if (result.wasSuccessful())
			logger.info("Uspesno testiranje");
		else
			logger.info("Neuspesno testiranje");

	}

}

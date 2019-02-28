package org.com;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.fluentd.logger.FluentLogger;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);

	String[] loggingSource = new String[] {"OCID", "FA_DASHBOARD", "AKOYA_ACCESS"};
	
	String[] eventName = new String[] {"ONBOARDING_SUCCESS", "ONBOARDING_FAILURE", "TOKEN_RENEWAL_SUCCESS", 
			"TOKEN_RENEWAL_FAILURE", "AUTHENTICATION_TOKEN_EXPIRED"};
	
	String[] dashBoardEvent = new String[] {"REMOVED_ACCT_ACCESS", "CHANGED_DATA_ELEMENT"};
	
	String[] fintechId = new String[] {"INTUIT", "AGGR1", "AGGR2"};
	
	String[] fiId  = new String[] {"BOA", "FIDELITY", "WELLSFARGO"};
	
	String loggingSourceForIndex;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Ask for FluentD URL
//		System.out.println("Please enter Url For FluentD:");
//		String fluentdUrl = scan.next();
//		
//		//Ask for FluentD Port
//		System.out.println("Please enter PORT For FluentD:");
//		int port = scan.nextInt();
		
		//Ask for Number of Log Lines to create
		System.out.println("Please enter Number of log lines you want to create:");
		int logLines = 10;//scan.nextInt();
		 
//		if (logLines<=0) {
//			System.out.println("Log lines should be greater than "+0+" please re-enter:");
//			logLines = scan.nextInt();
//		}
//		if (logLines<=0) {
//			System.out.println("Application Stopped");
//			System.exit(0);
//		}
//		scan.close();
//		FluentLogger Logger = FluentLogger.getLogger("myapp", 
//					fluentdUrl, port);
		
			Main obj = new Main();
			for (int i = 0; i < logLines; i++) {
				//obj.doApplicationLogic(Logger);
				obj.writeLogs();
			}
			FluentLogger.closeAll();
							
		System.out.println("Generating Logs");	
		System.out.println("Completed");
		
	}

	
	
    public void doApplicationLogic(FluentLogger Logger) {
        
    	
    	Map<String, Object> data = new HashMap<String, Object>();
    	
    	switch (1) {
		case 1:
			data.put("level", "INFO");
		case 2:
			int fs_id = (int)(Math.random() * 10 + 1);
			
			data.put("fs_id ", "FS_"+fs_id);
		case 3:
			int tempIndex = (int)(Math.random() * loggingSource.length);
			loggingSourceForIndex = loggingSource[tempIndex];
			data.put("logging_source ", loggingSourceForIndex);
		case 4:
			if(!loggingSourceForIndex.isEmpty() && loggingSourceForIndex.equalsIgnoreCase("FA_DASHBOARD")) {
				tempIndex = (int)(Math.random() * dashBoardEvent.length);
				data.put("event_name ", dashBoardEvent[tempIndex]);
			}else {
				tempIndex = (int)(Math.random() * eventName.length );
				data.put("event_name ", eventName[tempIndex]);
			}
			
		case 5:
			tempIndex = (int)(Math.random() * fintechId.length );
			data.put("fintech_id ", fintechId[tempIndex]);
		case 6:
			tempIndex = (int)(Math.random() * fiId.length );
			data.put("fi_id ", fiId[tempIndex]);	
		case 7:
			
			int customerId = (int)(Math.random() * 500 + 1);
			data.put("customer_id ", customerId);	
			
		case 8:
			int reason_code = (int)(Math.random() * 5 + 1);
			data.put("reason_code ", reason_code);	
			
		}
        
        Logger.log("follow", data);
        
    }
    
 public void writeLogs() {
        
    	
    	Map<String, Object> data = new HashMap<String, Object>();
    	
    	switch (1) {
		case 1:
			data.put("level", "INFO");
		case 2:
			int fs_id = (int)(Math.random() * 10 + 1);
			
			data.put("fs_id ", "FS_"+fs_id);
		case 3:
			int tempIndex = (int)(Math.random() * loggingSource.length);
			loggingSourceForIndex = loggingSource[tempIndex];
			data.put("logging_source ", loggingSourceForIndex);
		case 4:
			if(!loggingSourceForIndex.isEmpty() && loggingSourceForIndex.equalsIgnoreCase("FA_DASHBOARD")) {
				tempIndex = (int)(Math.random() * dashBoardEvent.length);
				data.put("event_name ", dashBoardEvent[tempIndex]);
			}else {
				tempIndex = (int)(Math.random() * eventName.length );
				data.put("event_name ", eventName[tempIndex]);
			}
			
		case 5:
			tempIndex = (int)(Math.random() * fintechId.length );
			data.put("fintech_id ", fintechId[tempIndex]);
		case 6:
			tempIndex = (int)(Math.random() * fiId.length );
			data.put("fi_id ", fiId[tempIndex]);	
		case 7:
			
			int customerId = (int)(Math.random() * 500 + 1);
			data.put("customer_id ", customerId);	
			
		case 8:
			int reason_code = (int)(Math.random() * 5 + 1);
			data.put("reason_code ", reason_code);	
			
			
		}
        logger.error(new Exception("test"));
        logger.info(data);
        
    }
}

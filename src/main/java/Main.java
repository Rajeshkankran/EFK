import java.util.HashMap;
import java.util.Map;
import org.fluentd.logger.FluentLogger;

public class Main {

	public static void main(String[] args) {
		Main obj = new Main();
		obj.doApplicationLogic();
		FluentLogger.closeAll();
	}

	private static FluentLogger LOG = FluentLogger.getLogger("myapp", 
			"ec2-13-58-52-166.us-east-2.compute.amazonaws.com", 8080);

    public void doApplicationLogic() {
        // ...
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("from", "userA");
        data.put("to", "userB");
        LOG.log("follow", data);
       // LOG.log("hi", "hkey", "hvalue");
        // ...
    }
}

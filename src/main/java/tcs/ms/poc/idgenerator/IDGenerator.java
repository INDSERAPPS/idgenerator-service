package tcs.ms.poc.idgenerator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class IDGenerator {
	
	@RestController
	@RequestMapping("/getID")
	public class IDGeneratorController {

	    //private static Logger logger = LoggerFactory.getLogger(IDGeneratorController.class);

	    public IDGeneratorController() {
	    }
	    @RequestMapping(method = RequestMethod.GET)
	    public String getID() {
	    	String type="ad";
	        //logger.debug("creating ID for " + type);
	        return type + "123";
	    }
	}
}

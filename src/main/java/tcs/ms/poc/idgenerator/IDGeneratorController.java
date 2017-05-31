package tcs.ms.poc.idgenerator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.joda.time.Instant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/idgenerator/")
	public class IDGeneratorController {
	    @GetMapping(value="/getID")
	    public String getID(@RequestParam(value="type",required=true) String type) {
	        return type + "-" + createUniqueID();
	    }
	   
	private String createUniqueID()
	{
		try
		{
		long millitimeNow = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());
		String millitimeNowString = Long.toString(millitimeNow);
		String[] sArrayTimeNow = millitimeNowString.split("");
		StringBuilder sbUniqueID = new StringBuilder();
		
		System.out.println("Now time in milli - " + millitimeNowString);
		
		for (int i = 0; i < sArrayTimeNow.length ; i++) {
			System.out.println("Now time in milli part - " + i + " - " +  sArrayTimeNow[i]);
			sbUniqueID.append(getRandomMap(sArrayTimeNow[i]));
		   }
		
		return sbUniqueID.toString();
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
			throw ex;
		}
		}
	
	private String getRandomMap(String SeqID)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt(5) + 1;
		String seqIDMap="0";
		System.out.println("Random ID - " + randomNum);
		switch(SeqID){    
		case "0":    
			String[] sArray0 = new String[] {"J","g","k","G","T"}; 
			seqIDMap = sArray0[randomNum];
			break;
		case "1":      
			String[] sArray1 = new String[] {"Q","P","Y","Z","W"}; 
			seqIDMap = sArray1[randomNum];
			break;	
		case "2":    
			String[] sArray2 = new String[] {"V","c","b","K","v"}; 
			seqIDMap = sArray2[randomNum];
			break;
		case "3":      
			String[] sArray3 = new String[] {"n","U","4","z","r"}; 
			seqIDMap = sArray3[randomNum];
			break;
		case "4":    
			String[] sArray4 = new String[] {"w","H","p","s","M"}; 
			seqIDMap = sArray4[randomNum];
			break;
		case "5":      
			String[] sArray5 = new String[] {"X","d","j","5","u"}; 
			seqIDMap = sArray5[randomNum];
			break;	
		case "6":    
			String[] sArray6 = new String[] {"2","E","9","e","f"}; 
			seqIDMap = sArray6[randomNum];
			break;
		case "7":      
			String[] sArray7 = new String[] {"Y","S","F","q","3"}; 
			seqIDMap = sArray7[randomNum];
			break;
		case "8":      
			String[] sArray8 = new String[] {"a","x","7","h","8"}; 
			seqIDMap = sArray8[randomNum];
			break;
		case "9":      
			String[] sArray9 = new String[] {"t","m","6","R","N"}; 
			seqIDMap = sArray9[randomNum];
			break;
		}
		System.out.println("Sequence Map - " + seqIDMap);
		 return seqIDMap;
	}
	}

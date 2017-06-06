package tcs.ms.poc.idgenerator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class IDGeneratorController {
		
        @RequestMapping(value = "/")
        public String home() {
        	return "Okay!";
        }

	    @GetMapping(value="/ID")
	    public String getID(@RequestParam(value="type",required=true) String type) {
	    	System.out.println("API:/getID, type:" + type);
	    	if (type.trim().length()>1)
	    	{
		    	String[] sArrayUniqueX = new String[] {"A","B","C","D"}; 
		    	Random randX = new Random();
				int randomNumX = randX.nextInt(4);
				String UniqueX = sArrayUniqueX[randomNumX];
				//to-do change to check sum
		    	String[] sArrayUniqueY = new String[] {"2","3","4","5","6","7","8","9"}; 
		    	Random randY = new Random();
				int randomNumY = randY.nextInt(8);
				String UniqueY = sArrayUniqueY[randomNumY];
				type = type.substring(0, 2).toUpperCase();
				String sID = type + createUniqueID() + UniqueX + UniqueY;
				System.out.println("ID Generated:" + sID);
		        return type + createUniqueID() + UniqueX + UniqueY;
	    	}
	    	else
	    	{
	    		System.out.println("Error: Invalid length for type. Length of type should be 2.");
	    		return "Error: Invalid length for type. Length of type should be 2.";
	    	}
	    }
	   
	private String createUniqueID()
	{
		try
		{
		long millitimeNow = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());
		String millitimeNowString = Long.toString(millitimeNow);
		String[] sArrayTimeNow = millitimeNowString.split("");
		StringBuilder sbUniqueID = new StringBuilder();
		
		System.out.println("Time Now:" + millitimeNowString);
		System.out.print("ID Creation:");
		for (int i = 0; i < sArrayTimeNow.length ; i++) {
			System.out.print("Part:" + i + "-" +  sArrayTimeNow[i] + "{");
			sbUniqueID.append(getRandomMap(sArrayTimeNow[i]));
			System.out.print("},");
		   }
		System.out.println("");
		System.out.println("Key Generated:" + sbUniqueID.toString());
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
		try
		{
		Random rand = new Random();
		int randomNum = rand.nextInt(5);
		String seqIDMap="0";
		System.out.print("getRandomMap:{randomNum:" + randomNum);
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
		System.out.print(", seqIDMap:" + seqIDMap + "}");
		 return seqIDMap;
		}
		 catch (Exception ex)
			{
				System.out.println(ex.toString());
				throw ex;
			}
	}
	}

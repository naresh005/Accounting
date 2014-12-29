package demo.std.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.std.model.api.StdLoan;
import demo.std.model.api.StdLoanImpl;
import demo.std.model.api.StdRequestImpl;
import demo.std.repository.StdRequestRepository;
import demo.std.util.JsonUtil;

@Service
public class StdUIHandler {
	
	@Autowired private StdRequestRepository stdRequestRepository;
	@Autowired private StdService stdService;
	
	public void saveStdRequest(long stdid, HttpServletRequest request) throws IOException, JSONException{
		String jsonBody = IOUtils.toString(request.getInputStream());
		System.out.println("Json Body -"+jsonBody);
		JSONObject obj = new JSONObject(jsonBody);
		Object extendingDept = obj.get("extendingUnit");
		StdRequestImpl stdRequest = stdService.getStdRequest(stdid);
		stdRequest.setExtendingUnit(extendingDept.toString());
		
		//Saving Loans
		Map<Long, JSONObject> loanMap = new HashMap<>();
		JSONArray stdLoansArray = obj.getJSONArray("stdLoans");
		for(int i=0;i<stdLoansArray.length();i++){						
			JSONObject loanJson = stdLoansArray.getJSONObject(i);			
			loanMap.put(new Long((Integer)loanJson.get("loanId")), loanJson);
		}		
		Set<StdLoan> stdLoans = stdRequest.getStdLoans();		
		for (StdLoan stdLoan : stdLoans) {
			StdLoanImpl loanImpl = (StdLoanImpl)stdLoan;
			JSONObject loanJsonObject = loanMap.get(loanImpl.getLoanId());
			if(loanJsonObject!=null && loanJsonObject.has("netOsuc")){
				loanImpl.setNetOsuc(loanJsonObject.getDouble("netOsuc"));
			}
			loanMap.remove(loanImpl.getLoanId());			
		}
		
		for(Entry<Long, JSONObject> entry: loanMap.entrySet()){
			JSONObject toBeCreated = entry.getValue();
			StdLoanImpl loanImpl = new StdLoanImpl();
			loanImpl.setNetOsuc(toBeCreated.getDouble("netOsuc"));
			stdRequest.getStdLoans().add(loanImpl);
		}
		
		
		stdService.saveStdRequest(stdRequest);
	}
	
	public void printJsonElementNames(long stdid, HttpServletRequest request) throws IOException, JSONException{
		String jsonBody = IOUtils.toString(request.getInputStream());
		System.out.println("Json Body -"+jsonBody);
		JSONObject obj = new JSONObject(jsonBody);
		JsonUtil.print(obj);
		
		Map<String, Object> map = JsonUtil.getKeyValueMap("stdLoans", obj);
		
		for(Entry<String, Object> entry: map.entrySet()){
			System.out.println("entry - "+entry.getKey() + "-"+ entry.getValue());
		}
	}


}

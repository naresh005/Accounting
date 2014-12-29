package demo.std.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.std.model.api.StdRequestImpl;
import demo.std.service.StdService;
import demo.std.service.StdUIHandler;

@Controller
public class StdController {
	
	@Autowired private StdService stdService;
	@Autowired private StdUIHandler stdUIHandler;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String createStdRequests(){
		stdService.createAndSaveStdRequest();
		return "create/success";		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String updateStdRequest(@RequestParam("stdid") long stdid){
		stdService.updateStdRequest(stdid);
		return "update/success";		
		
	}
	
	@RequestMapping(value="/updateED", method=RequestMethod.POST)
	public @ResponseBody String updateStdRequestEU(@RequestParam("stdid") long stdid, HttpServletRequest request) throws IOException, JSONException{		
		stdUIHandler.saveStdRequest(stdid, request);
		return "update/success";		
	}
	
	@RequestMapping(value="/printJson", method=RequestMethod.POST)
	public @ResponseBody String printJson(@RequestParam("stdid") long stdid, HttpServletRequest request) throws IOException, JSONException{		
		stdUIHandler.printJsonElementNames(stdid, request);
		return "update/success";		
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public @ResponseBody StdRequestImpl getStdRequest(@RequestParam("stdid") long stdid){
		
		return stdService.getStdRequest(stdid);
		
		
	}

}

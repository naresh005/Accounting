package demo.std.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.std.model.api.StdRequestImpl;
import demo.std.service.StdService;

@Controller
public class StdController {
	
	@Autowired private StdService StdService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String createStdRequests(){
		StdService.createAndSaveStdRequest();
		return "create/success";
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String updateStdRequest(@RequestParam("stdid") long stdid){
		StdService.updateStdRequest(stdid);
		return "update/success";
		
		
	}
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public @ResponseBody StdRequestImpl getStdRequest(@RequestParam("stdid") long stdid){
		
		return StdService.getStdRequest(stdid);
		
		
	}

}

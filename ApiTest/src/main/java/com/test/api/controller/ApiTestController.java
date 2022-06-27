package com.test.api.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.api.common.Cfr;
import com.test.api.common.CfrFace;
import com.test.api.common.Ocr;
import com.test.api.common.Speech;
import com.test.api.common.TextTrans;

@Controller
@RequestMapping("/api")
public class ApiTestController {

	@GetMapping("/text")
	public String testTest() {
		return "textTranslation";
	}
	
	@PostMapping("/trans")
	@ResponseBody
	public Map<String,String> trans(@RequestBody Map<String,String> map){
		String text= map.get("text");
		String trans = new TextTrans().textTrans(text);
		
		Map<String,String> res = new HashMap<String,String>();
		res.put("data", trans);
		
		return res;
	}
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping("/ocr")
	public String ocrTest(Model model) throws IOException {
		System.out.println(resourceLoader.getResource("classpath:static").getURI());
		System.out.println(Path.of(resourceLoader.getResource("classpath:static").getURI()));
		
		String path = Path.of(resourceLoader.getResource("classpath:static").getURI()).toString();
		
		String res = new Ocr().ocrTest(path);
		
		model.addAttribute("res",res);
		
		return "ocrRes";
	}
	
	@GetMapping("/cfr")
	public String cfrTest(Model model) throws IOException {
		String path = Path.of(resourceLoader.getResource("classpath:static").getURI()).toString();
		
		Cfr cfr = new Cfr();
		String res = cfr.cfrTest(path);
		
		model.addAttribute("res",res);
				
		return "cfrRes";
	}
	
	@GetMapping("/cfr2")
	public String cfrFace(Model model) throws IOException {
		String path = Path.of(resourceLoader.getResource("classpath:static").getURI()).toString();
		
		CfrFace cfr = new CfrFace();
		String res = cfr.face(path);
		
		model.addAttribute("face",res);
		
		//json형태로 형변환해서 json 형태를 저장해서 보내준다
		//JSONObject obj = new JSONObject(res);
//		model.addAttribute("jsonRes",obj);
		return "cfrRes2";
	}
	
	@GetMapping("/speech")
	public String speechTest(Model model) throws IOException {
		String path = Path.of(resourceLoader.getResource("classpath:static").getURI()).toString();
		
		Speech sp = new Speech();
		String res = sp.speechTest(path);
		
		model.addAttribute("res",res);
		
		return "speechRes";
	}
}

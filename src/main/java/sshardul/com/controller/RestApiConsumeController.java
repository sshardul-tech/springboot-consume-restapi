package sshardul.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestApiConsumeController {
	
	//@Value("${gorest.url}")
	//private String url;

	private RestTemplate restTemplate = new RestTemplate();
	ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/get")
	public List<String> getDetails() throws JsonMappingException, JsonProcessingException {
		List<String> lst = new ArrayList<>();
		String object = restTemplate.getForObject("https://gorest.co.in/public-api/users", String.class);
		JsonNode data = mapper.readTree(object).findValue("data");
		data.forEach( d -> {
			lst.add("id::"+d.findValue("id").asInt()+" name::"+d.findValue("name").asText()+" gender::"+d.findValue("gender").asText());
		});    
		return lst;
	}
	
}

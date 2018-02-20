package com.kgisl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SpringMVCController {
@RequestMapping(method = RequestMethod.GET)
public String greeting(ModelMap map){
map.addAttribute("greetMessage", "Hello!!! Learn From Examples!!!! LFX!!!");
return "Welcome";
}
}
package study.hry.spring.springvelocity.jstree;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import study.hry.spring.springvelocity.support.Customer;

@Controller
public class TreeController {
	
	public TreeController(){
		System.out.println("TreeController init");
	}
	
	/**
	 * http://localhost/springvelocity/mvc/tree?id=%23
	 * 
	 * @param idStr
	 * @return
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String saveCustomerPage(@RequestParam(value="id") String idStr) {
		int id = "#".equals(idStr) ? 1 :Integer.parseInt(idStr);
		System.out.println("id=" + id);
		String first = "[{\"id\":1,\"text\":\"Root node\",\"children\":[{\"id\":2,\"text\":\"Child node 1\",\"children\":true},{\"id\":3,\"text\":\"Child node 2\",\"children\":true}]}]";
		String id2 = "[\"Child node 3\",\"Child node 4\"]";
		String id3 = "[{\"id\":51,\"text\":\"Child node 51\",\"children\":[],\"icon\":\"jstree-folder\"},{\"id\":52,\"text\":\"Child node 52\"}]"; 
		 
		String rtn = "";
		switch(id){
		case 1 : rtn = first; break;
		case 2 : rtn = id2; break;
		case 3 : rtn = id3; break;
		}
		return rtn;
	}
} 

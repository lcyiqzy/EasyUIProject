package osbel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import osbel.bean.TCellPhone;
import osbel.service.TCellPhoneService;

import com.github.pagehelper.Page;

@Controller
public class CRUDController {

	@Autowired
	TCellPhoneService cellPhoneService;

	@ResponseBody
	@RequestMapping("/getPageInfo")
	public Map<String, Object> getPageInfo(@RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize) {

		List<TCellPhone> list = cellPhoneService.getTCellPhoneList(pageNum,
				pageSize);

		Page<TCellPhone> page = (Page<TCellPhone>) list;

		// 获取总记录数
		long total = page.getTotal();

		// 创建Map对象用来存放响应数据
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("total", total);
		jsonMap.put("rows", list);

		return jsonMap;
	}

	@RequestMapping("/savePhone")
	public void savePhone(TCellPhone phone) {

		cellPhoneService.savePhone(phone);

	}

	@ResponseBody
	@RequestMapping("/delPhone/{phoneId}")
	public String delPhone(@PathVariable("phoneId") String phoneId) {

		String[] split = phoneId.split(",");

		if (split.length > 0) {
			for (String string : split) {
				int i = Integer.parseInt(string);

				cellPhoneService.delPhone(i);
			}
			return "删除成功";
		} else {

			return "删除时出现异常";
		}

	}
	
	@RequestMapping("/editPhone")
	public void editPhone(TCellPhone phone){
		
		cellPhoneService.updatePhone(phone);
		
	}

}

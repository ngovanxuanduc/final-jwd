package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.training.models.DemoModel;
import fa.training.repositories.DemoRepository;

@Controller
public class DemoController {
	
	@Autowired
	private DemoRepository repo;
	
	@GetMapping("/")
	public String getDemo() {
//		repo.save(DemoModel.builder().name("name-1").build());
//		repo.save(DemoModel.builder().name("name-2").build());
//		repo.save(DemoModel.builder().name("name-3").build());
		return "index";
	}
	
	@GetMapping("/pa")
	@ResponseBody
	public String getPa() {
		Pageable page = PageRequest.of(1, 1, Sort.by("name"));
		Page<DemoModel> res =  repo.findAll(page);
		res.getContent().forEach(System.out::println);
		return "hehe";
	}
	
	@GetMapping("/hehe")
	@ResponseBody
	public List getList() {
		
		return repo.findAll();
	}
}

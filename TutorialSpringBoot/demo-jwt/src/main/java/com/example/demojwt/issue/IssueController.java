package com.example.demojwt.issue;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@RestController
@RequestMapping("/issues")
@AllArgsConstructor
public class IssueController {

	private final IssueService issueService;

	@GetMapping
	public List<Issue> getAll(){
		return issueService.getAll();
	}

	@GetMapping("/{id}")
	public Issue getIssue(@PathVariable Long id){
		return issueService.findById(id);
	}

	@PostMapping
	public boolean save(@RequestBody Issue issue){
		return issueService.save(issue);
	}

	@PutMapping("/{id}")
	public boolean edit(@PathVariable Long id, @RequestBody Issue issue){
		return  issueService.edit(id, issue);
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable Long id){
	return issueService.deleteById(id);
	}
}

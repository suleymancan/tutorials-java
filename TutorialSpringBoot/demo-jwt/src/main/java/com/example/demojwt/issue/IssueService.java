package com.example.demojwt.issue;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
public class IssueService {

	private final IssueRepository issueRepository;


	boolean save(Issue issue){
		try {
			issueRepository.save(issue);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	List<Issue> getAll(){
		return (List<Issue>) issueRepository.findAll();
	}

	Issue findById(Long id){
		final Optional<Issue> byId = issueRepository.findById(id);
		return byId.orElseThrow(IllegalArgumentException::new);
	}

	boolean deleteById(Long id){
		try {
			issueRepository.deleteById(id);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	 boolean edit(Long id, Issue editIssue){
		try {
			final Issue issue = findById(id);
			issue.setName(editIssue.getName());
			save(issue);
			return true;
		}
		catch (Exception e){
			return false;
		}



	}

}

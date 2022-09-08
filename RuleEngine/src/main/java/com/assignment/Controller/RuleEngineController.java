package com.assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.RuleEngine.Rule;
import com.assignment.RuleEngine.RuleNamespace;
//import com.assignment.rule.InferenceEngine;
import com.assignment.rule.RuleEngine;
import com.assignment.ruleimpl.loan.Loan;
import com.assignment.ruleimpl.loan.LoanInference;
import com.assignment.ruleimpl.loan.User;
import com.assignment.service.RuleService;
import com.google.common.base.Enums;

@RestController
public class RuleEngineController {
	@Autowired
    private RuleService Service;
    @Autowired
    private RuleEngine ruleEngine;
    @Autowired
    private LoanInference loanInferenceEngine;
    
    @GetMapping(value = "/get-all-rules")
    public List<Rule> getAllRules() {
        List<Rule> allRules = Service.getAllRules();
        return allRules;
    }

    @GetMapping(value = "/get-all-rules/{ruleNamespace}")
    public ResponseEntity<?> getRulesByNamespace(@PathVariable("ruleNamespace") String ruleNamespace) {
        RuleNamespace namespace = Enums.getIfPresent(RuleNamespace.class, ruleNamespace.toUpperCase()).or(RuleNamespace.DEFAULT);
        List<Rule> allRules = Service.getAllRuleByNamespace(namespace.toString());
        return ResponseEntity.ok(allRules);
    }
    @PostMapping(value = "/loan")
    public ResponseEntity<?> postUserLoanDetails(@RequestBody User user) {
        Loan result = (Loan) ruleEngine.run(loanInferenceEngine, user);
        return ResponseEntity.ok(result);
    }
}
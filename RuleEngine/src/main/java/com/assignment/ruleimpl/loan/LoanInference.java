package com.assignment.ruleimpl.loan;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.assignment.RuleEngine.RuleNamespace;
import com.assignment.rule.InferenceEngine;

//@Slf4j
@Service

public class LoanInference extends InferenceEngine<User, Loan> {

    @Override
    protected RuleNamespace getRuleNamespace() {
        return RuleNamespace.LOAN;
    }

    @Override
    protected Loan initializeOutputResult() {
        return Loan.builder().build();
    }

}

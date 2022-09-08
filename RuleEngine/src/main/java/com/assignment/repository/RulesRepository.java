package com.assignment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignemnt.Entity.RuleDbModel;

import java.util.List;

@Repository
public interface RulesRepository extends JpaRepository<RuleDbModel, Long> {
    List<RuleDbModel> findByRuleNamespace(String ruleNamespace);
    List<RuleDbModel> findAll(); 

}

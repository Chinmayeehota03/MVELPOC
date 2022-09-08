package com.assignment.ruleimpl.loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
	String firstName;
    String lastName;
    Integer age;
    Long accountNumber;
    Double monthlySalary;
    String bank;
    Integer cibilScore;
    Double requestedLoanAmount;

}

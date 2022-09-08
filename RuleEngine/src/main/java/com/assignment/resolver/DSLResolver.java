package com.assignment.resolver;

public interface DSLResolver {
	String getResolverKeyword();
    Object resolveValue(String keyword);

}

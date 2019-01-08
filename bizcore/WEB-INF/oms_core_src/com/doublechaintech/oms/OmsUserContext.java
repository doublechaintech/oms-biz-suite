package com.doublechaintech.oms;

public interface OmsUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(OmsChecker checker);
	OmsChecker getChecker();
}


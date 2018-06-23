package com.pro.business;

import com.pro.model.promodelclass;

public class probusinessclass 
{
public boolean adminvalidate(promodelclass modelobj)

{
	boolean adminresult1 = false;
	boolean adminresult2 = false;
	
	
	if (modelobj.getPassword().equals(modelobj.getConfirmPassword()) )
	{adminresult1 = true;
		if (modelobj.getDeptCode().equalsIgnoreCase("ADMIN"))
		{
			adminresult2 = true;
			return adminresult2;
		}
		else return adminresult2 = false;
		}
	else return adminresult2= false;
		
	
	}
}



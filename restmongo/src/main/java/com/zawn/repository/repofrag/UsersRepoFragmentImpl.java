package com.zawn.repository.repofrag;

import java.util.ArrayList;
import java.util.List;

import com.zawn.domain.Users;

public class UsersRepoFragmentImpl implements UsersRepoFragment{
	@Override
	public List<Users> findAllHavingBalBellowZero(){
		ArrayList<Users> found=new ArrayList<>();
		return found; 
	}

}

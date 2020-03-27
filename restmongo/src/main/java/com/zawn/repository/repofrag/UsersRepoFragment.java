package com.zawn.repository.repofrag;

import java.util.List;

import com.zawn.domain.Users;

public interface UsersRepoFragment {

	List<Users> findAllHavingBalBellowZero();

}

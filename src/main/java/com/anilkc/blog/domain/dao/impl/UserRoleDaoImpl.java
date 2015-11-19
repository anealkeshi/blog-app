package com.anilkc.blog.domain.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.dao.UserRoleDao;
import com.anilkc.blog.exception.UserRoleException;

@Repository("userRoleDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole, Long>implements UserRoleDao {

	@Override
	public UserRole getUserRoleByRoleName(String roleName) throws UserRoleException {
			Query query = currentSession().createQuery("SELECT u from UserRole u where u.role=:roleName");
			query.setParameter("roleName", roleName);
			
			List<UserRole> roles = query.list();
			
			if(roles == null || roles.isEmpty()){
				throw new UserRoleException("UserRole not found with roleName: " + roleName);
			}
			return roles.get(0);
		}

}

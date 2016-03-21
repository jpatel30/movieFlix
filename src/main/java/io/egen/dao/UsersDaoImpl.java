package io.egen.dao;


import io.egen.entity.Users;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Users findUserById(String id) {
		Users user = em.find(Users.class, id);
		return user;
	}

	@Override
	public Users findUserByEmailId(String email) {
		TypedQuery<Users> qlString = em.createNamedQuery(
				"Users.findUserByEmailId", Users.class).setParameter("email",
						email);
		List<Users> user = qlString.getResultList();
		if (user.size() == 1 && user != null) {
			return user.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Users createUser(Users users) {
		 em.persist(users);
		 return users;
	}

	@Override
	public List<Users> findAllUsers() {
		String qlString = "SELECT u FROM Users u ORDER BY u.id ASC";
		List<Users> Users = em.createQuery(qlString, Users.class)
				.getResultList();
		return Users;

	}

	@Override
	public Users findUserByEmailIdAndPassword(String email, String password) {
		TypedQuery<Users> qlString = em.createNamedQuery(
				"Users.findUserByEmailAndPassword", Users.class).setParameter("email",
						email).setParameter("Password", password);
		List<Users> user = qlString.getResultList();
		if (user.size() == 1 && user != null) {
			return user.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Users updateUser(Users user) {
		
		return em.merge(user);
	}

	@Override
	public void deleteUser(Users user) {
		em.remove(user);

	}

}

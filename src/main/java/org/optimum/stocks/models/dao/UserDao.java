package org.optimum.stocks.models.dao;

import javax.transaction.Transactional;

import org.optimum.stocks.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUserName(String userName);

    User findByUid(int uid);

}

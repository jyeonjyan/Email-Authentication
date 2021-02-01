package com.server.EmailAuthentication.repository;

import com.server.EmailAuthentication.domain.Member;
import org.springframework.data.repository.CrudRepository;

//CrudRepository를 사용해 기본적인 DB모델을 찾을 수 있다.
public interface UserRepo extends CrudRepository<Member, Long> {
    Member findByUsername(String username);
}

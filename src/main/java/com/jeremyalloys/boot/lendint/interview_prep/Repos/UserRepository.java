package com.jeremyalloys.boot.lendint.interview_prep.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeremyalloys.boot.lendint.interview_prep.Models.User;

// Used this as an utility class mostly. I haven't yet really learnt what
// I can control with this interface
// TODO: Read docs on Repos

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}

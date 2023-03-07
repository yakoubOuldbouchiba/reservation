package com.yakoub.demo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepositroy extends CrudRepository<Guest , Long> {
}

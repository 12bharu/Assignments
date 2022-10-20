package com.valtech.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.valtech.tx.entity.Tx;
@Repository
public interface TxRepo extends JpaRepository<Tx, Long>{

}

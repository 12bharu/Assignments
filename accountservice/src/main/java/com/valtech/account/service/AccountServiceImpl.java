package com.valtech.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.account.entity.Account;
import com.valtech.account.repo.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
    private AccountRepo accountRepo;
	
	
    
    
    /* (non-Javadoc)
	 * @see com.valtech.account.service.AccountService#createAccount(com.valtech.account.entity.Account)
	 */
    public Account createAccount(Account acc){
        return accountRepo.save(acc);
        
    }
    
    
    /* (non-Javadoc)
	 * @see com.valtech.account.service.AccountService#updateAccount(com.valtech.account.entity.Account)
	 */
    public Account updateAccount(Account acc){
        return accountRepo.save(acc);
        
    }
    
    /* (non-Javadoc)
	 * @see com.valtech.account.service.AccountService#getAccount(long)
	 */
    public Account getAccount(long id){
        return accountRepo.findById(id).get();
        
    }
    
    /* (non-Javadoc)
	 * @see com.valtech.account.service.AccountService#getAllAccount()
	 */
    public List<Account> getAllAccount(){
        return accountRepo.findAll();
        
    }
    @Override
    public Account createSavingAccount(double balance) {
        
        Account acc=new Account("SA",balance);
        return acc;



   }



   @Override
    public Account createCurrentAccount(double balance) {
        
        Account acc=new Account("CA",balance);
        return acc;
    }
}

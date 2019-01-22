package com.codecentric.retailbank.service;

import com.codecentric.retailbank.model.domain.Bank;
import com.codecentric.retailbank.repository.BankAccountRepository;
import com.codecentric.retailbank.repository.BankRepository;
import com.codecentric.retailbank.repository.BranchRepository;
import com.codecentric.retailbank.repository.CustomerRepository;
import com.codecentric.retailbank.repository.TransactionRepository;
import com.codecentric.retailbank.repository.helpers.ListPage;
import com.codecentric.retailbank.service.interfaces.IBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankService implements IBankService {

    //region FIELDS
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    //endregion

    //region REPOSITORIES
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BankRepository bankRepository;
    //endregion


    //region READ
    @Override public Bank getById(Long id) {
        Bank bank = bankRepository.single(id);
        return bank;
    }

    @Override public Bank getByDetails(String details) {
        Bank bank = bankRepository.singleByDetails(details);
        return bank;
    }

    @Override public List<Bank> getAllBanks() {
        List<Bank> banks = bankRepository.all();
        return banks;
    }

    @Override public ListPage<Bank> getAllBanksByPage(int pageIndex, int pageSize) {
        ListPage<Bank> banks = bankRepository.allRange(pageIndex, pageSize);
        return banks;
    }
    //endregion

    //region WRITE
    @Override public Bank addBank(Bank bank) {
        Bank result = bankRepository.add(bank);
        return result;
    }

    @Override public Bank updateBank(Bank bank) {
        Bank result = bankRepository.update(bank);
        return result;
    }
    //endregion

    //region DELETE
    @Override public void deleteBank(Bank bank) {
//        // Recursively find and delete any FK constraints that this bank has
//        branchRepository.findByBank(bank).forEach(branch -> {
//            customerRepository.findByBranch(branch).forEach(customer -> {
//                bankAccountRepository.findByCustomer(customer).forEach(bankAccount -> {
//                    transactionRepository.findByAccount(bankAccount).forEach(transaction -> {
//                        transactionRepository.delete(transaction);
//                    });
//                    bankAccountRepository.delete(bankAccount);
//                });
//                customerRepository.delete(customer);
//            });
//            branchRepository.delete(branch);
//        });

        // Delete the actual bank
        bankRepository.delete(bank);
    }

    @Override public void deleteBank(Long id) {
        // Get the bank with this id
        Bank bank = bankRepository.single(id);

//        // Recursively find and delete any FK constraints that this bank has
//        branchRepository.findByBank(bank).forEach(branch -> {
//            customerRepository.findByBranch(branch).forEach(customer -> {
//                bankAccountRepository.findByCustomer(customer).forEach(bankAccount -> {
//                    transactionRepository.findByAccount(bankAccount).forEach(transaction -> {
//                        transactionRepository.delete(transaction);
//                    });
//                    bankAccountRepository.delete(bankAccount);
//                });
//                customerRepository.delete(customer);
//            });
//            branchRepository.delete(branch);
//        });

        // Delete the actual bank
        bankRepository.delete(bank);
    }
    //endregion
}

package com.codecentric.retailbank.service;

import com.codecentric.retailbank.model.domain.Branch;
import com.codecentric.retailbank.repository.SpringData.BranchRepository;
import com.codecentric.retailbank.service.interfaces.IBranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BranchService implements IBranchService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BranchRepository branchRepository;


    public BranchService() {
        super();
    }


    @Override
    public Branch getById(Long id) {
        Branch branch = branchRepository.findById(id).get();
        return branch;
    }

    @Override
    public Branch getByDetails(String details) {
        Branch branch = branchRepository.findByDetails(details);
        return branch;
    }

    @Override
    public List<Branch> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches;
    }

    @Override
    public Page<Branch> getAllBranchesByPage(Integer pageIndex, int pageSize) {
        Pageable page = new PageRequest(pageIndex, pageSize);
        Page<Branch> branches = branchRepository.findAll(page);
        return branches;
    }

    @Override
    public Branch addBranch(Branch branch) {
        Branch result = branchRepository.save(branch);
        return result;
    }

    @Override
    public Branch updateBranch(Branch branch) {
        Branch result = branchRepository.save(branch);
        return result;
    }

    @Override
    public void deleteBranch(Branch branch) {
        branchRepository.delete(branch);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}

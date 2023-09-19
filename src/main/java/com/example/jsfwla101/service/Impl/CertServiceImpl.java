package com.example.jsfwla101.service.Impl;

import com.example.jsfwla101.entity.Cert;
import com.example.jsfwla101.repository.CertRepository;
import com.example.jsfwla101.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CertServiceImpl implements CertService {
    @Autowired
    CertRepository certRepository;

    @Override
    @Transactional
    public List<Cert> findAll() {
        return certRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Cert post) {
        certRepository.save(post);
    }

    @Override
    @Transactional
    public void update(Cert post) {
        certRepository.save(post);
    }

    @Override
    @Transactional
    public Cert getById(String id) {
        Optional<Cert> postOptional=certRepository.findById(id);
        if (postOptional.isPresent()){
            Cert userGet=postOptional.get();
            return userGet;
        }else {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        certRepository.deleteById(id);
    }
}

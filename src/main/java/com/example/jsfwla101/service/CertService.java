package com.example.jsfwla101.service;

import com.example.jsfwla101.entity.Cert;

import java.util.List;

public interface CertService {
    List<Cert> findAll();

    void save(Cert cert);

    void update(Cert cert);

    Cert getById(String id);

    void deleteById(String id);
}

package com.example.jsfwla101.repository;

import com.example.jsfwla101.entity.Cert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertRepository extends JpaRepository<Cert,String> {
}

package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    /*
    管理者情報を挿入する

    @param Administrator administrator
     */
    public void insert(Administrator administrator) {
        administratorRepository.insert(administrator);
    }

    /*
    ログイン処理を行う

    @param String mailAddress, String password
    @return 取得した管理者情報
     */
    public Administrator login(String mailAddress, String password) {
        Administrator administrator = administratorRepository.findByMailAddressAndPassword(mailAddress, password);

        return administrator;
    }
}

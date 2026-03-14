package com.example.ktp.service;

import com.example.ktp.entity.Ktp;
import java.util.List;

public interface KtpService {
    Ktp saveKtp(Ktp ktp);

    List<Ktp> getAllKtp();

    Ktp getKtpById(Integer id);

    Ktp updateKtp(Integer id, Ktp ktp);

    void deleteKtp(Integer id);
}

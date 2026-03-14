package com.example.ktp.impl;

import com.example.ktp.entity.Ktp;
import com.example.ktp.repository.KtpRepository;
import com.example.ktp.service.KtpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {
    private final KtpRepository ktpRepository;

    public KtpServiceImpl(KtpRepository ktpRepository) {
        this.ktpRepository = ktpRepository;
    }

    @Override
    public Ktp saveKtp(Ktp ktp) {
        return ktpRepository.save(ktp);
    }

    @Override
    public List<Ktp> getAllKtp() {
        return ktpRepository.findAll();
    }

    @Override
    public Ktp getKtpById(Integer id) {
        return ktpRepository.findById(id).orElse(null);
    }

    @Override
    public Ktp updateKtp(Integer id, Ktp ktp) {
        Ktp existing = ktpRepository.findById(id).orElse(null);

        if(existing != null){
            existing.setNomorKtp(ktp.getNomorKtp());
            existing.setNamaLengkap(ktp.getNamaLengkap());
            existing.setAlamat(ktp.getAlamat());
            existing.setTanggalLahir(ktp.getTanggalLahir());
            existing.setJenisKelamin(ktp.getJenisKelamin());

            return ktpRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteKtp(Integer id) {
        ktpRepository.deleteById(id);
    }
}

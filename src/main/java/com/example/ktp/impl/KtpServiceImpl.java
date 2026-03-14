package com.example.ktp.impl;

import com.example.ktp.dto.KtpRequest;
import com.example.ktp.dto.KtpResponse;
import com.example.ktp.entity.Ktp;
import com.example.ktp.mapper.KtpMapper;
import com.example.ktp.repository.KtpRepository;
import com.example.ktp.service.KtpService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {
    private final KtpRepository ktpRepository;

    public KtpServiceImpl(KtpRepository ktpRepository) {
        this.ktpRepository = ktpRepository;
    }

    @Override
    public KtpResponse create(KtpRequest request) {

        Ktp ktp = KtpMapper.toEntity(request);
        Ktp saved = ktpRepository.save(ktp);

        return KtpMapper.toResponse(saved);
    }

    @Override
    public List<KtpResponse> getAll() {

        return ktpRepository.findAll()
                .stream()
                .map(KtpMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public KtpResponse getById(Long id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        return KtpMapper.toResponse(ktp);
    }

    @Override
    public KtpResponse update(Long id, KtpRequest request) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());
        ktp.setAlamat(request.getAlamat());

        Ktp updated = ktpRepository.save(ktp);

        return KtpMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {

        ktpRepository.deleteById(id);
    }
}

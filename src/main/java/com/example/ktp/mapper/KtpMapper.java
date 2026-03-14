package com.example.ktp.mapper;

import com.example.ktp.dto.KtpRequest;
import com.example.ktp.dto.KtpResponse;
import com.example.ktp.entity.Ktp;

public class KtpMapper {
    public static Ktp toEntity(KtpRequest request) {

        Ktp ktp = new Ktp();

        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());
        ktp.setAlamat(request.getAlamat());

        return ktp;
    }

    public static KtpResponse toResponse(Ktp ktp) {

        KtpResponse response = new KtpResponse();

        response.setId(ktp.getId());
        response.setNomorKtp(ktp.getNomorKtp());
        response.setNamaLengkap(ktp.getNamaLengkap());
        response.setTanggalLahir(ktp.getTanggalLahir());
        response.setJenisKelamin(ktp.getJenisKelamin());
        response.setAlamat(ktp.getAlamat());

        return response;
    }
}

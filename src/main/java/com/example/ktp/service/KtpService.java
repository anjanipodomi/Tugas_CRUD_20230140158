package com.example.ktp.service;

import com.example.ktp.dto.KtpRequest;
import com.example.ktp.dto.KtpResponse;
import java.util.List;

public interface KtpService {
    KtpResponse create(KtpRequest request);

    List<KtpResponse> getAll();

    KtpResponse getById(Long id);

    KtpResponse update(Long id, KtpRequest request);

    void delete(Long id);
}

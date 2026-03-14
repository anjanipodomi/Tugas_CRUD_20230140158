package com.example.ktp.controller;

import com.example.ktp.dto.KtpRequest;
import com.example.ktp.dto.KtpResponse;
import com.example.ktp.model.ApiResponse;
import com.example.ktp.service.KtpService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ktp")
public class KtpController {
    private final KtpService ktpService;

    public KtpController(KtpService ktpService) {
        this.ktpService = ktpService;
    }

    @PostMapping
    public ApiResponse<KtpResponse> create(@RequestBody KtpRequest request) {

        return new ApiResponse<>("Data berhasil dibuat",
                ktpService.create(request));
    }

    @GetMapping
    public ApiResponse<List<KtpResponse>> getAll() {

        return new ApiResponse<>("Data berhasil diambil",
                ktpService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<KtpResponse> getById(@PathVariable Long id) {

        return new ApiResponse<>("Data ditemukan",
                ktpService.getById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<KtpResponse> update(@PathVariable Long id,
                                           @RequestBody KtpRequest request) {

        return new ApiResponse<>("Data berhasil diupdate",
                ktpService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {

        ktpService.delete(id);

        return new ApiResponse<>("Data berhasil dihapus", "OK");
    }
}

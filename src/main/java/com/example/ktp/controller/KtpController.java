package com.example.ktp.controller;

import com.example.ktp.entity.Ktp;
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

    // POST /ktp
    @PostMapping
    public Ktp createKtp(@RequestBody Ktp ktp) {
        return ktpService.saveKtp(ktp);
    }

    // GET /ktp
    @GetMapping
    public List<Ktp> getAllKtp() {
        return ktpService.getAllKtp();
    }

    // GET /ktp/{id}
    @GetMapping("/{id}")
    public Ktp getKtpById(@PathVariable Integer id) {
        return ktpService.getKtpById(id);
    }

    // PUT /ktp/{id}
    @PutMapping("/{id}")
    public Ktp updateKtp(@PathVariable Integer id, @RequestBody Ktp ktp) {
        return ktpService.updateKtp(id, ktp);
    }

    // DELETE /ktp/{id}
    @DeleteMapping("/{id}")
    public void deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
    }
}

package com.example.ktp.dto;

import java.time.LocalDate;

public class KtpResponse {
    
        private Long id;
        private String nomorKtp;
        private String namaLengkap;
        private LocalDate tanggalLahir;
        private String jenisKelamin;
        private String alamat;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNomorKtp() {
            return nomorKtp;
        }

        public void setNomorKtp(String nomorKtp) {
            this.nomorKtp = nomorKtp;
        }

        public String getNamaLengkap() {
            return namaLengkap;
        }

        public void setNamaLengkap(String namaLengkap) {
            this.namaLengkap = namaLengkap;
        }

        public LocalDate getTanggalLahir() {
            return tanggalLahir;
        }

        public void setTanggalLahir(LocalDate tanggalLahir) {
            this.tanggalLahir = tanggalLahir;
        }

        public String getJenisKelamin() {
            return jenisKelamin;
        }

        public void setJenisKelamin(String jenisKelamin) {
            this.jenisKelamin = jenisKelamin;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }
}

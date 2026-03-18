const api = "http://localhost:8080/ktp";

/* =========================
   LOAD DATA SAAT PAGE LOAD
========================= */

$(document).ready(function () {
    loadData();
});


/* =========================
   GET DATA
========================= */

function loadData() {

    $.ajax({
        url: api,
        method: "GET",
        success: function (res) {
        
            let rows = "";

            res.data.forEach(function (d) {

                rows += `
                <tr>
                    <td>${d.id}</td>
                    <td>${d.nomorKtp}</td>
                    <td>${d.namaLengkap}</td>
                    <td>${d.alamat}</td>
                    <td>${d.tanggalLahir}</td>
                    <td>${d.jenisKelamin}</td>
                    <td>
                        <button class="editBtn" onclick="editData(${d.id})">Edit</button>
                        <button class="deleteBtn" onclick="deleteData(${d.id})">Delete</button>
                    </td>
                </tr>
                `;

            });

            $("#ktpTable").html(rows);

        }
    });

}


/* =========================
   SUBMIT FORM (POST / PUT)
========================= */

$("#ktpForm").submit(function (e) {

    e.preventDefault();

    let id = $("#id").val();

    const data = {
        nomorKtp: $("#nomorKtp").val(),
        namaLengkap: $("#namaLengkap").val(),
        alamat: $("#alamat").val(),
        tanggalLahir: $("#tanggalLahir").val(),
        jenisKelamin: $("#jenisKelamin").val()
    };

    let method = "POST";
    let url = api;

    if (id) {
        method = "PUT";
        url = api + "/" + id;
    }

    $.ajax({
        url: url,
        method: method,
        contentType: "application/json",
        data: JSON.stringify(data),

        success: function () {

            alert("Data berhasil disimpan");

            $("#ktpForm")[0].reset();
            $("#id").val("");

            loadData();

        },

        error: function () {
            alert("Terjadi kesalahan");
        }

    });

});


/* =========================
   EDIT DATA
========================= */

function editData(id) {

    $.ajax({
        url: api + "/" + id,
        method: "GET",

        success: function (res) {

            let d = res.data;

            $("#id").val(d.id);
            $("#nomorKtp").val(d.nomorKtp);
            $("#namaLengkap").val(d.namaLengkap);
            $("#alamat").val(d.alamat);
            $("#tanggalLahir").val(d.tanggalLahir);
            $("#jenisKelamin").val(d.jenisKelamin);

        }

    });

}


/* =========================
   DELETE DATA
========================= */

function deleteData(id) {

    if (confirm("Yakin ingin menghapus data ini?")) {

        $.ajax({
            url: api + "/" + id,
            method: "DELETE",

            success: function () {

                alert("Data berhasil dihapus");

                loadData();

            },

            error: function () {
                alert("Gagal menghapus data");
            }

        });

    }

}
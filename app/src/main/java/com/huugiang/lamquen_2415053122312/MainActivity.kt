package com.huugiang.lamquen_2415053122312

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var luotCuoi_2312: LuotNhan? = null
    private var demLuot_2312 = 0
    private lateinit var edtTen: EditText
    private lateinit var edtSoLuong: EditText
    private lateinit var btnKiemTra: Button
    private lateinit var btnXoa: Button
    private lateinit var txtKetQua: TextView
    private lateinit var txtMaLuot: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTen = findViewById(R.id.edtTen)
        edtSoLuong = findViewById(R.id.edtSoLuong)
        btnKiemTra = findViewById(R.id.btnKiemTra)
        btnXoa = findViewById(R.id.btnXoa)
        txtKetQua = findViewById(R.id.txtKetQua)
        txtMaLuot = findViewById(R.id.txtMaLuot)

        btnKiemTra.setOnClickListener { kiemTra_2312() }
        btnXoa.setOnClickListener { xoa_2312() }
    }
    fun kiemTra_2312(){
        val tenChuan = edtTen.text.toString().chuanHoaTen_2312()
        val soLuongStr = edtSoLuong.text.toString().trim()
        if (tenChuan.length !in 2..40){
            xuLyLoi_2312("Lỗi: Tên phải từ 2 đến 40 ký tự")
            return
        }
        val soLuong = soLuongStr.toIntOrNull()
        if (soLuong == null || soLuong !in 1..9){
            xuLyLoi_2312("Lỗi: Số lượng phải là số nguyên từ 1 đến 9")
            return
        }
        demLuot_2312++
        val maMoi = QuyTacPhieu_2312.taoMaPhieu_2312(demLuot_2312)
        luotCuoi_2312 = LuotNhan(
            maLuot_2312 = maMoi,
            hoTen_2312 = tenChuan,
            soLuong_2312 = soLuong
        )
        luotCuoi_2312?.let{
            txtKetQua.text = " Xin chào ${it.hoTen_2312}, số lượng : ${it.soLuong_2312}"
            txtMaLuot.text = it.maLuot_2312
        }
    }
    private fun xuLyLoi_2312(thongBao:String){
        luotCuoi_2312 = null
        txtKetQua.text = thongBao
        txtMaLuot.text = ""
    }
    fun xoa_2312(){
        luotCuoi_2312 = null
        edtTen.text.clear()
        edtSoLuong.text.clear()
        txtKetQua.text = ""
        txtMaLuot.text = ""
    }
}
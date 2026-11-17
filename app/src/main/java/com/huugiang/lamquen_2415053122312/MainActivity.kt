package com.huugiang.lamquen_2415053122312

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var luotCuoi_2312: LuotNhan? = null
    var phienHienTai_2312 = PhienNhan(0)
    private var demLuot_2312 = 0

    private lateinit var edtTen: EditText
    private lateinit var edtSoLuong: EditText
    private lateinit var btnGhiNhan: Button
    private lateinit var btnXoa: Button
    private lateinit var txtKetQua: TextView
    private lateinit var txtMaLuot: TextView
    private lateinit var txtTong: TextView
    private lateinit var txtConLai: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTen = findViewById(R.id.edtTen)
        edtSoLuong = findViewById(R.id.edtSoLuong)
        btnGhiNhan = findViewById(R.id.btnGhiNhan)
        btnXoa = findViewById(R.id.btnXoa)
        txtKetQua = findViewById(R.id.txtKetQua)
        txtMaLuot = findViewById(R.id.txtMaLuot)
        txtTong = findViewById(R.id.txtTong)
        txtConLai = findViewById(R.id.txtConLai)

        capNhatHienThiSucChua_2312()

        btnGhiNhan.setOnClickListener { ghiNhan_2312() }
        btnXoa.setOnClickListener { xoa_2312() }
    }

    // Hàm bắt buộc gọi khi bấm nút Ghi nhận
    fun ghiNhan_2312() {
        val tenChuan = edtTen.text.toString().chuanHoaTen_2312()
        val soLuongStr = edtSoLuong.text.toString().trim()

        // 1. Kiểm tra tên 2-40 ký tự
        if (tenChuan.length !in 2..40) {
            edtTen.error = "Tên phải từ 2 đến 40 ký tự"
            xuLyLoi_2312("Lỗi: Tên phải từ 2 đến 40 ký tự")
            return
        }

        // 2. Kiểm tra số lượng nguyên 1-9
        val soLuong = soLuongStr.toIntOrNull()
        if (soLuong == null || soLuong !in 1..9) {
            edtSoLuong.error = "Số lượng phải từ 1 đến 9"
            xuLyLoi_2312("Lỗi: Số lượng phải là số nguyên từ 1 đến 9")
            return
        }

        // 3. Kiểm tra vượt sức chứa 9 người
        if (phienHienTai_2312.daNhan_2312 + soLuong > 9) {
            edtSoLuong.error = "Vượt quá sức chứa 9 người"
            xuLyLoi_2312("Lỗi: Vượt quá sức chứa tối đa 9 người")
            return
        }

        // 4. Hợp lệ -> Cập nhật tổng, tạo mã mới, lưu model và hiển thị
        phienHienTai_2312.daNhan_2312 += soLuong
        demLuot_2312++
        val maMoi = QuyTacPhieu_2312.taoMaPhieu_2312(demLuot_2312)

        luotCuoi_2312 = LuotNhan(
            maLuot_2312 = maMoi,
            hoTen_2312 = tenChuan,
            soLuong_2312 = soLuong
        )

        luotCuoi_2312?.let {
            txtKetQua.text = "Xin chào ${it.hoTen_2312}, số lượng: ${it.soLuong_2312}"
            txtMaLuot.text = it.maLuot_2312
        }
        capNhatHienThiSucChua_2312()
    }

    private fun xuLyLoi_2312(thongBao: String) {
        // Khi lỗi: giữ nguyên tổng/chỗ, không tăng mã, xóa kết quả hợp lệ cũ
        luotCuoi_2312 = null
        txtKetQua.text = thongBao
        txtMaLuot.text = ""
    }

    private fun capNhatHienThiSucChua_2312() {
        val tong = phienHienTai_2312.daNhan_2312
        val conLai = 9 - tong
        txtTong.text = "Tổng đã nhận: $tong"
        txtConLai.text = "Chỗ còn lại: $conLai"
    }

    fun xoa_2312() {
        luotCuoi_2312 = null
        phienHienTai_2312.daNhan_2312 = 0
        edtTen.text.clear()
        edtTen.error = null
        edtSoLuong.text.clear()
        edtSoLuong.error = null
        txtKetQua.text = ""
        txtMaLuot.text = ""
        capNhatHienThiSucChua_2312()
        // Không reset demLuot_2312 theo yêu cầu đề bài
    }
}
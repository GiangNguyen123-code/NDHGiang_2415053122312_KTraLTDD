package com.huugiang.lamquen_2415053122312

data class LuotNhan (
    val maLuot_2312: String,
    val hoTen_2312: String,
            val soLuong_2312: Int
    )
fun String.chuanHoaTen_2312():String{
    return this.trim()
}
object QuyTacPhieu_2312{
    fun taoMaPhieu_2312(soThuTu: Int) :String{
        return "L$soThuTu"
    }
}
data class PhienNhan(
    var daNhan_2312: Int = 0
)
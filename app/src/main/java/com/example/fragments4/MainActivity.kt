package com.example.fragments4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
val products = mutableListOf<Product>(Product(1,"Pixel3a",4500F,R.drawable._1rzdb2mqxl__ac_uf894_1000_ql80_,
                "Meet pixel3a premimum for less","Save your photos and videos for " +
            "free,unlimited storage in high quality with google photos "),
            Product(2,"Boat Rockerz",1800F,R.drawable.images,"For new generation",
                "Dhoom Dhadaka AAwaz Kaan Phat Jaye"),
            Product(3,"Canon CAMERA",50000F,R.drawable.images__1_,"To capture" +
                    "memories","aukad ke bahar ka camera hai hawabaj londe"),
            Product(4,"Sony Drone",10000F,R.drawable.images__2_,"hawaijahaj hai pura",
                "Drone hi hai ek normal sa udan khatola samjah ke beth mat jayio "),
            Product(5,"VR gear",5000F,R.drawable.images__3_,"ghar pe theatre",
                "naam ka theatre hota hai aankh me dard ho jata hai pesa barbadi"),
            Product(6,"earphones",1500F,R.drawable.p_groove_in_style_noise_vs303_earbuds_187099_m,
                "badhiya bass","pesa vasool hai ekdum bdhiya hai lele",))
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
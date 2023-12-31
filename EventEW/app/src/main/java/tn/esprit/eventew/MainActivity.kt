package tn.esprit.eventew


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val image1=findViewById<ImageView>(R.id.imageView)
        val image2=findViewById<ImageView>(R.id.imageView)
        val application =findViewById<TextView>(R.id.appname)




        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this,menuClient::class.java)
            startActivity(intent)
        },3000)
    }
}
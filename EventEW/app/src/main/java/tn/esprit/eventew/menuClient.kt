package tn.esprit.eventew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import tn.esprit.eventew.fragments.HomeFragment


class menuClient : AppCompatActivity() {
    private val homeFragment= HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_client)

        replaceFragment(homeFragment)


    }
    private fun replaceFragment (fragment: Fragment)
    {
        if(fragment!=null)
        {
              val bundle = Bundle()

            fragment.arguments = bundle
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)


            transaction.commit()
        }

    }



}
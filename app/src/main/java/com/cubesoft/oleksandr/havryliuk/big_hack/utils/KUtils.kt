package com.cubesoft.oleksandr.havryliuk.big_hack.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


fun addFragment(manager: FragmentManager, frameId: Int, fragment: Fragment) {
    val transaction = manager.beginTransaction()
    transaction.add(frameId, fragment)
    transaction.commit()
}


fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
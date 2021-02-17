package com.sam.prefrencescreendemokt

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       val fab = view.findViewById<FloatingActionButton>(R.id.fab_settings)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        loadSettings()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadSettings() {
        val sp = PreferenceManager.getDefaultSharedPreferences(context)
        val signature = sp.getString("signature","")
        val reply = sp.getString("reply","")
        val sync = sp.getBoolean("sync",true)
        val notifications = sp.getBoolean("notifications",false)
        val volume = sp.getInt("volume_notifications",0)
        val tvSignature = view?.findViewById<TextView>(R.id.tv_signature)
        tvSignature?.text = "Signature: $signature"
        val tvReply = view?.findViewById<TextView>(R.id.tv_reply)
        tvReply?.text = "Default Reply: $reply"
        val tvSync = view?.findViewById<TextView>(R.id.tv_sync)
        tvSync?.text = "Sync: $sync"
        val tvNotification = view?.findViewById<TextView>(R.id.tv_notifications)
        tvNotification?.text = "Disable Notification : $notifications"
        val pb = view?.findViewById<ProgressBar>(R.id.pb_volume)
        pb?.setProgress(volume,true)

    }
}
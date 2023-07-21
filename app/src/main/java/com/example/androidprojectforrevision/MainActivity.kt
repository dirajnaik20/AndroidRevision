package com.example.androidprojectforrevision

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.security.Permission

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnRequestPermission).setOnClickListener {
            requestPermission()
        }
    }

    private fun hasWriteExternalDevicePermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasForegroundLocationPermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun hasBackgroundLocationPermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun requestPermission(){
        var permissionToRequest= mutableListOf<String>()
        if (!hasWriteExternalDevicePermission()){
            permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasForegroundLocationPermission()){
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (!hasBackgroundLocationPermission()){
            permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if (permissionToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this,permissionToRequest.toTypedArray(),0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==0 && grantResults.isNotEmpty()){
            for (i in grantResults.indices){
                if (grantResults[i]==PackageManager.PERMISSION_GRANTED){
                    Log.d("PermissionRequest","${permissions[i]} is granted.")

                }
            }
        }
    }


}
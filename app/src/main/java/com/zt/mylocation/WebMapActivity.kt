package com.zt.mylocation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.zt.mylocation.common.showAlert
import com.zt.mylocation.common.showToast
import com.zt.mylocation.databinding.ActivityWebMapBinding
import com.zt.mylocation.models.Location

class WebMapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            binding = ActivityWebMapBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val listLocation = mutableListOf<Location>()
            listLocation.add(Location("Select Location", 0.0, 0.0))
            listLocation.add(Location("Fullers", -30.01703, 153.13179))
            listLocation.add(Location("Green Shed",-29.98904, 153.13602))
            listLocation.add(Location("Greys Road Farm", -29.9401, 153.12618))
            listLocation.add(Location("KD17", -30.00472, 153.13965))
            listLocation.add(Location("Packing Shed", -29.98767, 153.14126))
            listLocation.add(Location("Sutton’s", -29.99817, 153.13941))
            listLocation.add(Location("S2 (86)", -29.98896, 153.14121))
            listLocation.add(Location("Section 1", -29.99267, 153.1442))
            listLocation.add(Location("Section 2", -29.99791, 153.15077))
            listLocation.add(Location("Section 3", -30.01207, 153.14249))
            listLocation.add(Location("Section 4", -29.99063, 153.13319))
            listLocation.add(Location("Tols Main Maintenance Shed", -30.01577, 153.12422))

            val locationNameList = listLocation.map { it.name } as MutableList<*>
            val adapterLocation =
                ArrayAdapter(this, R.layout.item_spinner_location, locationNameList)
            binding.spinner.adapter = adapterLocation
            /*  binding.spinner.setOnItemSelectedListener(object :
                  AdapterView.OnItemSelectedListener {
                  override fun onItemSelected(
                      parent: AdapterView<*>?,
                      view: View?,
                      position: Int,
                      id: Long
                  ) {
                      TODO("Not yet implemented")
                  }

                  override fun onNothingSelected(parent: AdapterView<*>?) {
                      TODO("Not yet implemented")
                  }

              })
  */
            binding.btnlocation.setOnClickListener {
                try {
                    val position = binding.spinner.selectedItemPosition
                    if (position == 0) {
                        showToast("Please select location")
                    } else {
                        val location = listLocation.get(position)
                        val navigationIntentUri = Uri.parse("google.navigation:q=" + location.lat + "," + location.lng)
                        val mapIntent = Intent(Intent.ACTION_VIEW, navigationIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")
                        startActivity(mapIntent)
                    }
                    //binding.webview.loadUrl("https://www.google.com/maps/d/u/0/edit?mid=1bi0eBTUZSeBPOfXvlsSuBLJwKBL6g2Gv&usp=sharing")
                } catch (e: Exception) {
                    e.printStackTrace()
                    showAlert(e.localizedMessage)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
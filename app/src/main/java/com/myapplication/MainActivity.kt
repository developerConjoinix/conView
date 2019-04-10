package com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arges.sepan.argmusicplayer.Enums.AudioType
import com.arges.sepan.argmusicplayer.IndependentClasses.ArgAudio
import com.arges.sepan.argmusicplayer.IndependentClasses.ArgAudioList
import com.arges.sepan.argmusicplayer.PlayerViews.ArgPlayerLargeView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recycleview.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this)


        val db      =  FirebaseFirestore.getInstance()
        val collec  =  db.collection("Items").get()


        val playera = findViewById<ArgPlayerLargeView>(R.id.player)
         collec.addOnSuccessListener {

            val doc = it.documents

          recycleView.adapter = AdapterItem(doc)



             val songList =  ArgAudioList(true)
             for (ob in doc){
                 val test = ob.toObject(Data::class.java)
                 print(test)
                 songList.add(ArgAudio("OKOK" ,test?.duration,test?.url, AudioType.URL))

             }

//             playera.playPlaylist(songList)
      }

    }


   /* private fun getFile()
    {

      val databaseReference = FirebaseStorage.getInstance().reference



        try {
            val player =  MediaPlayer()
            player.setAudioStreamType(AudioManager.STREAM_MUSIC)
            player.setDataSource("https://firebasestorage.googleapis.com/v0/b/eloquent-drive-674.appspot.com/o/path%2Fmove.mp3?alt=media&token=587285b8-ddcd-4562-9868-8f4dd6719fc1");
            player.prepare()
            player.start()
        } catch (e : Exception) {
             log("### $e")
        }




        }*/


}




class AdapterItem(private val data : List<DocumentSnapshot>)
      : RecyclerView.Adapter<AdapterItem.Item>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_recycleview,parent,false)

        return Item(view)

    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Item, position: Int)
    {

        val item = data[position]
        val test = item.toObject(Data::class.java)
        holder.itemView.title.text = test?.name
        holder.itemView.duration.text = test?.duration


    }


    inner class Item(view: View) : RecyclerView.ViewHolder(view)


}



fun print(a: Any?){

    Log.e("#### ", "$a")
}



data class Data( var icon : String = "" ,
                 var name : String = "" ,
                 var url : String = "",
                 var duration : String = "")



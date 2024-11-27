package edu.iesam.examaad1eval

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.model.Ex1Repository
import edu.iesam.examaad1eval.features.ex2.data.local.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DataBase
import edu.iesam.examaad1eval.features.ex2.data.remote.mock.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        val repository : Ex1Repository = Ex1DataRepository(this)
        val users = repository.getUsers()
        val items = repository.getItems()
        val services = repository.getServices()


        findViewById<TextView>(R.id.txt_1).text = users.toString()
        findViewById<TextView>(R.id.txt_2).text = items.toString()
        findViewById<TextView>(R.id.txt_3).text = services.toString()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        val db = Room.databaseBuilder(
            applicationContext,
            Ex2DataBase::class.java,
            "database-ex2"
        )
        db.fallbackToDestructiveMigration()
        val dao = db.build().ex2Dao()
        val repository = Ex2DataRepository(dao, MockEx2RemoteDataSource())
        GlobalScope.launch {
            repository.getGames()
        }
    }
}
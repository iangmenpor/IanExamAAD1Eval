package edu.iesam.examaad1eval.features.ex1.data

import android.content.Context
import edu.iesam.examaad1eval.features.ex1.data.local.xml.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.mock.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.model.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.model.Item
import edu.iesam.examaad1eval.features.ex1.model.Services
import edu.iesam.examaad1eval.features.ex1.model.User


class Ex1DataRepository(context: Context) : Ex1Repository {

    private val localDataSource = Ex1XmlLocalDataSource(context)
    private val remoteDataSource = MockEx1RemoteDataSource()

    override fun getUsers(): List<User> {
        val local = localDataSource.getUsers()
        return local.ifEmpty {
            val remote = remoteDataSource.getUsers()
            localDataSource.saveUsers(remote)
            local
        }
    }

    override fun getItems(): List<Item> {
        val local = localDataSource.getItems()
        return local.ifEmpty {
            val remote = remoteDataSource.getItems()
            localDataSource.saveItems(remote)
            local
        }
    }

    override fun getServices(): List<Services> {
        val local = localDataSource.getServices()
        return local.ifEmpty {
            val remote = remoteDataSource.getServices()
            localDataSource.saveServices(remote)
            local
        }
    }

}
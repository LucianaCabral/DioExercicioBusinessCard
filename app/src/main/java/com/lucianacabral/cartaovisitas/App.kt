package com.lucianacabral.cartaovisitas

import android.app.Application
import com.lucianacabral.cartaovisitas.data.AppDataBase
import com.lucianacabral.cartaovisitas.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDataBase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao())}
}
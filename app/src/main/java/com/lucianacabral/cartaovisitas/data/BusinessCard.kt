package com.lucianacabral.cartaovisitas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var nome: String,
    var telefone: String,
    var email: String,
    var empresa: String,
)
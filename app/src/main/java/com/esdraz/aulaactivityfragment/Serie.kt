package com.esdraz.aulaactivityfragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

//utilizando o plugin parcelizeble
@Parcelize
data class Serie(
    val nome: String,
    val descricao: String,
    val avaliacoes: Double,
    val diretor: String,
    val distribuidor: String
) : Parcelable

//data class Serie(
//    val nome: String,
//    val descricao: String,
//    val avaliacoes: Double,
//    val diretor: String,
//    val distribuidor: String
//) : Serializable

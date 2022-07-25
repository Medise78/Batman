package com.example.batman.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.batman.domain.model.MovieDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Convertors(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromJsonLic(json:String):MovieDetails{
        return jsonParser.fromJson<MovieDetails>(
            json,
            object : TypeToken<MovieDetails>(){}.type
        ) ?: MovieDetails()
    }

    @TypeConverter
    fun toJsonString(obj:MovieDetails):String{
        return jsonParser.toJson(
            obj,
            object : TypeToken<MovieDetails>(){}.type
        )?:"[]"
    }

}
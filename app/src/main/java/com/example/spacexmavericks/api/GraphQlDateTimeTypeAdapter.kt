package com.example.spacexmavericks.api

import com.apollographql.apollo.api.CustomTypeAdapter
import com.apollographql.apollo.api.CustomTypeValue
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GraphQlDateTimeTypeAdapter : CustomTypeAdapter<Date> {

    private val format = SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss", Locale.getDefault())

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun decode(value: CustomTypeValue<*>): Date {
        return try {
            format.parse(value.value.toString())
        } catch (e: ParseException) {
            throw RuntimeException(e)
        }
    }

    override fun encode(value: Date): CustomTypeValue<*> {
        return CustomTypeValue.GraphQLString(format.format(value))
    }
}
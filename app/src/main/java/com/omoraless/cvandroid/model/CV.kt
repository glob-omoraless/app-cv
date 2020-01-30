package com.omoraless.cvandroid.model

data class CV (
    val contact_information: Info,
    val career_history : MutableList<CareerHistory>,
    val education : Education
   )
data class Info (
    val name: String,
    val mail : String,
    val city_state : String,
    val phone_number : String,
    val url_image :String,
    val career_summary :String,
    val technologies : List<String> ,
    val languages: MutableList<Language> )
data class CareerHistory (
    val company: String,
    val url_company_logo : String,
    val period : String,
    val responsibilities : String,
    val title : String,
    val projects : MutableList<Project>)
data class Project (
    val url_image: String,
    val project_name : String,
    val period : String)
data class Language (
    val type: String,
    val proficiency : String)
data class Education (
    val university: String,
    val period : String,
    val url_image : String)
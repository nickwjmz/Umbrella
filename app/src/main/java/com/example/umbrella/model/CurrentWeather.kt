package com.example.umbrella.model

data class CurrentWeather(var weather: List<CurrentList>,
                          var main: CurrentMain,
                          var name: String
)

data class CurrentList(var description: String)

data class CurrentMain(var temp: String,
                       var temp_min: String,
                       var temp_max: String
)
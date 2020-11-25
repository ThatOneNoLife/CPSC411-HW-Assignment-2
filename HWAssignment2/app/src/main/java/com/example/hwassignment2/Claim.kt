package com.example.hwassignment2

import java.util.*

data class Claim (var id: UUID = UUID.randomUUID(), var title:String?, var date:String?, var isSolved:Boolean = false)
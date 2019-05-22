package com.apppoweron.koindi.component

import com.apppoweron.koindi.module.retrofitModule
import org.koin.core.module.Module

val appComponent: List<Module> = listOf(retrofitModule)
package com.example.codeforcesapp.di

import com.example.codeforcesapp.codeforces.core.data.networking.HttpClientFactory
import com.example.codeforcesapp.codeforces.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.data.CodeForcesAPIImpl
import com.example.codeforcesapp.codeforces.presentation.user_info.UserInfoViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::CodeForcesAPIImpl).bind<CodeForcesAPI>()

    viewModelOf(::UserInfoViewModel)
}
package com.example.codeforcesapp.di

import com.example.codeforcesapp.codeforces.core.data.networking.HttpClientFactory
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.core.data.networking.CodeForcesAPIImpl
import com.example.codeforcesapp.codeforces.user.presentation.user_info.UserInfoViewModel
import com.example.codeforcesapp.codeforces.contest.presentation.contest_list.ContestListViewModel
import com.example.codeforcesapp.codeforces.problems.presentation.problems_list.ProblemListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::CodeForcesAPIImpl).bind<CodeForcesAPI>()

    viewModelOf(::UserInfoViewModel)
    viewModelOf(::ContestListViewModel)
    viewModelOf(::ProblemListViewModel)
}
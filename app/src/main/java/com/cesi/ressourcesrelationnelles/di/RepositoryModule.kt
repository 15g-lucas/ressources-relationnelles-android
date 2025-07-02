package com.cesi.ressourcesrelationnelles.di

import com.cesi.ressourcesrelationnelles.data.repository.RelationRepository
import com.cesi.ressourcesrelationnelles.data.repository.RelationRepositoryImpl
import com.cesi.ressourcesrelationnelles.data.repository.ResourceRepository
import com.cesi.ressourcesrelationnelles.data.repository.ResourceRepositoryImpl
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import com.cesi.ressourcesrelationnelles.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

    @Binds
    abstract fun bindRelationRepository(
        impl: RelationRepositoryImpl
    ): RelationRepository

    @Binds
    abstract fun bindResourceRepository(
        impl: ResourceRepositoryImpl
    ): ResourceRepository
}
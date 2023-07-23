package io.wetfloo.flashback.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.wetfloo.flashback.util.DispatchersProvider
import io.wetfloo.flashback.util.DispatchersProviderImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DispatchersModule {
    @Binds
    @Singleton
    fun dispatchersProvider(impl: DispatchersProviderImpl): DispatchersProvider
}

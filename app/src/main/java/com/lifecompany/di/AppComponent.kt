package com.lifecompany.di

import android.content.Context
import com.lifecompany.presentation.feature.companies.CompanyActivity
import com.lifecompany.presentation.feature.companydetails.CompanyDetailsActivity

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        NavigationModule::class,
        RepositoryModule::class,
        MapperModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        fun build(): AppComponent
        @BindsInstance
        fun context(context: Context): Builder
    }

    class Initializer private constructor() {

        companion object {
            fun init(context: Context): AppComponent {
                return DaggerAppComponent.builder()
                    .context(context)
                    .build()
            }
        }
    }

    fun inject(activity: CompanyActivity)
    fun inject(activity: CompanyDetailsActivity)
}

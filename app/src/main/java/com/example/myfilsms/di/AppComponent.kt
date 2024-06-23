package com.example.myfilsms.di


import com.example.myfilsms.di.modules.DatabaseModule
import com.example.myfilsms.di.modules.DomainModule
import com.example.myfilsms.viewmodel.HomeFragmentViewModel
import com.example.myfilsms.viewmodel.SettingsFragmentViewModel
import dagger.Component
import ru.MyFilsms.remote_module.RemoteProvider
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}
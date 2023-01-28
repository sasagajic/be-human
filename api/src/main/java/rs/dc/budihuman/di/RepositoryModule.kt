package rs.dc.budihuman.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import rs.dc.budihuman.api.BeHumanService
import rs.dc.budihuman.repository.BeneficiaryRepository
import rs.dc.budihuman.repository.BeneficiaryRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
internal class RepositoryModule {

    @Provides
    fun provideBeneficiaryRepository(service: BeHumanService): BeneficiaryRepository {
        return BeneficiaryRepositoryImpl(service)
    }

}
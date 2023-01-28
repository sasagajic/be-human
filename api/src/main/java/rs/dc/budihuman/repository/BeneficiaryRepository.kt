package rs.dc.budihuman.repository

import rs.dc.budihuman.api.BeHumanService
import rs.dc.budihuman.model.Beneficiary

interface BeneficiaryRepository {
    suspend fun getBeneficiaries(): List<Beneficiary>
}

class BeneficiaryRepositoryImpl(
    val service: BeHumanService
) : BeneficiaryRepository {

    override suspend fun getBeneficiaries(): List<Beneficiary> {
        val response = service.beneficiaries(page = 1, perPage = 1000)
        return response.data.map { remoteBeneficiary ->
            Beneficiary(
                id = remoteBeneficiary.id,
                group = remoteBeneficiary.group,
                active = remoteBeneficiary.active,
                name = remoteBeneficiary.name,
                campaignTitle = remoteBeneficiary.campaignTitle,
                campaignDescription = remoteBeneficiary.seoDescription,
                photoThumbUrl = remoteBeneficiary.photoThumbUrl,
                accountNumber = remoteBeneficiary.bankAccountNumber
            )
        }
    }

}
package rs.dc.budihuman.repository

import rs.dc.budihuman.api.BeHumanService
import rs.dc.budihuman.model.Beneficiary as LocalBeneficiary

interface BeneficiaryRepository {
    suspend fun getBeneficiaries(): List<LocalBeneficiary>
}

class BeneficiaryRepositoryImpl (
    val service: BeHumanService
): BeneficiaryRepository {

    override suspend fun getBeneficiaries(): List<LocalBeneficiary> {
        val response = service.beneficiaries(page = 1, perPage = 1000)
        return response.data.map { remoteBeneficiary ->
            LocalBeneficiary(
                id = remoteBeneficiary.id,
                group = remoteBeneficiary.group,
                active = remoteBeneficiary.active,
                name = remoteBeneficiary.name,
                campaignTitle =  remoteBeneficiary.campaignTitle,
                campaignDescription = remoteBeneficiary.seoDescription,
                photoThumbUrl = remoteBeneficiary.photoThumbUrl,
                accountNumber = remoteBeneficiary.bankAccountNumber
            )
        }
    }

}
package rs.dc.budihuman.model

data class Beneficiary(
    val id: String,
    val group: String,
    val active: Int,
    val name: String,
    val campaignTitle: String,
    val campaignDescription: String,
    val photoThumbUrl: String?
)
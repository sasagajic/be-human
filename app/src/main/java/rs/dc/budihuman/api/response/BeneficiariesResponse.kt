package rs.dc.budihuman.api.response

data class BeneficiariesResponse(
    val status: String,
    val message: String,
    val data: List<Beneficiary>,
    val meta: Meta
)
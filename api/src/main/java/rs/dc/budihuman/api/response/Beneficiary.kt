package rs.dc.budihuman.api.response

import com.google.gson.annotations.SerializedName

data class Beneficiary(
    val id: String,
    val group: String,
    val active: Int,
    val name: String,
    @SerializedName("seo_slug")
    val seoSlug: String,
    @SerializedName("seo_title")
    val seoTitle: String,
    @SerializedName("seo_description")
    val seoDescription: String,
    @SerializedName("sms_count")
    val smsCount: Int,
    @SerializedName("campaign_title")
    val campaignTitle: String,
    @SerializedName("campaign_description")
    val campaignDescription: String,
    @SerializedName("campaign_required_amount")
    val campaignRequiredAmount: Double,
    @SerializedName("page_content")
    val pageContent: String?,
    @SerializedName("bank_account_number")
    val bankAccountNumber: String,
    @SerializedName("bank_account_fc_number")
    val bankAccountFcNumber: String,
    @SerializedName("bank_account_fc_iban")
    val bankAccountFcIban: String,
    @SerializedName("bank_account_fc_swift")
    val bankAccountFcSwift: String,
    val translations: List<Translation>?,
    @SerializedName("sms_count_updated_at")
    val smsCountUpdated_At: String,
    @SerializedName("bank_accounts_stats")
    val bankAccountsStats: List<BankAccountStat>?,
    @SerializedName("photo_thumb_url")
    val photoThumbUrl: String?,
    @SerializedName("photo_banner1_url")
    val photoBanner1Url: String?,
    @SerializedName("photo_banner2_url")
    val photoBanner2Url: String?,
    @SerializedName("photo_banner3_url")
    val photoBanner3Url: String?,
    @SerializedName("photo_banner4_url")
    val photoBanner4Url: String?,
    @SerializedName("bank_account_qrcode_url")
    val bankAccountQrcodeUrl: String?,
    @SerializedName("bank_account_fc_instructions_url")
    val bankAccountFcInstructionsUrl: String?
)

data class Translation(
    val lang: String,
    val name: String,
    @SerializedName("seo_title")
    val seoTitle: String?,
    @SerializedName("seo_description")
    val seoDescription: String?,
    @SerializedName("campaign_title")
    val campaignTitle: String?,
    @SerializedName("campaign_description")
    val campaignDescription: String?,
    @SerializedName("page_content")
    val pageContent: String?
)

data class BankAccountStat(
    @SerializedName("account_number")
    val accountNumber: String,
    val currency: String,
    val iban: String?,
    val swift: String?,
    val amount: Double,
    @SerializedName("income_donation_total")
    val incomeDonationTotal: Double,
    @SerializedName("income_distribution_total")
    val incomeDistributionTotal: Double,
    @SerializedName("expences_payment_total")
    val expensesPaymentTotal: Double
)
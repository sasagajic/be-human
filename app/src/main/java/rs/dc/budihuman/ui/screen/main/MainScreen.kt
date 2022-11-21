package rs.dc.budihuman.ui.screen.main

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import rs.dc.budihuman.model.Beneficiary
import rs.dc.budihuman.ui.theme.BudiHumanTheme

@Composable
fun MainScreen(context: Context, navController: NavController, viewModel: MainScreenViewModel) {
    val beneficiaries: List<Beneficiary> by viewModel.beneficiaries.observeAsState(listOf())

    BeneficiariesList(
        beneficiaries = beneficiaries,
        onSendSms = { viewModel.sendSms(context, it) }
    )

    viewModel.fetchBeneficiaries()
}

@Composable
fun BeneficiariesList(
    beneficiaries: List<Beneficiary>,
    onSendSms: (String) -> Unit
) {
    LazyColumn {
        beneficiaries.map {  
            item (key = it.id ) {
                BeneficiaryListItemContent(
                    id = it.id,
                    title = it.campaignTitle,
                    description = it.campaignDescription,
                    imageUrl = it.photoThumbUrl,
                    onSendSms = onSendSms
                )
            } 
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun MainScreenContentPreview() {
    BudiHumanTheme {
        Surface(color = MaterialTheme.colorScheme.background) {


            val data = listOf(
                Beneficiary(id = "1", group = "", active = 1, name = "", campaignTitle = "Title", campaignDescription = "Description", photoThumbUrl = "" ),
                Beneficiary(id = "2", group = "", active = 1, name = "", campaignTitle = "Title", campaignDescription = "Description", photoThumbUrl = "" ),
                Beneficiary(id = "3", group = "", active = 1, name = "", campaignTitle = "Title", campaignDescription = "Description", photoThumbUrl = "" )
            )

            BeneficiariesList(beneficiaries = data, onSendSms = {})
        }
    }
}
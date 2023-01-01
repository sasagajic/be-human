package rs.dc.budihuman.ui.screen.main

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.facebook.flipper.plugins.uidebugger.LogTag
import rs.dc.budihuman.model.Beneficiary
import rs.dc.budihuman.ui.theme.BudiHumanTheme

@Composable
fun BeneficiariesScreen(
    context: Context,
    viewModel: MainScreenViewModel,
    onPaymentInstructionsSelected: (String) -> Unit
) {
    val beneficiaries: List<Beneficiary> by viewModel.beneficiaries.observeAsState(listOf())

    BeneficiariesListCompact(
        beneficiaries = beneficiaries,
        onBeneficiarySelected = {
            onPaymentInstructionsSelected(viewModel.getPaymentInstructions(it))
        }
    )

    viewModel.fetchBeneficiaries()

}

@Composable
fun BeneficiariesListCompact(
    beneficiaries: List<Beneficiary>,
    onBeneficiarySelected: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        beneficiaries.map {  
            item (key = it.id) {
                BeneficiaryListItemCompactContent(
                    id = it.id,
                    title = it.campaignTitle,
                    description = it.campaignDescription,
                    imageUrl = it.photoThumbUrl,
                    onBeneficiarySelected = onBeneficiarySelected
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
fun BeneficiariesScreenContentPreview() {
    BudiHumanTheme {
        Surface(color = MaterialTheme.colorScheme.background) {


            val data = listOf(
                Beneficiary(id = "1", group = "", active = 1, name = "", campaignTitle = "Title", campaignDescription = "Description", photoThumbUrl = "" , accountNumber = ""),
                Beneficiary(id = "2", group = "", active = 1, name = "", campaignTitle = "Title", campaignDescription = "Description", photoThumbUrl = "" , accountNumber = "" ),
                Beneficiary(id = "3", group = "", active = 1, name = "", campaignTitle = "Title", campaignDescription = "Description", photoThumbUrl = "" , accountNumber = "" )
            )

            BeneficiariesListCompact(beneficiaries = data, onBeneficiarySelected = {})
        }
    }
}
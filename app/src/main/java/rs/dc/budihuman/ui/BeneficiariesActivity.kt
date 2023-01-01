package rs.dc.budihuman.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import rs.dc.budihuman.ui.navigation.Navigation
import rs.dc.budihuman.ui.screen.main.BeneficiariesScreen
import rs.dc.budihuman.ui.screen.main.MainScreen
import rs.dc.budihuman.ui.screen.main.MainScreenViewModel
import rs.dc.budihuman.ui.theme.BudiHumanTheme

@AndroidEntryPoint
class BeneficiariesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudiHumanTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<MainScreenViewModel>()
                    BeneficiariesScreen(
                        context = this,
                        viewModel = viewModel,
                        onPaymentInstructionsSelected = { onPaymentInstructionsSelected(it) }
                    )
                }
            }
        }
    }

    private fun onPaymentInstructionsSelected(instructions: String) {
        val intent = Intent()
        intent.putExtra("payment_instructions", instructions)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}
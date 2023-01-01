package rs.dc.testapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.dc.testapp.ui.theme.BudiHumanTheme

class MainActivity : ComponentActivity() {
    private val instructions = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudiHumanTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Greeting(instructions.value) { launchBeHumanActivity() }
                }
            }
        }
    }

    private fun launchBeHumanActivity() {
        startForResult.launch(Intent("rs.dc.budihuman.BE_HUMAN"))
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            instructions.value = intent?.getStringExtra("payment_instructions") ?: ""
        }
    }

}

@Composable
fun Greeting(
    instructions: String,
    onShowBeneficiaries: () -> Unit
) {

    Column() {
        TextButton(
            onClick = { onShowBeneficiaries() },
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            // Inner content including an icon and a text label
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_volunteer_activism_24),
                contentDescription = "Be Human",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Be Human")
        }

        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
            text = instructions,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BudiHumanTheme {
        Greeting("K:PR|V:01|C:1|R:160600000151137495|N:Budi Human - 1418 - Lazar Zivanovic|I:RSD1000,00|SF:289|S:Za Lazara!|RO:001418-ipsqr", {})
    }
}
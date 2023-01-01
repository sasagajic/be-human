package rs.dc.budihuman.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import rs.dc.budihuman.R

val notoSansFamily = FontFamily(
    Font(R.font.notosans_light, FontWeight.Light),
    Font(R.font.notosans_regular, FontWeight.Normal),
    Font(R.font.notosans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.notosans_medium, FontWeight.Medium),
    Font(R.font.notosans_bold, FontWeight.Bold)
)

private val defaultTypography = Typography()

val beHumanTypography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = notoSansFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = notoSansFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = notoSansFamily),
    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = notoSansFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = notoSansFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = notoSansFamily),
    titleLarge = defaultTypography.titleLarge.copy(fontFamily = notoSansFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = notoSansFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = notoSansFamily),
    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = notoSansFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = notoSansFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = notoSansFamily),
    labelLarge = defaultTypography.labelLarge.copy(fontFamily = notoSansFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = notoSansFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = notoSansFamily)
)
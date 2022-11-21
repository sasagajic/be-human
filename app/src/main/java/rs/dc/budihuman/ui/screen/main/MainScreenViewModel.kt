package rs.dc.budihuman.ui.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import rs.dc.budihuman.model.Beneficiary
import rs.dc.budihuman.repository.BeneficiaryRepository


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: BeneficiaryRepository
) : ViewModel() {

    private val _beneficiaries = MutableLiveData<List<Beneficiary>>()
    val beneficiaries: LiveData<List<Beneficiary>> = _beneficiaries

    fun fetchBeneficiaries() {
        viewModelScope.launch {
            val response = repository.getBeneficiaries()
            _beneficiaries.value = response
        }
    }

    fun sendSms(context: Context, userId: String) {
        val uri: Uri = Uri.parse("smsto:3030")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", userId)
        context.startActivity(intent)
    }

}


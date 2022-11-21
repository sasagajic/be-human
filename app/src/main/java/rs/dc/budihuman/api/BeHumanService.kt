package rs.dc.budihuman.api

import retrofit2.http.GET
import retrofit2.http.Query
import rs.dc.budihuman.api.response.BeneficiariesResponse

interface BeHumanService {

    @GET("api/beneficiaries")
    suspend fun beneficiaries(
        @Query("page") page: Int? = 1,
        @Query("rows_per_page") perPage: Int? = 10
    ): BeneficiariesResponse

}
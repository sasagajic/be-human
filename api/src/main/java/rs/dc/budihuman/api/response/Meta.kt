package rs.dc.budihuman.api.response

import com.google.gson.annotations.SerializedName

data class Meta(
    val page: Int,
    @SerializedName("rows_per_page")
    val rowsPerPage: Int,
    @SerializedName("total_rows")
    val totalRows: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)
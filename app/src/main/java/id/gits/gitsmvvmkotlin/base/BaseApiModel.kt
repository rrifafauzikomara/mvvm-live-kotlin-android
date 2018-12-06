package id.gits.gitsmvvmkotlin.base

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

data class BaseApiModel<T>(
        var page: Int,
        var total_results: Int,
        var total_pages: Int,
        var results: T? = null

        //Todo code above just for testing. Change it with real base response from API
)
package test.huge.currencyconverter.rest;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import test.huge.currencyconverter.rest.model.CurrencyResponse;

/**
 * Created by David Alejandro Burgos on 3/10/16 11:12 AM.
 *
 */

public interface ApiService {

    @GET("/latest")
    void getRates(@Query("base") String base,
                  @Query("symbols") String CurrencyList,
                  Callback<CurrencyResponse> response);

}

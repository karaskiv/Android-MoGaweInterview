package space.karaskiv.ok1;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserService {

        @POST("api/mogawers/logIn")
        Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

        @POST("api/mogawers/logIn")
        Call<ProfileResponse> getProfile(@Header("token") String authToken);
}

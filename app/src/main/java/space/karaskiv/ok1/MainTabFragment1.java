package space.karaskiv.ok1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainTabFragment1 extends Fragment {

    EditText email, password;
    TextView lupaPass;
    Button btnLogin;

    public byte[] hash(String password) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] passBytes = password.getBytes();
        byte[] passHash = sha256.digest(passBytes);
        return passHash;
    }

    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_main_tab_fragment1, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        lupaPass = root.findViewById(R.id.lupaPass);
        btnLogin = root.findViewById(R.id.btnLogin);

        email.setTranslationX(800);
        password.setTranslationX(800);
        lupaPass.setTranslationX(800);
        btnLogin.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        lupaPass.setAlpha(v);
        btnLogin.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        lupaPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(getActivity(), "Email / Password required", Toast.LENGTH_LONG).show();
                } else{


                    login();
                }

            }
        });
        return root;
    }

    private static String token;

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_LONG).show();
                    token = response.body().getToken();

                    Intent intent = new Intent(getActivity(), Activity2.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}


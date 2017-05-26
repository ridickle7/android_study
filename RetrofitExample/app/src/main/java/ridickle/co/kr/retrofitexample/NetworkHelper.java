package ridickle.co.kr.retrofitexample;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by ridickle on 2016. 12. 5..
 */

public class NetworkHelper {

    public static NetworkHelper networkHelper;
    public Retrofit retrofit;
    public static NetworkInterface service;
    public static String baseURL = "http://211.249.50.198:8080";

    private NetworkHelper(){
    }

    public static NetworkInterface getInstance(){
        if(networkHelper == null){
            service = new Retrofit.Builder()
                    .baseUrl("baseURL")
                    .client(getRequestHeader())
                    .addConverterFactory(GsonConverterFactory.create())             //Json Parser 추가
                    .build().create(NetworkInterface.class);                     //인터페이스 연결

        }
        return service;
    }

    private static OkHttpClient getRequestHeader() {
        OkHttpClient httpClient = getUnsafeOkHttpClient();      // 인증서 무시
        return httpClient;
    }

    /**
     * UnCertificated 허용
     */
    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder
                    .connectTimeout(15, TimeUnit.SECONDS)       // 연결 타임아웃 시간 설정
                    .writeTimeout(15, TimeUnit.SECONDS)         // 쓰기 타임아웃 시간 설정
                    .readTimeout(15, TimeUnit.SECONDS)          // 읽기 타임아웃 시간 설정
                    .build();

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

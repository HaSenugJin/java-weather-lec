package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Http {

    public String 주소요청(List<Integer> 위경도) {
        HttpClient httpClient = HttpClient.newHttpClient();

        String url = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
        String serviceKey = "Pfdf1qCJdZXMstAVlTBGLP4EdUkT7G52wJAEIUTQcnzx%2BQ2Qe7F6eyoSn0hLQ0fMba62l3I%2BI8g4yqpKz9qxnw%3D%3D";
        String baseDate = "20240607";
        String baseTime = "1400";
        Integer nx = 위경도.get(0);
        Integer ny = 위경도.get(1);

        String uriAndParams = "$uri?serviceKey=$serviceKey&base_date=$baseDate&base_time=$baseTime&nx=$nx&ny=$ny&dataType=json&pageNo=1&numOfRows=1000"
                .replace("$uri", url)
                .replace("$serviceKey", serviceKey)
                .replace("$baseDate", baseDate)
                .replace("$baseTime", baseTime)
                .replace("$nx", nx.toString())
                .replace("$ny", ny.toString());

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uriAndParams))
                .build();

        HttpResponse<String> response = null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }
}

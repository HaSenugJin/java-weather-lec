package weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dto.Request;
import gson.Gson;
import http.Http;
import mysql.Mysql;

import java.util.List;
import java.util.Scanner;

public class WeatherApp {
    public void 실행() {
        Mysql mysql = new Mysql();
        Scanner sc = new Scanner(System.in);
        Http http = new Http();
        Gson gson = new Gson();
        String yn;
        while (true) {

            String 사용자입력구;
            String 사용자입력동;
            System.out.println("날씨를 알고자 하는 구를 입력하여 주세요.");
            System.out.println("예) 종로구, 수영구 등");
            사용자입력구 = sc.nextLine();

            List<String> 동리스트 = mysql.구검색(사용자입력구);

            if (동리스트.isEmpty()) {
                System.out.println("구를 정확히 입력하여 주십시오.");
                continue;
            }

            System.out.println("입력한 구 : " + 사용자입력구);
            System.out.println("동을 선택하여 주세요.");

            System.out.println("입력한 구에서 선택 가능한 동은 " + 동리스트 + "입니다.");
            사용자입력동 = sc.nextLine();

            List<Integer> 위경도 = mysql.동검색(사용자입력동);

            if (위경도.isEmpty()) {
                System.out.println("동을 정확히 입력하여 주십시오.");
                continue;
            }

            System.out.println("입력한 동 : " + 사용자입력동);
            String 주소요청 = http.주소요청(위경도);
            JsonArray jsonArray = gson.Json(주소요청);

            Request.DTO dto = new Request.DTO();

            // itemList에서 "category"가 "T1H"인 객체를 찾아서 obsrValue 값을 출력
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject item = jsonArray.get(i).getAsJsonObject();
                String category = item.get("category").getAsString();
                dto.setCategory(category);
                if (category.equals("T1H")) {
                    dto.setObsrValue(item.get("obsrValue").getAsString());
                }
            }

            System.out.println("온도 : " + dto.getObsrValue());

            System.out.println("온도를 더 찾아보시겠습니까? y / n");
            yn = sc.nextLine();

            if (yn.equals("y")) {
                System.out.println("온도를 더 찾습니다.");
                continue;
            } else if (yn.equals("n")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("y 또는 n을 정확히 입력하여 주십시오.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
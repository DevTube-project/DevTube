package com.hongik_university.toy_project.Devtube.service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongik_university.toy_project.Devtube.domain.BigField;
import com.hongik_university.toy_project.Devtube.domain.Lecture;
import com.hongik_university.toy_project.Devtube.domain.SmallField;
import com.hongik_university.toy_project.Devtube.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureService {
    private final LectureRepository lectureRepository;
    @Transactional
    public Long save(String apiUrl, BigField bigField, SmallField smallField){
        // API 호출
        RestTemplate restTemplate = new RestTemplate();
        //응답 받기
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        //응답 데이터 추출
        String apiResponse = response.getBody();
        //Json 데이터 파싱
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode jsonNode = objectMapper.readTree(apiResponse);
            //필요한 정보만 추출
            String title = jsonNode.get("items").get(0).get("snippet").get("title").asText();
            String url = "https://www.youtube.com/playlist?list="+jsonNode.get("items").get(0).get("id").asText();
            String channelTitle = jsonNode.get("items").get(0).get("snippet").get("channelTitle").asText();
            String imageUrl = jsonNode.get("items").get(0).get("snippet").get("thumbnails").get("high").get("url").asText();

            Lecture lecture = Lecture.builder().title(title).url(url)
                    .channelTitle(channelTitle).imageUrl(imageUrl)
                    .bigField(bigField).smallField(smallField).build();
            return lectureRepository.save(lecture).getLectureId();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public void create(){
        String apiUrl = "https://www.googleapis.com/youtube/v3/playlists?part=snippet&key=AIzaSyBlAPO-tHgidphqbZQoc6vzaH4CdryTsX8&id=";
        Map<String ,SmallField> playlist= new LinkedHashMap<>();
        // 각 작은 분야에 해당 되는 큰 분야들을 Map 으로 매핑
        Map<SmallField, BigField> fieldMapping = Map.ofEntries(
                Map.entry(SmallField.JAVA, BigField.BASIC),
                Map.entry(SmallField.PYTHON, BigField.BASIC),
                Map.entry(SmallField.CPP, BigField.BASIC),
                Map.entry(SmallField.C, BigField.BASIC),
                Map.entry(SmallField.JS, BigField.BASIC),
                Map.entry(SmallField.FLUTTER, BigField.MOBILE),
                Map.entry(SmallField.NATIVE, BigField.MOBILE),
                Map.entry(SmallField.REACT, BigField.WEB),
                Map.entry(SmallField.VUE, BigField.WEB),
                Map.entry(SmallField.SPRING, BigField.WEB),
                Map.entry(SmallField.DJANGO, BigField.WEB),
                Map.entry(SmallField.UNITY, BigField.GAME),
                Map.entry(SmallField.UNREAL, BigField.GAME),
                Map.entry(SmallField.ALGORITHM, BigField.CS),
                Map.entry(SmallField.OS, BigField.CS)
        );
        playlist.put("PLuHgQVnccGMCeAy-2-llhw3nWoQKUvQck", SmallField.JAVA);
        playlist.put("PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp", SmallField.JAVA);
        playlist.put("PLU9-uwewPMe2AX9o9hFgv-nRvOcBdzvP5", SmallField.PYTHON);
        playlist.put("PLz2iXe7EqJOOTNTK27a4-WsgZU5NVfguh", SmallField.PYTHON);
        playlist.put("PLNfg4W25Tapw5Yx4yuExHNybBIUk68aNz",SmallField.CPP);
        playlist.put("PLRx0vPvlEmdDNHeulKC6JM25MmZVS_3nT",SmallField.C);
        playlist.put("PLuHgQVnccGMA4uSig3hCjl7wTDeyIeZVU",SmallField.JS);
        playlist.put("PLFeNz2ojQZjv41Q5cCw8blOpGTTrZS5PU",SmallField.JS);
        playlist.put("PLfLgtT94nNq1izG4R2WDN517iPX4WXH3C",SmallField.FLUTTER);
        playlist.put("PLPtc9qD1979A8rRP0-YAUQMFImze5PnFN",SmallField.FLUTTER);
        playlist.put("PLaHIVvYn0_AvI_qfaPTi1Wm4gioyWP-KZ",SmallField.NATIVE);
        playlist.put("PL60Uti4nULBN7EQYmgjksXJXnkufo0m-9",SmallField.NATIVE);
        playlist.put("PLfLgtT94nNq0qTRunX9OEmUzQv4lI4pnP",SmallField.REACT);
        playlist.put("PLuHgQVnccGMCOGstdDZvH41x0Vtvwyxu7",SmallField.REACT);
        playlist.put("PLfLgtT94nNq3Br68sEe26jkOqCPK_8UQ-",SmallField.VUE);
        playlist.put("PLB7CpjPWqHOu6NnQJEGbofB5KO1j2ab9I",SmallField.VUE);
        playlist.put("PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd",SmallField.SPRING);
        playlist.put("PLyebPLlVYXCiYdYaWRKgCqvnCFrLEANXt",SmallField.SPRING);
        playlist.put("PLi4xPOplIq7d1vDdLBAvS5PmQR-p6KwUz",SmallField.DJANGO);
        playlist.put("PLuHgQVnccGMDLp4GH-rgQhVKqqZawlNwG",SmallField.DJANGO);
        playlist.put("PLO-mt5Iu5TeYI4dbYwWP8JqZMC9iuUIW2",SmallField.UNITY);
        playlist.put("PLC2Tit6NyVieQ6vVq9HX9zEJKjPZ8QNcn",SmallField.UNITY);
        playlist.put("PLxN-zf3BqZZl5dtnX0bgqYf8LDM3rn-Hs", SmallField.UNREAL);
        playlist.put("PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz",SmallField.ALGORITHM);
        playlist.put("PLFgS-xIWwNVX-zm4m6suWC9d7Ua9z7fuT", SmallField.ALGORITHM);
        playlist.put("PLVsNizTWUw7FCS83JhC1vflK8OcLRG0Hl", SmallField.OS);
        playlist.put("PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN", SmallField.OS);

        for (Map.Entry<String, SmallField> entry : playlist.entrySet()) {
            // 각 키 값은 플레이리스트 id 값
            String entireUrl = apiUrl + entry.getKey();
            BigField bigField = fieldMapping.getOrDefault(entry.getValue(), BigField.CS);
            save(entireUrl, bigField, entry.getValue());
        }
    }
    public Lecture findById(Long id){
        return lectureRepository.findById(id).orElseThrow(()->new IllegalArgumentException(id+"의 강의를 찾을 수 없습니다."));
    }
}


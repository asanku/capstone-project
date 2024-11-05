package com.ust.AthleteWellnessService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.AthleteWellnessService.dto.AthleteDTO;
import com.ust.AthleteWellnessService.feignClient.AthleteClient;
import com.ust.AthleteWellnessService.model.DailyPerformance;
import com.ust.AthleteWellnessService.model.Goal;
import com.ust.AthleteWellnessService.model.Recommendation;
import com.ust.AthleteWellnessService.repository.DailyPerformanceRepository;
import com.ust.AthleteWellnessService.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.json.JSONObject;

@Service
@AllArgsConstructor
public class PerformanceServiceImpl implements PerformanceService{

    private DailyPerformanceRepository dailyPerformanceRepository;

    private GoalRepository goalRepository;

    private RestTemplate restTemplate;

    private AthleteClient athleteClient;

    // API_URL_TEMPLATE

// remove the below comment before execution
    

    @Override
    public Goal createGoal(Goal goal) {
        Optional<AthleteDTO> dto = athleteClient.findAthlete(goal.getAthleteId());
        if(dto.isPresent()){
            Optional<Goal> plan = goalRepository.findByAthleteId(goal.getAthleteId());
            if(plan.isPresent()){
                goal.setAthleteId(plan.get().getAthleteId());
                //goalRepository.save(goal);
            }
            return goalRepository.save(goal);
        }
        else{
            throw new RuntimeException("Athlete Not Found");
        }
    }

    @Override
    public DailyPerformance createDailyPerformance(String id, DailyPerformance dailyPerformance) {
        Optional<AthleteDTO> dto = athleteClient.findAthlete(id);
        if(dto.isPresent()) {
            dailyPerformance.setAthleteId(id);
            return dailyPerformanceRepository.save(dailyPerformance);
        }
        else {
            throw new RuntimeException("Athlete Not Found");
        }
    }

    @Override
    public List<DailyPerformance> getDailyPerformance(String athleteId) {
        Optional<AthleteDTO> dto = athleteClient.findAthlete(athleteId);
        if(dto.isPresent()) {
            return dailyPerformanceRepository.findAllByAthleteId(athleteId);
        }
        else{
            throw new RuntimeException("Athlete Not Found");
        }
    }

    @Override
    public Recommendation getRecommandations(String athleteId) throws JsonProcessingException {

        // Fetch the goal information for the athlete
        Goal goal = goalRepository.findByAthleteId(athleteId).orElseThrow(
                () -> new RuntimeException("Athlete Not found")
        );

        // Set up HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openAiApiKey); // Use the OpenAI API key for authentication

        // Correct the JSON schema format
        String jsonformat = "{ \"type\": \"object\", \"properties\": { \"foodType\": {\"type\": \"string\"}, \"proteins\": {\"type\": \"string\"}, \"calories\": {\"type\": \"string\"} } }";

        // Formulate the prompt based on the athlete's goal
        String prompt = "Generate a dummy (not real) JSON response that follows this schema: " + jsonformat
                + " for a person whose daily calorie goal is " + goal.getDailyCalories()
                + ", target weight is " + goal.getTargetWeight()
                + " and has a preference for " + goal.getPreference() + " and for proteins," +
                " only provide the foods name that has the required proteins. Only provide JSON, no other response.";

        // Create request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-4o-mini");

        // Initialize the "messages" array and add the system and user content
        JSONArray messagesArray = new JSONArray();
        messagesArray.put(new JSONObject().put("role", "system").put("content", "You are a helpful assistant."));
        messagesArray.put(new JSONObject().put("role", "user").put("content", prompt));

        requestBody.put("messages", messagesArray); // Add the messages array to the request body

        // Create the HTTP entity with headers and request body
        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);

        // Send the request to OpenAI API and get the response
        ResponseEntity<String> response = restTemplate.exchange(API_URL_TEMPLATE, HttpMethod.POST, entity, String.class);

        // Log the raw response for debugging
        String responseBody = response.getBody();
        System.out.println("Raw API Response: " + responseBody);

        ObjectMapper objectMapper = new ObjectMapper();

        // Check if the response contains JSON content and extract it carefully
        try {
            // Extract the text content from the response (adjust based on actual API response structure)
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode textNode = rootNode.path("choices").get(0).path("message").path("content");

            // Convert the extracted JSON string into a Recommendation object
            String jsonString = textNode.asText(); // Assuming the text node contains a JSON-formatted string
            System.out.println("Extracted JSON: " + jsonString);
            //return jsonString;

           // String sanitizedResponse = response.replace("`", "").trim();

            // Parse the JSON string into a Recommendation object
            jsonString = jsonString.replace("```json", "").replace("```", "").trim();
            Recommendation recommendation = objectMapper.readValue(jsonString, Recommendation.class);
            return recommendation;
//
//            return recommendation;
        } catch (Exception e) {
            // Log the error and response for further debugging
            System.err.println("Error parsing response: " + responseBody);
            e.printStackTrace();
            throw new RuntimeException("Failed to parse OpenAI response", e);
        }

    }

//    @Override
//    public Recommendation getRecommandations(String athleteId) throws JsonProcessingException {
//
//        Goal goal = goalRepository.findByAthleteId(athleteId).orElseThrow(
//                () ->  new RuntimeException("Athlete Not found")
//        );
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(openAiApiKey);
//        //headers.set("Authorization", "Bearer " + openAiApiKey);
////        headers.setBearerAuth(openAiApiKey);
//
//        String jsonformat = "{ \\\"type\\\": \\\"object\\\", \\\"properties\\\": { \\\"foodType\\\": {\\\"type\\\": \\\"string\\\"}, \\\"proteins\\\": {\\\"type\\\": \\\"string\\\"}, \\\"calories\\\": {\\\"type\\\": \\\"string\\\"} } }";
//
//        String prompt = "Generate a dummy (not real) JSON response that follows this schema: "+ jsonformat
//                + " for a person whose daily calorie goal is "+ goal.getDailyCalories()+", target weight is " +goal.getTargetWeight()+
//                " and has a preference for "+goal.getPreference()+". Only provide JSON, no other response.";
//
//        // Create request body
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("model", "gpt-4o-mini");
////        requestBody.put("messages", Collections.singletonList(
////                new JSONObject().put("role", "system").put("content", "You are a helpful assistant.")
////        ));
//        requestBody.getJSONArray("messages").put(
//                new JSONObject().put("role", "user").put("content", prompt)
//        );
//
//        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(API_URL_TEMPLATE, HttpMethod.POST, entity, String.class);
//
//        String responseBody = response.getBody();
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Parsing the API response to extract the JSON text from the nested structure
//        JsonNode rootNode = objectMapper.readTree(responseBody);
//        JsonNode textNode = rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text");
//
//        // Convert the text node (which is a JSON string) into an actual JSON object
//        String jsonString = textNode.asText();
//
//        Recommendation recommendation = objectMapper.readValue(jsonString, Recommendation.class);
//        return recommendation;
////        if (response.getStatusCode() == HttpStatus.OK) {
////            JSONObject jsonResponse = new JSONObject(response.getBody());
////            return jsonResponse
////                    .getJSONArray("choices")
////                    .getJSONObject(0)
////                    .getJSONObject("message")
////                    .getString("content").trim();
////        } else {
////            return "Error: Failed to fetch response from OpenAI";
////        }
//    }


}

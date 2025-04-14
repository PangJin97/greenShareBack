package weather;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class WeatherController {

  private final WeatherApiService weatherApiService;

  @GetMapping("/api/info")
  public ResponseEntity<WeatherResponse> getWeatherInfo(@RequestParam String city) {
    WeatherResponse response = weatherApiService.getWeatherData(city);
    return ResponseEntity.ok(response);
  }
}


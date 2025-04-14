package weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {

  @Value("${weather.api.url}")
  private String apiUrl;

  @Value("${weather.api.key}")
  private String apiKey;

  public WeatherResponse getWeatherData(String city) {
    String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&lang=kr&units=metric";

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, WeatherResponse.class);
  }
}

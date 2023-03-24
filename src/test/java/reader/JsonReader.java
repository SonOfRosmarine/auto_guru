package reader;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonReader {

    private ClassLoader classLoader = JsonReader.class.getClassLoader();


    @Test
    @DisplayName("Чтение Json")
    void gsonRead() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = classLoader.getResourceAsStream("Json.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            PostCard postCard = gson.fromJson(isr, PostCard.class);

            Assertions.assertEquals("3FQF1UEFGUXG6NFL", postCard.id);
            Assertions.assertEquals("Sofia Barfield", postCard.name);
            Assertions.assertEquals("2014-11-18", postCard.dob);
            Assertions.assertEquals("+260-5999-735-177", postCard.telephone);
            Assertions.assertEquals(List.of("Dexter", "Bentley"), postCard.pets);
            Assertions.assertEquals("1.5", postCard.score);
            Assertions.assertEquals("hanh-sutter86240@garage.com", postCard.email);
            Assertions.assertEquals("https://www.oklahoma.com", postCard.url);
            Assertions.assertEquals("funds pediatric ruled cards powered shark shoe surplus payday convicted " +
                    "funk paying whenever loving internship are depend " +
                    "believed sticker indie", postCard.description);
            Assertions.assertEquals(true, postCard.verified);
            Assertions.assertEquals(34998, postCard.salary);

        }


    }
}

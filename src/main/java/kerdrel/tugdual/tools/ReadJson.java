package kerdrel.tugdual.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

public class ReadJson {


    public String getJsonFile(String filename){
        String jsonText = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while((line = bufferedReader.readLine()) != null){
                jsonText += line + "\n";
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return jsonText;
    }

    public void jsonParser() throws JsonException {
        String json;
        json = (String) Jsoner.deserialize(getJsonFile("../ressources/text.json"));
        System.out.println(json);
    }
}

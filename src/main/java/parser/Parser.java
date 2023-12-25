package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;


public class Parser {
    public static void main(String[] args) {
        try {
            Date currentDate = new Date();
            String shop = "Глобус";
            PrintStream out = new PrintStream(System.out, true, "UTF-8");

            Elements[] elems = new Elements[3];
            for (int i = 1; i < 10; i++) {
                //страница
                String page = "https://www.globus.ru/catalog/molochnye-produkty-syr-yaytsa/moloko-i-molochnye-produkty/moloko/" + "?page=" + i;
                // var document = Jsoup.connect(page).get();
                Document document = Jsoup.parse(new URL(page).openStream(), "UTF-8", page);
                //цена
                elems[0] = document.getElementsByClass("pim-list__item-price-actual-main");
                //название
                elems[1] = document.getElementsByClass("pim-list__item-title js-crop-text");
                //картинка
                elems[2] = document.getElementsByClass("pim-list__item-img");

                for (int k = 0; k < (elems[1].size() - 1); k++) {
                    out.println(elems[1].get(k).text());
                    if (elems[1].get(k).text().equals("Молоко для капучино ультрапастеризованное Петмол Barista 3,2%, 950 мл")) {
                        try {
                            URL url = new URL("http://localhost:8080/base/add");

                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.setDoOutput(true);

                            String body = "{\"price\": " + Integer.parseInt(elems[0].get(k).text()) + ", \"time\":" + currentDate.getDate() + ",\"product\":{\"id\": 1}, \"shop\": {\"id\": 3}}";
                            connection.setRequestProperty("Accept-Charset", "UTF-8");
                            connection.setRequestProperty("Content-Type", "application/json;charset=" + "UTF-8");
                            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                            writer.write(body);
                            writer.flush();

                            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            String line;
                            StringBuilder response = new StringBuilder();
                            while ((line = reader.readLine()) != null) {
                                response.append(line);
                            }
                            reader.close();

                            // Выводим ответ от сервера
                            System.out.println(response.toString());
                            System.out.println("!");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

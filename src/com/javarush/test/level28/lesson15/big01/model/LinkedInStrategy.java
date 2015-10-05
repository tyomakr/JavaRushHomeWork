package com.javarush.test.level28.lesson15.big01.model;


import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedInStrategy implements Strategy {

    private static final String URL_FORMAT = "https://www.linkedin.com/job/java-jobs-%s/?page_num=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {

        /** ТУТ КУСОК КОДА С HHSTRATEGY, РАБОЧИЙ ВАРИАНТ БУДЕТ НАПИСАН ПОСЛЕ ТОГО, КАК БУДУТ ГОТОВЫ РАБОЧИЕ ПРОВЕРКИ ЗАДАНИЯ

        List<Vacancy> vacancies = new ArrayList<>();
        int pageNumber = 0;

        try {

            while (true) {
                //Получаем документ для парсинга и увеличиваем счетчик страниц
                Document doc = getDocument(searchString, pageNumber++);

                //делаем выборку с указанными аттрибутами
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

                //Если вакансий нет - выходим из цикла
                if (elements.size() == 0) break;

                //парсим
                for (Element element : elements) {

                    //создаем новую вакансию
                    Vacancy vacancy = new Vacancy();

                    Element titleE = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").first();
                    vacancy.setTitle(titleE.text());

                    Element salaryE = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").first();
                    if (salaryE != null) {
                        vacancy.setSalary(salaryE.text());
                    } else {
                        vacancy.setSalary("");
                    }

                    Element cityE = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").first();
                    vacancy.setCity(cityE.text());

                    Element companyNameE = element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-employer").first();
                    vacancy.setCompanyName(companyNameE.text());

                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));

                    vacancy.setSiteName(doc.title());

                    vacancies.add(vacancy);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vacancies;
    }


    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
                .referrer("none")
                .timeout(5 * 1000)
                .get();

        return doc;
    }
**/

        return null;
    }
}

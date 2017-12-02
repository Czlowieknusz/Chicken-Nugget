import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;

public class PobieranieZInternetu {

    public DefaultListModel getItemsList(List<String> queries) throws IOException {
        String query = fromListToString(queries);
        String allInfo = readFromGoogle(query);
        return getLinks(allInfo);
    }
    
    public List<String> getSynonimsList(String word) throws IOException{
        String allInfo = readFromSynonimsDirectory(word);
        List<String> synonims = getSynonimsFromAllInfo(allInfo);
        return synonims;
    }

    private String fromListToString(List<String> queries) {
        String result = "";
        for (String i : queries) {
            result += i + "+";
        }
        return result;
    }

    private String readFromGoogle(String key) throws IOException {
        String allinfo = "";
        String url = "http://www.google.com/search?q=";
        String charset = "UTF-8";
        String query = String.format("%s", URLEncoder.encode(key, charset));
        URLConnection con = new URL(url + query).openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            allinfo += inputLine;
        }
        in.close();
        return allinfo;
    }

    private String readFromSynonimsDirectory(String word) throws IOException {
        String allinfo = "";
        String url = "https://wordassociations.net/en/words-associated-with/";
        String charset = "UTF-8";
        String query = String.format("%s", URLEncoder.encode(word, charset));
        URLConnection con = new URL(url + query).openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            allinfo += inputLine;
        }
        in.close();
        return allinfo;
    }

    private List<String> getSynonimsFromAllInfo(String infoFromWeb) throws IOException {
        List<String> synonims = new LinkedList<>();
        String[] temp = infoFromWeb.split("(>)|(;)");
        int counter = 0;
        for (String xx : temp) {
            if (xx.matches(("^<a href=.*")) && xx.matches(".*words-associated-with.*")) {
                synonims.add(xx.substring(35, xx.length() - 1));
                counter++;
            }
            if (counter > 10) {
                return synonims;
            }
        }
        return synonims;
    }

    private DefaultListModel getLinks(String allinfo) {
        DefaultListModel links = new DefaultListModel();
        String[] temp = allinfo.split("(>)|(;)");
        int counter = 0;
        for (String xx : temp) {
            if (xx.matches(("^<a href=.*")) && xx.matches(".*http.*") && !xx.matches((".*google.*"))) {
                links.addElement(xx.substring(16, xx.length() - 4));
                counter++;
            }
            if (counter > 2) {
                return links;
            }
        }
        return links;
    }
}
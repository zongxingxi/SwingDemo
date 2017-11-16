package swingdemo;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SwingControl {
    public static final String FilePath = "data,txt";

    public SwingControl() {

    }

    public String[] GetUrlAndIds(String CardId) {
        String[] result = new String[2];
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FilePath);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if (-1 != sCurrentLine.indexOf(CardId))
                {
                    result[0] = br.readLine().split(": ")[1];
                    result[1] = br.readLine().split(": ")[1];
                }
            }
        } catch (Exception e) {
        }
        return result;
    }

    public void Save(String cardId, String Url) throws IOException {
        File dataFile = new File(FilePath);
        //try {
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        //}

        FileWriter writer = new FileWriter(dataFile);
        PrintWriter print = new PrintWriter(writer);

        print.println("CardId: " + cardId);
        print.println("URL: " + Url);
        print.println("itemIds: " + GetItemIds(Url));

        print.close();
    }

    private String GetItemIds(String Url) {
        String itemIds = "";
        String urlDecoder = null;
        try {
            urlDecoder = URLDecoder.decode(Url, "UTF-8");
        } catch (Exception e) {
            //todo
        }
        //String urltemp = "http://localhost:8080/swing/get?param=str_item:\"[itemid1, itemid2, itemid3]\", str_item_id:\"[]\"";
//        try {
//            urltemp = URLEncoder.encode(urltemp, "UTF-8");
//        } catch (Exception e) {
//        }
        Pattern itemPattern = Pattern.compile("itemid[^],].*?");
        Pattern pattern = Pattern.compile("(str_item:|str_item_id:).*?]\"");
        Matcher matcher = pattern.matcher(urlDecoder);
        while (matcher.find()) {
            String result = matcher.group();
            Matcher result_matcher = itemPattern.matcher(result);
            while (result_matcher.find()) {
                String item = result_matcher.group();
                itemIds += item + " ";
            }
        }
        return itemIds;
    }
//    private void CheckFile() throws IOException {
//        File dataFile = new File(FilePath);
//        //try {
//        if (!dataFile.exists()) {
//            dataFile.createNewFile();
//        }
//        //}
//
//        FileWriter writer = new FileWriter(dataFile);
//        PrintWriter print = new PrintWriter(writer);
//
//        print.println("CardId: " + );
//
//        print.close();
//    }
}

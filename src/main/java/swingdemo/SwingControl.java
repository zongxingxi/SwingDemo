package swingdemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class SwingControl {
    public static final String FilePath = "data,txt";

    public SwingControl() {
        int a = 1;
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

        print.println("CardId: " +  cardId);
        print.println("URL: " + Url);
        //print.println("itemIds: " + GetItemIds(Url));

        print.close();
    }

    private void GetItemIds(String Url)
    {

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

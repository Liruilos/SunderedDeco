import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class LootTableGenerator {

    private static ArrayList<String> blockList = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public static void main( String[] args ) {

        try{
            addStringsFromFile();
        }catch(IOException e){
            e.printStackTrace();
        }


        for (String s : blockList) {

            File dir = new File("D:\\Users\\Lauren\\Documents\\GitHub\\SunderedDeco\\src\\main\\resources\\data\\sundereddeco\\loot_tables\\blocks");

            JSONObject loot_table = new JSONObject();

            loot_table.put("type", "minecraft:block");
            JSONArray pools = new JSONArray();
            loot_table.put("pools", pools);

            JSONObject pool1 = new JSONObject();
            pools.add(pool1);
            pool1.put("name", "pool1");
            pool1.put("rolls", 1);
            JSONArray entries = new JSONArray();
            pool1.put("entries", entries);

            JSONObject entry1 = new JSONObject();
            entries.add(entry1);
            entry1.put("type", "minecraft:item");
            entry1.put("name", "sundereddeco:" + s);

            JSONArray conditions = new JSONArray();
            pool1.put("conditions", conditions);

            JSONObject condition1 = new JSONObject();
            conditions.add(condition1);
            condition1.put("condition", "minecraft:survives_explosion");

            File file = new File(dir, s + ".json");
            if (!file.exists()) {
                //Write JSON file
                try (FileWriter writer = new FileWriter(file)) {

                    writer.write(loot_table.toJSONString());
                    writer.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void addStringsFromFile() throws IOException {
        File dir = new File("D:\\Users\\Lauren\\Documents\\GitHub\\SunderedDeco\\helpertools\\src\\main\\resources");
        File file = new File(dir, "RegistryList.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        try {
            while((line = reader.readLine()) != null) {
                blockList.add(line);
            }

        } finally {
            reader.close();
        }
    }
}

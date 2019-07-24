import net.grallarius.sundereddeco.item.ModItems;
import net.minecraft.item.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LootTableGenerator {


    @SuppressWarnings("unchecked")
    public static void main( String[] args ) {

        ArrayList<String> blockList = new ArrayList<>();

/*        for (Item i :ModItems.itemBlocks){
            blockList.add(i.getRegistryName().toString());
        }*/

        blockList.add("table");

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


            //Write JSON file
            try (FileWriter file = new FileWriter(new File(dir, s + ".json"))) {

                file.write(loot_table.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

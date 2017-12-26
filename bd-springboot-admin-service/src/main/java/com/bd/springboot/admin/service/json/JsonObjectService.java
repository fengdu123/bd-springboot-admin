package com.bd.springboot.admin.service.json;

import com.google.gson.*;


/**
 * 所在的包名: com.bd.springboot.admin.service.json
 * 所在的项目名：bd-springboot-admin
 *
 * @author:wangyp
 * @Description:
 * @Date: Created in 11:33 2017/12/26
 */
public class JsonObjectService {

    /**
     * 我们通过Gson进行解析，所以在使用前需要导入Gson.jar
     * 解析json数据时，
     * 1.需要进行创建Gson解析器
     * 2.创建JSONObject对象
     * 3.将json数据转为为相应的数据
     * @param args
     */
    public static void main(String[] args) {

        /** 创建json解析器 */
        JsonParser parse =new JsonParser();

        String jsonStr = "{\n" +
                "    \"resultcode\": \"200\",\n" +
                "    \"reason\": \"successed!\",\n" +
                "    \"result\": {\n" +
                "        \"sk\": {\n" +
                "            \"temp\": \"24\",\n" +
                "            \"wind_direction\": \"西南风\",\n" +
                "            \"wind_strength\": \"2级\",\n" +
                "            \"humidity\": \"51%\",\n" +
                "            \"time\": \"10:11\"\n" +
                "        },\n" +
                "        \"today\": {\n" +
                "            \"temperature\": \"16℃~27℃\",\n" +
                "            \"weather\": \"阴转多云\",\n" +
                "            \"weather_id\": {\n" +
                "                \"fa\": \"02\",\n" +
                "                \"fb\": \"01\"\n" +
                "            },\n" +
                "            \"wind\": \"西南风3-4 级\",\n" +
                "            \"week\": \"星期四\",\n" +
                "            \"city\": \"滨州\",\n" +
                "            \"date_y\": \"2015年06月04日\",\n" +
                "            \"dressing_index\": \"舒适\",\n" +
                "            \"dressing_advice\": \"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。\",\n" +
                "            \"uv_index\": \"最弱\",\n" +
                "            \"comfort_index\": \"\",\n" +
                "            \"wash_index\": \"较适宜\",\n" +
                "            \"travel_index\": \"\",\n" +
                "            \"exercise_index\": \"较适宜\",\n" +
                "            \"drying_index\": \"\"\n" +
                "        },\n" +
                "        \"future\": [\n" +
                "            {\n" +
                "                \"temperature\": \"16℃~27℃\",\n" +
                "                \"weather\": \"阴转多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"02\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"西南风3-4 级\",\n" +
                "                \"week\": \"星期四\",\n" +
                "                \"date\": \"20150604\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"20℃~32℃\",\n" +
                "                \"weather\": \"多云转晴\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"00\"\n" +
                "                },\n" +
                "                \"wind\": \"西风3-4 级\",\n" +
                "                \"week\": \"星期五\",\n" +
                "                \"date\": \"20150605\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"23℃~35℃\",\n" +
                "                \"weather\": \"多云转阴\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"02\"\n" +
                "                },\n" +
                "                \"wind\": \"西南风3-4 级\",\n" +
                "                \"week\": \"星期六\",\n" +
                "                \"date\": \"20150606\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"20℃~33℃\",\n" +
                "                \"weather\": \"多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"北风微风\",\n" +
                "                \"week\": \"星期日\",\n" +
                "                \"date\": \"20150607\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"22℃~34℃\",\n" +
                "                \"weather\": \"多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"西南风3-4 级\",\n" +
                "                \"week\": \"星期一\",\n" +
                "                \"date\": \"20150608\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"22℃~33℃\",\n" +
                "                \"weather\": \"阴\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"02\",\n" +
                "                    \"fb\": \"02\"\n" +
                "                },\n" +
                "                \"wind\": \"西南风3-4 级\",\n" +
                "                \"week\": \"星期二\",\n" +
                "                \"date\": \"20150609\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"22℃~33℃\",\n" +
                "                \"weather\": \"多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"南风3-4 级\",\n" +
                "                \"week\": \"星期三\",\n" +
                "                \"date\": \"20150610\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"error_code\": 0\n" +
                "}";

        try {
            /** 创建jsonObject对象 */
            JsonObject json = (JsonObject) parse.parse(jsonStr);

            /** 将json数据转为为int型的数据*/
            System.out.println("resultcode :" + json.get("resultcode").getAsInt());

            /** 将json数据转为为String型的数据*/
            System.out.println("reason :" + json.get("reason").getAsString());
            System.out.println("error_code :" + json.get("error_code").getAsInt());

            JsonObject result = json.get("result").getAsJsonObject();
            JsonObject today = result.get("today").getAsJsonObject();
            System.out.println("temperature :" + today.get("temperature").getAsString());
            System.out.println("weather :" + today.get("weather").getAsString());

            JsonObject sk = result.get("sk").getAsJsonObject();
            System.out.println("temp :  " + sk.get("temp").getAsInt());
            System.out.println("wind_direction :" + sk.get("wind_direction").getAsString());
            System.out.println("wind_strength : " + sk.get("wind_strength").getAsString());
            System.out.println("humidity :" + sk.get("humidity").getAsString());
            System.out.println("time :" + sk.get("time").getAsString());

            /** 解析json数组*/
            JsonArray future = result.get("future").getAsJsonArray();
            System.out.println(future);
            for(int i = 0 ; i < future.size(); i++){
                JsonObject object = future.get(i).getAsJsonObject();
                System.out.println("temperature : " + object.get("temperature").getAsString() );
                System.out.println("weather : " + object.get("weather").getAsString() );
                System.out.println("weather_id :" + object.get("weather_id").getAsJsonObject());

                /** 解析json对象*/
                System.out.println("fa : " + object.get("weather_id").getAsJsonObject().get("fa").getAsInt());
                System.out.println("fb : " + object.get("weather_id").getAsJsonObject().get("fb").getAsInt());

            }

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

    }



}

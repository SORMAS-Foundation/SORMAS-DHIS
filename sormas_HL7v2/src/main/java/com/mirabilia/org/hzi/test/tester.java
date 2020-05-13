package com.mirabilia.org.hzi.test;

import static com.mirabilia.org.hzi.Util.dhis.DHIS2resolver.getDemAllfromFHIR;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class tester {

    public static void main(String[] args) throws ParseException {
        // PusttoFHIR.fireDB();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObjectx;
        String base_url = "http://172.105.77.79:3447/fhir/Location";
        String json_all = getDemAllfromFHIR(base_url);

        System.out.println(json_all);

        jsonObjectx = (JSONObject) jsonParser.parse(json_all);
        Object total_values_onFHIR = jsonObjectx.get("total");

        //JSONObject jsonObjectxx = (JSONObject) total_values_onFHIR;
        System.out.println("Total resources = " + total_values_onFHIR);

        if (1 == 2) {

            JSONObject json = new JSONObject();
            json.put("resourceType", "Location");

            JSONArray identifier_array = new JSONArray();
            JSONObject identifier_json = new JSONObject();
            identifier_json.put("type", "http://dhis2.org/id");
            identifier_json.put("value", "UUID");
            identifier_array.add(identifier_json);
            json.put("identifier", identifier_array);

            json.put("name", "dhis_name");
            json.put("alias", "dhis2_shortname");
            json.put("description", "dhis_disc");
            json.put("mode", "instance");

            JSONArray type_array = new JSONArray();
            JSONObject type_json = new JSONObject();
            type_json.put("system", "http://hl7.org/fhir/v3/RoleCode");
            type_json.put("code", "PROFF");
            type_array.add(type_json);
            JSONObject type_json1 = new JSONObject();
            type_json1.put("coding", type_array);
            json.put("type", type_json1);

            JSONArray telecom_array = new JSONArray();
            JSONObject telecom_json = new JSONObject();
            telecom_json.put("value", "07031252904");
            telecom_array.add(telecom_json);
            json.put("telecom", telecom_array);

            JSONArray physicalType_array = new JSONArray();
            JSONObject physicalType_json = new JSONObject();
            physicalType_json.put("system", "http://hl7.org/fhir/location-physical-type");
            physicalType_json.put("code", "bu");
            physicalType_array.add(physicalType_json);
            JSONObject physicalType_json1 = new JSONObject();
            physicalType_json1.put("coding", physicalType_array);
            json.put("physicalType", physicalType_json1);

            JSONArray position_array = new JSONArray();
            JSONObject position_json = new JSONObject();
            position_json.put("longitude", "07031252904");
            position_json.put("latitude", "07031252904");
            position_array.add(position_json);
            json.put("position", position_array);

            JSONObject managingOrganization_json = new JSONObject();
            managingOrganization_json.put("reference", "Location/UUID");
            json.put("managingOrganization", managingOrganization_json);

            JSONObject address_json = new JSONObject();
            address_json.put("city", "");
            address_json.put("postalCode", "");

            JSONArray address_array = new JSONArray();
            address_array.add("6060 Green Park Avenue");
            address_array.add("Abuja");
            address_json.put("line", address_array);
            json.put("address", address_json);

            JSONArray tag_arrary = new JSONArray();
            JSONObject tag_json = new JSONObject();
            tag_json.put("system", "http://dhis2.org/organistionUnitLevels");
            tag_json.put("code", "kjhgtyuio");
            tag_json.put("display", "Ward");
            tag_arrary.add(tag_json);
            json.put("physicalType", tag_arrary);

            System.out.println(json.toString());
        }
    }

}

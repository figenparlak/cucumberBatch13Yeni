package utils;

import APISteps.APIWorkflowSteps;
import netscape.javascript.JSObject;
import org.json.JSONObject;

public class APIPayloadConstants {


    public static String createEmployeePayload() {

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Esen\",\n" +
                "  \"emp_lastname\": \"gungor\",\n" +
                "  \"emp_middle_name\": \"purki\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2001-01-01\",\n" +
                "  \"emp_status\": \"normal\",\n" +
                "  \"emp_job_title\": \"QA engineer\"\n" +
                "}";

        return createEmployeePayload;
    }

    // asagidaki metod yukaridakini yapmanin farkli yolu fakat yakaridaki kafa karistiriciymis
    public static String createEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Esen");
        obj.put("emp_lastname", "gungor");
        obj.put("emp_middle_name", "purki");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2001-01-01");
        obj.put("emp_status", "normal");
        obj.put("emp_job_title", "QA engineer");
        return obj.toString();

    }

    public static String createDynamicEmployeePayloadJson(String firstName, String lastName, String middleNama, String gender, String birhday, String status, String jopTitle) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstName);
        obj.put("emp_lastname", lastName);
        obj.put("emp_middle_name", middleNama);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", birhday);
        obj.put("emp_status", status);
        obj.put("emp_job_title", jopTitle);
        return obj.toString();

    }

    public static String updateEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("employee_id", APIWorkflowSteps.employee_id);
        obj.put("emp_firstname", "Esencan");
        obj.put("emp_lastname", "gungorler");
        obj.put("emp_middle_name", "purkis");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2009-02-02");
        obj.put("emp_status", "special employee");
        obj.put("emp_job_title", "QA1 engineerly");
        return obj.toString();
    }
}
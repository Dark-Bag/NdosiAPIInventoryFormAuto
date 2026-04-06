package payloadBuilder;

import org.json.simple.JSONObject;

public class PayloadBuilder {

    public  static JSONObject loginPayload(String email, String password){
        JSONObject payload = new JSONObject();
        payload.put("email", email);
        payload.put("password", password);
        return payload;
    }

    public static JSONObject registerUserPayload(String firstName, String lastName, String email, String password, String groupId) {
        JSONObject registerUser = new JSONObject();
        registerUser.put("firstName", firstName);
        registerUser.put("lastName", lastName);
        registerUser.put("email", email);
        registerUser.put("password", password);
        registerUser.put("confirmPassword", password);
        registerUser.put("groupId", groupId);

        return registerUser;
    }

    public static JSONObject role(String role)
         {
             JSONObject adminRole = new JSONObject();
             adminRole.put("role", role);
             return adminRole;
         }




}

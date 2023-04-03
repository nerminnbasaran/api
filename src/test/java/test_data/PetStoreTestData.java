package test_data;

import java.util.HashMap;
import java.util.Map;

public class PetStoreTestData {

    public Map<String,Object> expectedDataMapMethod(String userId,String firstname,String lastname,String email,String password,String phone,Integer userStatus){
        Map<String,Object> expectedData = new HashMap<>();
       if(userId!=null){
           expectedData.put("userId",userId);
       }
        if (firstname!=null){
            expectedData.put("firstname",firstname);
        }
        if (lastname!=null){
            expectedData.put("lastname",lastname);
        }
        if(email!=null){
            expectedData.put("email",email);
        }
        if (phone!=null){
            expectedData.put("phone",phone);
        }
       if(userStatus!=null){
           expectedData.put("userStatus",userStatus);
       }
        return expectedData;
    }



}
